package com.moonseonho.tddseminar.integration

import com.moonseonho.tddseminar.member.repository.MemberRepository
import com.moonseonho.tddseminar.support.QueryDslConfigForTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import

@DisplayName("회원 통합 테스트")
@DataJpaTest
@Import(QueryDslConfigForTest::class)
class MemberIntegrationTest @Autowired constructor(
    private val memberRepository: MemberRepository
) {

    @Test
    fun `최초에는 아이디 1의 회원이 존재하지 않는다`() {
        // given
        val memberId = 1L

        // when
        val myInfo = memberRepository.getMemberInfo(memberId)

        // then
        assertThat(myInfo).isNull()
    }
}