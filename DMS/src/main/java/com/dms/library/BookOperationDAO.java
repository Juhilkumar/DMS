package com.dms.library;

import com.dms.library.abstractfactory.LibraryAbstractFactory;
import com.dms.library.interfaces.IBookModel;
import com.dms.library.interfaces.IBookOperationDAO;
import com.dms.notification.SendEmail;
import com.dms.notification.interfaces.ISendEmail;
import com.dms.user.abstarctfactory.UserAbstractFactory;
import com.dms.user.interfaces.IUserDAO;
import connection.interfaces.ISqlConnection;
import connection.SqlConnectionImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookOperationDAO implements IBookOperationDAO {
    private static final String DATE_PATTERN = "dd-MM-yyyy";
    private static final String USER_ID_COLUMN = "userId";
    private static final String BOOK_ID_COLUMN = "bookId";
    private static final String BOOK_NAME_COLUMN = "bookName";
    private static final String ISSUE_DATE_COLUMN = "issueDate";
    private static final String RETURN_DATE_COLUMN = "returnDate";
    private static final String AVAILABLE_BOOK_COUNT_COLUMN = "availableBookCount";

    LibraryAbstractFactory libraryAbstractFactory = LibraryAbstractFactory.instance();
    UserAbstractFactory userAbstractFactory = UserAbstractFactory.instance();
    IUserDAO iUserDAO = userAbstractFactory.createUserDAO();
    private final ISqlConnection connectionManager;

    public BookOperationDAO() {
        connectionManager = new SqlConnectionImpl();
    }

    public List<IBookModel> getIssuedBookListForUser(String username) throws SQLException {
        List<IBookModel> issuedBookList = new ArrayList<>();
        try {
            DateFormat formatDate = new SimpleDateFormat(DATE_PATTERN);
            int userId = iUserDAO.getUserId(username);
            String selectIssuedBooksQuery = "SELECT Book.bookName, BorrowBook.bookId,BorrowBook.issueDate,BorrowBook.returnDate FROM ((Book INNER JOIN BorrowBook ON Book.bookId = BorrowBook.bookId)) WHERE BorrowBook.userId ='" + userId + "'";
            connectionManager.executeRead(selectIssuedBooksQuery);
            ResultSet result = connectionManager.executeResult(selectIssuedBooksQuery);
            while (result.next()) {
                IBookModel iBookModel = libraryAbstractFactory.createBookModel();
                Date issueDate = new Date(result.getLong(ISSUE_DATE_COLUMN));
                Date returnDate = new Date(result.getLong(RETURN_DATE_COLUMN));
                iBookModel.setBookId(result.getInt(BOOK_ID_COLUMN));
                iBookModel.setBookName(result.getString(BOOK_NAME_COLUMN));
                iBookModel.setIssueDate(formatDate.format(issueDate));
                iBookModel.setReturnDate(formatDate.format(returnDate));
                issuedBookList.add(iBookModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionManager.closeConnection();
        }
        return issuedBookList;
    }

    public boolean checkBookAvailability(int bookID, long dateToBeChecked, long returnDate) throws SQLException {
        boolean availability = true;
        try {
            String countQuery = "SELECT * FROM BorrowBook WHERE bookId = " + bookID;
            connectionManager.executeRead(countQuery);
            ResultSet resultSet = connectionManager.executeResult(countQuery);
            while (resultSet.next()) {
                long issueDate = resultSet.getLong(ISSUE_DATE_COLUMN);
                long bookReturn = resultSet.getLong(RETURN_DATE_COLUMN);
                if ((dateToBeChecked > issueDate && dateToBeChecked < bookReturn) || (returnDate > issueDate && returnDate < bookReturn)) {
                    availability = false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionManager.closeConnection();
        }
        return availability;
    }

    public Boolean issueBook(String username, int bookId, long issueDate, long returnDate) throws SQLException {
        try {
            int userId = iUserDAO.getUserId(username);
            String requestQuery = "INSERT INTO BorrowBook(userId,bookId,issueDate,returnDate)  VALUES('" + userId + "','" + bookId + "','" + issueDate + "','" + returnDate + "')";
            connectionManager.executeWrite(requestQuery);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionManager.closeConnectionWithoutResultset();
        }
        return true;
    }

    public int getAvailableBookCount(int bookID) throws SQLException {
        try {
            String countQuery = "SELECT availableBookCount FROM Book WHERE bookId = " + bookID;
            connectionManager.executeRead(countQuery);
            ResultSet resultSet = connectionManager.executeResult(countQuery);
            if (resultSet.next()) {
                return resultSet.getInt(AVAILABLE_BOOK_COUNT_COLUMN);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionManager.closeConnection();
        }
        return 0;
    }

    public boolean returnBook(int bookID) throws SQLException {
        try {
            String returnBookQuery = "DELETE FROM BorrowBook WHERE bookId = " + bookID;
            connectionManager.executeWrite(returnBookQuery);
//            addBookCount(bookID);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionManager.closeConnection();
        }
        return false;
    }

    public boolean addBookCount(int bookID) throws SQLException {
        try {
            String requestQuery = "UPDATE Book SET availableBookCount = availableBookCount + 1 WHERE bookId = '" + bookID + "'";
            connectionManager.executeWrite(requestQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionManager.closeConnectionWithoutResultset();
        }
        return true;
    }

    public boolean reduceBookCount(int bookID) throws SQLException {
        try {
            String requestQuery = "UPDATE Book SET availableBookCount = availableBookCount - 1 WHERE bookId = '" + bookID + "'";
            connectionManager.executeWrite(requestQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionManager.closeConnectionWithoutResultset();
        }
        return true;
    }

    public boolean isBookAlreadyIssued(String username, int bookId) throws SQLException {
        try {
            int userId = iUserDAO.getUserId(username);
            String selectQuery = "SELECT bookId FROM BorrowBook where userId = '" + userId + "'";
            connectionManager.executeRead(selectQuery);
            ResultSet resultSet = connectionManager.executeResult(selectQuery);
            while (resultSet.next()) {
                if (resultSet.getInt(1) == bookId) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionManager.closeConnectionWithoutResultset();
        }
        return false;
    }

    public boolean bookNotificationRequest(String username, int bookId) throws SQLException {
        try {
            int userId = iUserDAO.getUserId(username);
            String insertQuery = "INSERT INTO BookNotification(userId, bookId) VALUES('" + userId + "','" + bookId + "')";
            connectionManager.executeWrite(insertQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionManager.closeConnectionWithoutResultset();
        }
        return true;
    }

    public boolean notifyUsersForBookAvailability(int bookId) throws SQLException {
        final String mailSubject = "Notification for Book";
        final String mailBody = "Hi there ! Book with bookId :" + bookId + " is now available in the library";
        try {
//            int bookCount = getAvailableBookCount(bookId);
//            if (bookCount > 0) {
                String selectQuery = "SELECT userId FROM BookNotification WHERE bookId = '" + bookId + "'";
                connectionManager.executeRead(selectQuery);
                ResultSet resultSet = connectionManager.executeResult(selectQuery);
                while (resultSet.next()) {
                    ISendEmail sendEmailNotification = new SendEmail();
                    int userId = resultSet.getInt(USER_ID_COLUMN);

                    String userMailId = iUserDAO.getUserEmail(userId);
                    String[] mailID = {userMailId};
                    sendEmailNotification.sendMailNotification(mailID, mailSubject, mailBody);

                    this.deleteNotifyRequestFromBookNotification(userId);
                }
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionManager.closeConnection();
        }
        return true;
    }

    public boolean deleteNotifyRequestFromBookNotification(int userId) throws SQLException {
        try {
            String deleteQuery = "DELETE FROM BookNotification  WHERE userId = " + userId + "";
            connectionManager.executeWrite(deleteQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionManager.closeConnectionWithoutResultset();
        }
        return true;
    }
}
