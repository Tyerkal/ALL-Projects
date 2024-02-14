package com.exponent.bankapplication.serviceImplement;

import com.exponent.bankapplication.service.RBI;

import java.util.Scanner;

import com.exponent.bankapplication.model.Account;

public class SBI implements RBI {

	Scanner sc = new Scanner(System.in);
	Account acc = new Account();

	public int getValidAccountNumber()
	{
		System.out.println("Enter Account no: ");
		int accNo = sc.nextInt();
		
		String accNumberString =String.valueOf(accNo);
//		if (accNo < 1000 || accNo > 99)
		if(accNumberString.length()!=5)
		{
			System.out.println("Invalid Account no please try again!!!");
		return getValidAccountNumber();
		
		}
		return accNo;
	}
	
	public String getValidAccountName() {
		System.out.println("Enter Account Holder Name");
		String name=sc.next();
		
		if(name.length()<=2) {
			System.out.println("Invalid , please try");
		}
		return name;
	}
	
	public long getValidAadharDetails() {
		System.out.println("ENter Valid Aadhar Details");
		long aadharCard=sc.nextLong();
		return aadharCard;
	}
	public String getValidPanCard() {
		System.out.println("Enter Valid Pan Card");
		String s=sc.next();
		
		char[] arr=s.toCharArray();
		 boolean flag=true;
		 
		 for(int i=0; i<arr.length; i++){
			
			 if(i<=4) {
				 if(!(arr[i] >=65 && arr[i]<=90)) {
					 flag=false;
					 
				 }
				 else if(i<=8) {
					 if(!(arr[i] >=48 && arr[i]<=57)) {
						 flag=false;
						 
					 }
				 }else {
					 if(!(arr[i] >=65 && arr[i]<=90)) {
						 flag=false;
						 
					 }
				 }
			 }
		if(flag) {
			System.out.println("valid Pin number");
		}else {
			System.out.println("Invalid");
		}
		
		
		 }
		
		
		
		
		return s;
	}
	
	public long getValidMobileNo() {
		System.out.println("ENter Valid Mobile no: ");
		long mbNo=sc.nextLong();
		return mbNo;
	}
	public double getValidAccountBalance() {
		System.out.println("ENter Valid Aadhar DetailsAccount Balance");
		double balance=sc.nextDouble();
		return balance;
	}
	

	@Override
	public void registerAccount() {
//		System.out.println("Enter Account Number");
//		int accNo = sc.nextInt();
		
		acc.setAccountNo(getValidAccountNumber());

//		System.out.println("Enter your name");
//		String name = sc.next();
		
		acc.setAccountName(getValidAccountName());

//		System.out.println("Enter Aadhar details");
//		long aadharCard = sc.nextLong();
		acc.setAadharCard(getValidAadharDetails());

//		System.out.println("Enter Pancard");
//		String panCard = sc.next();
		acc.setPanCard(getValidPanCard());

//		System.out.println("Enter mobile no");
//		long mbNo = sc.nextInt();
		
		acc.setContact(getValidMobileNo());

//		System.out.println("Enter account opening balance");
//		double balance = sc.nextDouble();
		acc.setAccountBalance(getValidAccountBalance());

		System.out.println("Account Opening Sucess");

	}

	@Override
	public void showAccountDetails() {

		System.out.println("Enter Account Number");
		int accNo = sc.nextInt();
		if (acc.getAccountNo() == accNo) {
			System.out.println(acc.getAccountName() + " " + acc.getAccountNo() + " " + acc.getAccountBalance() + " "
					+ acc.getContact());

		} else {
			System.out.println("Account Doesn't Exist");
		}
	}

	@Override
	public void showAccountBalance() {
		System.out.println("Enter Account number");
		int accNo = sc.nextInt();

		if (acc.getAccountNo() == accNo) {
			System.out.println("CURRENT Account Balance" + acc.getAccountBalance());
		} else {
			System.out.println("Account Doesn't Exist");
		}
	}

	@Override
	public void withdrawMoney() {
		System.out.println("Enter amount to withdraw");
		double withDrawAmount = sc.nextDouble();
		boolean flag = true;
		if (acc.getAccountBalance() > withDrawAmount) {
			double accBal = acc.getAccountBalance();

			accBal = accBal - withDrawAmount;
			acc.setAccountBalance(accBal);
			System.out.println("your Balance withdraw successfully");

			while (flag) {
				System.out.println("press 1 to display Balance and press 2 to exit");
				int no = sc.nextInt();
				if (no == 1) {
					System.out.println("Balance is: " + accBal);
				} else if (no == 2) {
					flag = false;
				} else {
					System.out.println("incoreeect key press");
				}
			}

		} else {
			System.out.println("Balance is not sufficient");
		}

	}

	@Override
	public void depositMoney() {
		System.out.println("Enter amount to deposit");
		double depositAmount = sc.nextDouble();
		System.out.println("Amount Successfully Deposit");
		boolean flag = true;

		double accBal = acc.getAccountBalance();
		accBal = accBal + depositAmount;

		while (flag) {
			System.out.println("Press 1 to Deposit Amount and press 2 to exit");
			int no = sc.nextInt();

			if (no == 1) {
				System.out.println("Your Balance is: " + accBal);
			} else if (no == 2) {
				flag = false;
			} else {
				System.out.println("incorrect key");
			}

		}
	}

	@Override
	public void udateAccountDetails() {

		boolean flag = true;
		while (flag) {
			System.out.println("1: Enter your updated name");
			System.out.println("2: Enter updated Aadhar details");
			System.out.println("3: Enter updated Pancard");
			System.out.println("4: Enter updated mobile no");
			System.out.println("5: Exit");

			System.out.println("\n----------------------");

			System.out.println("Enter field you want to update");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.println("Enter your name");
				String name = sc.next();
				acc.setAccountName(name);
				System.out.println("new Updated ");
				break;

			case 2:
				System.out.println("Enter new Aadhar ");
				long aadhar = sc.nextLong();
				acc.setAadharCard(aadhar);
				break;

			case 3:
				System.out.println("updated contact: ");
				long contact = sc.nextLong();
				acc.setContact(contact);
				break;
			case 5:
				flag = false;
				break;

			}

		}

	}
}
