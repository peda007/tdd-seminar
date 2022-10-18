package com.moonseonho.tddseminar.unit

import com.querydsl.jpa.impl.JPAQueryFactory
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@DisplayName("querydsl 사용 준비 확인 테스트")
@SpringBootTest
class JpaQueryFactoryBeanInjectionUnitTest @Autowired constructor(
    private val jpaQueryFactory: JPAQueryFactory
) {

    @Test
    fun `jpaQueryFactory Bean은 injection돼있다`() {
        assertThat(jpaQueryFactory).isNotNull
    }
}