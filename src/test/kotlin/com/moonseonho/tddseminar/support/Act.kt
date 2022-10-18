package com.moonseonho.tddseminar.support

import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import io.restassured.http.Method
import io.restassured.response.ExtractableResponse
import io.restassured.response.ResponseBodyExtractionOptions

abstract class Act {

    protected inline fun <reified T> ResponseBodyExtractionOptions.to(): T {
        return this.`as`(T::class.java)
    }

    protected fun request(method: Method, url: String, body: Any? = null): ExtractableResponse<*> {
        return given()
            .log().all()
            .contentType(ContentType.JSON)
            .body(body)
        .`when`()
            .request(method, url)
        .then()
            .log().all()
            .extract()
    }

    protected fun request(method: Method, url: String): ExtractableResponse<*> {
        return given()
            .log().all()
            .contentType(ContentType.JSON)
        .`when`()
            .request(method, url)
        .then()
            .log().all()
            .extract()
    }
}