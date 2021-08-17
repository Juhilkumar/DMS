package com.dms.library.abstractfactory;

import com.dms.library.interfaces.IBookDAO;
import com.dms.library.interfaces.IBookModel;
import com.dms.library.interfaces.IBookOperationDAO;
import com.dms.library.interfaces.IBookOperationModel;

public abstract class LibraryAbstractFactoryTest {
    private static LibraryAbstractFactoryTest uniqueInstance = null;

    public abstract IBookModel createBookModelTest();
    public abstract IBookOperationModel createBookOperationModelTest();
    public abstract IBookDAO createBookDAO();
    public abstract IBookOperationDAO createBookOperationDAO();

    public static LibraryAbstractFactoryTest instance() {
        if (null == uniqueInstance) {
            uniqueInstance = new LibraryConcreteFactoryTest();
        }
        return uniqueInstance;
    }
}
