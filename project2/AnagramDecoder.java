//Nicholas Schroeder
//nis102

import java.io.*;
import java.util.*;

//AnagramDecoder class
public class AnagramDecoder{
	private StringTable dictionary;				//StringTable dictionary
	private ArrayList<String> possibleWords;	//list of possible words from given anagram
	private String anagram;						//anagram to be decoded

	/*****CONSTRUCTOR*****/
	public AnagramDecoder(File dictionaryFile, String anagram) throws Exception{
		this.anagram = anagram;
		this.dictionary = new StringTable();
		this.possibleWords = new ArrayList<String>();

		//load dictionary
		Scanner infile = new Scanner(dictionaryFile);
		
		while(infile.hasNext()){
			String next = infile.next();
			this.dictionary.insert(next);
		}
	}

	//method checks if string s is in the dictionary StringTable
	private boolean isWord(String s){
		return dictionary.contains(s);
	}

	//function that decodes the anagram using getWords() and generateWordCombos()
	private void decode(){		
		getWords("",anagram);
		
		for(String word : possibleWords)
			generateWordCombos(anagram.toCharArray(),"",word);
	}

	//recursive method that stores all possible words from an anagram into possibleWords.
	private void getWords(String test, String remaining){
		if(!startsWith(test))
			return;
		if(remaining.length() == 0);
			if(isWord(test))
				if(!possibleWords.contains(test))
					possibleWords.add(test);
		for(int i=0;i<remaining.length();i++)
			getWords(test+remaining.charAt(i),remaining.substring(0,i)+remaining.substring(i+1));
	}

	//recursive method that uses possibleWords and anagram letters to form word combinations of an anagram
	private void generateWordCombos(char[] letters, String result, String word){
		char[] nextLetters = removeLetters(letters,word.toCharArray());
		result += word+" ";

		if(nextLetters.length == 0)
			System.out.println(result);
	
		for(String w : possibleWords){
			if(!wordFits(String.valueOf(nextLetters),w.toCharArray()))
				continue;
			generateWordCombos(nextLetters,result,w);
		}
	}

	//checks if word can be made out of letters
	private boolean wordFits(String letters, char[] word){
		for(char c : word){
			if(letters.indexOf(c) == -1)
				return false;
			letters = letters.replaceFirst(Character.toString(c), ""); 
		}
		return true;
	}

	//removes all characters of word[] from letters[] 
	private char[] removeLetters(char[] letters,char[] word){
		char[] temp = new char[letters.length];
		int ix=0;
		for(char c : letters){
			temp[ix] = c;
			ix++;
		}
		char[] result = new char[(letters.length-word.length)];
		
		for(int i=0;i<letters.length;i++){
			for(int j=0;j<word.length;j++){
				if(word[j] == letters[i]){
					word[j]='\0';
					letters[i]='\0';
				}
			}
		}

		int index=0;
		for(int k=0;k<letters.length;k++){
			if(letters[k]!='\0'){
				result[index] = letters[k];
				index++;
			}
		}

		for(int l=0;l<temp.length;l++)
			letters[l] = temp[l];

		return result;
	}

	//checks if there's a word in dictionary that starts with String s
	private boolean startsWith(String s){
		String str = "";
		for(int i=0;i<dictionary.TABLE_SIZE;i++){
			str = dictionary.get(i);
			if(str != null)
				if(str.startsWith(s))
					return true;
		}
		return false;
	}

	//main
	public static void main(String[] args) throws Exception{
		//check args
		if(args.length!=2){
			System.out.println("Usage: ");
			System.out.println("\tjava AnagramDecoder <dictionary file> ANAGRAM");

			System.exit(0);
		}

		File dictionaryFile = new File(args[0]);

		//make sure file exists
		if(!dictionaryFile.exists()){
			System.out.println("File not found.");
			System.exit(0);
		}

		//create a decoder object
		AnagramDecoder decoder = new AnagramDecoder(dictionaryFile, args[1]);

		//decode the anagram
		decoder.decode();
	}
}