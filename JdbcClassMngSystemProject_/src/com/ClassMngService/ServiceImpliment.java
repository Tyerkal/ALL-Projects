package com.ClassMngService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.ClassMngConnection.MyConnection;

public class ServiceImpliment implements Services {

	Scanner sc = new Scanner(System.in);
//	Connection connection=MyConnection.getConnection();

	@Override
	public void addCourse() {

		try {

			System.out.println("How many course u want to add : ");
			int n = sc.nextInt();

			for (int i = 1; i <= n; i++) {

				System.out.println("Enter cid : ");
				int cid = sc.nextInt();

				System.out.println("Enter Cname : ");
				String cname = sc.next();

				Connection connection = MyConnection.getConnection();

				String sql = "insert into course values (?,?)";

				PreparedStatement psmt = connection.prepareStatement(sql);

				psmt.setInt(1, cid);
				psmt.setString(2, cname);

				psmt.execute();
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}

	@Override
	public void displayCourse() {

		try {
			Connection connection = MyConnection.getConnection();

			String sql = "select * from course";

			PreparedStatement psmt = connection.prepareStatement(sql);

			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				System.out.println("Cid : " + rs.getInt(1));
				System.out.println("Cname : " + rs.getString(2));
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}

	@Override
	public void addFaculty() {

		try {

			System.out.println("How many Faculty u want to add : ");
			int n = sc.nextInt();

			for (int i = 1; i <= n; i++) {

				System.out.println("Enter fid : ");
				int fid = sc.nextInt();

				System.out.println("Enter fname : ");
				String fname = sc.next();

				System.out.println("Chosse Course from following : ");
				displayCourse();// 11 12

				int cid = sc.nextInt();
				Connection connection = MyConnection.getConnection();

				String sql = "insert into faculty values (?,?,?)";

				PreparedStatement psmt = connection.prepareStatement(sql);

				psmt.setInt(1, fid);
				psmt.setString(2, fname);
				psmt.setInt(3, cid);

				psmt.execute();

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}

	public void disaplayFaculty() {

		try {
			Connection connection = MyConnection.getConnection();

			String sql = "select course.cid,course.cname,faculty.fid,faculty.fname from faculty inner join course on faculty.cid=course.cid";

			PreparedStatement psmt = connection.prepareStatement(sql);

			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				System.out.println();
				System.out.println("Cid : " + rs.getInt(1));
				System.out.println("Cname : " + rs.getString(2));
				System.out.println("Fid : " + rs.getInt(3));
				System.out.println("Fname : " + rs.getString(4));
				System.out.println("--------------------------------");

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}

	@Override
	public void addBatch() {

		System.out.println("How amny Batches u want to add : ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {

			System.out.println("Enter bid : ");
			int bid = sc.nextInt();

			System.out.println("enter bname : ");
			String bname = sc.next();
			try {
				Connection connection = MyConnection.getConnection();
				String sql = "insert into batch values (?,?,?)";

				System.out.println("Choose fid from following : ");
				displayFaculty();

				int fid = sc.nextInt();

				PreparedStatement psmt = connection.prepareStatement(sql);
				psmt.setInt(1, bid);
				psmt.setString(2, bname);
				psmt.setInt(3, fid);

				psmt.execute();
				System.out.println("Register");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}

		}

	}

	@Override
	public void displayBatch() {
		// TODO Auto-generated method stub

		try {

			Connection connection = MyConnection.getConnection();
			String sql = "select course.cid,course.cname,faculty.fid,faculty.fname,batch.bid,batch.bname from batch inner join faculty on batch.fid=faculty.fid inner join course on faculty.cid=course.cid";

			PreparedStatement psmt = connection.prepareStatement(sql);

			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				System.out.println();
				System.out.println("Cid : " + rs.getInt(1));
				System.out.println("Cname : " + rs.getString(2));
				System.out.println("Fid : " + rs.getInt(3));
				System.out.println("Fname : " + rs.getString(4));
				System.out.println("Bid : " + rs.getInt(5));
				System.out.println("Bname : " + rs.getString(6));
				System.out.println("--------------------------------");

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}

	@Override
	public void addStudent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void displayStudent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void displayFaculty() {
		// TODO Auto-generated method stub

	}

}
