package com.FullStack.ms_transaction.infrastructure.out.client.feign.port;

import com.FullStack.ms_transaction.application.dto.request.SalesReportFeignClientDto;
import com.FullStack.ms_transaction.infrastructure.configuration.feign.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import static com.FullStack.ms_transaction.infrastructure.out.client.utils.FeignClientConstants.TRACEABILITY_BASE_HOST;
import static com.FullStack.ms_transaction.infrastructure.out.client.utils.FeignClientConstants.TRACEABILITY_CONTROLLER_POST_SALES;
import static com.FullStack.ms_transaction.infrastructure.out.client.utils.FeignClientConstants.TRACEABILITY_SERVICE;

@FeignClient(name = TRACEABILITY_SERVICE, url = TRACEABILITY_BASE_HOST, configuration = FeignClientConfig.class)
public interface ISalesTraceabilityFeignClientExternalPort {

    @PostMapping(TRACEABILITY_CONTROLLER_POST_SALES)
    void createRecord(SalesReportFeignClientDto salesReportFeignClientDto);
}
