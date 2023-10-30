package com.group.libraryapp.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// 여기서 제네릭션으로 user 테이블과 매핑한 거임
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByName(String name);
}
