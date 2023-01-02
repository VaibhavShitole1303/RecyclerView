package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Product> products;
    RecyclerView recyclerProducts;
    ProductAdapter productAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initProducts();
        initview();

    }

    private void initview() {
        recyclerProducts=findViewById(R.id.recyclerProducts);
        recyclerProducts.setLayoutManager(new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
        ));
        productAdapter=new ProductAdapter(products);
        recyclerProducts.setAdapter(productAdapter);
    }

    private void initProducts() {
        products=new ArrayList<>();
        for (int i=0;i<10;i++){
         products.add(
                 new Product(
                         i,
                         "product"+i,
                         i+500,
                         i+10
                 )
         );
        }
    }
}