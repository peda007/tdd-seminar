package com.moonseonho.tddseminar.unit

import com.moonseonho.tddseminar.member.dto.JoinRequestDto
import com.moonseonho.tddseminar.member.repository.MemberRepository
import com.moonseonho.tddseminar.member.service.MemberService
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("회원가입 유닛 테스트")
class JoinUnitTest {

    private val memberRepository: MemberRepository = mockk()
    private val memberService = MemberService(memberRepository)

    @DisplayName("회원가입 실패 - 이메일 없음")
    @ParameterizedTest(name = "email = [{0}]")
    @NullAndEmptySource
    @ValueSource(strings = [" ", "    "])
    fun `이메일없이 회원가입 요청할 때 IllegalArgumentException이 발생한다`(email: String?) {
        // given
        val joinRequestDto = JoinRequestDto(email, "asdf")

        // when
        val catchThrowable = catchThrowable { memberService.join(joinRequestDto) }

        // then
        assertThat(catchThrowable).isInstanceOf(IllegalArgumentException::class.java)
    }
}