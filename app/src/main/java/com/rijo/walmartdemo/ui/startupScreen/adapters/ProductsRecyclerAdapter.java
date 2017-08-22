package com.rijo.walmartdemo.ui.startupScreen.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rijo.walmartdemo.R;
import com.rijo.walmartdemo.domains.product.Products;
import com.rijo.walmartdemo.ui.startupScreen.fragments.ProductListFragment;

/**
 * Created by rijogeorge on 8/20/17.
 */

public class ProductsRecyclerAdapter extends RecyclerView.Adapter<ProductsRecyclerAdapter.ViewHolder> {
    private Products products;
    Context context;
    ProductListFragment.OnProductSelectedListener activityCallback;

    public ProductsRecyclerAdapter(Products products,Context context,ProductListFragment.OnProductSelectedListener activityCallback) {
        this.products=products;
        this.context=context;
        this.activityCallback=activityCallback;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list_row, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(products.getItems().get(position).getName());
        try {
            if (products.getItems().get(position).getStock().equals("Available"))
                holder.stock.setTextColor(context.getResources().getColor(R.color.greenColor));
            else
                holder.stock.setTextColor(context.getResources().getColor(R.color.redColor));
            holder.stock.setText(products.getItems().get(position).getStock());
            holder.reviewCount.setText("(" + String.valueOf(products.getItems().get(position).getNumReviews()) + ")");
            if (products.getItems().get(position).getFreeShipToStore())
                holder.type.setText(R.string.ship_to_home);
            else
                holder.type.setText("");
        }catch (Exception e) {

        }
        Glide.with(context)
                .load(products.getItems().get(position).getThumbnailImage())
                .into(holder.imageViewThumb);
        try {
            setRatingStars(holder, Double.parseDouble(products.getItems().get(position).getCustomerRating()));
        }catch (Exception e) {

        }
    }

    @Override
    public int getItemCount() {
        return products.getItems().size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name,type,stock,reviewCount;
        private ImageView imageViewThumb,star1,star2,star3,star4,star5;
        public ViewHolder(View itemView) {
            super(itemView);
            name=(TextView) itemView.findViewById(R.id.name);
            reviewCount=(TextView) itemView.findViewById(R.id.review_count);
            stock=(TextView) itemView.findViewById(R.id.stock);
            type=(TextView) itemView.findViewById(R.id.type);
            imageViewThumb=(ImageView) itemView.findViewById(R.id.imageViewThumb);
            star1=(ImageView) itemView.findViewById(R.id.star1);
            star2=(ImageView) itemView.findViewById(R.id.star2);
            star3=(ImageView) itemView.findViewById(R.id.star3);
            star4=(ImageView) itemView.findViewById(R.id.star4);
            star5=(ImageView) itemView.findViewById(R.id.star5);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    activityCallback.onProductSelected(pos);
                }
            });
        }
    }

    private void setRatingStars(ViewHolder holder, double rating) {
        if(rating>=1)
            holder.star1.setImageResource(R.drawable.star_posetive);
        if(rating>=2)
            holder.star2.setImageResource(R.drawable.star_posetive);
        if(rating>=3)
            holder.star3.setImageResource(R.drawable.star_posetive);
        if(rating>=4)
            holder.star4.setImageResource(R.drawable.star_posetive);
        if(rating>=5)
            holder.star5.setImageResource(R.drawable.star_posetive);
    }

    public void setMoreData(Products moreProducts) {
        products.getItems().addAll(moreProducts.getItems());
        notifyDataSetChanged();
    }
}
