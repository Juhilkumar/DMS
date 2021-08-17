package com.dms.grade.abstractfactory;

import com.dms.grade.interfaces.IGradeHistoryModel;
import com.dms.grade.interfaces.IPostGradesModel;

public abstract class GradeAbstractFactoryTest {
    private static GradeAbstractFactoryTest uniqueInstance = null;
    public  abstract IGradeHistoryModel createGradeHistoryModel();
    public abstract IPostGradesModel createPostGradesModel();

    public static GradeAbstractFactoryTest instance() {
        if (null == uniqueInstance) {
            uniqueInstance = new GradeConcreteFactoryTest();
        }
        return uniqueInstance;
    }
}
