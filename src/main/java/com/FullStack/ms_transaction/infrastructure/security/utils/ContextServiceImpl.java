package com.FullStack.ms_transaction.infrastructure.security.utils;

import org.springframework.stereotype.Service;

@Service
public class ContextServiceImpl implements IContextService{
    @Override
    public long getAuthenticationId() {
        return SecurityUtils.getIdFromInfrastructure();
    }
}
