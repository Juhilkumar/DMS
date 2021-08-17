package com.dms.library;

import com.dms.library.abstractfactory.LibraryAbstractFactoryTest;
import com.dms.library.interfaces.IBookModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class BookModelTest {
    IBookModel book;
    LibraryAbstractFactoryTest libraryAbstractFactoryTest;
    IBookModel iBookModel;

    @BeforeEach
    void init() {
        libraryAbstractFactoryTest = LibraryAbstractFactoryTest.instance();
        iBookModel = libraryAbstractFactoryTest.createBookModelTest();
        book = new BookModel();
    }

    @Test
    void getBookName() {
        String bookName = "SOLID Principals";
        book.setBookName(bookName);
        Assertions.assertNotNull(book.getBookName());
        Assertions.assertEquals(book.getBookName(), bookName);
    }

    @Test
    void setBookName() {
        String bookName = "Design Patterns";
        book.setBookName(bookName);
        Assertions.assertNotNull(book.getBookName());
        Assertions.assertEquals(book.getBookName(), bookName);
    }

    @Test
    void getBookAuthor() {
        String bookAuthor = "Rob";
        book.setBookAuthor(bookAuthor);
        Assertions.assertNotNull(book.getBookAuthor());
        Assertions.assertEquals(book.getBookAuthor(), bookAuthor);
    }

    @Test
    void setBookAuthor() {
        String bookAuthor = "Andrew";
        book.setBookAuthor(bookAuthor);
        Assertions.assertNotNull(book.getBookAuthor());
        Assertions.assertEquals(book.getBookAuthor(), bookAuthor);
    }

    @Test
    void getBookId() {
        int bookId = 4;
        book.setBookId(bookId);
        Assertions.assertNotNull(book.getBookId());
        Assertions.assertEquals(book.getBookId(), bookId);
    }

    @Test
    void setBookId() {
        int bookId = 18;
        book.setBookId(bookId);
        Assertions.assertNotNull(book.getBookId());
        Assertions.assertEquals(book.getBookId(), bookId);
    }

    @Test
    void getBookQuantity() {
        int bookQuantity = 6;
        book.setBookQuantity(bookQuantity);
        Assertions.assertNotNull(book.getBookQuantity());
        Assertions.assertEquals(book.getBookQuantity(), bookQuantity);
    }

    @Test
    void setBookQuantity() {
        int bookQuantity = 2;
        book.setBookQuantity(bookQuantity);
        Assertions.assertNotNull(book.getBookQuantity());
        Assertions.assertEquals(book.getBookQuantity(), bookQuantity);
    }

    @Test
    void getIssueDate() {
        String issueDate = "15-01-2021";
        book.setIssueDate(issueDate);
        Assertions.assertNotNull(book.getIssueDate());
        Assertions.assertEquals(book.getIssueDate(), issueDate);
    }

    @Test
    void setIssueDate() {
        String issueDate = "27-02-2021";
        book.setIssueDate(issueDate);
        Assertions.assertNotNull(book.getIssueDate());
        Assertions.assertEquals(book.getIssueDate(), issueDate);
    }

    @Test
    void getReturnDate() {
        String returnDate = "07-03-2021";
        book.setReturnDate(returnDate);
        Assertions.assertNotNull(book.getReturnDate());
        Assertions.assertEquals(book.getReturnDate(), returnDate);
    }

    @Test
    void setReturnDate() {
        String returnDate = "30-02-2021";
        book.setReturnDate(returnDate);
        Assertions.assertNotNull(book.getReturnDate());
        Assertions.assertEquals(book.getReturnDate(), returnDate);
    }

    @Test
    void validateDatesForBookRequest() {
        Assertions.assertTrue(book.validateDatesForBookRequest("15-02-2021", "25-02-2021"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> book.validateDatesForBookRequest("15-02-2021", "05-02-2021"));
    }

    @Test
    void showBookList() throws SQLException {
        List<IBookModel> bookList = new ArrayList<>();
        IBookModel book = new BookModel();
        book.setBookId(1);
        book.setBookName("Computer Networking");
        book.setBookAuthor("Prakash");
        bookList.add(book);
        List<IBookModel> expectedBookList = iBookModel.showBookList();
        Assertions.assertEquals(bookList.size(), expectedBookList.size());
    }

    @Test
    void saveBook() throws SQLException {
        Assertions.assertTrue(iBookModel.saveBook("Computer Networking", "Prakash", 3));
    }

    @Test
    void removeBook() throws SQLException {
        Assertions.assertEquals("Computer Networking", iBookModel.removeBook("Computer Networking"));
    }

    @Test
    void searchedBookList() throws SQLException {
        IBookModel book = new BookModel();
        List<IBookModel> bookList = new ArrayList<>();
        book.setBookAuthor("Prakash");
        bookList.add(book);
        List<IBookModel> expectedBookList = iBookModel.searchedBookList("Pr");
        Assertions.assertEquals(bookList.size(), expectedBookList.size());
    }
}