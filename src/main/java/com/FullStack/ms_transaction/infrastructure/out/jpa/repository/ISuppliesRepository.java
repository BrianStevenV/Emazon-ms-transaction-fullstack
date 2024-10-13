package com.FullStack.ms_transaction.infrastructure.out.jpa.repository;

import com.FullStack.ms_transaction.infrastructure.out.jpa.entities.SuppliesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

import static com.FullStack.ms_transaction.infrastructure.out.jpa.repository.utils.ConstantsSQLQuerySupplies.QUERY_GET_NEXT_SUPPLY_DATE_BY_PRODUCT_ID;

@Repository
public interface ISuppliesRepository extends JpaRepository<SuppliesEntity, Long> {
    @Query(QUERY_GET_NEXT_SUPPLY_DATE_BY_PRODUCT_ID)
    Date findNextSupplyDateByProductId(@Param("productId") long productId);
}
