package com.brianmajewski.advanced;

import java.math.BigDecimal;

public interface Price {
    public BigDecimal getCost();
    public void setCost(BigDecimal cost);
    public int getQuantity();
    public void setQuantity(int quantity);
}
