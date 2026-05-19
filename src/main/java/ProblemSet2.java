import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ProblemSet2 {
	//welcome
	public static void main(String args[]) {
	Scanner input = new Scanner(System.in);
	System.err.println("Welcome to the Text Analyzer.");

	System.out.println("Please enter a sentence or paragraph: ");
	String inp = input.nextLine();
	//declear 
	int totalCharacters = inp.length();
	//int totalWords = 0;
	int totalVowels = 0;
	int totalSpaces = 0;

	//count vowels and spaces
	for (int i = 0; i < inp.length(); i++){
		char ch = Character.toLowerCase(inp.charAt(i));
		if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
			totalVowels++;
		}
		else if (ch == ' '){
			totalSpaces ++;
		}

	}

	// word count and splitting
	String[] owords;
	if (inp.trim().isEmpty()) {
		owords = new String[0];

	}
	else{
		owords = inp.trim().split(" ");
	}

	int totalWords = owords.length;

	//uniqque words 
	Map<String, Integer> WordMap = new LinkedHashMap<>();

	//words check 
	for (int i = 0; i < owords.length; i++) {
		String word2 = owords[i];

		String cleanwords = "";
		for (int q = 0; q < word2.length(); q++) {
			char ch = word2.charAt(q);
			if (Character.isLetter(ch)){
				cleanwords += ch;
			}
		}

	//irgone caps
	cleanwords = cleanwords.toLowerCase();
	 if (!cleanwords.isEmpty()) {
            WordMap.put(cleanwords, WordMap.getOrDefault(cleanwords, 0) + 1);	
	}
	}
	System.out.println("Total Characters: " + totalCharacters);
	System.out.println("Total words: "+ totalWords);
	System.out.println("Total Vowels: "+ totalVowels);
	System.out.println("Total Spaces: "+ totalSpaces);
	System.out.println("word frequency" + WordMap);
	
	}
}
