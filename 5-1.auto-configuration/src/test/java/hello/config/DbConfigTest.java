package hello.config;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
class DbConfigTest {

    // DbConfig 클래스에 @Configuration을 제거했음에도, 해당 빈들이 정상적으로 주입되는 것을 확인할 수 있음
    // 아래의 빈들은 스프링부트가 자동으로 등록해주는 빈에 속한다.
    @Autowired
    DataSource dataSource;

    @Autowired
    TransactionManager transactionManager;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void checkBean() {
        log.info("dataSource = {}", dataSource);
        log.info("transactionManager = {}", transactionManager);
        log.info("jdbcTemplate = {}", jdbcTemplate);

        // 해당 빈들은 DbConfig 설정을 통해 스프링 컨테이너에 등록했기 때문에, null이면 안됨
        // 사실 @Autowired 는 의존관계 주입에 실패 시 오류가 발생
        assertThat(dataSource).isNotNull();
        assertThat(transactionManager).isNotNull();
        assertThat(jdbcTemplate).isNotNull();
    }


}