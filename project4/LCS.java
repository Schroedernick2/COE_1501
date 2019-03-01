//Nicholas Schroeder
//11.20.2018
//Project 4 - CS 1501

public class LCS{
	public static String findLCS(String w1, String w2){
		String LCS = "";

		int[][] memo = new int[w1.length()+1][w2.length()+1];

		for(int i=0;i<w1.length()+1;i++){
			for(int j=0;j<w2.length()+1;j++){
				memo[i][j] = 0;
			}
		}

		for(int i=1;i<w1.length()+1;i++){
			for(int j=1;j<w2.length()+1;j++){
				if(w1.charAt(i-1) == w2.charAt(j-1))
					memo[i][j] = memo[i-1][j-1]+1;
				else{
					if(memo[i][j-1] >= memo[i-1][j])
						memo[i][j] = memo[i][j-1];
					else
						memo[i][j] = memo[i-1][j];
				}
			}
		}

		int i=w1.length();
		int j=w2.length();

		while(i>0 && j>0){
			if(memo[i][j]==memo[i-1][j])
				i--;
			else if(memo[i][j]==memo[i][j-1])
				j--;
			else{
				LCS = w1.charAt(i-1)+LCS;
				i--;
				j--;
			}
		}

		return LCS;
	}
}
