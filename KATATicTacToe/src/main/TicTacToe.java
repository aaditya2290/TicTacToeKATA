package main;

public class TicTacToe {

	int[][] board=new int[3][3];
	public static final int X = 1;
	public static final int O = -X;
	int currentValue = X;

	public String move(int i,int j)

	{
		board[i][j]=currentValue;
		return arrayToString(board);
	}

	public String arrayToString(int[][] boardArray)
	{
		String arrayString=new String("{");
		for (int i=0;i<3;i++)
		{
			arrayString+="{";
			for (int j=0;j<2;j++)
				arrayString+=""+boardArray[i][j]+",";
			if (i<2)
				arrayString+=""+boardArray[i][2]+"},";
			else
				arrayString+=""+boardArray[i][2]+"}";	
		}
		arrayString+="}";
		String returnString=arrayString.replaceAll("1", "X").replaceAll("-1", "O").replaceAll("0", "-");
		return returnString;

	}

}
