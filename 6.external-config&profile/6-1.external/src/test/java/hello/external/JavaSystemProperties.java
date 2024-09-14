package hello.external;

import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

@Slf4j
public class JavaSystemProperties {
    public static void main(String[] args) {

        // 자바 시스템 속성(Java System properties)은 실행한 JVM 안에서 접근 가능한 외부 설정
        // 자바가 기본으로 제공하는 속성들을 볼 수 있다.
        Properties properties = System.getProperties();
        for (Object key : properties.keySet()) {
            log.info("prop {}={}", key, System.getProperty(String.valueOf(key)));
        }

        /* 1. -D  VM 옵션 방식 (실행 시점에 전달)
        * -D  VM 옵션을 통해서 key=value 형식을 주면 된다.
        * 이 예제는 url=dev 속성을 추가
        * -Durl=devdb -Dusername=dev_user -Dpassword=dev_pw (VM 옵션에 추가한 후 실행)
         */
        String url = System.getProperty("url");
        String username = System.getProperty("username");
        String password = System.getProperty("password");

        log.info("url={}", url); // url=devdb
        log.info("username={}", username); // username=dev_user
        log.info("password={}", password); // password=dev_pw

        // 2. 자바 시스템 속성을 자바 코드로 설정 (해당 방식은 외부로 설정을 분리하는 효과는 X)
        System.setProperty("helloKey", "helloValue");
        log.info("helloKey={}" ,System.getProperty("helloKey"));

        /* 3. Jar 실행
        jar 로 빌드되어 있다면 실행시 다음과 같이 자바 시스템 속성을 추가가능
        java -Durl=devdb -Dusername=dev_user -Dpassword=dev_pw -jar app.jar
         */
    }
}
