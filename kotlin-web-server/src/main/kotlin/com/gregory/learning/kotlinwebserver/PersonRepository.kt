package com.gregory.learning.kotlinwebserver

import org.springframework.data.repository.CrudRepository

interface PersonRepository : CrudRepository<Person, Long> {
    fun findByLastName(lastName: String): List<Person>
}