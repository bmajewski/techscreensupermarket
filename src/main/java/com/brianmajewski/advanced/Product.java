package com.brianmajewski.advanced;

import java.util.List;

public interface Product {
    public String getIdentifier();
    public void setIdentifier(String identifier);
    public List<Price> getPrices();
    public void addPrice(Price price);

    public int calculateTotal(Integer quantity);
}
