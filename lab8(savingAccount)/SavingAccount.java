import java.io.*;
import java.util.Scanner;

class Bank_Details
{
	
	protected int accountnumber;
	protected double balance;
	protected double rate;
	

	double checkBalance(){
	    return this.balance;
	}
	
	public void deposit( double amount)
	{
		this.balance += amount;
		System.out.println("Deposited into account " + accountnumber);
		System.out.println("Amount : " + amount);
		System.out.println("New balance :" + balance);
	}
	
	public boolean checkminbalance(double tempBalance)
	{
		if(tempBalance < 1000)
			return false;
		return true;
	}
	
	public boolean withdraw(double amount)
	{
	
		System.out.println("Withdrawal from account " + accountnumber);
		System.out.println("Amount : " + amount);
		
		double tempBalance = this.balance - amount;
		if(checkminbalance(tempBalance))
		{
	            this.balance -= amount;
		    System.out.println("New balance:" + balance);
			return true;
		}	
		else
		{	
		    System.out.println("Insufficient funds :");
		    return false;
		}
	
	}
	
	public void add_interest(double rate)
	{
		
	    this.balance += this.balance *( this.rate / 100);
	    System.out.println("Interest added to account :" + accountnumber);
	    System.out.println("New balance :" + balance);
	}
	
     
     public void getDetails()
     {
     	Scanner input = new Scanner(System.in);	
	   
     	System.out.println("Enter account number :");
     	this.accountnumber = input.nextInt();
     	System.out.println("Enter initial balance :");
     	this.balance = input.nextDouble();
     	System.out.println("Enter rate :");
     	this.rate = input.nextDouble();
    }
}


public class SavingAccount
{
     public static void main(String[] args)
     {
        
     	Scanner scan = new Scanner(System.in);
     	System.out.print("Enter Count of accounts : ");
     	int size = scan.nextInt();
     	Bank_Details[] accounts = new Bank_Details[size];
        
        for(int i=0; i<size; i++)
     	{
     		accounts[i] = new Bank_Details();
     		System.out.println("Enter account(" + (i+1) + " details: \n");
	        accounts[i].getDetails();
     	}
	
	
    	boolean flag = true;
    	do
    	{
    		boolean accFlag = true;
    		Bank_Details inputAccount = new Bank_Details();
    		do{
    			System.out.println("Enter the account no. in which transaction to be done : ");
    			int accountNumInput = scan.nextInt();
    			for(int i = 0; i < size; i++){
    				if(accounts[i].accountnumber == accountNumInput){
    					inputAccount = accounts[i];
    					accFlag = false;
    					break;
    				}
    			}
    			if(accFlag){
    				System.out.println("Invalid account number!!!\nPlease try again with valid account no.~~~~ ");
    			}
    		}while(accFlag);
    		//choice
    		System.out.println("\n\n1. Deposit");
    		System.out.println("2. Withdraw");
    		System.out.println("3. Check Balance");
    		System.out.println("4. Exit");
    		
    		System.out.println("Enter your choice");
    		int choice = scan.nextInt();
    		switch(choice)
    		{
    			case 1 :
    				System.out.println("Enter amount to be deposited");
    				double amt = scan.nextDouble();
    				inputAccount.deposit(amt);
    				break;
    			case 2 :
    				System.out.println("Enter amount to be withdrawn");
    				double amt_withdraw = scan.nextDouble();
    				inputAccount.withdraw(amt_withdraw);
    				break;
    			case 3 :
    				 System.out.println("Balance in the account : " + inputAccount.checkBalance());
    				 break;
    			case 4 :
    				 flag = false;
    			default : 
    				 System.out.println("Invalid option");
    		}
    	}while(flag);
    }
}
