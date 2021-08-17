package com.dms.library.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface IBookModel {
    String getBookName();

    void setBookName(String bookName);

    String getBookAuthor();

    void setBookAuthor(String bookAuthor);

    int getBookId();

    void setBookId(int bookId);

    int getBookQuantity();

    void setBookQuantity(int bookQuantity);

    String getIssueDate();

    void setIssueDate(String issueDate);

    String getReturnDate();

    void setReturnDate(String returnDate);

    Boolean validateDatesForBookRequest(String issueDate, String returnDate);

    List<IBookModel> showBookList() throws SQLException;

    Boolean saveBook(String bookName, String bookAuthor, int bookQuantity) throws SQLException;

    String removeBook(String bookName) throws SQLException;

    List<IBookModel> searchedBookList(String text) throws SQLException;
}
