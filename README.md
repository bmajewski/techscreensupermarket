Problem Statement
=================

Review the following technical problem. There are few basic requirements and inputs and outputs but the
design is completely open-ended. The solution should be delivered via a git repo (preferred) or zip file.
 
 
The Problem:
 
A supermarket sells 3 products listed below: 

* Product A = $20
* Product B = $50 (or 5 for the price of 3)
* Product C = $30
 
Implement the code for a checkout register that calculates the price
of a given sequence of items. The input is a product list as a
String, e.g "ABBACBBAB" : for which the output should be the integer 240.
Please consider testability, documentation, and other good coding
practices in your solution. As an additional challenge, consider how
new pricing rules might be provided programmatically.
 
 
 
Implement the following:
 
 
    public interface Supermarket {
     
       public int checkout(String items);
     
    }

Solution
========

The project is organized using [Maven](http://maven.apache.org) to supply dependencies and provide 
easy test case running. Two concrete implementations of the `Supermarket` interface have been provided. 
`QuickAndDirtySupermarket` provides a basic implementation with support only for the conditions provided.
`ExtensibleSupermarket` and its supporting classes provides a pricing system that supports multiple 
products and multiple pricing levels for each product. It can also be extended at runtime with new
pricing conditions. 

This implementation makes some assumptions about the type of pricing discounts that 
can be applied and optimizes pricing by ordering the list of items before assigning costs. Further
enhancements could provide a way to price each item as it is scanned and then apply discounts as purchase
requirements are met.

