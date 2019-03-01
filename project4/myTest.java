//////////////////////////////////////////////////////////////////////
///
/// Contents: Test LCS program.
/// Author:   John Aronis (modified by Nicholas Schroeder 11.20.2018)
/// Date:     April 2013
///
//////////////////////////////////////////////////////////////////////

public class myTest {
	public static void main(String[] args){
		//first given test
		String word1, word2;
		word1 = "axxbyyycz";
		word2 = "1a2b333c44444";
		System.out.print("LCS of " + word1 + " and " + word2 + ": ");
		System.out.println( LCS.findLCS(word1,word2));

		//test given in project description
		String next1, next2;
		next1 = "haedlelfog";
		next2 = "abchxeylzloabc";
		System.out.print("\nLCS of " + next1 + " and " + next2 + ": ");
		System.out.println( LCS.findLCS(next1,next2));

		//test with strings >= 100
		String long1, long2;
		long1 = "axxbyyyczaxxbyyyczaxxbyyyczaxxbyyyczaxxbyyyczaxxbyyyczaxxbyyyczaxxbyyyczaxxbyyyczaxxbyyyczaxxbyyycz";
		long2 = "1a2b333c444441a2b333c444441a2b333c444441a2b333c444441a2b333c444441a2b333c444441a2b333c444441a2b333c44444";
		System.out.print("\nLCS of " + long1 + " and " + long2 + ": ");
		System.out.println( LCS.findLCS(long1,long2));
	}

}

/// End-of-File

