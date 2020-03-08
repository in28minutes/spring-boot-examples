package com.in28minutes.springboot.controller.configuration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DevelopmentOnlyConfigurationTest {
    @Autowired
    String dummy;
    @Autowired
    @Qualifier("dummy2")
    String dummy2;
    @Test
    public void beanAccessTest(){
        Assert.assertNotNull(dummy);
        Assert.assertNotNull(dummy2);
    }
}
