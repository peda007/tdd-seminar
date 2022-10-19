package com.moonseonho.tddseminar.member.service

import com.moonseonho.tddseminar.member.dto.JoinRequestDto
import com.moonseonho.tddseminar.member.dto.LoginRequestDto
import com.moonseonho.tddseminar.member.dto.MyInfoResponseDto
import com.moonseonho.tddseminar.member.repository.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberService(
    private val memberRepository: MemberRepository
) {

    @Transactional(readOnly = true)
    fun getMyInfo(memberId: Long): MyInfoResponseDto {
        return memberRepository.getMemberInfo(memberId) ?: throw IllegalStateException("존재하지 않는 회원입니다.")
    }

    @Transactional
    fun join(joinRequestDto: JoinRequestDto): Long {
        val member = memberRepository.save(joinRequestDto.toMember())
        return member.id
    }

    fun login(loginRequestDto: LoginRequestDto) {
        val regex = Regex("[a-zA-Z]{3,}")
        require(!loginRequestDto.password.isNullOrBlank()) { "password가 null일 수 없습니다" }
        if (!loginRequestDto.password.matches(regex)) {
            throw RuntimeException("영문자가 부족하대요")
        }
    }
}