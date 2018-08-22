package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.MD5;
import model.User;





public class UserDao {

	public User findByLoginInfo(String loginId, String password) {
		Connection conn =null;
		try {
			conn = DBManager.getConnection();

			String sql = "select * from user where Login_id = ? and password = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginId);
			pStmt.setString(2, MD5.create(password));
			ResultSet rs = pStmt.executeQuery();

			if (!rs.next()) {
				return null;
			}

			String loginData = rs.getString("login_id");
			String nameData = rs.getString("name");
			return new User(loginData, nameData);

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
					// TODO: handle exception
				}
			}
		}
	}

	public List <User> findAll(){
		Connection conn = null;
		List<User> userList = new ArrayList<User>();

		try {
			conn = DBManager.getConnection();

			String sql = "select * from user where login_id != 'admin'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String loginId = rs.getString("login_id");
				String name = rs.getString("name");
				String birthDate = rs.getString("birth_date");
				String password = rs.getString("password");
				String createDate = rs.getString("create_date");
				String updateate = rs.getString("update_date");
				User user = new User(id, loginId, name, birthDate, password, createDate, updateate);

				userList.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;

			// TODO: handle exception
		} finally {
			if (conn != null) {
				try {

				} catch (Exception e) {
					e.printStackTrace();
					return null;

					// TODO: handle exception
				}
			}
		}
		return userList;

	}

	public List <User> Search(String loginId1, String name1, String birthDate1, String birthDate2 ){
		Connection conn = null;
		List<User> userList = new ArrayList<User>();

		try {
			conn = DBManager.getConnection();

			String sql = "select * from user where login_id != 'admin' ";

			if(!loginId1.equals("")) {
				sql += "and login_id ='"+loginId1+"' ";
			}
			if (!name1.equals("")) {
				sql += "and name like '%"+name1+"%'";
			}
			if (!birthDate1.equals("")) {
				sql += "and birth_date >= '"+birthDate1+"'";
			}
			if (!birthDate2.equals("")) {
				sql += "and birth_date <= '"+birthDate2+"'";
			}
			System.out.println(sql);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String loginId2 = rs.getString("login_id");
				String name2 = rs.getString("name");
				String birthDate = rs.getString("birth_date");
				String password = rs.getString("password");
				String createDate = rs.getString("create_date");
				String updateate = rs.getString("update_date");
				User user = new User(id, loginId2, name2, birthDate, password, createDate, updateate);

				userList.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;

			// TODO: handle exception
		} finally {
			if (conn != null) {
				try {

				} catch (Exception e) {
					e.printStackTrace();
					return null;

					// TODO: handle exception
				}
			}
		}
		return userList;

	}

	//	ユーザ登録
	public int Regist(String loginId, String userName, String birthDate, String password ) {
		Connection conn = null;

		try {
			conn = DBManager.getConnection();

			String sql = "insert into user(login_id, name, birth_date, password, create_date, update_date ) "
					+ "values (?, ?, ?, ?, now(), now())";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,MD5.create(password));
			pStmt.setString(2,userName);
			pStmt.setString(3,birthDate);
			pStmt.setString(4,password);
			return pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
			// TODO: handle exception

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}
	}

	public User findById(String targetId ) {
		Connection conn = null;
		try {
			conn = DBManager.getConnection();

			String sql = "select * from user where id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, targetId);
			ResultSet rs = pStmt.executeQuery();

			if (!rs.next()) {
				return null;
			}
			int id = rs.getInt("id");
			String loginId = rs.getString("login_id");
			String name = rs.getString("name");
			String birthDate = rs.getString("birth_date");
			String password = rs.getString("password");
			String createDate = rs.getString("create_date");
			String updateDate = rs.getString("update_date");
			return new User(id, loginId, name, birthDate, password, createDate, updateDate);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
					// TODO: handle exception
				}
			}
		}
	}

	public int Update (String loginId, String password, String name, String birthDate ) {
		Connection conn = null;

		try {
			conn = DBManager.getConnection();

			String sql = "update user set password = ?, name = ?, birth_date = ?, update_date = now() where login_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,MD5.create(password));
			pStmt.setString(2,name);
			pStmt.setString(3,birthDate);
			pStmt.setString(4,loginId);
			return pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
			// TODO: handle exception

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}
	}

	public int Update (String loginId, String name, String birthDate ) {
		Connection conn = null;

		try {
			conn = DBManager.getConnection();

			String sql = "update user set name = ?, birth_date = ?, update_date = now() where login_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,name);
			pStmt.setString(2,birthDate);
			pStmt.setString(3,loginId);
			return pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
			// TODO: handle exception

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}
	}

	public int Delete (String loginId) {
		Connection conn = null;

		try {
			conn = DBManager.getConnection();

			String sql = "delete from user where  login_id = ?" ;
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,loginId);

			return pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
			// TODO: handle exception

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}
	}
}
