package com.soob.study.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// JPA에서 제공하는 package
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// [annotation 설명]
// 정렬 기준        : 주요 어노테이션을 클래스에 가깝게 둔다. (why? 코틀린 등의 새 언어 전화으로 롬복이 더 이상 필요 없을 경우 쉽게 삭제 可)
// lombok 사용 이유 : 서비스 초기 구축 단계에서 table 설계 (여기서는 Entity 설계) 가 빈번하게 변경됨. lombok 이 코드 변경량을 최소화 시켜줌.

// [Setter 메소드가 없는 이유]
// pb) 자바빈규약에 따라 getter/setter 를 무작정 생성함 -> 인스턴스 값이 어디서 변해야 하는지 코드 상으로 명확하게 구분할 수 없다. 차후 기능 변경 시 복잡해짐.
// sol) Entity class 에서 절대 setter 메소드를 만들지 않음.
//      값 변경이 필요하면, 명확히 목적/의도를 나타낼 수 있는 메소드 추가.



@Getter                                                     // lombok annotation

// 기본 생성자 자동 추가
// `public Posts() {}` 와 같은 효과이다.
@NoArgsConstructor                                          // lombok annotation

// RDB table과 매칭될 class임을 나타낸다.
// 이름 매칭 default : 카멜 케이스 이름을 언더스코어(_) 이름으로 매칭 e.g. SalesManager.java -> sales_manager table
@Entity                                                     // JPA annotation
public class Posts {
    // Posts: 실제 DB의 테이블과 매칭될 클래스, Entity class라고도 한다.
    // JPA를 사용하면 DB 데이터 작업 시, 실제 쿼리를 날리지 않고 이 Entity class의 수정을 통해 작업한다.

    @Id                                                     // table 의 PK field 를 나타낸다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // PK 생성 규칙을 나타낸다. spring boot 2.0 부터는 IDENTITY 가 auto_increment 가 된다.
    private Long id;

    @Column(length = 500, nullable = false)                 // table 의 coulmn을 나타낸다.
                                                            // 굳이 선언하지 class 의 모든 field 는 column 이 된다.
                                                            // 기본값 외 옵션 변경을 위해 사용한다.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder                                                // 해당 클래스의 빌더 패턴 클래스를 생성, constructur에 포함된 필드만 빌더에 포함된다.
                                                            // gd) 생성자 사용 시에, 필드가 명시되어 잘못 입력할 위험 ↓ e.g. Posts(a, b) Posts(b, a)
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

}
