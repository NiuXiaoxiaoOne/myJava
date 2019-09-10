package jdbcdemo.preparedstatementdemo;

import java.sql.*;

/**
 * @author xiaolei
 * PreparedStatement的插入和更新操作应用
 */
public class InsertSql {
    public static final String DBDRIVER = "com.mysql.jdbc.Driver";
    public static final String DBURL = "jdbc:mysql://localhost:3306/school";
    public static final String DBUSER = "root";
    public static final String DBPASS = "123456";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        String myname = "monkey";
        String mypassword = "66";
        int myage = 66;
        String mysex = "woman";
        // 1.sql语句中最好写上指定列的名字, ?为预处理sql,占位用
        String sql = "INSERT INTO user(name, password, age, sex) " +
                "VALUES(?,?,?,?)";
        // 更新操作
//        String sql = "UPDATE IGNORE user " +
//                "SET password = ?, age = ?, sex = ? " +
//                "WHERE name = '" + myname + "'";
        Class.forName(DBDRIVER);
        conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        // 2.实例化prepareStatement
        pstmt = conn.prepareStatement(sql);

        // 3.插入数据，要插入的内容依次对应占位符的位置
        pstmt.setString(1, myname);
        pstmt.setString(1, mypassword);
        pstmt.setInt(2, myage);
        pstmt.setString(3, mysex);
        // 4.更新数据
        pstmt.executeUpdate();
        pstmt.close();
        conn.close();
    }
}
