package chapter11;

import java.awt.Frame;
import java.util.Random;

public class TestAwt{
	private final int TABLE_WIDTH=300;
	private final int TABLE_HEIGHT=400;
	//球拍的垂直位置
	private final int RACKET_Y = 340;
	
	private final int RACKET_HEIGHT=20;
	private final int RACKET_WIDTH=60;
	
	private final int BALL_SIZE = 16;
	
	private Frame f = new Frame("弹球游戏");
	
	Random rand = new Random();
	//小球纵向运行速度
	private int ySpeed = 10;
	//-0.5~0.5的比率，控制小球运行方向
	private double xyRate = rand.nextDouble()-0.5;
	private int xSpeed =(int )(ySpeed*xyRate*2);
	public void init(){
	}
	public static void main(String[]args){
		new TestAwt().init();
	}
}