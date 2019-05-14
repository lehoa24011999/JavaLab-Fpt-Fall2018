package Lab10;

import java.util.regex.Pattern;

 interface DateMatcher {
    boolean matches(String date);
}
public class Test implements DateMatcher{
	
	
//	  private static Pattern DATE_PATTERN = Pattern.compile(
//		      "^\\d{4}-\\d{2}-\\d{2}$");
//	private static Pattern DATE_PATTERN= Pattern.compile("^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$");
	  // a valid date must consist of three groups of integers separated by a dash. 
	private static Pattern DATE_PATTERN= Pattern.compile("^((2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26])))-02-29)$");
	
	
//	private static Pattern DATE_PATTERN = Pattern.compile(
//		      "^((2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26])))-02-29)$"
//		      + "|^(((19|2[0-9])[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8]))$"
//		      + "|^(((19|2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$"
//		      + "|^(((19|2[0-9])[0-9]{2})-(0[469]|11)-(0[1-9]|[12][0-9]|30))$");


	@Override
	public boolean matches(String date) {
		// TODO Auto-generated method stub
		return DATE_PATTERN.matcher(date).matches();
	}
	public static void main(String[] args) {
		Test a = new Test();
		System.out.println(a.matches("2018-02-01"));
	}

	
}
