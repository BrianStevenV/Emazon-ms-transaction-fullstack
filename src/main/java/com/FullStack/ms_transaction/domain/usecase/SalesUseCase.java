package com.FullStack.ms_transaction.domain.usecase;

import com.FullStack.ms_transaction.domain.api.ISalesServicePort;
import com.FullStack.ms_transaction.domain.model.CartDetails;
import com.FullStack.ms_transaction.domain.model.ProductSales;
import com.FullStack.ms_transaction.domain.model.ProductsIds;
import com.FullStack.ms_transaction.domain.model.QuantityStock;
import com.FullStack.ms_transaction.domain.model.ReduceQuantity;
import com.FullStack.ms_transaction.domain.model.Sales;
import com.FullStack.ms_transaction.domain.model.SalesDetails;
import com.FullStack.ms_transaction.domain.model.SalesProductDetails;
import com.FullStack.ms_transaction.domain.model.SalesReport;
import com.FullStack.ms_transaction.domain.spi.ICartFeignClientPort;
import com.FullStack.ms_transaction.domain.spi.ISalesDetailsPersistencePort;
import com.FullStack.ms_transaction.domain.spi.ISalesPersistencePort;
import com.FullStack.ms_transaction.domain.spi.ISalesTraceabilityFeignClientPort;
import com.FullStack.ms_transaction.domain.spi.IStockFeignClientPort;
import com.FullStack.ms_transaction.domain.spi.ISuppliesPersistencePort;
import com.FullStack.ms_transaction.domain.usecase.utils.UseCaseUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class SalesUseCase implements ISalesServicePort {

    private final ISalesPersistencePort salesPersistencePort;
    private final ISalesDetailsPersistencePort salesDetailsPersistencePort;
    private final ISalesTraceabilityFeignClientPort salesTraceabilityFeignClientPort;
    private final IStockFeignClientPort stockExternalPort;
    private final ICartFeignClientPort cartExternalPort;
    private final UseCaseUtils useCaseUtils;

    public SalesUseCase(ISalesPersistencePort salesPersistencePort, ISalesDetailsPersistencePort salesDetailsPersistencePort, ISalesTraceabilityFeignClientPort salesTraceabilityFeignClientPort, IStockFeignClientPort stockExternalPort, ICartFeignClientPort cartExternalPort, UseCaseUtils useCaseUtils) {
        this.salesPersistencePort = salesPersistencePort;
        this.salesDetailsPersistencePort = salesDetailsPersistencePort;
        this.salesTraceabilityFeignClientPort = salesTraceabilityFeignClientPort;
        this.stockExternalPort = stockExternalPort;
        this.cartExternalPort = cartExternalPort;
        this.useCaseUtils = useCaseUtils;
    }

    @Override
    public void buyCart() {
        List<CartDetails> productsInCart = cartExternalPort.getProductsInCart(useCaseUtils.getIdFromUserContextService());

        List<QuantityStock> quantityStockList = createQuantityStockList(productsInCart);

        ReduceQuantity reduceQuantity = new ReduceQuantity(quantityStockList);

        SalesProductDetails salesProductDetails = stockExternalPort.reduceStockQuantity(reduceQuantity);

        deleteCart(productsInCart);

        long cartId = productsInCart.get(0).getCartId();

        List<ProductSales> productSalesList = salesProductDetails.getProducts();

        double subtotal = salesProductDetails.getSubtotal();

        Sales sales = createSales(cartId, subtotal, useCaseUtils.getIdFromUserContextService());

        createSalesDetails(productSalesList, sales.getId());

        createSalesReport(cartId, productSalesList, subtotal);
    }




    private Sales createSales(long cartId, double subtotal, long userId) {
        LocalDateTime now = LocalDateTime.now();
        Sales sales = new Sales();
        sales.setSubtotal(subtotal);
        sales.setCreatedAt(now);
        sales.setUpdatedAt(now);
        sales.setUserId(userId);
        sales.setCartId(cartId);

        salesPersistencePort.saveSales(sales);

        return sales; // Deberías retornar el objeto guardado con su id establecido
    }
    private void createSalesDetails(List<ProductSales> productSalesList, long salesId) {
        LocalDateTime now = LocalDateTime.now();

        // Crear una lista de SalesDetails utilizando streams
        List<SalesDetails> salesDetailsList = productSalesList.stream()
                .map(productSales -> {
                    SalesDetails salesDetails = new SalesDetails();
                    salesDetails.setAmount(productSales.getAmount());
                    salesDetails.setPrice(productSales.getPrice());
                    salesDetails.setCreatedAt(now);
                    salesDetails.setUpdatedAt(now);
                    salesDetails.setProductId(productSales.getProductId());
                    salesDetails.setSalesId(salesId);
                    return salesDetails;
                })
                .collect(Collectors.toList());

        salesDetailsPersistencePort.savesSalesDetails(salesDetailsList);


    }

    private void createSalesReport(long cartId, List<ProductSales> productSalesList, double subtotal) {
        SalesReport salesReport = new SalesReport();
        salesReport.setCartId(cartId);
        salesReport.setCartDetails(productSalesList);
        salesReport.setSubtotal(subtotal);
        salesReport.setPurchaseDate(LocalDateTime.now());

        salesTraceabilityFeignClientPort.createRecord(salesReport);
    }

    private List<QuantityStock> createQuantityStockList(List<CartDetails> productsInCart) {
        return productsInCart.stream()
                .map(cartDetails -> new QuantityStock(cartDetails.getProductId(), cartDetails.getAmount()))
                .collect(Collectors.toList());
    }

    private void deleteCart(List<CartDetails> productsInCart) {
        long userId = useCaseUtils.getIdFromUserContextService();
        List<Long> productIds = productsInCart.stream()
                .map(CartDetails::getProductId)
                .collect(Collectors.toList());

        cartExternalPort.deleteCart(userId, new ProductsIds(productIds));
    }


}
