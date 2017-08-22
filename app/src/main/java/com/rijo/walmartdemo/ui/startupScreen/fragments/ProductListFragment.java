package com.rijo.walmartdemo.ui.startupScreen.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.rijo.walmartdemo.R;
import com.rijo.walmartdemo.domains.product.Products;
import com.rijo.walmartdemo.ui.startupScreen.StartUpActivity;
import com.rijo.walmartdemo.ui.startupScreen.adapters.ProductsRecyclerAdapter;


public class ProductListFragment extends Fragment {

    private Products products;
    private boolean isLoading=false;
    ProgressBar progressBar;

    private OnProductSelectedListener activityCallback;
    private OnScrolledToEndListener loadMoreCallback;
    ProductsRecyclerAdapter productsRecyclerAdapter;

    private static final int loadMoreThreshold=15;

    public ProductListFragment() {
        // Required empty public constructor
    }

    public static ProductListFragment newInstance(Products products) {
        ProductListFragment fragment = new ProductListFragment();
        Bundle args = new Bundle();
        args.putParcelable(StartUpActivity.PRODUCTS_KEY, products);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            products = getArguments().getParcelable(StartUpActivity.PRODUCTS_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_product_list, container, false);
        progressBar=(ProgressBar)view.findViewById(R.id.progressBar);
        RecyclerView productsRecyclerView=view.findViewById(R.id.productList_recycler_view);
        productsRecyclerView.setHasFixedSize(true);
        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        productsRecyclerView.setLayoutManager(mLayoutManager);
        productsRecyclerAdapter=new ProductsRecyclerAdapter(products,getActivity().getApplicationContext(),activityCallback);
        productsRecyclerView.setAdapter(productsRecyclerAdapter);
        productsRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int totalItemCount = mLayoutManager.getItemCount();
                int lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
                if (!isLoading && totalItemCount <= (lastVisibleItem + loadMoreThreshold)) {
                    isLoading = true;
                    progressBar.setVisibility(View.VISIBLE);
                    loadMoreCallback.LoadMore();
            }
        };
        });
        return view;
    }

    public void addMoreProducts(Products products){
        productsRecyclerAdapter.setMoreData(products);
        progressBar.setVisibility(View.GONE);
        isLoading=false;
    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        try {
            activityCallback = (OnProductSelectedListener) context;
            loadMoreCallback = (OnScrolledToEndListener) context;
        } catch(ClassCastException e) {
            throw new RuntimeException(context.toString()
                    + " must implement OnProductSelectedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activityCallback = null;
        loadMoreCallback = null;
    }


    public interface OnProductSelectedListener {
        void onProductSelected(int position);
    }
    public interface OnScrolledToEndListener {
        void LoadMore();
    }
}
