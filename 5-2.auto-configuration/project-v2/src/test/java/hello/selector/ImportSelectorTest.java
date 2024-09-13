package hello.selector;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.*;

public class ImportSelectorTest {

    @Test
    void staticConfig() {
        // 스프링 컨테이너
        AnnotationConfigApplicationContext appContext =
                new AnnotationConfigApplicationContext(StaticConfig.class);

        HelloConfig bean = appContext.getBean(HelloConfig.class);
        assertThat(bean).isNotNull();
    }

    @Test
    void selectorConfig() {
        // 스프링 컨테이너
        AnnotationConfigApplicationContext appContext =
                new AnnotationConfigApplicationContext(SelectorConfig.class);
        HelloConfig bean = appContext.getBean(HelloConfig.class);
        assertThat(bean).isNotNull();
    }

    @Configuration
    @Import(HelloConfig.class)
    public static class StaticConfig {
    }

    @Configuration
    @Import(HelloImportSelector.class) // 구현한 메서드의 반환값 기준 (동적으로 import)
    public static class SelectorConfig {
    }


}
