package com.FullStack.ms_transaction.infrastructure.out.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static com.FullStack.ms_transaction.infrastructure.out.jpa.entities.utils.ConstantsEntity.SALES_DETAILS_COLUMN_AMOUNT;
import static com.FullStack.ms_transaction.infrastructure.out.jpa.entities.utils.ConstantsEntity.SALES_DETAILS_COLUMN_CREATED_AT;
import static com.FullStack.ms_transaction.infrastructure.out.jpa.entities.utils.ConstantsEntity.SALES_DETAILS_COLUMN_PRICE;
import static com.FullStack.ms_transaction.infrastructure.out.jpa.entities.utils.ConstantsEntity.SALES_DETAILS_COLUMN_PRODUCT_ID;
import static com.FullStack.ms_transaction.infrastructure.out.jpa.entities.utils.ConstantsEntity.SALES_DETAILS_COLUMN_SALES_ID;
import static com.FullStack.ms_transaction.infrastructure.out.jpa.entities.utils.ConstantsEntity.SALES_DETAILS_COLUMN_UPDATED_AT;
import static com.FullStack.ms_transaction.infrastructure.out.jpa.entities.utils.ConstantsEntity.SALES_DETAILS_ENTITY_TABLE;

@Entity
@Table(name = SALES_DETAILS_ENTITY_TABLE)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SalesDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = SALES_DETAILS_COLUMN_AMOUNT, nullable = false)
    private Integer amount;

    @Column(name = SALES_DETAILS_COLUMN_PRICE, nullable = false)
    private Double price;

    @Column(name = SALES_DETAILS_COLUMN_CREATED_AT, nullable = false)
    private LocalDateTime createdAt;

    @Column(name = SALES_DETAILS_COLUMN_UPDATED_AT, nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = SALES_DETAILS_COLUMN_PRODUCT_ID, nullable = false)
    private Long productId;

    @Column(name = SALES_DETAILS_COLUMN_SALES_ID, nullable = false)
    private Long salesId;
}
