package com.ohgiraffers.common;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

// Database Access Object = DAO
@Component
public class MemberDAO {
    //final 키워드를 붙혀서 필드값을 클래스 내부에서 변경못하게함
    //목적 자체가 상수가 아니고 변경하지 못하게 막은 거기 때문에 상수 목적이 아니라 소문자로 작성
    private final Map<Integer, MemberDTO> memberMap;

    public MemberDAO() {
        memberMap = new HashMap<Integer, MemberDTO>();
        
        memberMap.put(1, new MemberDTO(1, "user01", "pass01", "홍길동"));
        memberMap.put(2, new MemberDTO(2, "user02", "pass02", "유관순"));
    }

    public MemberDTO findMemberBySeq(int seq) {

        return memberMap.get(seq);
    }

    public boolean save(MemberDTO member) {

        int before = memberMap.size();

        memberMap.put(member.getSequence(), member);

        int after = memberMap.size();

        return after > before;
    }
}
