package com.rijo.walmartdemo.dataRepository;

import com.rijo.walmartdemo.domains.product.Item;
import com.rijo.walmartdemo.domains.product.Products;

/**
 * Created by rijogeorge on 8/18/17.
 */

public interface ProductsRepository {
    Products getProductsFrom(String urlString);

    Item getProductDetailsFrom(String urlString);
}
