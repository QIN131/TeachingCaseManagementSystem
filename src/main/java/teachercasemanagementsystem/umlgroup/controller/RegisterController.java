package teachercasemanagementsystem.umlgroup.controller;
/*
 *   @Author:COOLIGHT
 *   @Ide:IntelliJ IDEA
 *   @Creation time:2021/5/14 0014 11:01
 */

import java.sql.*;

public class RegisterController {
    String DB_URL = null;
    String USER = null;
    String PASS = null;

    private String Id;
    private String password;

    /*
    * 验证登录信息合法性
    * @return 合法返回true,否则返回false
    * @para 1 教师登录,2 管理员登录*/
    public boolean checkRegister(int para) {
        if (para == 1) {
            return this.registerTeacher();
        } else {
            return this.registerAdmin();
        }
    }

    private boolean registerTeacher() {
        Connection conn;
        PreparedStatement pstmt;
        String sql = "select teacheraccount_pwd from teacheraccount where teacheraccount_id = ?";
        ResultSet rs;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);//缺失--数据库连接url,角色
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,getId());
            rs = pstmt.executeQuery();

            //密码验证
            while(rs.next()){
                return getPassword().equals(rs.getString("teacheraccount_pwd"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    private boolean registerAdmin() {
        Connection conn;
        PreparedStatement pstmt;
        String sql = "select admin_pwd from admin where admin_id = ?";
        ResultSet rs;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);//缺失--数据库连接url,角色

            //参数设置
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,getId());

            rs = pstmt.executeQuery();//执行sql

            //密码验证
            while(rs.next()){
                return getPassword().equals(rs.getString("admin_pwd"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    private String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    private String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
