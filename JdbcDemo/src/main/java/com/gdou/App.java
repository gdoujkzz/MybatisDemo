package com.gdou;

import javax.swing.text.StyledEditorKit;
import java.sql.*;
import java.util.*;

/**
 * Hello world!
 */
public class App {
    public static final String userName = "mespro";
    public static final String password = "mesprotst123";
    public static final String url = "jdbc:oracle:thin:@//10.16.9.24:1601/mestst9";

    public static void main(String[] args) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        List<UserDTO> users = new ArrayList<UserDTO>();
        try {
            Properties pro = new Properties();
            pro.put("user", userName);
            pro.put("password", password);
            conn = DriverManager.getConnection(url, pro);
            stmt = conn.prepareStatement("select * from test_user");
            result = stmt.executeQuery();
            while (result.next()) {
                //实际应用中，要把这里进行转换为JavaBean对象。
                UserDTO user = new UserDTO();
                user.setId(result.getInt("id"));
                user.setName(result.getString("name"));
                users.add(user);
            }
            for (UserDTO user : users) {
                System.out.println(user);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
            System.out.println("SQLState" + ex.getSQLState());
            System.out.println("VennorError" + ex.getErrorCode());
        } finally {
            result.close();
            stmt.close();
            conn.close();
        }

    }
}
