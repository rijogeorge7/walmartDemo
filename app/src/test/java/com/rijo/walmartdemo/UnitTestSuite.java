package com.rijo.walmartdemo;

import com.rijo.walmartdemo.dataRepository.ProductRepositoryImplTest;
import com.rijo.walmartdemo.ui.startupScreen.StartUpPresenterTest;
import com.rijo.walmartdemo.util.UtilitiesTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by rijogeorge on 8/22/17.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({StartUpPresenterTest.class,
        ProductRepositoryImplTest.class,
        UtilitiesTest.class})
public class UnitTestSuite {
}
