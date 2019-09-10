package jdbcdemo.preparedstatementdemo;

import java.sql.*;

/**
 * @author xiaolei
 * preparedStatement的查询操作
 * 坑: 查询操作设置占位符的内容时，建议全部都设置为String类型
 */
public class SelectSql {
    public static final String DBDRIVER = "com.mysql.jdbc.Driver";
    public static final String DBURL = "jdbc:mysql://localhost:3306/school";
    public static final String DBUSER = "root";
    public static final String DBPASS = "123456";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        String keyWord1 = "monkey";
        int keyWord2 = 55;
        String keyWord3 = "man";

        ResultSet rs = null;
        String sql = "SELECT name, password, age, sex " +
                "FROM user WHERE name LIKE ? OR " +
                "age LIKE ? OR " +
                "sex LIKE ?";

        Class.forName(DBDRIVER);
        conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        pstmt = conn.prepareStatement(sql);
        // 设置占位符内容
        pstmt.setString(1, "%" + keyWord1 + "%");
        pstmt.setString(2, "%" + keyWord2 + "%");
        pstmt.setString(3, "" + keyWord3 + "");

        rs = pstmt.executeQuery();
        // 查看查询后的结果
        while (rs.next()) {
            String myName = rs.getString(1);
            int myAge = rs.getInt(3);
            String myPassword = rs.getString(2);

            System.out.print("name: " + myName + "; ");
            System.out.print("age: " + myAge + "; ");
            System.out.println("password: " + myPassword);
            System.out.println("======");
        }
        rs.close();
        pstmt.close();
        conn.close();
    }
}
