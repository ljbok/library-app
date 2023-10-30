package com.group.libraryapp.domain.book;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    //@Column(nullable = false, length = 255, name = "name")
    // length 는 default가 255 이며 테이블의 name을 varchar(255) 로 설정하였기 때문에 생략 가능
    // 테이블의 필드명(컬럼명)을 name 이라고 private String name의 변수명과 동일하게 하였기 때문에 생략 가능
    @Column(nullable = false)
    private String name;

    // jpa는 기본생성자가 필요하다 --> public Book(String name) {} 생성자를 생성하려면
    protected Book() {

    }

    public Book(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어왔습니다",name));
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
