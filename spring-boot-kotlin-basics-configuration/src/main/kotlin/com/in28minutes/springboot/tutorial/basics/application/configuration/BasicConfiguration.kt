package com.in28minutes.springboot.tutorial.basics.application.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties("basic")
class BasicConfiguration {
    var isValue = false
    var message: String? = null
    var number = 0
}