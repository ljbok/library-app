package com.group.libraryapp.dto.user.request;

public class UserCreateRequest {

    private String name;
    private Integer age; // int -> null을 표현 못함 VS Integer -> null을 표현할 수 있다.
                         // 필수가 아닌 항목이라면 int 대신에 Integer을 사용하도록 하자


    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
