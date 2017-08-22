package com.rijo.walmartdemo.ui.startupScreen.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rijo.walmartdemo.R;
import com.rijo.walmartdemo.domains.product.Item;
import com.rijo.walmartdemo.ui.startupScreen.StartUpActivity;
import com.rijo.walmartdemo.ui.startupScreen.adapters.ProductsRecyclerAdapter;

/**
 * Created by rijogeorge on 8/21/17.
 */

public class ProductDetailsFragment extends Fragment {

    public static final String ITEM_KEY="com.rijo.walmartdemo.ui.startupScreen.fragments.itemKey";
    public static final String POSITION_KEY="com.rijo.walmartdemo.ui.startupScreen.fragments.positionKey";
    ImageView largeImage,star1,star2,star3,star4,star5;
    TextView name,description,reviewCount,stockAvailable,shipToStore;
    View transparentView;
    ProgressBar progressBar;
    private Item item;
    private int position;
    OnUserSwipedListener swipeListener;
    private boolean isLoading=true;

    public static ProductDetailsFragment newInstance(Item item,int position) {
        ProductDetailsFragment productDetailsFragment=new ProductDetailsFragment();
        Bundle args=new Bundle();
        args.putParcelable(ITEM_KEY,item);
        args.putInt(POSITION_KEY,position);
        productDetailsFragment.setArguments(args);
        return productDetailsFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            item = getArguments().getParcelable(ITEM_KEY);
            position=getArguments().getInt(POSITION_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_product_details, container, false);
        transparentView=(View) view.findViewById(R.id.transparentView);
        progressBar=(ProgressBar)view.findViewById(R.id.progressBar);
        ScrollView screen=(ScrollView) view.findViewById(R.id.screen);
        screen.setOnTouchListener(new View.OnTouchListener() {
            float swipeThreshold=150;
            float x1=0,x2=0,y1=0,y2=0;
            long t1=0,t2=0;

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(!isLoading) {
                    switch (motionEvent.getAction()) {

                        case MotionEvent.ACTION_DOWN:
                            x1 = motionEvent.getX();
                            y1 = motionEvent.getY();
                            t1 = System.currentTimeMillis();
                            return true;

                        case MotionEvent.ACTION_UP:
                            x2 = motionEvent.getX();
                            y2 = motionEvent.getY();
                            t2 = System.currentTimeMillis();

                            if ((x1 - x2) > swipeThreshold) {
                                try {
                                    setTransparentLayer(true);
                                    swipeListener.loadNextItem(position + 1);
                                    return true;
                                }catch(ArrayIndexOutOfBoundsException e) {

                                }
                            } else if ((x2 - x1) > swipeThreshold) {
                                if (position > 0) {
                                    setTransparentLayer(true);
                                    swipeListener.loadNextItem(position - 1);
                                    return true;
                                }
                            }
                    }
                }

                return false;
            }
        });
        largeImage=(ImageView)view.findViewById(R.id.imageView);
        name=(TextView)view.findViewById(R.id.name);
        description=(TextView)view.findViewById(R.id.description);
        reviewCount=(TextView)view.findViewById(R.id.reviewCount);
        star1=(ImageView) view.findViewById(R.id.star1);
        star2=(ImageView) view.findViewById(R.id.star2);
        star3=(ImageView) view.findViewById(R.id.star3);
        star4=(ImageView) view.findViewById(R.id.star4);
        star5=(ImageView) view.findViewById(R.id.star5);
        stockAvailable=(TextView)view.findViewById(R.id.stockAvilable);
        shipToStore=(TextView)view.findViewById(R.id.shiptoStore);
        bindData();
        return view;
    }

    public void bindData(){
        Glide.with(getActivity())
                .load(item.getLargeImage())
                .into(largeImage);
        name.setText(item.getName());
        description.setText(item.getLongDescription());
        reviewCount.setText("("+String.valueOf(item.getNumReviews())+")");
        try {
            setRatingStars(star1, star2, star3, star4, star5, Double.parseDouble(item.getCustomerRating()));

            if (item.getStock().equals("Available"))
                stockAvailable.setTextColor(getActivity().getResources().getColor(R.color.greenColor));
            else
                stockAvailable.setTextColor(getActivity().getResources().getColor(R.color.redColor));

            stockAvailable.setText(item.getStock());

            if(item.getShipToStore()) {
                shipToStore.setTextColor(getActivity().getResources().getColor(R.color.greenColor));
                shipToStore.setText("Yes");
            }
            else {
                shipToStore.setTextColor(getActivity().getResources().getColor(R.color.redColor));
                shipToStore.setText("No");
            }
        } catch (Exception e) {

        }
        finally {
            isLoading=false;
            setTransparentLayer(false);
        }
    }

    private void setTransparentLayer(boolean flag){
        if(flag){
            transparentView.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.VISIBLE);
        }
        else{
            transparentView.setVisibility(View.GONE);
            progressBar.setVisibility(View.GONE);
        }
    }

    public void setItemandPosition(Item item,int position){
        this.item=item;
        this.position=position;
    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        try {
            swipeListener = (ProductDetailsFragment.OnUserSwipedListener) context;
        } catch(ClassCastException e) {
            throw new RuntimeException(context.toString()
                    + " must implement OnUserSwipedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        swipeListener = null;
    }

    private void setRatingStars(ImageView star1,ImageView star2,ImageView star3,ImageView star4,ImageView star5, double rating) {
        if(rating>=1)
            star1.setImageResource(R.drawable.star_posetive);
        if(rating>=2)
            star2.setImageResource(R.drawable.star_posetive);
        if(rating>=3)
            star3.setImageResource(R.drawable.star_posetive);
        if(rating>=4)
            star4.setImageResource(R.drawable.star_posetive);
        if(rating>=5)
            star5.setImageResource(R.drawable.star_posetive);
    }

    public interface OnUserSwipedListener {
        void loadNextItem(int position);
    }

}
