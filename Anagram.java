/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String s1 = preProcess(str1);
		String s2 = preProcess(str2);

		for(int i=0; i<s1.length(); i++) {
			if (s1.charAt(i)==32)
			s1= s1.substring(0, i)+ s1.substring(i+1);
		}

		for(int i=0;i <s2.length(); i++) {
			if (s2.charAt(i)==32)
			s2= s2.substring(0, i)+ s2.substring(i+1);
		}

		if (s1.length() != s2.length()){
			return false;
		}

		for(int i=0; i<s1.length();i++) {
			char c = s1.charAt(i);
			int j = s2.indexOf(c);
			if (j == -1){
				return false;
			}

			s2 = s2.substring(0, j) + s2.substring(j+1);

		}
		
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		str = str.toLowerCase();
		String newStr="";
		for (int i=0; i< str.length();i++) {
			char c = str.charAt(i);
			if (c==32){
				newStr+= c;
			}
			if ((c>96) && (c<123)) {
				newStr += c;
			}
		}
		return newStr;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		int x;
		String newStr = "";
		while (str.length() >0) {
			x= (int) (Math.random() * str.length());
			newStr += str.charAt(x);
			str = str.substring(0, x) + str.substring(x+1);

		}
		return newStr;
	}
}
