Nicholas Schroeder (nis102)
Project 2

What Works:

As far as I can tell everything works! My AnagramDecoder output matches the output.txt file from Courseweb. The results are the same, but my AnagramDecoder output is in a different order than the output file on Courseweb.

StringTable.java:
	-My StringTable insert() and contains() methods function properly. 
	-I added a get() method that just returns a value at a specific index
	-int computeHash(String s) method does the hashing and then in insert() and contains() linear probing is handled.

AnagramDecoder.java:
	-Constructor reads dictionary text file into a StringTable called dictionary
	-boolean isWord(String s) uses contains method from StringTable to see if a word exists
	-void decode() uses getWords() and generateWordCombos() to solve the anagram
	-void getWords(String test, String remaining) recursive method to get all possible words from an anagram
	-void generateWordCombos(char[] letters, String result, String word) uses the results from getWords() to recursively generate combinations of words from an anagram
	-boolean wordFits(String letters, char[] word) checks if char[] word can be made from String letters.
	-char[] removeLetters(char[] letters,char[] word) removes all the characters in char[] word from char[] letters
	-boolean startsWith(String s) iterates through StringTable and checks if s is a prefix of any dictionary word 
	-main() drives the program. checks arguments and program usage and then calls decode on the anagram supplied in the arguments

Compiling:
	javac *.java 

Running:
	java AnagramDecoder <dictionary filename> ANAGRAM

	example: AnagramDecoder dictionary.txt wrongdoing