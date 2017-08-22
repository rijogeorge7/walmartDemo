package com.rijo.walmartdemo.ui.startupScreen.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rijo.walmartdemo.R;

/**
 * Created by rijogeorge on 8/20/17.
 */

public class NoProductsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_no_products, container, false);
    }
}
