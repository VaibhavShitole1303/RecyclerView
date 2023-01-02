package com.example.recyclerview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ProductsDetailActivity extends Activity {
    TextView txtProductTitle,txtProductPrice;
    ImageView imgProduct;
    Product product;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products_details);
        initview();
        GetExtraData();

    }

    private void GetExtraData() {
        Intent intent=getIntent();
      /*  Bundle bundle=intent.getExtras();
        String txtproducttitle=bundle.getString("txtTitle");
        int id =bundle.getInt("id");
        int imgid=bundle.getInt("imgId");
        int price=bundle.getInt("price");
        txtProductTitle.setText(txtproducttitle);
        txtProductPrice.setText(price);*/
        product =(Product) intent.getSerializableExtra("product");
        product.getId();
        imgProduct.setImageResource(product.getImgId());
        txtProductTitle.setText(product.getTxtTitle());
        txtProductPrice.setText(product.getPrice()+"");
    }

    private void initview() {
        txtProductTitle=findViewById(R.id.txtProductTitle);
        txtProductPrice=findViewById(R.id.txtProductPrice);
        imgProduct=findViewById(R.id.imgProduct);
    }
}
