package com.FullStack.ms_transaction.infrastructure.out.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import static com.FullStack.ms_transaction.infrastructure.out.jpa.entities.utils.ConstantsEntity.SUPPLIES_COLUMN_CREATED_AT;
import static com.FullStack.ms_transaction.infrastructure.out.jpa.entities.utils.ConstantsEntity.SUPPLIES_COLUMN_IS_AVAILABLE;
import static com.FullStack.ms_transaction.infrastructure.out.jpa.entities.utils.ConstantsEntity.SUPPLIES_COLUMN_PRICE;
import static com.FullStack.ms_transaction.infrastructure.out.jpa.entities.utils.ConstantsEntity.SUPPLIES_COLUMN_PRODUCT_ID;
import static com.FullStack.ms_transaction.infrastructure.out.jpa.entities.utils.ConstantsEntity.SUPPLIES_COLUMN_QUANTITY_AVAILABLE;
import static com.FullStack.ms_transaction.infrastructure.out.jpa.entities.utils.ConstantsEntity.SUPPLIES_COLUMN_QUANTITY_TOTAL;
import static com.FullStack.ms_transaction.infrastructure.out.jpa.entities.utils.ConstantsEntity.SUPPLIES_COLUMN_REPLENISHMENT_DATE;
import static com.FullStack.ms_transaction.infrastructure.out.jpa.entities.utils.ConstantsEntity.SUPPLIES_COLUMN_STATUS;
import static com.FullStack.ms_transaction.infrastructure.out.jpa.entities.utils.ConstantsEntity.SUPPLIES_COLUMN_USER_ID;
import static com.FullStack.ms_transaction.infrastructure.out.jpa.entities.utils.ConstantsEntity.SUPPLIES_ENTITY_TABLE;
import static com.FullStack.ms_transaction.infrastructure.out.jpa.entities.utils.ConstantsEntity.SUPPLIES_UPDATED_AT;

@Entity
@Table(name = SUPPLIES_ENTITY_TABLE)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SuppliesEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = SUPPLIES_COLUMN_PRICE)
    private Double price;

    @Column(name = SUPPLIES_COLUMN_QUANTITY_TOTAL)
    private Integer quantityTotal;

    @Column(name = SUPPLIES_COLUMN_QUANTITY_AVAILABLE) // -> Sincronizar con procesos de reserva
    private Integer quantityAvailable;

    @Column(name = SUPPLIES_COLUMN_STATUS)
    private String status;

    @Column(name = SUPPLIES_COLUMN_IS_AVAILABLE)
    private Boolean isAvailable;

    @Column(name = SUPPLIES_COLUMN_REPLENISHMENT_DATE)
    private Date replenishmentDate;

    @Column(name = SUPPLIES_COLUMN_CREATED_AT, nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = SUPPLIES_UPDATED_AT)
    private LocalDateTime updatedAt;

    @Column(name = SUPPLIES_COLUMN_PRODUCT_ID)
    private Long productId;

    @Column(name = SUPPLIES_COLUMN_USER_ID)
    private Long userId;

}
