import java.util.*;

class Bank
{
private String accno;
private String accname;
private long accbalance;

Scanner sc = new Scanner(System.in);

//   Method to open an Account

public void openAccount()
{
System.out.println("Enter the Account Number");
accno = sc.next();
System.out.println("Enter the Account Holder Name");
accname=sc.next();
System.out.println("Enter the Account Holder Balance");
accbalance = sc.nextLong();
}

// Method to Display Account Holder Details
public void showAccount()
{
System.out.println(accno+","+accname+","+accbalance);
}

	// Method to Deposit Money
	public void deposit()
	{
	long amount;
	System.out.println("Enter the Amount to Deposit");
	amount = sc.nextLong();
	accbalance = accbalance+amount;
	System.out.println("New balance is:"+accbalance);
	}

	// Withdrawl Money
	public void withdrawl()
	{
	long amount;
	System.out.println("Enter the Amount to Withdraw");
	amount = sc.nextLong();
	if(accbalance>=amount)  
	{
	accbalance = accbalance-amount;
	System.out.println("New balance is:"+accbalance);
	}
	else
	{
	System.out.println("Less Balance");	
	}
	}
// Method to Search an Account Number
	public boolean search(String accountnumber)
	{
	if(accno.equals(accountnumber))	
	{
	showAccount();
	return (true);
	}
	return (false);
	}
} // class close

public class BankSystem1
{
public static void main(String []args)
{
Scanner sc = new Scanner(System.in);
System.out.println("How Many Customer's Do you want to input");
int n = sc.nextInt();
Bank b[] = new Bank[n];
	for(int i=0;i<b.length;i++)
	{
	b[i]=new Bank();
	b[i].openAccount();
	}
//    Run menu upto 5 
int choice;
do
{
System.out.println("Main Menu\n");
System.out.println("1.Display All");
System.out.println("2.Search By Account");
System.out.println("3.Deposit");
System.out.println("4.Withdrawal\n");
System.out.println("5.Exit");
			System.out.println("Ur Choice :");
choice = sc.nextInt();
	switch(choice)
	{
	case 1: for(int i=0;i<b.length;i++)
		{
		b[i].showAccount();
		}
		break;		
	case 2:
		System.out.println("Enter Account number to search");
		String searchaccountno = sc.next();
		boolean found = false;
		for(int i=0;i<b.length;i++)
		{
		found = b[i].search(searchaccountno );
			if(found)
			{
			break;
			}
		}
		if(!found)
		{
		System.out.println("no such account exist");
		}	
		break;
		
	case 3: 
		System.out.print("Enter Account No :");
		searchaccountno=sc.next();
		found=false;
		for(int i=0;i<b.length;i++)
		{  
		found=b[i].search(searchaccountno );
		if(found)
		{
		b[i].deposit();
		break;
		}
		}
		if(!found)
		{
		System.out.println("Account number not valid");
		}
		break;
	  case 4:
		System.out.print("Enter Account No :");
		searchaccountno=sc.next();
		found=false;
		for(int i=0;i<b.length;i++)
		{  
		found=b[i].search(searchaccountno );
		if(found)
		{
		b[i].withdrawl();
		break;
		}
		}
		if(!found)
		{
		System.out.println("Account number not valid");
		}
		break;
		}
	}while(choice!=5);

}
}


