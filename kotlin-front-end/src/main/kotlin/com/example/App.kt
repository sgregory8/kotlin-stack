package com.example

import pl.treksoft.kvision.Application
import pl.treksoft.kvision.form.text.text
import pl.treksoft.kvision.html.*
import pl.treksoft.kvision.modal.Alert
import pl.treksoft.kvision.module
import pl.treksoft.kvision.panel.root
import pl.treksoft.kvision.require
import pl.treksoft.kvision.rest.Response
import pl.treksoft.kvision.rest.RestClient
import pl.treksoft.kvision.startApplication
import kotlin.js.Json
import kotlin.js.Promise

class App : Application() {
    init {
        require("css/kvapp.css")
    }

    override fun start() {
        val restClient = RestClient()
        var firstName: String
        var lastName = ""
        root("kvapp") {

            val searchValue: String
            val text = text(label = "Last name")
            div(text) {
                lastName = "$it"
            }
            button("Search", style = ButtonStyle.PRIMARY) {
                onClick {
                    val result: Promise<Response<dynamic>> = restClient.remoteRequest("http://localhost:8080/findbylastname?lastname=" + lastName)
                    result.then {
                        val json = JSON.parse<Json>(it.data.toString())
                        firstName = json["firstName"] as String
                        lastName = json["lastName"] as String
                        Alert.show(firstName + " " + lastName)
                    }
                }
            }
        }
    }
}

fun main() {
    startApplication(::App, module.hot)
}
