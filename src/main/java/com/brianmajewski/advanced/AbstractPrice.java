package com.brianmajewski.advanced;

import java.math.BigDecimal;

public class AbstractPrice implements Price {
    private BigDecimal cost;
    private int quantity;

    @Override
    public BigDecimal getCost() {
        return cost;
    }

    @Override
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
