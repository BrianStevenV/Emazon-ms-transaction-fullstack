package com.FullStack.ms_transaction.infrastructure.out.client.feign.port;

import com.FullStack.ms_transaction.application.dto.request.QuantityStockFeignClientDto;
import com.FullStack.ms_transaction.application.dto.request.ReduceQuantityFeignClientDto;
import com.FullStack.ms_transaction.application.dto.response.SaleFeignClientResponseDto;
import com.FullStack.ms_transaction.domain.model.ReduceQuantity;
import com.FullStack.ms_transaction.domain.model.SalesProductDetails;
import com.FullStack.ms_transaction.infrastructure.configuration.feign.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.FullStack.ms_transaction.infrastructure.out.client.utils.FeignClientConstants.PRODUCT_CONTROLLER_POST_REDUCE_QUANTITY;
import static com.FullStack.ms_transaction.infrastructure.out.client.utils.FeignClientConstants.STOCK_BASE_HOST;
import static com.FullStack.ms_transaction.infrastructure.out.client.utils.FeignClientConstants.STOCK_CANCEL_UPDATE_QUANTITY_URL;
import static com.FullStack.ms_transaction.infrastructure.out.client.utils.FeignClientConstants.STOCK_SERVICE;
import static com.FullStack.ms_transaction.infrastructure.out.client.utils.FeignClientConstants.STOCK_UPDATE_QUANTITY_URL;

@FeignClient(name = STOCK_SERVICE, url = STOCK_BASE_HOST, configuration = FeignClientConfig.class)
public interface IStockFeignClientExternalPort {

    @PatchMapping(STOCK_UPDATE_QUANTITY_URL)
    ResponseEntity<Void> updateStockQuantity(@RequestBody QuantityStockFeignClientDto quantityStockFeignClientDto);

    @PatchMapping(STOCK_CANCEL_UPDATE_QUANTITY_URL)
    ResponseEntity<Void> cancelStockQuantity(@RequestBody QuantityStockFeignClientDto quantityStockFeignClientDto);

    @PostMapping(PRODUCT_CONTROLLER_POST_REDUCE_QUANTITY)
    SaleFeignClientResponseDto reduceStockQuantity(@RequestBody ReduceQuantityFeignClientDto reduceQuantityFeignClientDto);
}
