package com.brianmajewski.advanced;

import java.util.ArrayList;
import java.util.List;

public class AbstractProduct implements Product {
    private final List<Price> prices = new ArrayList<Price>();

    private String identifier;

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public List<Price> getPrices() {
        return prices;
    }

    @Override
    public void addPrice(Price price) {
        prices.add(price);

    }

    @Override
    public int calculateTotal(Integer quantity) {
        int total = 0;
        while (quantity > 0) {
            for (Price price : prices) {
                while (quantity >= price.getQuantity()) {
                    quantity -= price.getQuantity();
                    total += price.getCost().intValue();
                }
            }
        }
        return total;
    }
}
