package com.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mode.Batch;
import com.mode.Course;
import com.mode.Faculty;
import com.mode.Student;

public class ServiceImplementation implements Services {
	Scanner sc = new Scanner(System.in);

	List<Course> clist = new ArrayList<Course>();
	List<Batch> blist = new ArrayList<Batch>();
	List<Student> slist = new ArrayList<Student>();
	List<Faculty> flist = new ArrayList<Faculty>();

	@Override
	public void addCourse() {
		System.out.println("How many course you have add");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			Course course = new Course();

			System.out.println("Enter course id");
			int cid = sc.nextInt();
			course.setCid(cid);

			System.out.println("Enter course name");
			String cname = sc.next();
			course.setCname(cname);

			clist.add(course);
		}
	}

	@Override
	public void displayCourse() {

		for (Course c : clist) {
			System.out.println(c);
		}
	}

	@Override
	public void addFaculty() {

		System.out.println("How many faculty add");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {

			Faculty faculty = new Faculty();
			System.out.println("Enter fid : ");
			faculty.setFid(sc.nextInt());

			System.out.println("Enter fname : ");
			faculty.setFname(sc.next());

			System.out.println("Choose course from following : ");
			displayCourse();

			int cid = sc.nextInt();

			for (Course course : clist) {

				if (cid == course.getCid()) {
					faculty.setCourse(course);
				}

			}

			flist.add(faculty);
		}

	}

	@Override
	public void displayFaculty() {

		for(Faculty f: flist) {
			System.out.println(f);
		}
	}

	@Override
	public void addBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public void displayBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addStudent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void displayStudent() {
		// TODO Auto-generated method stub

	}

}
