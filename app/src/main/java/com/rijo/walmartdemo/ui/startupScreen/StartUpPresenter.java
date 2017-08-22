package com.rijo.walmartdemo.ui.startupScreen;

import com.rijo.walmartdemo.dataRepository.Const;
import com.rijo.walmartdemo.dataRepository.ProductsRepository;
import com.rijo.walmartdemo.domains.product.Item;
import com.rijo.walmartdemo.domains.product.Products;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by rijogeorge on 8/18/17.
 */

public class StartUpPresenter implements StartUpContract.UserActionListener {
    StartUpContract.View view;
    ProductsRepository productsRepository;

    public StartUpPresenter(StartUpContract.View view, ProductsRepository productsRepository) {
        this.view=view;
        this.productsRepository=productsRepository;
    }

    @Override
    public void getProducts() {
        Products products=null;
        ExecutorService executor= Executors.newSingleThreadExecutor();
        Future<Products> productFuture=executor.submit(new Callable<Products>() {
            @Override
            public Products call() throws Exception {
                return productsRepository.getProductsFrom(Const.walmartPaginatedUrl);
            }
        });
        try {
            products=productFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        if(products!=null) {
            view.showProductList(products);
        } else {
            view.showProductNotAvailableScreen();
        }
    }

    @Override
    public void getProductDetails(int itemId) {
        Item item=null;
        final String urlString="http://api.walmartlabs.com/v1/items/"+itemId+"?format=json&apiKey=hcucxgupb42ktqxn5mdbweee";
        ExecutorService executor= Executors.newSingleThreadExecutor();
        Future<Item> itemFuture=executor.submit(new Callable<Item>() {
            @Override
            public Item call() throws Exception {
                return productsRepository.getProductDetailsFrom(urlString);
            }
        });
        try{
            item=itemFuture.get();
        }catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(item!=null)
            view.showProductDetailScreen(item);
        else
            view.showProductDetailNotAvailable();
    }

    @Override
    public void getMoreProducts(final String url) {
        Products products=null;
        ExecutorService executor= Executors.newSingleThreadExecutor();
        Future<Products> productFuture=executor.submit(new Callable<Products>() {
            @Override
            public Products call() throws Exception {
                return productsRepository.getProductsFrom(Const.walmartPaginatedBaseUrl+url);
            }
        });
        try {
            products=productFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        if(products!=null) {
            view.addMoreDataToAdapter(products);
        }
    }

}
