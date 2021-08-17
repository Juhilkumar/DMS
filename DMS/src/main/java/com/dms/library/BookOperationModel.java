package com.dms.library;

import com.dms.library.interfaces.IBookModel;
import com.dms.library.interfaces.IBookOperationDAO;
import com.dms.library.interfaces.IBookOperationModel;

import java.sql.SQLException;
import java.util.List;

public class BookOperationModel implements IBookOperationModel {

    private final IBookOperationDAO iBookOperationDAO;

    public BookOperationModel(IBookOperationDAO iBookOperationDAO) {
        this.iBookOperationDAO = iBookOperationDAO;
    }


    public List<IBookModel> showIssuedBookList(String username) throws SQLException {
        return iBookOperationDAO.getIssuedBookListForUser(username);
    }

    public boolean requestBook(String username, int bookID, long dateToBeChecked, long returnDate) {
        try {
            if (iBookOperationDAO.getAvailableBookCount(bookID) > 0 &&
                    iBookOperationDAO.checkBookAvailability(bookID, dateToBeChecked, returnDate)
            ) {
                iBookOperationDAO.reduceBookCount(bookID);
                iBookOperationDAO.issueBook(username, bookID, dateToBeChecked, returnDate);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean returnIssuedBook(int bookId) throws SQLException {
        if (iBookOperationDAO.returnBook(bookId)) {
            iBookOperationDAO.addBookCount(bookId);
            return true;
        } else return false;
    }

    public boolean bookAlreadyIssued(String username, int bookId) throws SQLException {
        return iBookOperationDAO.isBookAlreadyIssued(username, bookId);
    }

    public boolean requestForBookNotification(String username, int bookId) throws SQLException {
        return iBookOperationDAO.bookNotificationRequest(username, bookId);
    }

    public boolean notifyForBookAvailability(int bookId) throws SQLException {
        int bookCount = iBookOperationDAO.getAvailableBookCount(bookId);
        if (bookCount > 0) {
            iBookOperationDAO.notifyUsersForBookAvailability(bookId);
            return true;
        }
        return false;
    }
}
