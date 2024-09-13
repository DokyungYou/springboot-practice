package hello.member;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class MemberRepository {

    public final JdbcTemplate jdbcTemplate;


    public void initTable() { // 간단한 예제여서 여기서 테이블을 만듬 (원래는 이러면 안됨)
        jdbcTemplate.execute("create table member(member_id varchar primary key, name varchar)");
    }

    public void save(Member member) {
        jdbcTemplate.update("insert into member(member_id, name) values(?,?)",
                member.getMemberId(),
                member.getName());
    }

    public Member find(String memberId) {
        return jdbcTemplate.queryForObject("select member_id, name from member where member_id = ?",
                BeanPropertyRowMapper.newInstance(Member.class),
                memberId);
    }

    public List<Member> findAll() {
        return jdbcTemplate.query("select member_id, name from member",
        BeanPropertyRowMapper.newInstance(Member.class));
    }

}
