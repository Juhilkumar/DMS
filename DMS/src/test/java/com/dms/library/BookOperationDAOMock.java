package com.dms.library;

import com.dms.library.interfaces.IBookModel;
import com.dms.library.interfaces.IBookOperationDAO;
import com.dms.user.UserDAO;
import com.dms.user.UserModel;
import com.dms.user.interfaces.IUserDAO;
import com.dms.user.interfaces.IUserModel;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class BookOperationDAOMock implements IBookOperationDAO {
    IUserDAO iUserDAO = new UserDAO();
    IUserModel user = new UserModel(iUserDAO);
    IBookModel book = new BookModel();

    public List<IBookModel> getIssuedBookListForUser(String username) {
        IBookModel book = new BookModel();
        IUserModel user = new UserModel();
        user.setUsername("Juhil");
        book.setBookId(47);
        book.setBookName("Fundamentals of CS");
        book.setIssueDate("15-02-2020");
        book.setReturnDate("27-02-2020");
        List<IBookModel> userBookList = new ArrayList<>();
        userBookList.add(book);
        if (StringUtils.equals(user.getUsername(), "Juhil")) {
            return userBookList;
        }
        return null;
    }

    public boolean checkBookAvailability(int bookId, long dateToBeChecked, long returnDate) {
        dateToBeChecked = 21 - 3 - 2021;
        returnDate = 28 - 3 - 2021;
        long issueDate = 17 - 3 - 2021;
        long bookReturn = 30 - 3 - 2021;

        if (dateToBeChecked >= bookReturn && (returnDate <= issueDate || returnDate >= bookReturn)) {
            return true;
        }
        return false;
    }

    public Boolean issueBook(String username, int bookId, long issueDate, long returnDate) {
        return StringUtils.equals(user.getUsername(), "Juhil") && book.getBookId() == 47 && issueDate == 20 - 11 - 2020 && returnDate == 07 - 12 - 2020;
    }

    public int getAvailableBookCount(int bookId) {
        if (bookId == 47) {
            return 2;
        }
        return 0;
    }

    public boolean returnBook(int bookId) {
        if (bookId == 47) {
            return true;
        }
        return false;
    }

    public boolean addBookCount(int bookId) {
        if (bookId == 47) {
            return true;
        }
        return false;
    }

    public boolean reduceBookCount(int bookId) {
        if (bookId == 47) {
            return true;
        }
        return false;
    }

    public boolean isBookAlreadyIssued(String username, int bookId) {
        if (StringUtils.equals(username, "Juhil") && bookId == 47) {
            return true;
        }
        return false;
    }

    public boolean bookNotificationRequest(String username, int bookId) {
        IBookModel book = new BookModel();
        IUserModel user = new UserModel();
        user.setUsername("Juhil");
        book.setBookId(47);
        if (StringUtils.equals(user.getUsername(), "Juhil") && book.getBookId() == 47) {
            return true;
        }
        return false;
    }

    public boolean notifyUsersForBookAvailability(int bookId) {
        book.setBookId(47);
        if (book.getBookId() == 47) {
            return true;
        }
        return false;
    }

    public boolean deleteNotifyRequestFromBookNotification(int userId) {
        user.setUserId(7);
        if (user.getUserId() == 7) {
            return true;
        }
        return false;
    }
}
