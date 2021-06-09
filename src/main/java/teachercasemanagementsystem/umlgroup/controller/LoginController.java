package teachercasemanagementsystem.umlgroup.controller;
/*
 *   @Studio:CHJY · 源梦科技
 *   @Author:COOLIGHT
 *   @Ide:IntelliJ IDEA
 *   @Creation time:2021/6/9 0009 17:00
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginController {
    private String DB_URL = null;
    private String USER = null;
    private String PASS = null;

    public boolean verifyLoginInfo(String teacherId) {
        Connection conn;
        PreparedStatement pstmt;
        String sql = "select teacher_Id from teacher where teacher_id = ?";
        ResultSet rs;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);//缺失--数据库连接url,角色
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,teacherId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                return true;
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean addLoginInfo(String teacherAccount_name,String teacherAccount_pwd,String teacherAccount_id) {
        Connection conn;
        PreparedStatement pstmt;
        String sql = "insert into teacheraccount values (?,?,?)";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);//缺失--数据库连接url,角色
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,teacherAccount_name);
            pstmt.setString(2,teacherAccount_pwd);
            pstmt.setString(3,teacherAccount_id);
            if (pstmt.executeUpdate() == 1) {
                return true;
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
