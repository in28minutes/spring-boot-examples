package com.in28minutes.springboot;


import com.in28minutes.springboot.StudentApplication;
import com.in28minutes.springboot.configuration.DevelopmentOnlyConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class CheckBeanAccessibility
{
    @Autowired
    String dummy;


    @Autowired
    @Qualifier("sampleBean")
    String sampleBean;

    @Test
    public void checkBeans()
    {
        Assert.assertNotNull(dummy);
        Assert.assertEquals("something",dummy);
        Assert.assertNotNull(sampleBean);
        Assert.assertEquals("Second Sample bean",sampleBean);
    }
}
