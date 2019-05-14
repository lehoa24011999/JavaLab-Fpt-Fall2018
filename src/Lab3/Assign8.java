package Lab3;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Assign8 {
	
	
	private static Scanner in;

	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		System.out.println("Enter you content: \n");
		String line = in.nextLine();
		HashMap<Character, Integer> CountCharacter = new HashMap<Character, Integer>();

		for(int i=0; i<line.length();i++) {
			Character c = line.charAt(i);
			if(!CountCharacter.containsKey(c)) {
				CountCharacter.put(c, 0);
			}
			Integer value = CountCharacter.get(c);
			value = value + 1;
			CountCharacter.put(c, value);
		}
		//gets values
		for (Character c : CountCharacter.keySet()){
            Integer value = CountCharacter.get(c);
            System.out.println(c + " " + value);  
		} 
		
		//count word
		HashMap< String, Integer> countWord = new HashMap<>();
		StringTokenizer st = new StringTokenizer(line);
	    while (st.hasMoreTokens()) {
	    	String word = st.nextToken();
	    	if(!countWord.containsKey(word)) {
	    		countWord.put(word, 0);
			}
			Integer value = countWord.get(word);
			value = value + 1;
			countWord.put(word, value);
	    
	    }
		for (String word: countWord.keySet()){
            Integer value = countWord.get(word);
            System.out.println(word + " " + value);  
		}
	 
		
		
	}

}
