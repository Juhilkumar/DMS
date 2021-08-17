package com.dms.grade.abstractfactory;

import com.dms.grade.interfaces.IGradeHistoryModel;
import com.dms.grade.interfaces.IPostGradesModel;

public abstract class GradeAbstractFactory {
    private static GradeAbstractFactory uniqueInstance = null;
    public  abstract IGradeHistoryModel createGradeHistoryModel();
    public abstract IPostGradesModel createPostGradesModel();

    public static GradeAbstractFactory instance() {
        if (null == uniqueInstance) {
            uniqueInstance = new GradeConcreteFactory();
        }
        return uniqueInstance;
    }
}
