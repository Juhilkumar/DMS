package com.dms.library.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface IBookDAO {
    List<IBookModel> getBookList() throws SQLException;

    Boolean addBook(String bookName, String bookAuthor, int bookQuantity) throws SQLException;

    String removeBook(String bookName) throws SQLException;

    List<IBookModel> searchBook(String text) throws SQLException;
}
