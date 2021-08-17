package com.dms.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BookOperationDAOTest {
    BookOperationDAOMock bookOperationMock = new BookOperationDAOMock();

    @Test
    void getIssuedBookListForUserTest() {
        BookModel book = new BookModel();
        book.setBookId(14);
        book.setBookName("Fundamentals of CS");
        book.setIssueDate("15-02-2020");
        book.setReturnDate("27-02-2020");
        List<BookModel> userBookList = new ArrayList<>();
        userBookList.add(book);
        Assertions.assertEquals(userBookList.size(), bookOperationMock.getIssuedBookListForUser("Pratik").size());
    }

    @Test
    void checkBookAvailabilityTest() {
        Assertions.assertFalse(bookOperationMock.checkBookAvailability(21, 21 - 3 - 2021, 28 - 3 - 2021));
    }

    @Test
    void issueBookTest() {
        Assertions.assertFalse(bookOperationMock.issueBook("Parth", 20, 20 - 11 - 2020, 15 - 12 - 2020));
    }

    @Test
    void getAvailableBookCountTest() {
        int count = bookOperationMock.getAvailableBookCount(47);
        Assertions.assertEquals(2, count);
    }

    @Test
    void returnBookTest() {
        Assertions.assertTrue(bookOperationMock.returnBook(47));
    }

    @Test
    void addBookCountTest() {
        Assertions.assertTrue(bookOperationMock.addBookCount(47));
    }

    @Test
    void reduceBookCountTest() {
        Assertions.assertTrue(bookOperationMock.reduceBookCount(47));
    }

    @Test
    void isBookAlreadyIssuedTest() {
        Assertions.assertTrue(bookOperationMock.isBookAlreadyIssued("Juhil", 47));
    }
}