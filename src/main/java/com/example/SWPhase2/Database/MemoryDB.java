package com.example.SWPhase2.Database;

import com.example.SWPhase2.Models.Customer;
import com.example.SWPhase2.Models.Order;
import com.example.SWPhase2.Models.OrderStatus;
import com.example.SWPhase2.Models.Product;
import org.springframework.stereotype.Repository;

import java.net.Inet4Address;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class MemoryDB implements Database{
    HashMap<Integer, Product>products = new HashMap<Integer, Product>();
    HashMap<Integer, Customer>customers = new HashMap<Integer, Customer>();

    HashMap<Integer, Order> orders = new HashMap<Integer, Order>();
    int nextCustomerId = 0;
    int nextOrderId = 0;

    MemoryDB(){
        products.put(1, new Product(1, "product1", "microsoft", "mobile", 23.3, 15));
        products.put(2, new Product(2, "product2", "samsung", "laptop", 213.143, 3));
        products.put(3, new Product(3, "product3", "facebook", "devices", 89.334, 1));
        products.put(4, new Product(4, "product4", "vodafone", "pc", 1033.12, 20));
    }

    @Override
    public Product[] getProducts() {
        Product[] allProducts = new Product[products.size()];
        int cnt = 0;
        for(Map.Entry<Integer, Product> productEntry : products.entrySet()){
            allProducts[cnt] = productEntry.getValue();
            cnt++;
        }
        return  allProducts;
    }

    @Override
    public boolean addCustomer(Customer customer) {
        int id = nextCustomerId++;
        customer.setId(id);
        customers.put(id, customer);
        return  true;
    }

    @Override
    public Customer getCustomerByUsername(String username) {
        for(Map.Entry<Integer, Customer> customerEntry : customers.entrySet()){
            if(customerEntry.getValue().getUsername().equals(username)){
                return customerEntry.getValue();
            }
        }
        return null;
    }

    @Override
    public Customer[] getCustomers(){
        Customer[] customerArray = customers.values().toArray(new Customer[0]);
        return customerArray;
    }

    @Override
    public Customer getCustomerById(int id) {
        return customers.get(id);
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
        return  true;
    }

    @Override
    public boolean addOrder(Order order) {
        order.setId(nextOrderId++);
        Customer customer = getCustomerById(order.getCustomerId());
        customer.addOrder(order.getId());
        orders.put(order.getId(), order);
        order.setOrderStatus(OrderStatus.APPROVED);
        return true;
    }

    @Override
    public boolean updateProduct(Product product) {
        products.put(product.getSerialNumber(), product);
        return  true;
    }

    @Override
    public Product getProductById(int id) {
        return  products.get(id);
    }

    @Override
    public Order[] getOrders() {
        Order[] orderArray = orders.values().toArray(new Order[0]);
        return orderArray;
    }

    @Override
    public Order getOrderById(int id) {
        return  orders.get(id);
    }
}
