package databaseConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	//加载jdbc链接MySQL的驱动
	public final static String driver = "com.mysql.cj.jdbc.Driver";
	//连接MySQL数据库的地址
	public final static String url = "jdbc:mysql://localhost:3306/curriculum_design";
	//连接MySQL的用户名
	public final static String user = "root";
	//连接MySQL的密码
	public final static String pwd = "root";
	//静态块加载jdbc驱动
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//连接MySQL的连接对象
	public static Connection getConn() {
		try {
			return DriverManager.getConnection(url, user, pwd);
		}  catch (SQLException e)  {
			e.printStackTrace();
		}
		return null;
	}
	//关闭连接
	public static void close(ResultSet rs,PreparedStatement ps, Connection conn) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		System.out.println(getConn());
	}
}