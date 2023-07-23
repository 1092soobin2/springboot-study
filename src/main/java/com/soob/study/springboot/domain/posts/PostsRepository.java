package com.soob.study.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// `JpaRepository` : DB Layer 접근자. cf) ibatis, MyBatis 등에서는 Dao 와 역할이 같다.
// JpaRepository<entity class, PK type>
// CRUD 메소드가 자동으로 생성된다.

// *주의점 : entity class & entity repository 는 함꼐 위치해야 한다. (한 package 내에 위치하여야 한다.)
public interface PostsRepository extends JpaRepository<Posts,Long> {

}
