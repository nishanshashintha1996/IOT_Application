package com.example.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class SecoundryProductAdapter extends RecyclerView.Adapter<SecoundryProductAdapter.ProductViewHolder> {

    private Context mCtx;
    private List<SecoundryProduct> secoundryProductList;

    public SecoundryProductAdapter(Context mCtx, List<SecoundryProduct> secoundryProductList) {
        this.mCtx = mCtx;
        this.secoundryProductList = secoundryProductList;
    }

    @NonNull
    @Override
    public SecoundryProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.secoundry_list_layout,null);
        SecoundryProductAdapter.ProductViewHolder holder = new SecoundryProductAdapter.ProductViewHolder(view);
        return new SecoundryProductAdapter.ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder productViewHolder, int position) {
        SecoundryProduct secoundryProduct = secoundryProductList.get(position);
        productViewHolder.textViewTitle.setText(secoundryProduct.getTitle());
        //productViewHolder.textViewDescription.setText(product.getDescription());
        //productViewHolder.textViewRating.setText(String.valueOf(product.getRating()));
        //productViewHolder.textViewPrice.setText(String.valueOf(product.getPrice()));
        Glide.with(mCtx)
                .load(secoundryProduct.getImage())
                .into(productViewHolder.imageView);
    }


    @Override
    public int getItemCount() {
        return secoundryProductList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textViewTitle, textViewDescription, textViewRating, textViewPrice;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            //textViewDescription = itemView.findViewById(R.id.textViewShortDesc);
            //textViewPrice = itemView.findViewById(R.id.textViewPrice);
            //textViewRating = itemView.findViewById(R.id.textViewRating);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
        }
    }
}
