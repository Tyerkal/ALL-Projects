package com.exponent.bankapplication.controller;

import java.util.Scanner;
import com.exponent.bankapplication.service.RBI;
import com.exponent.bankapplication.serviceImplement.SBI;

public class AdminController {

	public static void main(String[] args) {

		System.out.println("Welcome to Bank");
		Scanner sc = new Scanner(System.in);

		boolean flag = true;
		RBI rbi = new SBI();

		while (flag) {
			System.out.println("--------------------------");
			System.out.println("1: Create Bank Account    ");
			System.out.println("2: Show Account Details   ");
			System.out.println("3: show Account Balance   ");
			System.out.println("4: Deposit Money          ");
			System.out.println("5: Withdraw Money         ");
			System.out.println("6: Update Account Deatils ");
			System.out.println("7: Exit                   ");

			System.out.println("--------------$$$$$$$$$$$$$$$$$$$$$$$$------------------");
			System.out.println("Enter your choice");

			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				rbi.registerAccount();
				break;

			case 2:
				rbi.showAccountDetails();
				break;

			case 3:
				rbi.showAccountBalance();
				break;

			case 4:
				rbi.depositMoney();
				break;

			case 5:
				rbi.withdrawMoney();
				break;

			case 6:
				rbi.udateAccountDetails();
				break;

			case 7:
				flag = false;
				break;

			default:
				System.out.println("Wrong choice");
				break;

			}

		}

		System.out.println("Thank You For Visiting Bank");
	}

}
