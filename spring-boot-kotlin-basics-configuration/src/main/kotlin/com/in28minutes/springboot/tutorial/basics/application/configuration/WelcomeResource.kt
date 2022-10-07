package com.in28minutes.springboot.tutorial.basics.application.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class WelcomeResource {
    @Value("\${welcome.message}")
    private val welcomeMessage: String? = null

    @Autowired
    private val configuration: BasicConfiguration? = null

    @GetMapping("/welcome")
    fun retrieveWelcomeMessage(): String? {
        // Complex Method
        return welcomeMessage
    }

    @RequestMapping("/dynamic-configuration")
    fun dynamicConfiguration(): Map<String, Any?> {
        // Not the best practice to use a map to store different types!
        val configMap: MutableMap<String, Any?> = HashMap()
        configMap["message"] = configuration!!.message
        configMap["number"] = configuration.number
        configMap["key"] = configuration.isValue
        return configMap
    }
}