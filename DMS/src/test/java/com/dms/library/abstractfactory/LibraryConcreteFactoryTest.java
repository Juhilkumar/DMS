package com.dms.library.abstractfactory;

import com.dms.library.*;
import com.dms.library.interfaces.IBookDAO;
import com.dms.library.interfaces.IBookModel;
import com.dms.library.interfaces.IBookOperationDAO;
import com.dms.library.interfaces.IBookOperationModel;

public class LibraryConcreteFactoryTest extends LibraryAbstractFactoryTest{
    public IBookModel createBookModelTest() {
        return new BookModel(new BookDAOMock());
    }

    public IBookOperationModel createBookOperationModelTest() {
        return new BookOperationModel(new BookOperationDAOMock());
    }

    public IBookDAO createBookDAO() {
        return new BookDAO();
    }

    public IBookOperationDAO createBookOperationDAO() {
        return new BookOperationDAOMock();
    }
}
