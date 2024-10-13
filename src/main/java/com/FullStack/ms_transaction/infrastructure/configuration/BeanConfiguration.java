package com.FullStack.ms_transaction.infrastructure.configuration;

import com.FullStack.ms_transaction.domain.api.ISalesServicePort;
import com.FullStack.ms_transaction.domain.api.ISuppliesServicePort;
import com.FullStack.ms_transaction.domain.spi.ICartFeignClientPort;
import com.FullStack.ms_transaction.domain.spi.ISalesDetailsPersistencePort;
import com.FullStack.ms_transaction.domain.spi.ISalesPersistencePort;
import com.FullStack.ms_transaction.domain.spi.ISalesTraceabilityFeignClientPort;
import com.FullStack.ms_transaction.domain.spi.ISuppliesPersistencePort;
import com.FullStack.ms_transaction.domain.usecase.SalesUseCase;
import com.FullStack.ms_transaction.domain.usecase.SuppliesUseCase;
import com.FullStack.ms_transaction.domain.usecase.utils.UseCaseUtils;
import com.FullStack.ms_transaction.infrastructure.out.client.adapter.CartFeignClientAdapter;
import com.FullStack.ms_transaction.infrastructure.out.client.adapter.SalesTraceabilityFeignClientAdapter;
import com.FullStack.ms_transaction.infrastructure.out.client.feign.port.ICartFeignClientExternalPort;
import com.FullStack.ms_transaction.infrastructure.out.client.feign.port.ISalesTraceabilityFeignClientExternalPort;
import com.FullStack.ms_transaction.infrastructure.out.client.feign.port.IStockFeignClientExternalPort;
import com.FullStack.ms_transaction.domain.spi.IStockFeignClientPort;
import com.FullStack.ms_transaction.infrastructure.out.client.adapter.StockFeignClientAdapter;
import com.FullStack.ms_transaction.infrastructure.out.client.mapper.feignclient.ICartFeignClientMapper;
import com.FullStack.ms_transaction.infrastructure.out.client.mapper.feignclient.ITraceabilityFeignClientMapper;
import com.FullStack.ms_transaction.infrastructure.out.jpa.adapter.SalesDetailsMySqlAdapter;
import com.FullStack.ms_transaction.infrastructure.out.jpa.adapter.SalesMySqlAdapter;
import com.FullStack.ms_transaction.infrastructure.out.jpa.adapter.SuppliesMySqlAdapter;
import com.FullStack.ms_transaction.infrastructure.out.jpa.mapper.ISalesDetailsEntityMapper;
import com.FullStack.ms_transaction.infrastructure.out.jpa.mapper.ISalesEntityMapper;
import com.FullStack.ms_transaction.infrastructure.out.jpa.mapper.ISuppliesEntityMapper;
import com.FullStack.ms_transaction.infrastructure.out.client.mapper.feignclient.IStockFeignClientMapper;
import com.FullStack.ms_transaction.infrastructure.out.jpa.repository.ISalesDetailsRepository;
import com.FullStack.ms_transaction.infrastructure.out.jpa.repository.ISalesRepository;
import com.FullStack.ms_transaction.infrastructure.out.jpa.repository.ISuppliesRepository;
import com.FullStack.ms_transaction.infrastructure.security.utils.IContextService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final ISuppliesRepository suppliesRepository;
    private final ISuppliesEntityMapper suppliesEntityMapper;

    private final IStockFeignClientExternalPort stockFeignClientPort;
    private final IStockFeignClientMapper stockFeignClientMapper;

    private final IContextService contextService;

    private final ICartFeignClientExternalPort cartFeignClientExternalPort;
    private final ICartFeignClientMapper cartFeignClientMapper;

    private final ISalesDetailsRepository salesDetailsRepository;
    private final ISalesDetailsEntityMapper salesDetailsEntityMapper;

    private final ISalesRepository salesRepository;
    private final ISalesEntityMapper salesEntityMapper;

    private final ISalesTraceabilityFeignClientExternalPort salesTraceabilityFeignClientExternalPort;
    private final ITraceabilityFeignClientMapper traceabilityFeignClientMapper;

    @Bean
    public UseCaseUtils useCaseUtils() {
        return new UseCaseUtils(contextService);
    }

    @Bean
    public ISuppliesPersistencePort suppliesPersistencePort() {
        return new SuppliesMySqlAdapter(suppliesRepository, suppliesEntityMapper);
    }

    @Bean
    public IStockFeignClientPort stockFeignClientPort() {
        return new StockFeignClientAdapter(stockFeignClientPort, stockFeignClientMapper);
    }

    @Bean
    public ISuppliesServicePort suppliesServicePort() {
        return new SuppliesUseCase(suppliesPersistencePort(), stockFeignClientPort(), useCaseUtils());
    }

    @Bean
    public ICartFeignClientPort cartFeignClientPort() {
        return new CartFeignClientAdapter(cartFeignClientMapper, cartFeignClientExternalPort);
    }

    @Bean
    public ISalesDetailsPersistencePort salesDetailsPersistencePort() {
        return new SalesDetailsMySqlAdapter(salesDetailsRepository, salesDetailsEntityMapper);
    }

    @Bean
    public ISalesPersistencePort salesPersistencePort() {
        return new SalesMySqlAdapter(salesRepository, salesEntityMapper);
    }

    @Bean
    public ISalesServicePort salesServicePort() {
        return new SalesUseCase(salesPersistencePort(), salesDetailsPersistencePort(), salesTraceabilityFeignClientPort(), stockFeignClientPort(), cartFeignClientPort(), useCaseUtils());
    }

    @Bean
    public ISalesTraceabilityFeignClientPort salesTraceabilityFeignClientPort() {
        return new SalesTraceabilityFeignClientAdapter(salesTraceabilityFeignClientExternalPort, traceabilityFeignClientMapper);
    }
}

