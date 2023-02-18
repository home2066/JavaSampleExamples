package codeSamples;

public class UseOfFinally {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	int x = 100;	
	}
catch(Exception e)
{
	System.out.println(e);
}
 finally {
	 System.out.println("Finally block is executed");
}
	
String s1 = "welcome";
String s2 = "welcome";
String s3 = "welcome";

System.out.println("No of objects created");
	
	}

}
