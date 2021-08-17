package com.dms.library.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface IBookOperationDAO {
    List<IBookModel> getIssuedBookListForUser(String username) throws SQLException;

    boolean checkBookAvailability(int bookId, long dateToBeChecked, long returnDate) throws SQLException;

    Boolean issueBook(String username, int bookId, long issueDate, long returnDate) throws SQLException;

    int getAvailableBookCount(int bookId) throws SQLException;

    boolean returnBook(int bookId) throws SQLException;

    boolean addBookCount(int bookId) throws SQLException;

    boolean reduceBookCount(int bookId) throws SQLException;

    boolean isBookAlreadyIssued(String username, int bookId) throws SQLException;

    boolean bookNotificationRequest(String username, int bookId) throws SQLException;

    boolean notifyUsersForBookAvailability(int bookId) throws SQLException;

    boolean deleteNotifyRequestFromBookNotification(int userId) throws SQLException;
}
