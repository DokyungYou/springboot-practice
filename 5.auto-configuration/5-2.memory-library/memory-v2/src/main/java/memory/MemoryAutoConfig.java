package memory;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

@AutoConfiguration // 스프링 부트가 제공하는 자동 구성 기능을 적용할 떄 사요하는 애노테이션
@ConditionalOnProperty(name = "memory", havingValue = "on") // 해당 환경정보가 있을 때 라이브러리 적용 (스프링 빈 등록)
public class MemoryAutoConfig {

    @Bean
    public MemoryFinder memoryFinder() {
        return new MemoryFinder();
    }

    @Bean
    public MemoryController memoryController() {
        return new MemoryController(memoryFinder());
    }
}
