package hello.boot;

import org.springframework.context.annotation.ComponentScan;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented // 문서화
@ComponentScan // 해당 애노테이션을 적용한 클래스의 패키지부터 그 패키지 하위를 컴포넌트 스캔의 대상으로 사용
// 다른 여러 기능도 있다고 가정하자
public @interface MySpringbootApplication {
}
