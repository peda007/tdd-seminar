package com.moonseonho.tddseminar.member.repository

import com.moonseonho.tddseminar.member.dto.MyInfoResponseDto

interface CustomizedMemberRepository {

    fun getMemberInfo(memberId: Long): MyInfoResponseDto?
}