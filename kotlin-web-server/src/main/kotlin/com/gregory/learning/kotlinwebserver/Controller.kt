package com.gregory.learning.kotlinwebserver

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.concurrent.atomic.AtomicLong

@RestController
@CrossOrigin(origins = arrayOf("http://localhost:3000"))
class Controller {

    @Autowired
    lateinit var repository: PersonRepository

    val counter = AtomicLong()

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) =
            Greeting(counter.incrementAndGet(), "Hello, $name")

    @PostMapping("/save")
    fun process(@RequestBody person: Person): String{
        repository.save(person)
        return "Done"
    }

    @RequestMapping("/findall")
    fun findAll(): String{
        var result = ""

        for(person in repository.findAll()){
            result += person.toString()
        }

        return result
    }

    @RequestMapping("/findbyid")
    fun findById(@RequestParam("id") id: Long): String{
        return repository.findById(id).toString()
    }

    @RequestMapping("/findbylastname")
    fun fetchDataByLastName(@RequestParam("lastname") lastName: String): String{
        var result = ""

        for(cust in repository.findByLastName(lastName)){
            result += cust.toString()
        }

        return result
    }

}