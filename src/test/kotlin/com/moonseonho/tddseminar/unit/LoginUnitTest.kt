package com.moonseonho.tddseminar.unit

import com.moonseonho.tddseminar.member.dto.LoginRequestDto
import com.moonseonho.tddseminar.member.repository.MemberRepository
import com.moonseonho.tddseminar.member.service.MemberService
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("로그인 유닛 테스트")
class LoginUnitTest {

    // 기획: 영문자 3글자 이상이 포함돼야 하는 조건
    private val memberRepository: MemberRepository = mockk()
    private val memberService = MemberService(memberRepository)

    @DisplayName("로그인 실패 - 영문자 3글자 이상 포함 안 됨")
    @ParameterizedTest
    @ValueSource(strings = ["a", "as", "as3", "한글테스트"])
    fun `로그인할 때 비밀번호는 영문자 3글자가 포함되지 않으면 RuntimeException이 발생한다`(password: String) {
        // given
        val loginRequestDto = LoginRequestDto("email@gmail.com", password)

        // when
        val catchThrowable = catchThrowable { memberService.login(loginRequestDto) }

        // then
        assertThat(catchThrowable).isInstanceOf(RuntimeException::class.java)
        assertThat(catchThrowable.message).isEqualTo("영문자가 부족하대요")
    }

    @DisplayName("로그인 실패 - 패스워드 입력 안 함")
    @ParameterizedTest
    @NullAndEmptySource
    fun `로그인할 때 비밀번호가 입력되지 않으면 RuntimeException이 발생한다`(password: String?) {
        // given
        val loginRequestDto = LoginRequestDto("email@gmail.com", password)

        // when
        val catchThrowable = catchThrowable { memberService.login(loginRequestDto) }

        // then
        assertThat(catchThrowable).isInstanceOf(IllegalArgumentException::class.java)
        assertThat(catchThrowable.message).isEqualTo("password가 null일 수 없습니다")
    }
}