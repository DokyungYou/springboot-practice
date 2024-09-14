package hello.external;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommandLineV1 {
    /**
     * ex) java -jar app.jar dataA dataB
     * 필요한 데이터를 마지막 위치에 스페이스로 구분해서 전달
     * 이 경우 dataA , dataB  2개의 문자 가 args 에 전달된다.
     */

    /**
     * CommandLine 인수는 스페이스로 구분
     * java -jar app.jar dataA dataB -> [dataA, dataB] 2개
     * java -jar app.jar url=devdb -> [url=devdb] 1개
     * url=devdb 이라는 단어를 개발자가 직접 파싱해야 함 (통문자로 들어옴)
     * 
     * 형식이 배열이어서 루프를 돌면서 원하는 데이터를 찾아야하는 단점
     */
    public static void main(String[] args) {
        for (String arg : args) {
            log.info("arg {}", arg);
        }
    }
}
