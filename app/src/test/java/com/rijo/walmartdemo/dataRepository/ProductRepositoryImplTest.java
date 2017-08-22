package com.rijo.walmartdemo.dataRepository;

import com.rijo.walmartdemo.domains.product.Item;
import com.rijo.walmartdemo.domains.product.Products;
import com.rijo.walmartdemo.util.Utilities;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by rijogeorge on 8/19/17.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(Utilities.class)

public class ProductRepositoryImplTest {

    @Mock
    Utilities utilitiesMock;

    ProductRepositoryImpl productRepositoryImpl;

    @Before
    public void setUp() throws Exception {
        productRepositoryImpl=new ProductRepositoryImpl();
    }

    @Test
    public void getProductsFromTest() throws Exception {
        PowerMockito.mockStatic(Utilities.class);
        Products products=new Products();
        when(Utilities.downloadProductsFromUrl(any(String.class))).thenReturn(anyString());
        when(Utilities.getClassFromJSONString(anyString(),Products.class)).thenReturn(products);
        Products products2=productRepositoryImpl.getProductsFrom(Const.walmartPaginatedUrl);
        assertEquals(products2,products);
    }

    @Test
    public void getProductDetailsFromTest() throws Exception {
        PowerMockito.mockStatic(Utilities.class);
        Item item=new Item();
        when(Utilities.downloadProductsFromUrl(any(String.class))).thenReturn(anyString());
        when(Utilities.getClassFromJSONString(anyString(),Item.class)).thenReturn(item);
        Item item2=productRepositoryImpl.getProductDetailsFrom("string");
        assertEquals(item,item2);
    }
}