package com.group.libraryapp.domain.user.loanhistory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserLoanHistoryRepository extends JpaRepository<UserLoanHistory, Long> {

    // 2. 대출 기록 정보를 확인해서 대출중인지 확인합니다. (from BookService)
    // select * from user_loan_history where book_name = ? and is_return = ?
    boolean existsByBookNameAndIsReturn(String name, boolean isReturn);

}
