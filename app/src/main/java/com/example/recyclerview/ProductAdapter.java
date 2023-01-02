package com.example.recyclerview;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    TextView txtProductTitle,txtProductPrice;
    ImageView imgProduct;
    Product product;
    ArrayList<Product> products;

    public ProductAdapter(ArrayList<Product> products) {
        this.products=products;
    }
    public class  ProductViewHolder extends RecyclerView.ViewHolder{

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduct=itemView.findViewById(R.id.imgProduct);
            imgProduct.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Product product=products.get(getAdapterPosition());
                    Intent intent=new Intent(v.getContext(),ProductsDetailActivity.class);
                 /*   intent.putExtra("id",product.getId());
                    intent.putExtra("imgId", product.getImgId());
                    intent.putExtra("txtTitle",product.getTxtTitle());
                    intent.putExtra("price",product.getPrice());
                    v.getContext().startActivity(intent);*/
                    intent.putExtra("product",product );
                    v.getContext().startActivity(intent);
                }
            });

        }
    }

    @SuppressLint("MissingInflatedId")
    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.product_view,null);
        imgProduct=view.findViewById(R.id.imgProduct);
       /* imgProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "image clicked", Toast.LENGTH_LONG).show();
            }
        });
        txtProductTitle=view.findViewById(R.id.txtProductTitle);
        txtProductTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "txtProductTitle", Toast.LENGTH_LONG).show();
            }
        });
        txtProductPrice=view.findViewById(R.id.txtProductPrice);
        txtProductPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "txtProductsPrice", Toast.LENGTH_LONG).show();
            }
        });*/

        return new ProductViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {
         this.product=products.get(position);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
