# memory-v2 (자동 구성 라이브러리)

### 1. 자동구성용으로 사용할 설정클래스를 만든다.
   - 필요한 bean들을 등록
   - 클래스에 @AutoConfiguration 추가
   - 필요하다면 추가 설정을 넣어준다. 
     - ex) @ConditionalOnProperty 등

### 2. src/main/resources/META-INF/spring/
   org.springframework.boot.autoconfigure.AutoConfiguration.imports 파일을 만든다.
   - 파일에 앞서 만든 자동 구성용 클래스를 패키지를 포함하여 지정
     - ex) memory.MemoryConfig

 <br/>

### 1. 해당 라이브러리 사용 시점
   1. 스프링부트는 시작 시점에 라이브러리들을 뒤져서 각 라이브러리마다 안에 있는 src/main/resources/META-INF/spring/
  org.springframework.boot.autoconfigure.AutoConfiguration.imports 파일을 읽어서 자동구성으로 사용한다.
   2. 자동 구성이 실행될 타이밍에 해당 파일 내에 지정해뒀던 클래스를 빈으로 등록한다. (@AutoConfiguration 을 적용했던 클래스)
   3. 내부에 있는 해당 클래스가 자동으로 실행