package com.smhrd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.entity.Member;

// mapper 파일임을 명시 -> @Mapper
// root-context.xml 파일에서 어떤 패키지에서 mapper 파일을 scan할건지 명시.
@Mapper
public interface MemberMapper {

	
	// 기존 DAO 역할을 수행한다. DAO는 sqlSession을 열고 닫는 것을 관리했다면
	// MemberMapper 인터페이스는 myBatis한테 SQL 쿼리를 요청만 한다.
	
	// 추상 메서드
	void join(Member member);

	Member login(Member member);

	void update(Member member);

	List<Member> showMember();

	void deleteMember(String email);

	Member emailCheck(String inputE);
	
}
