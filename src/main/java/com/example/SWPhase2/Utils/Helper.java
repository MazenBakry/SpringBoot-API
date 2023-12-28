package com.example.SWPhase2.Utils;

import com.example.SWPhase2.Database.Database;
import com.example.SWPhase2.Models.Order;
import com.example.SWPhase2.Models.Product;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Helper {
    public static double  calculateAmount(Database db, Order order){
        double totalAmount = 0;
        ArrayList<Integer> productsId = order.getProducts();
        for (int pId : productsId) {
            Product product = db.getProductById(pId);
            totalAmount += product.getPrice();
        }
        return  totalAmount;
    }

    public static void updateProducts(Database db,  Order order){
        ArrayList<Integer> productsId = order.getProducts();
        for (int pId : productsId) {
            Product product = db.getProductById(pId);
            product.setAmountAvailable(product.getAmountAvailable()-1);
        }
    }

    public static boolean CheckAvaliableProducts(Database db, HashMap<Product, Integer>productsNum){
        for(Map.Entry<Product, Integer>entry :productsNum.entrySet()){
            if(entry.getKey().getAmountAvailable() < entry.getValue()){
                return  false;
            }
        }
        return  true;
    }

    public  static  HashMap<Product, Integer> createProductsNum(Database db, ArrayList<Integer>products){
        HashMap<Product, Integer>productsNum = new HashMap<>();
        for(Integer productId : products){
            Product product = db.getProductById(productId);
            Integer currAmount = productsNum.get(product);
            if(currAmount == null){
                currAmount = 1;
            }else{
                currAmount++;
            }
            productsNum.put(product, currAmount);
        }
        return  productsNum;
    }
}
