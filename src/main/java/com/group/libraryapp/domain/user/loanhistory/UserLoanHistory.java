package com.group.libraryapp.domain.user.loanhistory;

import com.group.libraryapp.domain.user.User;

import javax.persistence.*;

@Entity
public class UserLoanHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    //private long userId;
    @JoinColumn(nullable = false)
    @ManyToOne // 내가 n 이고 너가 1 이다.
    private User user;

    private String bookName;

    private boolean isReturn;

    // Entity는 빈 생성자가 필요하므로
    protected UserLoanHistory() {

    }

    // 대출할 때 수행될 메소드
    public UserLoanHistory(User user, String bookName) {
        this.user = user;
        this.bookName = bookName;
        this.isReturn = false;
    }

    // 반납시 수행될 isReturn 상태갑 바꿔줄 메소드
    public void doReturn() {
        this.isReturn = true;
    }

    public String getBookName() {
        return this.bookName;
    }
}
