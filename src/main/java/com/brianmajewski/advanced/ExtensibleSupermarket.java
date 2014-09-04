package com.brianmajewski.advanced;

import com.brianmajewski.Supermarket;

import java.util.HashMap;
import java.util.Map;

public class ExtensibleSupermarket implements Supermarket {
    private final Map<String, Product> products = new HashMap<String, Product>();

    @Override
    public int checkout(String items) {
        int total = 0;
        Map<String, Integer> map = sortItems(items);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int productTotal = calculateTotal(entry);
            total += productTotal;
        }
        return total;
    }

    private int calculateTotal(Map.Entry<String, Integer> entry) {
        int total = 0;
        String item = entry.getKey();
        Integer quantity = entry.getValue();
        if (products.containsKey(item)) {
            Product product = products.get(item);
            total = product.calculateTotal(quantity);
        }

        return total;
    }

    private Map<String, Integer> sortItems(String items) {
        Map<String, Integer> productCount = new HashMap<String, Integer>();
        if (null != items) {
            for (int i = 0; i < items.length(); i++) {
                String item = String.valueOf(items.charAt(i));
                if (!productCount.containsKey(item)) {
                    productCount.put(item, 0);
                }
                Integer quantity = productCount.get(item);
                productCount.put(item, ++quantity);
            }
        }
        return productCount;
    }

    public void addProduct(Product product) {
        products.put(product.getIdentifier(), product);
    }
}
