
public class Board {
public String[][] gameBoard;
public int col,row;


public Board(){
	col=3;
	row=3;
	
	gameBoard= new String [col][row];
	setBoard();
	
	
	
	
}

public void setBoard() {
	for (int i=0; i<col;i++) {
		for(int j=0; j<row; j++) {
			gameBoard[i][j]="-";
			System.out.print(gameBoard[i][j]);
		}
		System.out.println();
	}
		
}
public String getBoard(int c, int r) {
	return gameBoard[c][r];
	
}
	

public void changeSpot(int c, int r, String s) {
	gameBoard[c][r]=s;
}
			
}