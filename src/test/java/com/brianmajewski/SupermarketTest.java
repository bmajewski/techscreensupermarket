package com.brianmajewski;

import com.brianmajewski.advanced.AbstractPrice;
import com.brianmajewski.advanced.AbstractProduct;
import com.brianmajewski.advanced.ExtensibleSupermarket;
import com.brianmajewski.basic.QuickAndDirtySupermarket;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for Supermarket App.
 */
public class SupermarketTest extends TestCase {

    private List<Supermarket> impls;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SupermarketTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(SupermarketTest.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        impls = new ArrayList<Supermarket>();
        impls.add(new QuickAndDirtySupermarket());

        ExtensibleSupermarket extensibleSupermarket = new ExtensibleSupermarket();
        extensibleSupermarket.addProduct(new ProductA());
        extensibleSupermarket.addProduct(new ProductB());
        extensibleSupermarket.addProduct(new ProductC());

        impls.add(extensibleSupermarket);
    }

    /**
     * Business Tests
     */
    public void testPrimaryAssertion() {
        for (Supermarket impl : impls) {
            assertEquals("Primary assertion has failed", 240, impl.checkout("ABBACBBAB"));
        }
    }

    public void testSingleProductA() {
        for (Supermarket impl : impls) {
            assertEquals("A single A should be 20", 20, impl.checkout("A"));
        }
    }

    public void testSingleProductB() {
        for (Supermarket impl : impls) {
            assertEquals("A single B should be 50", 50, impl.checkout("B"));
        }
    }

    public void testDiscountProductB() {
        for (Supermarket impl : impls) {
            assertEquals("5 of B should be 150", 150, impl.checkout("BBBBB"));
        }
    }

    public void testSingleProductC() {
        for (Supermarket impl : impls) {
            assertEquals("A single C should be 30", 30, impl.checkout("C"));
        }
    }

    public void testNoProducts() {
        for (Supermarket impl : impls) {
            assertEquals("No products should be free",0, impl.checkout(""));
            assertEquals("No products should be free",0, impl.checkout(null));
        }
    }

    public void testUnknownProducts() {
        for (Supermarket impl : impls) {
            assertEquals("Unknown products should be free", 0, impl.checkout("D"));
        }
    }

    private class ProductA extends AbstractProduct {
        private ProductA() {
            setIdentifier("A");
            addPrice(new PriceA());
        }
    }

    private class ProductB extends AbstractProduct {
        private ProductB() {
            setIdentifier("B");
            addPrice(new PriceB5());
            addPrice(new PriceB1());
        }
    }

    private class ProductC extends AbstractProduct {
        private ProductC() {
            setIdentifier("C");
            addPrice(new PriceC());
        }
    }


    private class PriceA extends AbstractPrice {
        private PriceA() {
            setCost(new BigDecimal(20));
            setQuantity(1);
        }
    }

    private class PriceB1 extends AbstractPrice {
        private PriceB1() {
            setCost(new BigDecimal(50));
            setQuantity(1);
        }
    }

    private class PriceB5 extends AbstractPrice {
        private PriceB5() {
            setCost(new BigDecimal(150));
            setQuantity(5);
        }
    }

    private class PriceC extends AbstractPrice {
        private PriceC() {
            setCost(new BigDecimal(30));
            setQuantity(1);
        }
    }
}
