package com.dms.library;

import com.dms.library.abstractfactory.LibraryAbstractFactory;
import com.dms.library.interfaces.IBookModel;
import com.dms.library.interfaces.IBookOperationModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class BookController {
    private static final String LIBRARY_PAGE = "library";
    private static final String BOOKS_PAGE = "addBook";
    private static final String REDIRECT_BOOKS_PAGE = "redirect:/addBook";
    private static final String NOTIFY_PAGE = "notifyWhenBookAvailable";
    private static final String CHECK_BOOK_AVAILABILITY_PAGE = "checkBookAvailability";
    private static final String ALREADY_ISSUED_BOOK_PAGE = "bookAlreadyIssued";
    private static final String ERROR_PAGE = "error";
    private static final String BOOK_AVAILABLE_PAGE = "bookAvailableSuccess";
    private static final String BOOK_NOT_AVAILABLE_PAGE = "bookNotAvailable";
    private static final String ISSUED_BOOKS_PAGE = "showIssuedBooks";
    private static final String REDIRECT_ISSUED_BOOKS_PAGE = "redirect:/showIssuedBooks";
    private static final String BOOK_RETURN_FAILED_PAGE = "bookReturnError";
    private static final String DATE_PATTERN = "dd-MM-yyyy";
    private static final String USER_LOGGED_IN = "loggedIn";
    private static final String USER_NAME = "username";
    private static final String YES = "yes";

    LibraryAbstractFactory libraryAbstractFactory = LibraryAbstractFactory.instance();
    IBookModel iBookModel = libraryAbstractFactory.createBookModel();
    IBookOperationModel iBookOperationModel = libraryAbstractFactory.createBookOperationModel();

    @GetMapping(value = "/addBook")
    public ModelAndView bookList(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        String loggedIn = (String) session.getAttribute(USER_LOGGED_IN);
        if (StringUtils.equals(loggedIn, YES)) {
            List<IBookModel> bookList = iBookModel.showBookList();
            ModelAndView model = new ModelAndView(BOOKS_PAGE);
            model.addObject("list", bookList);
            return model;
        }
        return new ModelAndView(ERROR_PAGE);
    }

    @RequestMapping(value = "/addBook")
    public String showBook() {
        return BOOKS_PAGE;
    }

    @RequestMapping("/ProcessAddBook")
    public String addBook(@RequestParam("bookName") String bookName, @RequestParam("bookAuthor") String bookAuthor, @RequestParam("bookQuantity") int bookQuantity) throws SQLException {
        iBookModel.saveBook(bookName, bookAuthor, bookQuantity);
        return REDIRECT_BOOKS_PAGE;
    }

    @GetMapping(value = "/{bookName}/removeBook")
    public String removeBook(@PathVariable String bookName) throws SQLException {
        iBookModel.removeBook(bookName);
        return REDIRECT_BOOKS_PAGE;
    }

    @RequestMapping(value = "/library")
    public String showLibrary() {
        return LIBRARY_PAGE;
    }

    @GetMapping(value = "/searchBook")
    public ModelAndView searchBook(@RequestParam("searchKeyword") String text) throws SQLException {
        List<IBookModel> bookList = iBookModel.searchedBookList(text);
        ModelAndView model = new ModelAndView(LIBRARY_PAGE);
        model.addObject("list", bookList);
        return model;
    }

    @GetMapping(value = "/notifyBookWhenAvailable")
    public ModelAndView notifyBook(@RequestParam("bookId") int bookId, HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        String loggedIn = (String) session.getAttribute(USER_LOGGED_IN);
        if (StringUtils.equals(loggedIn, YES)) {
            String userName = (String) session.getAttribute(USER_NAME);
            ModelAndView model = new ModelAndView(NOTIFY_PAGE);
            iBookOperationModel.requestForBookNotification(userName, bookId);
            return model;
        }
        return new ModelAndView(ERROR_PAGE);
    }

    @GetMapping(value = "/library")
    public ModelAndView bookListForLibrary(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        String loggedIn = (String) session.getAttribute(USER_LOGGED_IN);
        if (StringUtils.equals(loggedIn, YES)) {
            List<IBookModel> bookList = iBookModel.showBookList();
            ModelAndView model = new ModelAndView(LIBRARY_PAGE);
            model.addObject("list", bookList);
            return model;
        }
        return new ModelAndView(ERROR_PAGE);
    }

    @GetMapping(value = "/checkBookAvailability/{bookId}")
    public String showBookAvailability(@PathVariable(name = "bookId") int bookId, HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        String loggedIn = (String) session.getAttribute(USER_LOGGED_IN);
        if (StringUtils.equals(loggedIn, YES)) {
            String userName = (String) session.getAttribute(USER_NAME);
            boolean bookAlreadyIssued = iBookOperationModel.bookAlreadyIssued(userName, bookId);
            ModelAndView model = new ModelAndView(CHECK_BOOK_AVAILABILITY_PAGE);
            model.addObject("bookId", bookId);
            if (bookAlreadyIssued) {
                return ALREADY_ISSUED_BOOK_PAGE;
            } else {
                return CHECK_BOOK_AVAILABILITY_PAGE;
            }
        }
        return ERROR_PAGE;
    }

    @GetMapping(value = "/checkBookAvailability/checkBook")
    public ModelAndView requestBook(@RequestParam("bookId") int bookId, @RequestParam("issueDate") String issueDate, @RequestParam("returnDate") String returnDate, HttpServletRequest request) throws ParseException {
        HttpSession session = request.getSession();
        String loggedIn = (String) session.getAttribute(USER_LOGGED_IN);
        Date issueDateCheck = new SimpleDateFormat(DATE_PATTERN).parse(issueDate);
        Date returnDateCheck = new SimpleDateFormat(DATE_PATTERN).parse(returnDate);
        if (StringUtils.equals(loggedIn, YES) && Boolean.TRUE.equals(iBookModel.validateDatesForBookRequest(issueDate, returnDate))) {
            String userName = (String) session.getAttribute(USER_NAME);
            if (iBookOperationModel.requestBook(userName, bookId, issueDateCheck.getTime(), returnDateCheck.getTime())) {
                return new ModelAndView(BOOK_AVAILABLE_PAGE);
            }
        }
        return new ModelAndView(BOOK_NOT_AVAILABLE_PAGE);
    }

    @GetMapping(value = "/showIssuedBooks")
    public ModelAndView issuedBookList(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        String loggedIn = (String) session.getAttribute(USER_LOGGED_IN);
        ModelAndView model = new ModelAndView(ISSUED_BOOKS_PAGE);
        if (StringUtils.equals(loggedIn, YES)) {
            String userName = (String) session.getAttribute(USER_NAME);
            List<IBookModel> issuedBookList = iBookOperationModel.showIssuedBookList(userName);
            model.addObject("issuedBookList", issuedBookList);
        }
        return model;
    }

    @RequestMapping(value = "/returnBook")
    public String returnBook(@RequestParam("bookId") int bookId) throws SQLException {
        if (iBookOperationModel.returnIssuedBook(bookId)) {
            iBookOperationModel.notifyForBookAvailability(bookId);
            return REDIRECT_ISSUED_BOOKS_PAGE;
        } else return BOOK_RETURN_FAILED_PAGE;
    }
}
