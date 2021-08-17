package com.dms.library;

import com.dms.library.interfaces.IBookDAO;
import com.dms.library.interfaces.IBookModel;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class BookDAOMock implements IBookDAO {
    private static final String BOOK_NAME = "Computer Networking";
    private static final String BOOK_AUTHOR = "Prakash";
    private static final int BOOK_QUANTITY = 3;


    public List<IBookModel> getBookList() {
        List<IBookModel> bookList = new ArrayList<>();
        IBookModel book = new BookModel();
        book.setBookId(1);
        book.setBookName("Computer Networking");
        book.setBookAuthor("Prakash");
        bookList.add(book);
        return bookList;
    }

    public Boolean addBook(String bookName, String bookAuthor, int bookQuantity) {
        IBookModel book = new BookModel();
        book.setBookName("Computer Networking");
        book.setBookAuthor("Prakash");
        book.setBookQuantity(3);
        if (StringUtils.equals(book.getBookName(), BOOK_NAME) &&
                StringUtils.equals(book.getBookAuthor(), BOOK_AUTHOR) &&
                book.getBookQuantity() == BOOK_QUANTITY) {
            return true;
        }
        return false;
    }

    public String removeBook(String bookName) {
        IBookModel book = new BookModel();
        book.setBookName("Computer Networking");
        if (StringUtils.equals(book.getBookName(), BOOK_NAME)) {
            return book.getBookName();
        }
        return bookName;
    }

    public List<IBookModel> searchBook(String text) {
        IBookModel book = new BookModel();
        List<IBookModel> bookList = new ArrayList<>();
        book.setBookAuthor("Prakash");
        bookList.add(book);
        return bookList;
    }
}
