package com.in28minutes.springboot.tutorial.basics.application.configuration

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = [SpringBootTutorialBasicsConfigurationApplication::class])
class SpringBootTutorialBasicsConfigurationApplicationTests {
    @Test
    fun contextLoads() {
    }
}