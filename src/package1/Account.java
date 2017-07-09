package package1;   //This java file is inside package named package1 inside src folder.


public class Account   //Creating the class to store the account details. 
{
	int balanceAmt;   //int variable to store the balance of the Acoount.
	
	//Constructor.
	public Account(int balanceAmt)
	{
		//Initializing instance variable of class by parameter passed in the constructor.
		this.balanceAmt=balanceAmt;
	}
	
	//Method to deposit amount in the bank.
	public void depositMoney(int depositAmt)
	{
		balanceAmt = balanceAmt + depositAmt ;   //We are increasing balanceAmt by adding depositAmt.
		
		System.out.println(depositAmt+" Rs. have been successfully depositted in Your Account.");   //Printing Statement.
		System.out.println("You have "+balanceAmt+" Rs. balance in your account.");     //Printing Statement.
	}
	
	//Method to withdraw money in the bank.
	public void withdrawMoney(int withdrawnAmt)
	{
		//Checking that there is sufficient balance or not.
		if(balanceAmt < withdrawnAmt)
		{
			System.out.println("Insufficient Balance in your Account.");   //Printing Statement.
		}
		else
		{
			balanceAmt = balanceAmt - withdrawnAmt;    //Reducing amount balance by withdrawnAmt.
			
			System.out.println("You have withdrawn Rs. "+withdrawnAmt);      //Printing Statement.
			System.out.println("Now, You have left Rs. "+balanceAmt+" in your account.");     //Printing Statement.
		}
	}
	
}     //End of class.