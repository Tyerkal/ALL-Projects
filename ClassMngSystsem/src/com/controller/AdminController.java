package com.controller;

import java.util.Scanner;

import com.services.ServiceImplementation;
import com.services.Services;


public class AdminController {

public static void main(String[] args) {
		
		Services obj = new ServiceImplementation();
		Scanner sc= new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("\n*************WELCOME TO CLASS************\n");
			System.out.println("Please Select the The Service From Following Options :\n");
			System.out.println("ENTER 1 : TO ADD COURSE DETAILS");
			System.out.println("ENTER 2 : TO DESPLY COURSE DETAILS");
			System.out.println("ENTER 3 : TO ADD FACULTY DETAILS");
			System.out.println("ENTER 4 : TO DESPLY FACULTY DETAILS");
			System.out.println("ENTER 5 : TO ADD BATCH DETAILS");
			System.out.println("ENTER 6 : TO DESPLY BATCH DETAILS");
			System.out.println("ENTER 7 : TO ADD STUDDENT DETAILS");
			System.out.println("ENTER 8 : TO DESPLY  DETAILS");
			System.out.println("ENTER 9 ; TO EXIT THE APPLICATION");
			
			int userInput=sc.nextInt();

			switch (userInput) {

			case 1:
				obj.addCourse();
				break;

			case 2:
				obj.displayCourse();
				break;

			case 3:
				obj.addFaculty();
				break;

			case 4:
				obj.displayFaculty();
				break;

			case 5:
				obj.addBatch();
				break;

			case 6:
				obj.displayBatch();
				break;

			case 7:
				obj.addStudent();
				break;

			case 8:
				obj.displayStudent();
				break;

			case 9:
				flag = false;
				break;
				
			default :
				
				System.out.println("\nXXXXXXXX Please enter valid input XXXXXXXX\n");

			}

		}
		
		
	}

}
