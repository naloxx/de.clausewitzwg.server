package de.clausewitzwg.server.api

import de.clausewitzwg.server.service.NetworkService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RestController(
        private val networkService: NetworkService
) {

    @GetMapping("/")
    fun greeting() = networkService.test()

}
