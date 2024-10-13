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

import static com.FullStack.ms_transaction.infrastructure.out.jpa.entities.utils.ConstantsEntity.SALES_COLUMN_CART_ID;
import static com.FullStack.ms_transaction.infrastructure.out.jpa.entities.utils.ConstantsEntity.SALES_COLUMN_CREATED_AT;
import static com.FullStack.ms_transaction.infrastructure.out.jpa.entities.utils.ConstantsEntity.SALES_COLUMN_SUBTOTAL;
import static com.FullStack.ms_transaction.infrastructure.out.jpa.entities.utils.ConstantsEntity.SALES_COLUMN_UPDATED_AT;
import static com.FullStack.ms_transaction.infrastructure.out.jpa.entities.utils.ConstantsEntity.SALES_COLUMN_USER_ID;
import static com.FullStack.ms_transaction.infrastructure.out.jpa.entities.utils.ConstantsEntity.SALES_ENTITY_TABLE;

@Entity
@Table(name = SALES_ENTITY_TABLE)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SalesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = SALES_COLUMN_SUBTOTAL, nullable = false)
    private Double subtotal;

    @Column(name = SALES_COLUMN_CREATED_AT, nullable = false)
    private LocalDateTime createdAt;

    @Column(name = SALES_COLUMN_UPDATED_AT, nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = SALES_COLUMN_USER_ID, nullable = false)
    private Long userId;

    @Column(name = SALES_COLUMN_CART_ID, nullable = false)
    private Long cartId;
}
