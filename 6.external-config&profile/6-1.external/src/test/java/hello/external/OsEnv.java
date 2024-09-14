package hello.external;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class OsEnv {
    public static void main(String[] args) {
        Map<String, String> envSet = System.getenv(); // 모든 시스템 환경 변수를 읽어옴
        for (String key : envSet.keySet()) {
            log.info("env {}={}", key, System.getenv(key));
        }
        /* ex) 외부 설정인 OS 환경변수를 실행 시점에 주입
         * 개발서버: DBURL = dev.db.com
         * 운영서버: DBURL = prod.db.com
         * 
         * // DBURL 값을 조회 시 각각의 환경에 따라서 서로 다른 값을 읽게 됨 (애플리케이션 코드는 동일)
         * String dbUrl = System.getenv("DBURL");
         */

    }
}
