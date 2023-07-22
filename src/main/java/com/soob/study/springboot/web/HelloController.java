package com.soob.study.springboot.web;

import com.soob.study.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 컨트롤러를 JSON을 반환 컨트롤러로 만듬
// 예쩐 @ResponseBody 를 각 메소드마다 선언 -> 한 번에 사용할 수 있게.
@RestController
public class HelloController {

    // HTTP method인 `Get`의 요청을 받을 수 있는 API를 만들어 줌.
    @GetMapping("/hello")
    public String hello() {
        return "h e l l o";
    }

    @GetMapping("/hello/dto")
    // @R.. : 외부에서 API 넘긴 파라미터를 가져오는 어노테이션
    // 'name'으로 넘긴 파라미터를 메소드 파라미터 `name`에 저장하게 됨
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
