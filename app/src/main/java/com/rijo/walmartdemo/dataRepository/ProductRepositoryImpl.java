package com.rijo.walmartdemo.dataRepository;

import com.rijo.walmartdemo.domains.product.Item;
import com.rijo.walmartdemo.domains.product.Products;
import com.rijo.walmartdemo.util.Utilities;


/**
 * Created by rijogeorge on 8/18/17.
 */

public class ProductRepositoryImpl implements ProductsRepository {

    @Override
    public Products getProductsFrom(String urlString) {
        String productString= Utilities.downloadProductsFromUrl(urlString);
        if(productString!=null) {
            Products products = Utilities.getClassFromJSONString(productString, Products.class);
            return products;
        }
        else {
            return null;
        }
    }

    @Override
    public Item getProductDetailsFrom(String urlString) {
        String itemString= Utilities.downloadProductsFromUrl(urlString);
        if(itemString!=null) {
            Item item=Utilities.getClassFromJSONString(itemString,Item.class);
            return item;
        }
        else {
            return null;
        }
    }

}
