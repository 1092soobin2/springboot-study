package com.soob.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 프로젝트의 메인 클래스.

// @SpringBootApplication 가 스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정함
// @.. 위치부터 설정을 읽음 -> 항상 프로젝트 최상단에 위치해야 ^^
@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        // `run`으로 내장 WAS를 실행한다.
        // 내장 WAS란?  외부 WAS 없이, 내부 WAS 실행.
            // 서버에 Tomcat 설치 필요 X할.
            // 스프링부트로 만들어진 Jar 파일로 실행하면 됨.
        // why) 항상 같은 환경에서 스프링 부트 배포 可 -> 스프링 부트에서 내장 WAS 사용을 권고함.
        SpringApplication.run(Application.class, args);
    }
}
