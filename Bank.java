import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author DivyaVipin
 *
 */
class BankATMException extends Exception{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String exceptionMessage;
    BankATMException(String message) {
    	exceptionMessage=message;
    }
    public String toString(){ 
       return exceptionMessage;
    }
}
class BankATM
{
	String atmId;
	String bankName;
	String location;
	static double balance;
	double atmAmount;
	public double getAtmAmount() {
		return atmAmount;
	}
	public void setAtmAmount(double atmAmount) {
		this.atmAmount = atmAmount;
	}
	public static double getBalance() {
		return balance;
	}
	public static void setBalance(double balance) {
		BankATM.balance = balance;
	}
	
	
	public String getAtmId() {
		return atmId;
	}
	public void setAtmId(String atmId) {
		this.atmId = atmId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	BankATM()
	{
		
	}
	BankATM(String id,String bankname,String location,double atmAmount)
	{
		this.atmId=id;
		this.bankName=bankname;
		this.location=location;
		this.atmAmount=atmAmount;
		balance=atmAmount;
	}
	public double withdrawamount(double amt) throws BankATMException
	{
		if(balance <= amt) {
			throw new BankATMException("Amount cannot be withdrawn");
	         //balance -= amt;
	      }else {
	         
	         balance-=amt;
	         System.out.println("Amount successfully withdrawn");
	         System.out.println("Closing balance"+balance);
	      }
		return balance;
	}
	public double deposit(double amount)
	{
		balance+=amount;
		System.out.println("Amount successfully deposited");
		System.out.println("Closing balance"+balance);
		return balance;
		
	}
	public void display()
	{
		System.out.println("ATM Details");
		System.out.println("-------------");
		System.out.println("ATMId: "+getAtmId());
		System.out.println("BankName: "+getBankName());
		System.out.println("Location: "+getLocation());
		System.out.println("Initial ATM Amount: "+getAtmAmount());
		System.out.println("Balance after updating: "+BankATM.balance);
	}
	
}

public class Bank {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException, BankATMException{
		// TODO Auto-generated method stub
		Scanner ob;
		int a;
		String ch,chc;
		String option;
		String atmId,bankName,atmLocation;
		Double atmAmount;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		do
		{
			 
			System.out.println("Bank ATM Operations");
			System.out.println("\n1.ATM1 Operation 2.ATM2 Operation 3.ATM3 Operation");
			System.out.print("\nEnter option "+"\n");
			ob=new Scanner(System.in);
			a=ob.nextInt();
			switch(a)
			{
			case 1:
				System.out.println ("Enter ATM Id "+"\n");
				 atmId = br.readLine();
				System.out.println ("Enter Bank  Name"+"\n");
				  bankName = br.readLine();
				System.out.println ("Enter ATM Location "+"\n");
				 atmLocation = br.readLine();
				System.out.println ("Enter ATM Amount "+"\n");
				 atmAmount = Double.parseDouble(br.readLine());
				BankATM atm1=new BankATM(atmId,bankName,atmLocation,atmAmount);
				atm1.display();
				do
				{
				System.out.println ("Enter the operation u want to perform "+"\n");
				System.out.print("\nEnter 1:Deposit 2:Withdrawal 3:Exit "+"\n");
				int choice=ob.nextInt();
				switch(choice)
				{
				case 1:
					System.out.println ("Enter amount to deposit: "+"\n");
					Double deposit= Double.parseDouble(br.readLine());
					atm1.deposit(deposit);
					atm1.display();
					break;
				
				case 2:
					System.out.println ("Enter amount to withdraw: "+"\n");
					Double withdraw= Double.parseDouble(br.readLine());
					atm1.withdrawamount(withdraw);
					atm1.display();
					break;
				case 3:
					break;
				case 4:
				default:
					System.out.println("Enter the correct no.");
					break;
				}
				System.out.println("Enter 'Y' for continue or 'N' to stop");
		        chc = ob.next();
				}while(chc.equals("Y"));
				break;
			case 2:
				System.out.println ("Enter ATM Id: "+"\n");
				atmId = br.readLine();
				System.out.println ("Enter Bank  Name: "+"\n");
				bankName = br.readLine();
				System.out.println ("Enter ATM Location: "+"\n");
				atmLocation = br.readLine();
			 	System.out.println ("Enter ATM Amount: "+"\n");
			 	atmAmount = Double.parseDouble(br.readLine());
			BankATM atm2=new BankATM(atmId,bankName,atmLocation,atmAmount);
			atm2.display();
			do
			{
			System.out.println ("Enter the operation u want to perform"+"\n");
			System.out.print("\nEnter 1:Deposit 2:Withdrawal 3:Exit "+"\n");
			int choice=ob.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println ("Enter amount to deposit "+"\n");
				Double deposit= Double.parseDouble(br.readLine());
				atm2.deposit(deposit);
				atm2.display();
				break;
			
			case 2:
				System.out.println ("Enter amount to withdraw "+"\n");
				Double withdraw= Double.parseDouble(br.readLine());
				atm2.withdrawamount(withdraw);
				atm2.display();
				break;
			case 3:
				break;
			case 4:
			default:
				System.out.println("Enter the correct no.");
				break;
			}
			System.out.println("Enter 'Y' for continue or 'N' to stop");
	         option = ob.next();
			}while(option.equals("Y"));
			break;
			case 3:
				System.out.println ("Enter ATM Id "+"\n");
				atmId = br.readLine();
				System.out.println ("Enter Bank  Name"+"\n");
				bankName = br.readLine();
				System.out.println ("Enter ATM Location "+"\n");
				atmLocation = br.readLine();
			 	System.out.println ("Enter ATM Amount "+"\n");
			 	atmAmount = Double.parseDouble(br.readLine());
			BankATM atm3=new BankATM(atmId,bankName,atmLocation,atmAmount);
			atm3.display();
			do
			{
			System.out.println ("Enter the operation u want to perform"+"\n");
			System.out.print("\nEnter 1:Deposit 2:Withdrawal 3:Exit "+"\n");
			int choice=ob.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println ("Enter amount to deposit :"+"\n");
				Double deposit= Double.parseDouble(br.readLine());
				atm3.deposit(deposit);
				atm3.display();
				break;
			
			case 2:
				System.out.println ("Enter amount to withdraw :"+"\n");
				Double withdraw= Double.parseDouble(br.readLine());
				atm3.withdrawamount(withdraw);
				atm3.display();
				break;
			case 3:
				break;
			case 4:
			default:
				System.out.println("Enter the correct no");
				break;
			}
			System.out.println("Enter 'Y' for continue or 'N' to stop ");
	        chc = ob.next();
			}while(chc.equals("Y"));
			break;
			case 4:
			break;
			default:
				System.out.println("Enter the correct no ");break;
				
		}
			
		System.out.println("Continue(Y/N)");
        ch = ob.next();
		}while(ch.equals("Y"));
		
		
	}

}
