package com.dms.library.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface IBookOperationModel {
    List<IBookModel> showIssuedBookList(String username) throws SQLException;

    boolean requestBook(String username, int bookID, long dateToBeChecked, long returnDate);

    boolean returnIssuedBook(int bookId) throws SQLException;

    boolean bookAlreadyIssued(String username, int bookId) throws SQLException;

    boolean requestForBookNotification(String username, int bookId) throws SQLException;

    boolean notifyForBookAvailability(int bookId) throws SQLException;
}
