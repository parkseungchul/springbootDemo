package com.psc.demo003.repository;

import org.springframework.data.repository.CrudRepository;

import com.psc.demo003.domain.Member;

public interface MemberRepository extends CrudRepository<Member, String> {

}
