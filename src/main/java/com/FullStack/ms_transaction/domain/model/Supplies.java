package com.FullStack.ms_transaction.domain.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Supplies {

    private Long id;

    private Double price;

    private Integer quantityTotal;

    private Integer quantityAvailable;

    private EnumStatus status;

    private Boolean isAvailable;

    private Date replenishmentDate;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Long productId;

    private Long userId;

    public Supplies(Long id, Double price, Integer quantityTotal, Integer quantityAvailable, EnumStatus status,
                    Boolean isAvailable, Date replenishmentDate, LocalDateTime createdAt, LocalDateTime updatedAt,
                    Long productId, Long userId) {
        this.id = id;
        this.price = price;
        this.quantityTotal = quantityTotal;
        this.quantityAvailable = quantityAvailable;
        this.status = status;
        this.isAvailable = isAvailable;
        this.replenishmentDate = replenishmentDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.productId = productId;
        this.userId = userId;
    }

    public Supplies() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantityTotal() {
        return quantityTotal;
    }

    public void setQuantityTotal(Integer quantityTotal) {
        this.quantityTotal = quantityTotal;
    }

    public Integer getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(Integer quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public EnumStatus getStatus() {
        return status;
    }

    public void setStatus(EnumStatus status) {
        this.status = status;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean available) {
        isAvailable = available;
    }

    public Date getReplenishmentDate() {
        return replenishmentDate;
    }

    public void setReplenishmentDate(Date replenishmentDate) {
        this.replenishmentDate = replenishmentDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
