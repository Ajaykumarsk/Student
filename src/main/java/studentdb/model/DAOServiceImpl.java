package studentdb.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAOServiceImpl implements DAOService {
		
	private Connection con;
	private Statement stm;
	@Override
	public void connectDB() {
		
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","Maker123@");
				stm=con.createStatement();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public boolean verfiyCredentials(String email, String password) {
		try {
			ResultSet result = stm.executeQuery("select * from login where email='"+email+"' and password='"+password+"'");
			return result.next();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	@Override
	public void saveRegistration(String name, String fathername, String mothername, String gender, String email,
			String mobile, String course) {
		try {
				stm.executeUpdate("insert into student values('"+name+"','"+fathername+"','"+mothername+"',"
						+ "'"+gender+"','"+email+"','"+mobile+"','"+course+"')");
				
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	@Override
	public ResultSet getAllReg() {
		try {
			ResultSet result = stm.executeQuery("select * from student");
			return result;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void deleteReg(String name, String email, String mobile) {
		try {
			stm.executeUpdate("delete from student where name='"+name+"' and email='"+email+"' and mobile='"+mobile+"'");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	@Override
	public void updateReg(String name, String email, String mobile) {
		try {
			stm.executeUpdate("update student set mobile='"+mobile+"' where name='"+name+"' and email='"+email+"'");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
