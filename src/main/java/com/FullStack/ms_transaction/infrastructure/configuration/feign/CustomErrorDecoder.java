package com.FullStack.ms_transaction.infrastructure.configuration.feign;

import com.FullStack.ms_transaction.infrastructure.configuration.feign.exceptions.FeignBadRequestException;
import com.FullStack.ms_transaction.infrastructure.configuration.feign.exceptions.FeignForbiddenException;
import com.FullStack.ms_transaction.infrastructure.configuration.feign.exceptions.FeignInternalServerErrorException;
import com.FullStack.ms_transaction.infrastructure.configuration.feign.exceptions.FeignNotFoundException;
import com.FullStack.ms_transaction.infrastructure.configuration.feign.exceptions.FeignUnauthorizedException;
import feign.Response;
import feign.codec.ErrorDecoder;



import static com.FullStack.ms_transaction.infrastructure.configuration.feign.utils.ConstantFeignClientInfra.STATUS_CODE_400;
import static com.FullStack.ms_transaction.infrastructure.configuration.feign.utils.ConstantFeignClientInfra.STATUS_CODE_401;
import static com.FullStack.ms_transaction.infrastructure.configuration.feign.utils.ConstantFeignClientInfra.STATUS_CODE_403;
import static com.FullStack.ms_transaction.infrastructure.configuration.feign.utils.ConstantFeignClientInfra.STATUS_CODE_404;
import static com.FullStack.ms_transaction.infrastructure.configuration.feign.utils.ConstantFeignClientInfra.STATUS_CODE_500;

public class CustomErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        System.out.println("CustomErrorDecoder");
        switch (response.status()) {
            case STATUS_CODE_400:
                return new FeignBadRequestException();
            case STATUS_CODE_401:
                return new FeignUnauthorizedException();
            case STATUS_CODE_403:
                return new FeignForbiddenException();
            case STATUS_CODE_404:
                return new FeignNotFoundException();
            case STATUS_CODE_500:
                return new FeignInternalServerErrorException();
            default:
                return errorDecoder.decode(methodKey, response);
        }
    }
}
