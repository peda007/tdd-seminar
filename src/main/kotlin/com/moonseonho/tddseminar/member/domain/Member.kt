package com.moonseonho.tddseminar.member.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Member(

    @Column(nullable = false)
    val email: String,

    @Column(nullable = false)
    val password: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L
) {

    var name: String? = null
        private set

    var age: Int? = null
        private set

    companion object {
        fun accountWith(email: String?, password: String?): Member {
            requireNotNull(email)
            requireNotNull(password)
            return Member(email = email, password = password)
        }
    }
}