package com.group.libraryapp.service.book;

import com.group.libraryapp.domain.book.Book;
import com.group.libraryapp.domain.book.BookRepository;
import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory;
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistoryRepository;
import com.group.libraryapp.dto.book.request.BookCreateRequest;
import com.group.libraryapp.dto.book.request.BookLoanRequest;
import com.group.libraryapp.dto.book.request.BookReturnRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    // 2.대출 기록 정보 확인 하기 위해 UserLoanRepository 의존성 추가하기
    private final UserLoanHistoryRepository userLoanHistoryRepository;
    // 4. 유저 정보를 가져오기를 위해 UserRepository 의존성 추가하기.
    private final UserRepository userRepository;

    /*
    public BookService(
            BookRepository bookRepository,
            UserLoanHistoryRepository userLoanHistoryRepository,
            UserRepository userRepository
    ) {
        this.bookRepository = bookRepository;
        this.userLoanHistoryRepository = userLoanHistoryRepository;
        this.userRepository = userRepository;
    }
    */

    @Transactional
    public void saveBook(BookCreateRequest request) {
        bookRepository.save(new Book(request.getName()));
    }

    @Transactional
    public void loanBook(BookLoanRequest request) {
        // 1. 책 정보를 가져온다.
        Book book = bookRepository.findByName(request.getBookName())
                .orElseThrow(IllegalArgumentException::new);

        // 2. 대출 기록 정보를 확인해서 대출중인지 확인합니다.
        // 3. 만약에 확인했는데 대출 중이라면 예외를 발생시킨다.
        if (userLoanHistoryRepository.existsByBookNameAndIsReturn(book.getName(), false)) {
            throw new IllegalArgumentException("이미 대출되어 있는 책입니다");
        }

        // 4. 유저 정보를 가져온다.
        User user = userRepository.findByName(request.getUserName())
                .orElseThrow(IllegalArgumentException::new);
        // user와 userLoanhistory user 하나에서 작업하도록 묶으려고 만든 코드
        user.loanBook(book.getName());

        // // 5. 유저 정보와 책 정보를 기반으로 UserLoanHistory를 저장한다.
        //   userLoanHistoryRepository.save(new UserLoanHistory(user, book.getName()));
    }

    @Transactional
    public void returnBook(BookReturnRequest request) {
        // 1. 유저 name 으로 유저 id 가지고 오기
        User user = userRepository.findByName(request.getUserName())
                .orElseThrow(IllegalArgumentException::new);

        // user 와 userLoanHistory를 user.java 에서 클래스 하나로 작업하도록 피팩토링한 후의 코드
        // 이전 코드는 지웠음
        user.returnBook(request.getBookName());
    }

}
