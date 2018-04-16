package chapter11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Gobang
{
	// 定义棋盘的大小
	private static int BOARD_SIZE =7;
	// 定义一个二维数组来充当棋盘
	private static int EDGE=4;
	private  String[][] board;
	private int color=0;
	public void initBoard(){
		board=new String[BOARD_SIZE][BOARD_SIZE];
		for(int i =0;i<BOARD_SIZE;i++){//列
			//打印x个+
			for(int j =0;j<BOARD_SIZE;j++){//行
				board[i][j]="十";//数组的内容在赋值之前需要先初始化，不然会报nullPoint错误
			}
		}
	}
	public void showBoard(){
		for(int i =0;i<BOARD_SIZE;i++){//列
			//打印x个+
			for(int j =0;j<BOARD_SIZE;j++){//行
				System.out.print(board[i][j]);//j从0~14打印不换行
			}
			System.out.println();//i 从0~14打印换行
		}
		System.out.println("____________________________________");
	}
	
	public Boolean paint(int i,int j ){
		Boolean flag=false;
		if(i>BOARD_SIZE||i<1||j>BOARD_SIZE||j<1){
			return false;
		}
		//怎么判断是写○还是写*？
		// color=0 下O,为用户方，=1 下第二个，为PC方；
		if(board[i-1][j-1].equals("十")){
			if(color==0){
				board[i-1][j-1]="●";
				color=1;
			}else if(color==1){
				board[i-1][j-1]="○";
				color=0;
			}
			flag=true;
		}
		return flag;
	}
	public int random(){
		return (int)Math.round(Math.random()*(BOARD_SIZE-1)+1);
	}
	//flag为true时,游戏结束
	public Boolean gameOver(int xpos,int ypos){
		Boolean flag=false;
		xpos=xpos-1;
		ypos=ypos-1;
		//横向查看
		int countx=1;
		for(int i=ypos+1;i<=BOARD_SIZE;i++){
			if(i<BOARD_SIZE&&board[xpos][i].equals(board[xpos][ypos])){
				countx=countx+1;
			}else{
				break;
			}
		}
		for(int i=ypos-1;i>=0;i--){
			if(i>=0&&board[xpos][i].equals(board[xpos][ypos])){
				countx=countx+1;
			}else{
				break;
			}
		}
		if(countx==5){
			flag=true;
			System.out.println("胜负已分");
			initBoard();
			return flag;
		}
		
		return flag;
	}
	
	
	public static void main(String []args) throws NumberFormatException, IOException{
		Gobang gb=new Gobang();
		System.out.println("—————————————————五子棋游戏—————————————————");
		System.out.println("请输入落子");
		gb.initBoard();
		Pattern p1=Pattern.compile("^\\d\\d?,\\d\\d?$");
		Pattern p2=Pattern.compile("^Y$");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		while ((inputStr = br.readLine()) != null)
		{
			Matcher m1 =p1.matcher(inputStr);
			if(!m1.matches()){
				System.out.println("请输入数字坐标，用,隔开");
				continue;
			}
			String[] posStrArr = inputStr.split(",");
			// 将2个字符串转换成用户下棋的座标
			int xPos = Integer.parseInt(posStrArr[0]);
			int yPos = Integer.parseInt(posStrArr[1]);
			if(gb.paint(xPos,yPos)){
				gb.showBoard();
				if(gb.gameOver(xPos,yPos)){
					System.out.println("想继续游戏请输入Y");
					inputStr = br.readLine();
					m1 =p2.matcher(inputStr);
					if(!m1.matches()){
						System.out.println("game over");
						break;
					}
				}
			}else{
				System.out.println("当前位置已有棋子，请重新落子");
				continue;
			}
			int xpos=0;
			int ypos=0;
			//默认画失败
			Boolean flag = false;
			while(!flag){//flag为错的时候，执行，一旦flag为true了，结束循环
				flag = gb.paint(xpos=gb.random(), ypos=gb.random());
			}
			gb.showBoard();
				if(gb.gameOver(xpos, ypos)){
					System.out.println("想继续游戏请输入Y");
					inputStr = br.readLine();
					p2=Pattern.compile("^Y$");
					m1 =p2.matcher(inputStr);
					if(!m1.matches()){
						System.out.println("game over");
						break;
						}
			}
		}
	}
}
