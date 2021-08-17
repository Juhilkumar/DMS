package com.dms.library.abstractfactory;

import com.dms.library.interfaces.IBookModel;
import com.dms.library.interfaces.IBookDAO;
import com.dms.library.interfaces.IBookOperationDAO;
import com.dms.library.interfaces.IBookOperationModel;

public abstract class LibraryAbstractFactory {
    private static LibraryAbstractFactory uniqueInstance = null;

    public abstract IBookModel createBookModel();
    public abstract IBookOperationModel createBookOperationModel();

    public static LibraryAbstractFactory instance() {
        if (null == uniqueInstance) {
            uniqueInstance = new LibraryConcreteFactory();
        }
        return uniqueInstance;
    }
}
