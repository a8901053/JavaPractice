package 策略模式科目學期末成績;

public interface Subjects {
    int count(int attendGrade,int wordGrade,int midExamGrade,int finalExamGrade);
    String getName();
}
