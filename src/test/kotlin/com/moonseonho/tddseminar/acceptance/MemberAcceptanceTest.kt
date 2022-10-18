package com.moonseonho.tddseminar.acceptance

import com.moonseonho.tddseminar.common.dto.CreatedResponseDto
import com.moonseonho.tddseminar.member.dto.JoinRequestDto
import com.moonseonho.tddseminar.member.dto.MyInfoResponseDto
import io.restassured.http.Method
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("회원 인수 테스트")
class MemberAcceptanceTest : AcceptanceTest() {

    @Test
    fun `회원 가입한 뒤 아이디로 조회하면 내 계정이 조회된다`() {
        val email = "email"
        val joinRequestDto = JoinRequestDto(email, "pass")
        val joinResponse = request(Method.POST, "/members", joinRequestDto)
        val joinResponseDto = joinResponse.to<CreatedResponseDto>()

        val getMyInfoResponse = request(Method.GET, "/members/${joinResponseDto.createdId}")
        val myInfoResponseDto = getMyInfoResponse.to<MyInfoResponseDto>()

        assertThat(myInfoResponseDto.id).isEqualTo(1L)
        assertThat(myInfoResponseDto.email).isEqualTo(email)
    }
}