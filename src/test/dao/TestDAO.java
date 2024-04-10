package test.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import databaseConnection.DBConnection;
import test.model.Test;

public class TestDAO {
	//增加
	public boolean add(Test tes) {
		//执行SQL语句
		//连接MySQL
		Connection conn = DBConnection.getConn();
		//预编译
		String sql = "insert into test values(?, ?, now())";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, tes.getIdtest());
			ps.setString(2, tes.getName());
			//执行更改操作
			boolean result = ps.executeUpdate() > 0;
			//关闭数据库
			DBConnection.close(null, ps, conn);
			return result;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}
	//修改
	public boolean update(Test tes) {
		// 执行SQL语句
	    // 连接MySQL
	    Connection conn = DBConnection.getConn();
	    // 预编译
	    String sql = "UPDATE test SET name = ? WHERE Idtest = ?";
	    try {
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, tes.getName());
	        ps.setInt(2, tes.getIdtest());
	        // 执行更改操作
	        boolean result = ps.executeUpdate() > 0;
	        // 关闭数据库资源
	        DBConnection.close(null, ps, conn);
	        return result;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	//删除
	public boolean delete(int Idtest) {
		// 执行SQL语句
	    // 连接MySQL
	    Connection conn = DBConnection.getConn();
	    // 预编译
	    String sql = "DELETE FROM test WHERE Idtest = ?";
	    try {
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1, Idtest);
	        // 执行更改操作
	        boolean result = ps.executeUpdate() > 0;
	        // 关闭数据库资源
	        DBConnection.close(null, ps, conn);
	        return result;
	    }catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	//查询单条
	public Test query(int Idtest) {
		// 执行SQL语句
	    // 连接MySQL
	    Connection conn = DBConnection.getConn();
	    String sql = "SELECT * FROM test WHERE Idtest = ?";
	    try {
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1, Idtest);
	        // 执行更改操作
	        ResultSet rs = ps.executeQuery();
	        Test tes = new Test();
	        while(rs.next()) {
	        	tes.setIdtest(rs.getInt(1));
	        	tes.setName(rs.getString(2));
	        	tes.setTime(rs.getDate(3));
	        }
	        // 关闭数据库资源
	        DBConnection.close(rs, ps, conn);
	        return tes;
	    }catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	//查询全部
	public List<Test> getAll(){
		Connection conn = DBConnection.getConn();
		String sql = "SELECT * FROM test";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			// 执行更改操作
			ResultSet rs = ps.executeQuery();
			List<Test> tess = new ArrayList<Test>();
			while(rs.next()) {
				Test tes = new Test();
				tes.setIdtest(rs.getInt(1));
				tes.setName(rs.getString(2));
				tes.setTime(rs.getDate(3));
				//把当前对象存储到list中
				tess.add(tes);
			}
			// 关闭数据库资源
			DBConnection.close(rs, ps, conn);
			return tess;
		}catch (SQLException e) {
			e.printStackTrace();
		}
    return null;
		
	}
	public static void main(String[] args) {
//		Test tes = new Test();
//		tes.setIdtest(4);
//		tes.setName("o");
		TestDAO t = new TestDAO();
//		if(t.add(tes)) {
//			System.out.print("保存成功！");
//		} else {
//			System.out.println("保存失败！");
//		}
		//修改
//		Test tes1 = new Test();
//		
		//删除
//		if(t.delete(4)) {
//			System.out.println("删除成功！");
//		} else {
//			System.out.println("删除失败！");
//		}
		
		//查询
		Test tes2 = t.query(3);
		System.out.println(tes2.getName());
		//查询列表
		List<Test> tess = t.getAll();
		for(Test tes : tess) {
		System.out.println(tes.getIdtest()+" "+tes.getName()+" "+tes.getTime());
		}
	}
}
