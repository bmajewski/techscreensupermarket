package com.brianmajewski.basic;

import com.brianmajewski.Supermarket;

public class QuickAndDirtySupermarket implements Supermarket {
    @Override
    public int checkout(String items) {
        int total = 0;
        int bCount = 0;
        if (null != items) {
            for (int i = 0; i < items.length(); i++) {
                char product = items.charAt(i);
                switch (product){
                    case 'A' :
                        total += 20;
                        break;
                    case 'B' :
                        bCount++;
                        break;
                    case 'C':
                        total += 30;
                        break;
                }
            }
            if (bCount > 0 ) {
                total += (bCount / 5 * 150 );
                total += bCount % 5 * 50;
            }
        }
        return total;
    }
}
