package com.in28minutes.springboot.rest.example.dynamicfiltering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FilteringController {

    // field1,field2
    /** WITH MappingJacksonValue **/
//    @GetMapping("/filtering")
//    public MappingJacksonValue retrieveSomeBean() {
//        var someBean = new SomeBean("value1", "value2", "value3");
//        var filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
//        var filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
//        var mapping = new MappingJacksonValue(someBean);
//        mapping.setFilters(filters);
//
//        return mapping;
//    }

    /**
     * WITH JSON view Dynamic Filter for
     *
     * @return field1, field2
     */
    @GetMapping("/filtering")
    public MappingJacksonValue retrieveSomeBean() {
        SomeBean someBean = new SomeBean("value1", "value2", "value3");
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(someBean);
        mapping.setFilters(filters);

        return mapping;
    }


    // field2, field3
    @GetMapping("/filtering-list")
    public MappingJacksonValue retrieveListOfSomeBeans() {
        List<SomeBean> list = List.of(
                new SomeBean("value1", "value2", "value3"),
                new SomeBean("value12", "value22", "value32")
        );
        var filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
        var filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        var mapping = new MappingJacksonValue(list);
        mapping.setFilters(filters);

        return mapping;
    }

}