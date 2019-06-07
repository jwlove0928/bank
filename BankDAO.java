package money;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BankDAO {
	
	public void insert(BankDTO dto) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/bank";
			String user = "root";
			String password = "1234";
			
			Connection con = DriverManager.getConnection(url,user,password);
			
			String sql = "insert into member values(?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getName());
			ps.setInt(3, dto.getAge());
			ps.setInt(4, dto.getTel());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(BankDTO dto) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/bank";
			String user= "root";
			String password = "1234";
			
			Connection con = DriverManager.getConnection(url,user,password);
			
			String sql = "update member set tel=? where id=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, dto.getTel());
			ps.setString(2, dto.getId());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void delete(BankDTO dto) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/bank";
			String user = "root";
			String password = "1234";
			
			Connection con = DriverManager.getConnection(url,user,password);
			
			String sql = "delete from member where id = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, dto.getId());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList select(String inputid) {
		
		ArrayList list = new ArrayList();
		BankDTO dto = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url ="jdbc:mysql://localhost:3306/bank";
			String user = "root";
			String password = "1234";
			
			Connection con = DriverManager.getConnection(url,user,password);
			
			String sql = "select * from member where id=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, inputid);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				dto = new BankDTO();
				String id = rs.getString(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				int tel = rs.getInt(4);
				dto.setId(id);
				dto.setName(name);
				dto.setAge(age);
				dto.setTel(tel);
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public ArrayList selectAll(BankDTO dto) {
		
		ArrayList list = new ArrayList();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url ="jdbc:mysql://localhost:3306/bank";
			String user = "root";
			String password = "1234";
			
			Connection con = DriverManager.getConnection(url,user,password);
			
			String sql = "select * from member";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				dto = new BankDTO();
				String id = rs.getString(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				int tel = rs.getInt(4);
				dto.setId(id);
				dto.setName(name);
				dto.setAge(age);
				dto.setTel(tel);
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
