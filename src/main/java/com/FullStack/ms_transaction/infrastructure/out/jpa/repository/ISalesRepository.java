package com.FullStack.ms_transaction.infrastructure.out.jpa.repository;

import com.FullStack.ms_transaction.infrastructure.out.jpa.entities.SalesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISalesRepository extends JpaRepository<SalesEntity, Long> {
}
