package com.in28minutes.springboot.tutorial.basics.application.configuration

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Profile

@SpringBootApplication
class SpringBootTutorialBasicsConfigurationApplication {
    @Profile("dev")
    @Bean
    fun devBean(): String {
        return "dev"
    }

    @Profile("qa")
    @Bean
    fun qaBean(): String {
        return "qa"
    }

    @Profile("prod")
    @Bean
    fun prodBean(): String {
        return "prod"
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val applicationContext: ApplicationContext =
                SpringApplication.run(SpringBootTutorialBasicsConfigurationApplication::class.java, *args)
            applicationContext.beanDefinitionNames.iterator()
                .forEach { name -> println(name) }
        }
    }
}