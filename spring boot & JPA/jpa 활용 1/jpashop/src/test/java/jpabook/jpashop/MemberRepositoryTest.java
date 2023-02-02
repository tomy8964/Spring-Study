package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

   @Test
   @Transactional
   @Rollback(value = false)
   public void testMember() throws Exception {
       //given
       Member member = new Member();
       member.setUsername("memberA");

       //when
       Long saveId = memberRepository.save(member);
       Member findMember = memberRepository.find(saveId);

       //then
       assertThat(findMember.getId()).isEqualTo(member.getId());
       assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
       assertThat(findMember).isEqualTo(member);

   }
    
   
}