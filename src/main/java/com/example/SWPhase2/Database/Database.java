package com.example.SWPhase2.Database;
import com.example.SWPhase2.Models.Order;
import com.example.SWPhase2.Models.Customer;
import com.example.SWPhase2.Models.Product;
public interface Database {
     Product[] getProducts();
     boolean addCustomer(Customer customer);
     Customer getCustomerByUsername(String username);
     Customer[] getCustomers();
     boolean updateCustomer(Customer customer);
     Customer getCustomerById(int id);

     Order getOrderById(int id);

     boolean addOrder(Order order);

     Product getProductById(int id);
     Order[] getOrders();
     public boolean updateProduct(Product product);


}
