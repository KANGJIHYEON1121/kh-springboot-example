package com.kh.springmemberaopjpa.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springmemberaopjpa.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

}
