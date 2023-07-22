package com.soob.study.springboot.web;

import com.soob.study.springboot.web.HelloController;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.FilterType;
//import org.springframework.security.test.context.support.WithMockUser;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// JUnit에 내장된 실행자 외 다른 실행자를 실행 (스프링 부트 테스트와 JUnit 사이의 연결자 역할)
// 여기서는 SpringRunner라는 스프링 실행자를 사용
@RunWith(SpringRunner.class)

// 여러 스프링 테스트 어노테이션 중, Web(Spring MVC)에 집중할 수 있는 어노테이션
@WebMvcTest(controllers = HelloController.class)

public class HelloControllerTest {

    // 스프링이 관리하는 빈(Bean)을 주입받는다.
    @Autowired
    // MockMvs : 웹 api 테스트 시 사용, 스프링 MVC 테스트의 시작점, HTTP GET/POST 등의 API에 대한 테스트 가능
   private MockMvc mvc;

    //
    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "h e l l o";

        mvc.perform(get("/hello"))           // `mvc.perform` : `MockMvc`를 통해 /hello 주소로 HTTP GET 요청을 한다. 체이닝이 지워되어 `.andExpect`와 같은 검증 기능을 ..할 수 있다.
                .andExpect(status().isOk())             // `andExpect`: `mvc.perform`의 결과를 검증한다.
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name)                        // `param`: API 요청 시 파라미터 설정, String만 허용
//                        .param("amount", amount))                       // 인자로 String 타입만 허용되어서, 오류가 남!
                        .param("amount", String.valueOf(amount)))   // `jsonPath`: JSON 응답값을 필드별로 검증할 수 있는 메소드, $를 기준으로 필드명을 명시한다.
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
