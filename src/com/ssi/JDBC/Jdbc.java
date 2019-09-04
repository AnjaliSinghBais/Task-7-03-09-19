package com.ssi.JDBC;

import java.sql.*;
import java.util.Scanner;

public class Jdbc {

	// CRUD OPERATIONS USING JDBC
	private static Connection con;
	private static Scanner sc = new Scanner(System.in);

	// SELECTION OPERATION
	public static void select() throws Exception {
		System.out.println("DATA OF THE STUDENTS");
		PreparedStatement ps = con.prepareStatement("select * from student");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println("NAME-> " + rs.getString(1) + "   AGE->" + rs.getString(2) + "  PHONE->" + rs.getInt(3)
					+ " ID->" + rs.getInt(5));
		}

	}

	// CREATE OPERATION
	public static void create() throws Exception {
		System.out.println("CREATE TABLE");
		PreparedStatement ps = con
				.prepareStatement("create table STUDENT3 (id int,studname varchar(50),address varchar(30),phone int)");
		int x = ps.executeUpdate();

		if (x == 0)
			System.out.println("Table Created");
		else
			System.out.println("NOT CREATED");

	}

	// ALTER OPERATION
	public static void alter() throws Exception {
		System.out.println("ALTER TABLE");
		System.out.println("Press 1 if you want to alter an existing table");
		if (sc.nextInt() == 1) {
			boolean t_exist = false;
			System.out.println("Enter name of table you want to alter");
			String table = sc.next();
			try (ResultSet rs = con.getMetaData().getTables(null, null, table, null)) {
				while (rs.next()) {
					String t_name = rs.getString("TABLE_NAME");
					if (t_name != null && table.equals(table))
						t_exist = true;
					if (t_exist)
						System.out.println("table exist");
					else
						System.out.println("Table not exist");
					System.out.println("which column you want to change");
					String column = sc.next();
					System.out.println("Enter the new name");
					String newcol = sc.next();
					String query = "Alter table " + t_name + " CHANGE " + column + " " + newcol + "" + " INT NOT NULL";
					System.out.println(query);
					PreparedStatement ps = con.prepareStatement(query);
					ps.executeUpdate();
					System.out.println("Altered successfully........");

					break;
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

	}

	// DELETE OPERATION
	public static void delete() throws Exception {
		System.out.println("ENTER THE ID OF THE STUDENT TO BE DELETED");
		int id = sc.nextInt();
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "root");
		PreparedStatement ps = con.prepareStatement("Delete from student where id=?");
		ps.setInt(1, id);
		int x = ps.executeUpdate();
		if (x == 0)
			System.out.println("RECORD NOT FOUND CHECH ID");
		else
			System.out.println("RECORD DELETED.....");

	}

	// UPDATE OPERATION
	public static void update() throws Exception {
		System.out.println("ENTER THE ID OF THE STUDENT TO BE UPDATED");
		int id = sc.nextInt();
		System.out.println("ENTER UPDATED NAME ");
		String name = sc.next();
		System.out.println("ENTER UPDATED AGE ");
		int age = sc.nextInt();
		System.out.println("ENTER UPDATED PHONE");
		int phone = sc.nextInt();
		System.out.println("ENTER UPDATE PASSWORD");
		String password = sc.next();
		PreparedStatement ps = con.prepareStatement("update student set name=?,age=?,phone=?,password=? where id=?");
		ps.setString(1, name);
		ps.setInt(2, age);
		ps.setInt(3, phone);
		ps.setString(4, password);
		ps.setInt(5, id);
		int x = ps.executeUpdate();
		if (x == 0)
			System.out.println("RECORD NOT UPDATED");
		else
			System.out.println("RECORD UPDATED.....");

	}

	// INSERT OPERATION
	public static void insert() throws Exception {
		System.out.println("ENTER THE DETAILS OF THE STUDENT ");
		System.out.println("ENTER NAME ");
		String name = sc.next();
		System.out.println("ENTER AGE ");
		int age = sc.nextInt();
		System.out.println("ENTER PASSWORD");
		int phone = sc.nextInt();
		System.out.println("ENTER PASSWORD");
		String password = sc.next();
		System.out.println("ENTER ID");
		int id = sc.nextInt();
		PreparedStatement ps = con
				.prepareStatement("Insert into student (name,age,phone,password,id) values (?,?,?,?,?)");
		ps.setString(1, name);
		ps.setInt(2, age);
		ps.setInt(3, phone);
		ps.setString(4, password);
		ps.setInt(5, id);
		int x = ps.executeUpdate();
		if (x == 0)
			System.out.println("NOT INSERTED");
		else
			System.out.println("RECORD INSERTED.....");
	}

	public static void main(String[] args) throws Exception {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "root");

			create();
			select();
			alter();
			select();
			update();
			select();
			delete();
			select();
			insert();
			select();
			update();
			select();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
			sc.close();
		}

	}

}