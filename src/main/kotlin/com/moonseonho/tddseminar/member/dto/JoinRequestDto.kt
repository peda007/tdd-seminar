package com.moonseonho.tddseminar.member.dto

import com.moonseonho.tddseminar.member.domain.Member

data class JoinRequestDto(

    val email: String?,

    val password: String?
) {

    fun toMember(): Member {
        return Member.accountWith(email, password)
    }
}