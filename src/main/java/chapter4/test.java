package chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test
{
	// 定义棋盘的大小
	private static int BOARD_SIZE =7;
	// 定义一个二维数组来充当棋盘
	private static int EDGE=4;
	private static  String[][] board;
	private int color=0;
	public void initBoard(){
		board=new String[BOARD_SIZE][BOARD_SIZE];
		for(int i =0;i<BOARD_SIZE;i++){//列
			//打印x个+
			for(int j =0;j<BOARD_SIZE;j++){//行
				board[i][j]="+ ";//数组的内容在赋值之前需要先初始化，不然会报nullPoint错误
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
		if(board[i-1][j-1].equals("+ ")){
			if(color==0){
				board[i-1][j-1]="○ ";
				color=1;
			}else if(color==1){
				board[i-1][j-1]="Q ";
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
	public void paint( ){
		for(int j=0;j<BOARD_SIZE;j++){
			//遍历横向的数组，查看横向宿主的子元素是否是相连的目标字符
			
			System.out.println(board[j]);
		}
	}
	
	
	public static void main(String []args) throws NumberFormatException, IOException{
		test gb=new test();
		System.out.println("—————————————————五子棋游戏—————————————————");
		System.out.println("请输入1~"+BOARD_SIZE+"的数字");
		gb.initBoard();
		//get输入，用，分离
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine()：每当在键盘上输入一行内容按回车，用户刚输入的内容将被br读取到。
		while ((inputStr = br.readLine()) != null)
		{
			// 将用户输入的字符串以逗号（,）作为分隔符，分隔成2个字符串
			if(!inputStr.contains(",")){
				System.out.println("需要输入英文逗号哦，请重新输入~");
				continue;
			}
			String[] posStrArr = inputStr.split(",");
			// 将2个字符串转换成用户下棋的座标
			int xPos = Integer.parseInt(posStrArr[0]);
			int yPos = Integer.parseInt(posStrArr[1]);
			if(xPos<1||xPos>BOARD_SIZE||yPos<1||yPos>BOARD_SIZE){
				System.out.println("请输入1~"+BOARD_SIZE+"的数字");
				continue;
			}
			if(gb.paint(xPos,yPos)){
				gb.showBoard();
			}else{
				System.out.println("当前位置已有棋子，请重新落子");
				continue;
			}
			
			gb.paint();
			
			
		}
	}
}
