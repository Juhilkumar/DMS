package com.dms.grade.abstractfactory;

import com.dms.grade.GradeHistoryDAO;
import com.dms.grade.GradeHistoryModel;
import com.dms.grade.PostGradesDAO;
import com.dms.grade.PostGradesModel;
import com.dms.grade.interfaces.IGradeHistoryModel;
import com.dms.grade.interfaces.IPostGradesModel;

public class GradeConcreteFactory extends GradeAbstractFactory{
    public IGradeHistoryModel createGradeHistoryModel(){
        return new GradeHistoryModel(new GradeHistoryDAO());
    }
    public IPostGradesModel createPostGradesModel(){
        return new PostGradesModel(new PostGradesDAO());
    }
}
