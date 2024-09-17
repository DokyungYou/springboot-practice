package hello.external;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;

import java.util.List;
import java.util.Set;

@Slf4j
public class CommandLineV2 {
    public static void main(String[] args) {
        /** 커맨드 라인 옵션 인수 (command line option arguments)
         *
         * - 자바 언어의 표준 기능 X (스프링이 제공하는 기능)
         * - key=value 형식의 방식
         * - 커맨드 라인에 - (dash) 2개( -- )를 연결해서 시작
         *
         * ex) --url=devdb --username=dev_user --password=dev_pw mode=on
 *             mode=on 은 일반 커맨드라인 (비교용)
         */
        
        // 하나의 문자열로 나옴  ex) --url=devdb
        for (String arg : args) {
            log.info("arg {}", arg);
        }

        // ApplicationArguments 인터페이스와 DefaultApplicationArguments 구현체를 사용 하면 커맨드 라인 옵션 인수를 규격대로 파싱해서 편리하게 사용
        ApplicationArguments appArgs = new DefaultApplicationArguments(args);
        log.info("SourceArgs = {}", List.of(appArgs.getSourceArgs())); // SourceArgs = [--url=devdb, --username=dev_user, --password=dev_pw, mode=on]
        log.info("NonOptionsArgs ={}", appArgs.getNonOptionArgs()); // NonOptionsArgs =[mode=on]
        log.info("OptionNames={}", appArgs.getOptionNames()); // OptionNames=[password, url, username]

        Set<String> optionNames = appArgs.getOptionNames();
        for (String optionName : optionNames) {
            log.info("option args {}={}", optionName, appArgs.getOptionValues(optionName)); // option args password=[dev_pw] ...
        }

        // 하나의 키에 여러 값을 포함하는 것이 가능해서 List로 반환
        // ex) --url=devdb --url=devdb2
        List<String> url = appArgs.getOptionValues("url");
        List<String> username = appArgs.getOptionValues("username");
        List<String> password = appArgs.getOptionValues("password");
        List<String> mode = appArgs.getOptionValues("mode");

        log.info("url={}", url); // url=[devdb1, devdb2]
        log.info("username={}", username); // username=[dev_user]
        log.info("password={}", password); // password=[dev_pw]
        log.info("mode={}", mode); // mode=null



    }
}
