package com.rijo.walmartdemo.ui.startupScreen;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rijo.walmartdemo.R;
import com.rijo.walmartdemo.dataRepository.ProductRepositoryImpl;
import com.rijo.walmartdemo.domains.product.Item;
import com.rijo.walmartdemo.domains.product.Products;
import com.rijo.walmartdemo.ui.startupScreen.fragments.NoProductDetailsFragment;
import com.rijo.walmartdemo.ui.startupScreen.fragments.NoProductsFragment;
import com.rijo.walmartdemo.ui.startupScreen.fragments.ProductDetailsFragment;
import com.rijo.walmartdemo.ui.startupScreen.fragments.ProductListFragment;
import com.rijo.walmartdemo.util.Utilities;

public class StartUpActivity extends AppCompatActivity implements StartUpContract.View, ProductListFragment.OnProductSelectedListener, ProductListFragment.OnScrolledToEndListener, ProductDetailsFragment.OnUserSwipedListener {

    public static String PRODUCTS_KEY="com.rijo.walmartdemo.ui.startupScreen.productsKey";
    StartUpPresenter presenter;
    String nextProductUrl;
    int position;
    Products products;
    whichPage currentPage;
    Item item;

    private enum whichPage {
        LIST,
        DETAILS;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            boolean detailsPage=savedInstanceState.getBoolean("detailsPage");
            if(detailsPage) {
                Item item = savedInstanceState.getParcelable(ProductDetailsFragment.ITEM_KEY);
                this.position = savedInstanceState.getInt("position");
                setContentView(R.layout.activity_startup);
                ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
                presenter = new StartUpPresenter(this, productRepository);
                if(Utilities.IsInternetAvailable(getApplicationContext())) {
                    presenter.getProducts();
                    showProductDetailScreen(item);
                }
                else {
                    showNoNetworkDialog();
                }
                return;
            }
        }
        setContentView(R.layout.activity_startup);
        ProductRepositoryImpl productRepository=new ProductRepositoryImpl();
        presenter=new StartUpPresenter(this,productRepository);
        if(Utilities.IsInternetAvailable(getApplicationContext()))
            presenter.getProducts();
        else
            showNoNetworkDialog();
    }

    @Override
    public void showProductList(Products products) {
        this.products=products;
        currentPage=whichPage.LIST;
        nextProductUrl=products.getNextPage();
        Fragment productListFragment=ProductListFragment.newInstance(products);
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, productListFragment,"productListFragment")
                .commit();
    }

    @Override
    public void showProductNotAvailableScreen() {
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new NoProductsFragment())
                .commit();
    }

    @Override
    public void showProductDetailScreen(Item item) {
        this.item=item;
        currentPage=whichPage.DETAILS;
        ProductDetailsFragment productDetailsFragment=(ProductDetailsFragment) getFragmentManager().findFragmentByTag("product details fragment");
        if(productDetailsFragment==null) {
            productDetailsFragment = ProductDetailsFragment.newInstance(item, position);
            getFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, productDetailsFragment, "product details fragment")
                    .commit();
        }
        else {
            productDetailsFragment.setItemandPosition(item,position);
            productDetailsFragment.bindData();
        }
    }

    @Override
    public void showProductDetailNotAvailable() {
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new NoProductDetailsFragment())
                .commit();
    }

    @Override
    public void addMoreDataToAdapter(Products productsMore) {
        products.getItems().addAll(productsMore.getItems());
        nextProductUrl=products.getNextPage();
        ProductListFragment productListFragment=(ProductListFragment) getFragmentManager().findFragmentByTag("productListFragment");
        if(productListFragment!=null)
            productListFragment.addMoreProducts(products);
    }

    //activity callbacks
    @Override
    public void onProductSelected(int position) {
        if(Utilities.IsInternetAvailable(getApplicationContext())) {
            this.position = position;
            presenter.getProductDetails(products.getItems().get(position).getItemId());
        } else {
            showNoNetworkDialog();
        }
    }

    @Override
    public void LoadMore() {
        if(Utilities.IsInternetAvailable(getApplicationContext()))
            presenter.getMoreProducts(nextProductUrl);
        else
            showNoNetworkDialog();
    }

    @Override
    public void loadNextItem(int position) {
            onProductSelected(position);
    }

    private void showNoNetworkDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(StartUpActivity.this);

        builder.setMessage(R.string.internet_dialog_message)
                .setTitle(R.string.internet_dialog_title);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });

        AlertDialog dialog = builder.create();
        builder.show();
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        if(currentPage==whichPage.DETAILS){
            outState.putParcelable(ProductDetailsFragment.ITEM_KEY,item);
            outState.putInt("position",position);
            outState.putBoolean("detailsPage",true);
        } else if(currentPage==whichPage.LIST) {
            outState.putBoolean("detailsPage",false);
        }
    }

    @Override
    public void onBackPressed() {
        if(currentPage==whichPage.DETAILS){
            showProductList(products);
        }
        else{
            super.onBackPressed();
        }
    }

}
