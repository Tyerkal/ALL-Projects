package com.serviceImplementation;

import java.util.Scanner;

import com.model.Account;
import com.service.RBI;

public class SBI implements RBI {
	Scanner sc = new Scanner(System.in);
	Account ac = new Account();

	@Override
	public void registerAccount() {
		System.out.println("Enter acc no");
		int accountNo = sc.nextInt();
		ac.setAccountNo(accountNo);
		System.out.println("Enter Acc holder name");
		String name = sc.next();
		ac.setAccountName(name);
		System.out.println("Enter AadharCard no");
		long adharNo = sc.nextLong();
		ac.setAadharCard(adharNo);

		System.out.println("Enter pan card");
		String panCard = sc.next();
		ac.setPanCard(panCard);

		System.out.println("Enter contact no");
		long contactNO = sc.nextLong();
		ac.setContact(contactNO);

		System.out.println("Enter Amount to add Bank");
		double AccountBalance = sc.nextDouble();
		ac.setAccountBalance(AccountBalance);

		System.out.println("Enter Email address");
		String email = sc.next();
		ac.setEmail(email);

	}

	@Override
	public void showAccountDetails() {
		System.out.println("Enter Account No");
		int accNo = sc.nextInt();
		if (ac.getAccountNo() == accNo) {
			System.out.println(ac.getAccountName() + " " + ac.getAccountNo() + " " + ac.getAccountBalance() + " "
					+ ac.getContact());
		} else {
			System.out.println("Account doesnt exist");
		}
	}

	@Override
	public void showAccountBalance() {
		System.out.println("Enter Account No");
		int accNo = sc.nextInt();
		if (ac.getAccountNo() == accNo) {
			System.out.println(ac.getAccountName() + " " + ac.getAccountNo() + " " + ac.getAccountBalance() + " ");
		} else {
			System.out.println("Account no is incorrect!!! pls write correct accNO");
		}
	}

	@Override
	public void withdrawMoney() {
		boolean flag = true;

		System.out.println("Enter amount to withdraw");
		double withDrawamount = sc.nextDouble();
		if (ac.getAccountBalance() > withDrawamount) {
			double accBal = ac.getAccountBalance();
			accBal = accBal - withDrawamount;
			System.out.println("Successfully amount withdraw");

			while (flag) {
				System.out.println("press 1 for show balance and 2 for exit");
			int no = sc.nextInt();
			if (no == 1) {
				System.out.println("balance is: " + accBal);
			} else if (no == 2) {
				flag = false;
			} else {
				System.out.println("Incorrect key press");
			}
			}

		} else {
			System.out.println("Balance not sufficient");
		}

	}

	@Override
	public void depositMoney() {

		System.out.println("Enter amount to deposit");
		double depositamount = sc.nextDouble();
		System.out.println("amount successfully deposit");
		boolean flag = true;
		double accBal = ac.getAccountBalance();
		accBal = accBal + depositamount;
		while (flag) {
			System.out.println("press 1 for show balance and 2 for exit");
			int no = sc.nextInt();
			if (no == 1) {
				System.out.println("balance is: " + accBal);
			} else if (no == 2) {
				flag = false;
			} else {
				System.out.println("Incorrect key press");
			}

		}

	}

	@Override
	public void updateAccountDetails() {
		// TODO Auto-generated method stub

	}

	@Override
	public void udateAccountDetails() {
		// TODO Auto-generated method stub

	}

}
