package com.FullStack.ms_transaction.infrastructure.configuration;

import com.FullStack.ms_transaction.domain.api.ISuppliesServicePort;
import com.FullStack.ms_transaction.domain.spi.ISuppliesPersistencePort;
import com.FullStack.ms_transaction.domain.usecase.SuppliesUseCase;
import com.FullStack.ms_transaction.domain.usecase.utils.SuppliesUseCaseUtils;
import com.FullStack.ms_transaction.infrastructure.out.client.feign.port.IStockFeignClientExternalPort;
import com.FullStack.ms_transaction.domain.spi.IStockFeignClientPort;
import com.FullStack.ms_transaction.infrastructure.out.client.adapter.SuppliesFeignClientAdapter;
import com.FullStack.ms_transaction.infrastructure.out.jpa.adapter.SuppliesMySqlAdapter;
import com.FullStack.ms_transaction.infrastructure.out.jpa.mapper.ISuppliesEntityMapper;
import com.FullStack.ms_transaction.infrastructure.out.client.mapper.feignclient.IStockFeignClientMapper;
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

    @Bean
    public ISuppliesPersistencePort suppliesPersistencePort() {
        return new SuppliesMySqlAdapter(suppliesRepository, suppliesEntityMapper);
    }

    @Bean
    public IStockFeignClientPort stockFeignClientPort(){
        return new SuppliesFeignClientAdapter(stockFeignClientPort, stockFeignClientMapper);
    }

    @Bean
    public ISuppliesServicePort suppliesServicePort() {
        return new SuppliesUseCase(suppliesPersistencePort(), stockFeignClientPort(), suppliesUseCaseUtils());
    }
    @Bean
    public SuppliesUseCaseUtils suppliesUseCaseUtils() {
        return new SuppliesUseCaseUtils(contextService);
    }
}
