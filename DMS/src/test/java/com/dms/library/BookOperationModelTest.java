package com.dms.library;

import com.dms.library.abstractfactory.LibraryAbstractFactoryTest;
import com.dms.library.interfaces.IBookModel;
import com.dms.library.interfaces.IBookOperationModel;
import com.dms.user.UserModel;
import com.dms.user.interfaces.IUserModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class BookOperationModelTest {

    LibraryAbstractFactoryTest libraryAbstractFactoryTest;
    IBookOperationModel iBookOperationModel;

    @BeforeEach
    void init() {
        libraryAbstractFactoryTest = LibraryAbstractFactoryTest.instance();
        iBookOperationModel = libraryAbstractFactoryTest.createBookOperationModelTest();
    }

    @Test
    void showIssuedBookList() throws SQLException {
        IBookModel book = new BookModel();
        IUserModel user = new UserModel();
        user.setUsername("Juhil");
        book.setBookId(47);
        book.setBookName("Fundamentals of CS");
        book.setIssueDate("15-02-2020");
        book.setReturnDate("27-02-2020");
        List<IBookModel> userBookList = new ArrayList<>();
        userBookList.add(book);
        List<IBookModel> expectedBookList = iBookOperationModel.showIssuedBookList("Juhil");
        Assertions.assertEquals(expectedBookList.size(), userBookList.size());
    }

    @Test
    void requestBook() {
        Assertions.assertFalse(iBookOperationModel.requestBook("Parth", 47, 21 - 3 - 2021, 28 - 3 - 2021));
    }

    @Test
    void notifyForBookAvailability() throws SQLException {
        Assertions.assertTrue(iBookOperationModel.notifyForBookAvailability(47));
    }

    @Test
    void bookAlreadyIssued() throws SQLException {
        Assertions.assertTrue(iBookOperationModel.bookAlreadyIssued("Juhil", 47));
    }

    @Test
    void returnIssuedBook() throws SQLException {
        Assertions.assertTrue(iBookOperationModel.returnIssuedBook(47));
    }

    @Test
    void requestForBookNotification() throws SQLException {
        IBookModel book = new BookModel();
        IUserModel user = new UserModel();
        user.setUsername("Juhil");
        book.setBookId(3);
        Assertions.assertTrue(iBookOperationModel.requestForBookNotification(user.getUsername(), book.getBookId()));
    }
}