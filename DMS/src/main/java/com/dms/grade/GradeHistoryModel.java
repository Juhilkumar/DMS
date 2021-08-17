package com.dms.grade;

import com.dms.grade.interfaces.IGradeHistory;
import com.dms.grade.interfaces.IGradeHistoryModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GradeHistoryModel implements IGradeHistoryModel {
    private static final String GRADE1="A+";
    private static final String GRADE2="A";
    private static final String GRADE3="A-";
    private static final String GRADE4="B+";
    private static final String GRADE5="B";
    private static final String GRADE6="B-";
    private static final String GRADE7="F";
    private static final int GRADE1_POINTS=10;
    private static final int GRADE2_POINTS=9;
    private static final int GRADE3_POINTS=8;
    private static final int GRADE4_POINTS=7;
    private static final int GRADE5_POINTS=6;
    private static final int GRADE6_POINTS=5;

    Map<Integer,String> finalGrades = new HashMap<Integer,String>();
    private final IGradeHistory iGradeHistory;

    public GradeHistoryModel(IGradeHistory iGradeHistory) {
        this.iGradeHistory = iGradeHistory;
    }


    public List<String> courseNamesList(String userName) throws SQLException {
        List<String> courseNames = iGradeHistory.getRegisteredCourses(userName);
        return courseNames;
    }
    public Map<Integer, String> calculateGrades(String userName, String courseName) throws SQLException {
        Map<Integer,Integer> courseGrades= iGradeHistory.getGrades(userName,courseName);
        for (Map.Entry<Integer, Integer> each: courseGrades.entrySet()) {
            String grade = scoreToLetterGrade(each.getValue());
            finalGrades.put(each.getKey(),grade);
        }
        return finalGrades;
    }

    public String scoreToLetterGrade(int finalgrade){
        String result=" ";
        if (finalgrade>=90 && finalgrade<=100){
            result= GRADE1;
        }
        else if (finalgrade>=85 && finalgrade<90){
            result= GRADE2;
        }
        else if (finalgrade>=80 && finalgrade<85){
            result= GRADE3;
        }
        else if (finalgrade>=77 && finalgrade<80){
            result= GRADE4;
        }
        else if (finalgrade>=73 && finalgrade<77){
            result= GRADE5;
        }
        else if (finalgrade>=70 && finalgrade<73){
            result= GRADE6;
        }
        else if (finalgrade>=0 && finalgrade<70){
            result= GRADE7;
        }
        return result;
    }

    public double calculateCgpa(String userName, int semester) throws SQLException {
        double cgpa= 0.0;
        double points=0;
        List<String> grades = new ArrayList<String>();
        List marks=iGradeHistory.allGrades(userName, semester);
        for(int i = 0; i<marks.size();i++){
            grades.add(scoreToLetterGrade((Integer) marks.get(i)));
        }
        for (int j = 0 ; j<grades.size();j++){
            if (grades.get(j).equals(GRADE1)){
                points += GRADE1_POINTS;
            }
            else if (grades.get(j).equals(GRADE2)){
                points += GRADE2_POINTS;
            }
            else if (grades.get(j).equals(GRADE3)){
                points += GRADE3_POINTS;
            }
            else if (grades.get(j).equals(GRADE4)){
                points += GRADE4_POINTS;
            }
            else if (grades.get(j).equals(GRADE5)){
                points += GRADE5_POINTS;
            }
            else if (grades.get(j).equals(GRADE6)){
                points += GRADE6_POINTS;
            }
            else {
                return cgpa;
            }
        }
        cgpa = points / grades.size();
        return cgpa;
    }
}
