package com.in28minutes.springboot.rest.example.dynamicfiltering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonView;

class Views {
    public static class Public {}
    public static class Internal extends Public {}
}

/**
 * @JsonView controls serialization based on the selected view.
 * @JsonFilter allows dynamic property filtering at runtime.
 */
@JsonFilter("SomeBeanFilter")
public record SomeBean(
        @JsonView(Views.Public.class) String field1,
        @JsonView(Views.Internal.class) String field2,
        String field3
) { }
