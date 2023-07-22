package com.soob.study.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}

// 에러 전

//    Testing started at 9:16 PM ...
//
//        > Task :compileJava FAILED
//       /Users/soobinlee/IdeaProjects/springboot-study/src/main/java/com/soob/study/springboot/web/dto/HelloResponseDto.java:11: error: variable name not initialized in the default constructor
//private final String name;
//        ^
//        /Users/soobinlee/IdeaProjects/springboot-study/src/main/java/com/soob/study/springboot/web/dto/HelloResponseDto.java:12: error: variable amount not initialized in the default constructor
//private final int amount;
//        ^
//        2 errors
//        FAILURE: Build failed with an exception.
//        * What went wrong:
//        Execution failed for task ':compileJava'.
//        > Compilation failed; see the compiler error output for details.
//        * Try:
//        Run with --stacktrace option to get the stack trace. Run with --info or --debug option to get more log output. Run with --scan to get full insights.
//        * Get more help at https://help.gradle.org
//        Deprecated Gradle features were used in this build, making it incompatible with Gradle 7.0.
//        Use '--warning-mode all' to show the individual deprecation warnings.
//        See https://docs.gradle.org/6.3/userguide/command_line_interface.html#sec:command_line_warnings
//        BUILD FAILED in 666ms
//        1 actionable task: 1 executed

// 해결
// build.gradle dependencies에 `annotationProcessor("org.projectlombok:lombok")` 추가