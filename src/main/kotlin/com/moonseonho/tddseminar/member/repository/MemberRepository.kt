package com.moonseonho.tddseminar.member.repository

import com.moonseonho.tddseminar.member.domain.Member
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository : JpaRepository<Member, Long>, CustomizedMemberRepository {
}