package collection;

public class reveseString {

	public static void main(String[] args) {
		String s="rajavallapan";
		String s1="";
		for(int i=s.length()-1;i>=1;i--) {
			s1=s1+s.charAt(i);
			
		}
		System.out.println(s1);
		if(s1.equals(s)) {
			System.out.println("the String palindrome");
		}
		else {
			System.out.println("the String not a palindrome");
		}
		
		
		
		
		
	}

}
