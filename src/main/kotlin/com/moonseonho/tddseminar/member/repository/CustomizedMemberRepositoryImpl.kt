package com.moonseonho.tddseminar.member.repository

import com.moonseonho.tddseminar.member.domain.QMember.member
import com.moonseonho.tddseminar.member.dto.MyInfoResponseDto
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory

class CustomizedMemberRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory
) : CustomizedMemberRepository {

    override fun getMemberInfo(memberId: Long): MyInfoResponseDto? {
        return jpaQueryFactory
            .select(
                Projections.fields(
                    MyInfoResponseDto::class.java,
                    member.id,
                    member.email,
                    member.name,
                    member.age
                )
            )
            .from(member)
            .where(member.id.eq(memberId))
            .fetchOne()
    }
}