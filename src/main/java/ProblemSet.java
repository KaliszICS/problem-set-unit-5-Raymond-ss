/**
    * File: Problem set 5:
    * Author: Raymond
    * Date Created: March 29, 2026
    * Date Last Modified: May 19, 2026
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ProblemSet {
	public static void main(String args[]) {

	Scanner input = new Scanner(System.in);
	//welcome
	System.out.println("Welcome to the Text Analyzer.");

	System.out.println("Please enter a sentence or paragraph: ");
	String inp = input.nextLine();

	//declearing variables and adding common filler words
    ArrayList<String> stopWords = new ArrayList<>();
    stopWords.add ("the");
    stopWords.add ("a");
    stopWords.add ("an");
    stopWords.add ("and");
    stopWords.add ("is");
    
    //declare variable
	int totalCharacters = inp.length();
	//int totalWords = 0; 
	int totalVowels = 0;
	int totalSpaces = 0;

	//checking for vowels and spaces
	for (int i = 0; i < inp.length(); i++){
		char ch = Character.toLowerCase(inp.charAt(i));
		if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
			totalVowels++;
		}
		else if (ch == ' '){
			totalSpaces ++;
		}

	}

	// word/characters count and splitting out words 
	String[] oriWords;
	if (inp.trim().isEmpty()) {
		oriWords = new String[0];
    }
	else{
		oriWords = inp.trim().split(" ");
	}
	int totalWords = oriWords.length;

	//unique words map
	HashMap<String, Integer> wordMap = new HashMap<>();

	//checking for only words
	for (int i = 0; i < oriWords.length; i++) {
		String word2 = oriWords[i];

        //cleaning puncttuation
		String cleanwords = "";
		for (int q = 0; q < word2.length(); q++) {
			char ch = word2.charAt(q);
			if (Character.isLetter(ch)){ // filtter words
				cleanwords += ch;
			}
		}

	//ignore lower and caps
	cleanwords = cleanwords.toLowerCase();

    //check for word is empty and if contains filler words and filters it out
	 if (!cleanwords.isEmpty() && !stopWords.contains(cleanwords)) {
        if (wordMap.containsKey(cleanwords)){
            wordMap.put(cleanwords, wordMap.get(cleanwords)+1);
        }
        else {
            wordMap.put(cleanwords, 1);
        }
	}
	}
	//printing out final values
	System.out.println("Total Characters: " + totalCharacters);
	System.out.println("Total words: "+ totalWords);
	System.out.println("Total Vowels: "+ totalVowels);
	System.out.println("Total Spaces: "+ totalSpaces);
	System.out.println("word frequency\n" + wordMap);

	}
	
}

