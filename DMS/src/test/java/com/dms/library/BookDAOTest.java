package com.dms.library;

import com.dms.library.interfaces.IBookModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BookDAOTest {
    IBookModel book;
    BookDAOMock bookDAOMock;

    @BeforeEach
    void init() {
        book = new BookModel();
        bookDAOMock = new BookDAOMock();
    }

    @Test
    void getBookListTest() {
        List<IBookModel> bookList = new ArrayList<>();
        book.setBookId(1);
        book.setBookName("Computer Networking");
        book.setBookAuthor("Prakash");
        bookList.add(book);
        Assertions.assertEquals(bookList.size(), bookDAOMock.getBookList().size());
    }

    @Test
    void addBookTest() {
        Assertions.assertTrue(bookDAOMock.addBook("ASDC", "Rob", 3));
    }

    @Test
    void removeBookTest() {
        String result = bookDAOMock.removeBook("Computer Networking");
        Assertions.assertEquals("Computer Networking", result);
    }

    @Test
    void searchBookTest() {
        List<IBookModel> searchBookList = new ArrayList<>();
        book.setBookName("Computer Networking");
        searchBookList.add(book);
        Assertions.assertEquals(searchBookList.size(), bookDAOMock.searchBook("Computer Networking").size());
    }
}