package com.gregory.learning.kotlinwebserver

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "customer")
class Person(
        @Id
        val id: Long = -1,

        @Column(name = "firstname")
        val firstName: String = "",

        @Column(name = "lastname")
        val lastName: String = ""
){
    override fun toString(): String {
        return "{\n" +
                "\t\"id\" : " + id + ",\n" +
                "\t\"firstName\": \"" + firstName + "\",\n" +
                "\t\"lastName\" : \"" + lastName + "\"\n" +
                "}"
    }
}