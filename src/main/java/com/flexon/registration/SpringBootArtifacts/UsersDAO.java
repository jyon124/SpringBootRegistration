package com.flexon.registration.SpringBootArtifacts;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import org.springframework.stereotype.Component;

@Component
public class UsersDAO {
	Scanner input = new Scanner(System.in); 
	public static ArrayList<User> userArr = new ArrayList<>();

	
	public void addUser(User userObj) {
		try {
			String url = "jdbc:mysql://localhost:3306/users";
			String user = "chloe";
			String password = "1234";
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement stmt = conn.createStatement();
			ResultSet lastUser = stmt.executeQuery("SELECT user_id FROM users ORDER BY user_id DESC LIMIT 1");
			int newUserId = 0;
			while(lastUser.next()) {
				newUserId = lastUser.getInt("user_id") + 1;
			}
			String insertInput = newUserId + ", '" + userObj.getFirstName() + "' , '" + userObj.getLastName() + "', '" + userObj.getEmail() + "', '" + userObj.getPassword() + "', '" + userObj.getDateOfBirth() + "', '" + userObj.getGender() + "'";
			System.out.println(insertInput);
			stmt.executeUpdate("INSERT INTO users " + "values(" + insertInput + ")");
			stmt.close();
		}catch(Exception exec) {
			System.out.println(exec);
		}
	}
	
	public void updateUser(int userID) {
		try {
			String url = "jdbc:mysql://localhost:3306/users";
			String user = "chloe";
			String password = "1234";
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users WHERE user_id = " + userID);
			String currPw = null;
			while(rs.next()) {
				currPw = rs.getString("password");
			}
			System.out.println("Enter a current password for selected user:");
			String typedPw = input.nextLine();
			if(typedPw.equals(currPw)) {
				System.out.println("Enter a new first name:");
				String newfn = input.nextLine();
				String queryInput = "UPDATE users set firstName = '" + newfn + "' WHERE user_id = " + userID;
				stmt.executeUpdate(queryInput);
			} else {
				System.out.println("Incorrect current password.");
			}
			stmt.close();
		} catch (Exception exec) {
			System.out.println(exec.getMessage());
		}
	}
	
	public void removeUser(int choice) {
		try {
			String url = "jdbc:mysql://localhost:3306/users";
			String user = "chloe";
			String password = "1234";
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement stmt = conn.createStatement();
			String queryInput = "DELETE FROM users WHERE user_id = " + choice;
			stmt.executeUpdate(queryInput);
			stmt.close();
		} catch (Exception exec) {
			System.out.println(exec);
		}
		System.out.println("Selected User has been successfully deleted.");
	}

	public User findUser(int user_id) {
		for(int i = 0; i < userArr.size(); i++) {
			if(userArr.get(i).getUser_id() == user_id) {
				return userArr.get(i);
			}
		}
		return null;
	}
	
	public ArrayList<User> printUsers(){
		try {
			String url = "jdbc:mysql://localhost:3306/users";
			String user = "chloe";
			String password = "1234";
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users");
			while(rs.next()) {
				User temp = new User();
				int userId = rs.getInt("user_id");
				String fn = rs.getString("firstName");
				String ln = rs.getString("lastName");
				String email = rs.getString("email");
				String dob = rs.getString("dateOfBirth");
				String gender = rs.getString("gender");
				temp.setUser_id(userId);
				temp.setFirstName(fn);
				temp.setLastName(ln);
				temp.setEmail(email);
				temp.setDateOfBirth(dob);
				temp.setGender(gender);
				if(findUser(userId) == null) {
					userArr.add(temp);
				}
			}
			stmt.close();
		} catch (Exception exec) {
			System.out.println(exec.getMessage());
		}
		return userArr;
	}
}
