package package1;     //This java file is inside package named package1 inside src folder.
import java.util.*;       //importing all classes from java's util library.. Because it has Scanner Class needed for this Assignment.

public class Customer implements Runnable 
{
	Account accountObj ;    //Account object has to be created to store the information.
	String customerName;    //String to store the name of the Customer.
	
	//Constructor.
	public Customer(Account accountObj, String customerName) 
	{
		//Initializing instance variable of class by parameters passed in the constructor.
		this.accountObj = accountObj;
		this.customerName = customerName;
	}
	

	@Override
	//Overriding abstract method of parent interface.
	public void run() 
	{
		//Creating Synchronized Block to avoid usage of inner code simultaneously by two threads.
		synchronized(accountObj)
		{
			System.out.println("Account transaction for "+customerName);     //Printing Statement.
			
			Scanner sc = new Scanner(System.in);     //Creating Scanner class object to take input from the user.
			
			try
			{
			System.out.print("Enter the amount you want to deposit :");     //Printing Statement.
			accountObj.depositMoney(sc.nextInt());         //Passing the user input value to function.
			
			System.out.print("Enter the amount you want to Withdraw :");     //Printing Statement.
			accountObj.withdrawMoney(sc.nextInt());         //Passing the user input value to function.
			
			System.out.print("\n\n");     //Break line.
			}
			catch(Exception e)
			{
				System.out.println(" Exception occured.");
			}
		}	
	}   //End of run().
}   //End of class.

/*
 * Here, we are using synchronized block in run method.
 * The use of that block here is to avoid use of same content of code by two threads at a time.
 * For example, If we have two threads both are of class Customer.
 * And if we start executing both threads, We don't know that at which point of time, which thread will be running.
 * If let's say, You have 1000 Rs. balance in your Account.
 * You have made two threads ThreadA and ThreadB. 
 * ThreadA is passed to withdraw 600 Rs and ThreadB is passed to withdraw 500 Rs.
 * If we execute the program without synchronized block , Then at that time, both threads will be in Runnable State for the function run() 
 * in Customer class. And condition will be satisfied that (600 < 1000) and (500 < 1000). So both will be executed.
 * And total withdrawn money will be 1100. But we had only 1000 Rs. in our balance.
 * This problem occurred because both threads are working on same source code at the same time.
 * We can encounter this problem by making restriction that at a time, only one thread is allowed to work on that source code.
 * When the work of that thread completes, then only second thread is allowed to work.
 * This restriction is called synchronization.
 * We can use synchronized keyword with variables, methods and we even can make synchronized blocks like above.
 * We will not be able to say that which Thread will execute first on synchronized block,
 * But we can say that at a time, Only one thread will be working on that block. 
 */