package hello.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Transactional
    @Test
    void memberTest() {
        memberRepository.initTable();

        Member member = new Member("idA", "memberA");
        memberRepository.save(member);

        Member findMember = memberRepository.find(member.getMemberId());

        assertThat(findMember).isEqualTo(member);
        assertThat(findMember.getMemberId()).isEqualTo(member.getMemberId());
        assertThat(findMember.getName()).isEqualTo(member.getName());
    }
}