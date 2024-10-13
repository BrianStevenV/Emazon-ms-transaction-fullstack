package com.FullStack.ms_transaction.infrastructure.out.jpa.repository;

import com.FullStack.ms_transaction.infrastructure.out.jpa.entities.SalesDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISalesDetailsRepository extends JpaRepository<SalesDetailsEntity, Long> {
}
