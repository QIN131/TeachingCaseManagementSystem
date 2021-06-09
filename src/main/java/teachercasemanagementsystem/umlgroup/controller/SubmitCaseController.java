package teachercasemanagementsystem.umlgroup.controller;
/*
 *   @Author:COOLIGHT
 *   @Ide:IntelliJ IDEA
 *   @Creation time:2021/5/17 0017 22:52
 */

import java.sql.*;

public class SubmitCaseController {
    private String DB_URL = null;
    private String USER = null;
    private String PASS = null;

    private String caseType;
    private String caseContent;
    private int caseCondition;
    private int caseSubTime;
    private String caseSubTeacher;

    /*
    * 添加案例信息到案例信息表*/
    public int addCaseInfo(){
        Connection conn;
        PreparedStatement pstmt;

        String sql = "insert into caseinfo values (null,?,?,?,?,?)";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);//缺失--数据库连接url,角色

            //参数设置
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,getCaseType());
            pstmt.setString(2,getCaseContent());
            pstmt.setInt(3,getCaseCondition());
            pstmt.setInt(4,getCaseSubTime());
            pstmt.setString(5,getCaseSubTeacher());

            return pstmt.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }

        return 0;
    }

    private String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    private String getCaseContent() {
        return caseContent;
    }

    public void setCaseContent(String caseContent) {
        this.caseContent = caseContent;
    }

    private int getCaseCondition() {
        return caseCondition;
    }

    public void setCaseCondition(int caseCondition) {
        this.caseCondition = caseCondition;
    }

    private int getCaseSubTime() {
        return caseSubTime;
    }

    public void setCaseSubTime(int caseSubTime) {
        this.caseSubTime = caseSubTime;
    }

    private String getCaseSubTeacher() {
        return caseSubTeacher;
    }

    public void setCaseSubTeacher(String caseSubTeacher) {
        this.caseSubTeacher = caseSubTeacher;
    }
}
