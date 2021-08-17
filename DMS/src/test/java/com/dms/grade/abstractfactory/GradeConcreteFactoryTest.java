package com.dms.grade.abstractfactory;

import com.dms.grade.*;
import com.dms.grade.interfaces.IGradeHistoryModel;
import com.dms.grade.interfaces.IPostGradesModel;

public class GradeConcreteFactoryTest extends GradeAbstractFactoryTest {
    public IGradeHistoryModel createGradeHistoryModel(){
        return new GradeHistoryModel(new GradeHistoryDAOMock());
    }
    public IPostGradesModel createPostGradesModel(){
        return new PostGradesModel(new PostGradesDAOMock());
    }
}
