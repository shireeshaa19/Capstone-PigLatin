package piglatin;

import java.util.Scanner;

public class CapstonePigLatin {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Welcome to the Pig Latin Translator");
		  
	    String ans;
	     
		do {
			System.out.println("Enter a line to be translated :");
	        String word = scnr.nextLine();
	   

	        String[] line = word.split(" "); 
	        String output = "";
            
	        for (int i = 0; i < line.length; i++)
	        {
                
	            if(".,:;?!".contains(String.valueOf(line[i].charAt(line[i].length()-1)))) {
	                String wordCase = caseType(line[i].substring(
	                                0, line[i].length()-1));
	                
	                
	                String pigLatinWord = translateWord(line[i].substring(
	                                0, line[i].length()-1 ));
	                
	                String punctuation = String.valueOf(
	                    line[i].charAt(line[i].length()-1));
	                if(wordCase.equals("upper")) {
	                    output += pigLatinWord.toUpperCase() + punctuation + " ";
	                } else if(wordCase.equals("title")) {
	                    output += String.valueOf(pigLatinWord.charAt(0)).toUpperCase() 
	                            + pigLatinWord.substring(1) + punctuation + " ";
	                    
	                } else { 
	                    output += pigLatinWord + punctuation + " "; 
	                }
	            } else {
	                String wordCase = caseType(line[i]);
    	            String pigLatinWord = translateWord(line[i]); 
    	            
    	            if(wordCase.equals("upper")) {
    	                output += pigLatinWord.toUpperCase() + " ";
    	            } else if(wordCase.equals("title")) {
    	                output += String.valueOf(pigLatinWord.charAt(0)).toUpperCase() 
    	                            + pigLatinWord.substring(1) + " ";
    	                
    	            } else {
    	                output += pigLatinWord + " "; 
    	            }
	            }
	        }

	   
	        System.out.println("Translation: " + output + "\n");
	   
	        System.out.print("Translate another line? (y/n): ");
	        ans = scnr.nextLine().trim();


	   
	    } while(ans.equals("y"));
	}

	public static String translateWord(String word) {
	    String lowerCaseWord = word.toLowerCase();
	    int firstvowel = 0; 
	    char ch;
	    
	    for (int i = 0; i < lowerCaseWord.length(); i++) {
	        ch = lowerCaseWord.charAt(i);
	        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'y') {
	            firstvowel = i;
	            break;
	        }
	    }

	    if (firstvowel == 0) {
	       return lowerCaseWord + "way"; 
	    } else {
	        String A = lowerCaseWord.substring(firstvowel);
	        String B = lowerCaseWord.substring(0, firstvowel);
	        return A + B + "ay"; //
	     
	    }
    }
    
    public static String caseType(String word) { //return "upper", "lower", or "title"
        if (word.length() > 1) {
            if(Character.isUpperCase(word.charAt(0)) &&
                Character.isLowerCase(word.charAt(1))) {
                    return "title"; 
            }
            
            boolean isUpper = true;
            boolean isLower = true;
            
            for(int i = 0; i < word.length(); i++) {
                if(Character.isUpperCase(word.charAt(i))) {
                    isLower = false;
                } else { 
                    isUpper = false;
                }
            }    
            
            if(isUpper) {
                return "upper";
            } else {
                return "lower";
            }
        } else {
            return Character.isUpperCase(word.charAt(0))? "upper" : "lower";
        }
    }
    
    public static boolean translatable(String word) {
    boolean out = true;
    for(int i = 0; i < word.length(); i++) {
    	
        if("0123456789@".contains(String.valueOf(word.charAt(i)))) {
           
            out = false; 
        }
    }
    
    return out; 
}

}


