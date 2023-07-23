package com.soob.study.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)

// @SprintBootTest 사용 시, 디폴트로 H2 DB가 사용됨.
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    // Junit 에서 단위 테스트 종료 시마다 수행되는 메소드를 지정
    // for) 배포 전 전체 테스트 수행 시, 테스트 간 데이터 침범 방지
    // ex)  여러 테스트 동시 수행 시, 테스트용 db에 남은 이전 테스트 데이터가 다음 테스트의 실패 원인이 될 수 있음.
    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()                // `posts` 테이블에 insert/update 쿼리를 실행한다.
                .title(title)                               // id 有 -> update
                                                            // id 無 -> insert
                .content(content)
                .author("jojoldu@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();  // `posts` 테이블의 모든 데이터를 조회한다.

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

//    @Test
//    public void BaseTimeEntity_등록() {
//        //given
//        LocalDateTime now = LocalDateTime.of(2019, 6, 4, 0, 0, 0);
//        postsRepository.save(Posts.builder()
//                .title("title")
//                .content("content")
//                .author("author")
//                .build());
//        //when
//        List<Posts> postsList = postsRepository.findAll();
//
//        //then
//        Posts posts = postsList.get(0);
//
//        System.out.println(">>>>>>>>> createDate=" + posts.getCreatedDate() + ", modifiedDate=" + posts.getModifiedDate());
//
//        assertThat(posts.getCreatedDate()).isAfter(now);
//        assertThat(posts.getModifiedDate()).isAfter(now);
//    }
}