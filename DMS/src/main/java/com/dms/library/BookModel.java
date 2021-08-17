package com.dms.library;

import com.dms.library.interfaces.IBookDAO;
import com.dms.library.interfaces.IBookModel;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BookModel implements IBookModel {
    private static final String DATE_ERROR = "Return Date should be grater than issue Date";
    private static final String DATE_PATTERN = "dd-MM-yyyy";

    private IBookDAO iBookDAO;
    private int bookId;
    private String bookName;
    private String bookAuthor;
    private int bookQuantity;
    private String issueDate;
    private String returnDate;

    public BookModel() {

    }

    public BookModel(IBookDAO iBookDAO) {
        this.iBookDAO = iBookDAO;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Boolean validateDatesForBookRequest(String issueDate, String returnDate) {
        Date checkIssueDate;
        Date checkReturnDate;
        try {
            checkIssueDate = new SimpleDateFormat(DATE_PATTERN).parse(issueDate);
            checkReturnDate = new SimpleDateFormat(DATE_PATTERN).parse(returnDate);
            if(checkReturnDate.getTime() < checkIssueDate.getTime()) {
                throw new IllegalArgumentException(DATE_ERROR);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return true;
    }

    public List<IBookModel> showBookList() throws SQLException {
        return iBookDAO.getBookList();
    }

    public Boolean saveBook(String bookName, String bookAuthor, int bookQuantity) throws SQLException {
        return iBookDAO.addBook(bookName, bookAuthor, bookQuantity);
    }

    public String removeBook(String bookName) throws SQLException {
        return iBookDAO.removeBook(bookName);
    }

    public List<IBookModel> searchedBookList(String text) throws SQLException {
        return iBookDAO.searchBook(text);
    }
}
