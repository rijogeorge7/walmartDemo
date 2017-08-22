package com.rijo.walmartdemo.ui.startupScreen;

import com.rijo.walmartdemo.dataRepository.ProductsRepository;
import com.rijo.walmartdemo.domains.product.Item;
import com.rijo.walmartdemo.domains.product.Products;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

/**
 * Created by rijogeorge on 8/19/17.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(StartUpPresenter.class)
public class StartUpPresenterTest {

    @Mock
    StartUpContract.View showProductsActivityMock;
    @Mock
    ProductsRepository productsRepositoryMock;

    StartUpPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter=new StartUpPresenter(showProductsActivityMock,productsRepositoryMock);
    }

    @Test
    public void getProductsTest() throws Exception {
        //given
        when(productsRepositoryMock.getProductsFrom(any(String.class))).thenReturn(new Products());

        //when
        presenter.getProducts();

        //then
        Mockito.verify(showProductsActivityMock).showProductList(any(Products.class));

    }

    @Test
    public void getProductsReturnNullTest() throws Exception {
        //given
        when(productsRepositoryMock.getProductsFrom(any(String.class))).thenReturn(null);

        //when
        presenter.getProducts();
        //then
        Mockito.verify(showProductsActivityMock).showProductNotAvailableScreen();
    }

    @Test
    public void getProductDetailsTest() throws Exception {
        //given
        when(productsRepositoryMock.getProductDetailsFrom(any(String.class))).thenReturn(new Item());
        //when
        presenter.getProductDetails(648);
        //then
        Mockito.verify(showProductsActivityMock).showProductDetailScreen(any(Item.class));

        //given
        when(productsRepositoryMock.getProductDetailsFrom(any(String.class))).thenReturn(null);
        //when
        presenter.getProductDetails(648);
        //then
        Mockito.verify(showProductsActivityMock).showProductDetailNotAvailable();
    }

    @Test
    public void getMoreProductsTest() throws Exception {
        //given
        when(productsRepositoryMock.getProductsFrom(any(String.class))).thenReturn(new Products());
        //when
        presenter.getMoreProducts("string");
        //then
        Mockito.verify(showProductsActivityMock).addMoreDataToAdapter(any(Products.class));
    }
}