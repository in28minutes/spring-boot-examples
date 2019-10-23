package com.in28minutes.springboot.configuration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigurationBeanTest {

    @Autowired
    String dummy;

    @Autowired
    @Qualifier("anotherBean")
    String anotherBean;

    @Test
    public void dummy() {
        assertEquals("something",dummy);
    }

    @Test
    public void anotherBean() {
        assertEquals("Production bean",anotherBean);
    }

}