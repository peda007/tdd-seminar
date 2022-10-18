package com.moonseonho.tddseminar.member.controller

import com.moonseonho.tddseminar.common.dto.CreatedResponseDto
import com.moonseonho.tddseminar.member.dto.JoinRequestDto
import com.moonseonho.tddseminar.member.dto.MyInfoResponseDto
import com.moonseonho.tddseminar.member.service.MemberService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/members")
class MemberRestController(
    private val memberService: MemberService
) {

    @PostMapping
    fun join(@RequestBody joinRequestDto: JoinRequestDto): ResponseEntity<CreatedResponseDto> {
        val memberId = memberService.join(joinRequestDto)
        return ResponseEntity.ok(CreatedResponseDto(memberId))
    }

    @GetMapping("/{memberId}")
    fun getMyInfo(@PathVariable memberId: Long): ResponseEntity<MyInfoResponseDto> {
        val myInfo = memberService.getMyInfo(memberId)
        return ResponseEntity.ok(myInfo)
    }
}