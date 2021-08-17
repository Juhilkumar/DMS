package com.dms.library.abstractfactory;

import com.dms.library.BookModel;
import com.dms.library.BookDAO;
import com.dms.library.BookOperationDAO;
import com.dms.library.BookOperationModel;
import com.dms.library.interfaces.IBookModel;
import com.dms.library.interfaces.IBookDAO;
import com.dms.library.interfaces.IBookOperationDAO;
import com.dms.library.interfaces.IBookOperationModel;

public class LibraryConcreteFactory extends LibraryAbstractFactory {

    public IBookModel createBookModel() {
        return new BookModel(new BookDAO());
    }

    public IBookOperationModel createBookOperationModel() {
        return new BookOperationModel(new BookOperationDAO());
    }

}
