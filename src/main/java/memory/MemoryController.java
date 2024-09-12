package memory;

import hello.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * memory 패키지로 별도로 나눈 이유
 * memory 라는 완전한 별도의 모듈이 있고, hello에서 memory의 기능을 가져다 사용한다고 가정한 예제
 */
@Slf4j
@RequiredArgsConstructor
@RestController
public class MemoryController {

    private final MemoryFinder memoryFinder;

    @GetMapping("/memory")
    public Memory system() {
        Memory memory = memoryFinder.get();
        log.info("memory={} ", memory);

        return memory;
    }
}
