package com.example.SWPhase2.Services;

import com.example.SWPhase2.Database.MemoryDB;
import com.example.SWPhase2.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
    MemoryDB memoryDB;
    @Autowired
    public ProductServiceImpl(MemoryDB memoryDB) {
        this.memoryDB = memoryDB;
    }

    @Override
    public Product[] getAllProducts() {
        return memoryDB.getProducts();
    }
}
