package chapter6;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @param WEEK
 *            牌面数值
 * @param suit
 *            花色
 * @param poker[]
 *            扑克牌字符串数组
 */
class Stud {
	Locale myLocale = Locale.getDefault();
	ResourceBundle bundle=ResourceBundle.getBundle("mess",myLocale);
	public final static int CARD_NO = 52;
	public final static String WEEK = "A23456789TJQK";
	public final static String SUIT = "♠♥♦♣";

	/**
	 * 返回 {@code ArrayList}是初始化的牌面，
	 * 
	 * @return ArrayList 为初始化赋值的牌面
	 */
	public ArrayList<String> initPokerCard() {
		ArrayList<String> poker = new ArrayList<String>();
		for (int j = 0; j < SUIT.length(); j++) {
			for (int k = 0; k < WEEK.length(); k++) {
				poker.add(SUIT.substring(j, j + 1) + WEEK.substring(k, k + 1));
			}
		}
		return poker;
	}

	/**
	 * 返回 {@code ArrayList}是洗牌后的牌面结果， 给一个[0,52)的随机数,然后从给定的牌里面，按照随机数取出来，add给新牌面
	 * 并将旧牌面的该随机数的牌remove
	 * 
	 * @param pokercard
	 *            a {@code ArrayList} value.
	 * @return 将poker洗牌后的结果
	 */
	public ArrayList<String> shuffleCard(ArrayList<String> poker) {
		ArrayList<String> al = new ArrayList<String>();
		while (poker.size() > 0) {
			int randomNum = (int) Math.floor(Math.random() * (poker.size()));
			al.add(poker.get(randomNum));
			poker.remove(randomNum);
		}
		return al;
	}
	/**
	 * 返回 {@code String}发给玩家的手牌,并更新玩家手牌,将玩家手牌按照大小排序
	 * 
	 * @param poker
	 *            参数是用来发牌的公牌
	 * 
	 */
	public String handCard(ArrayList<String> poker, Player player) {
		String newCard =  poker.get(0);// 发过来的牌
		String handCard = player.getCard();// 本来的牌
		System.out.println(bundle.getString("new") + newCard + bundle.getString("handcard") + handCard);
		int newIndex = WEEK.indexOf(newCard.charAt(1));
		if (handCard.equals("")) {
			handCard = newCard;
			player.setCard(handCard);

			System.out.println(bundle.getString("handcard") + handCard);
			return handCard;
		} else {
			for (int i = 1; i < handCard.length(); i = i + 2) {
				if (newIndex <= WEEK.indexOf(handCard.charAt(i))) {
					handCard = handCard.substring(0, i - 1) + newCard + handCard.substring(i - 1, handCard.length());
					player.setCard(handCard);
					return handCard;
				} else if (newIndex > WEEK.indexOf(handCard.charAt(i)) && i == handCard.length() - 1) {
					handCard = handCard + newCard;
					player.setCard(handCard);
					return handCard;
				}
			}
		}
		return handCard;
	}

	/**
	 * {@code ArrayList}将第一张牌移除，返回剩余的牌面
	 * 
	 * @param poker
	 *            当前剩余公牌 模拟发牌
	 */
	public ArrayList<String> restCard(ArrayList<String> poker) {
		poker.remove(0);
		return poker;
	}

	/**
	 * 比牌
	 */
	public Player judge(HashMap<Integer,Player> player) {
		Player winner = (Player) player.get(0);
		// 遍历，如果第一个大，就将第一个和第N个的位置调换
		for (int i = 1; i < player.size(); i++) {
			Player next = (Player) player.get(i);
			// 比较两者，如果手牌next>winner ,返回true,反之，返回false
			if (compare(next.getCard(), winner.getCard())) {
				winner = next;
			}
		}
		return winner;
	}

	/**
	 * 默认值是false，如果a的牌更大，就将player置为b
	 * 
	 * @param 用来比较的牌
	 * @param 当前的winner的牌
	 * @return 前者比后者大，返回true，否则返回false
	 */
	public Boolean compare(String handCardA, String handCardB) {
		Boolean flag = false;
		// 先判断牌面level，再判断牌面大小
		int levelA = levelOfCard(handCardA);
		int levelB = levelOfCard(handCardB);
		if (levelA > levelB) {
			return true;
		} else if (levelA < levelB) {
			return false;
		} else if(levelA==levelB) {
			//同牌型比牌：
			switch (levelA) {
			// 同花顺
			case 1:
			// 金刚
			case 2:
			// 葫芦
			case 3:
			// 同花
			case 4:
			// 顺子
			case 5:
				//other
			}
		}
		return flag;
	}

	public int levelOfCard(String handCard) {
		int level = 0;
		String week = "";
		String suit="";
		if (handCard.length() > 10 || handCard.length() <= 0) {
			System.out.println(bundle.getString("error"));
			return -1;
		}
		int color = 1;
		// 判断同花的
		suit=handCard.replaceAll("\\w", "");
		for (int i = 1; i < suit.length();i ++) {
			char x = suit.charAt(i);
			char last = suit.charAt(i - 1);
			if (SUIT.indexOf(x) == SUIT.indexOf(last)) {
				color++;
			} else if (x != last) {
				break;
			}
		}
		// 判断顺子的
		week=handCard.replaceAll("\\W", "");
		// 判断同花顺，同花，顺子
		if (color == 5 && WEEK.contains(week)) {
			System.out.println("同花顺");
			return 1;
		} else if (color == 5 && (!WEEK.contains(week))) {
			System.out.println("同花");
			return 4;
		} else if (color != 5 && WEEK.contains(week)) {
			System.out.println("顺子");
			return 5;
		}
		// 判断同week出现的次数
		int countMax=1;
		int count=1;
		char maxchar=week.charAt(0);
		for(int i =1;i<week.length();i++){
			//计算count,将第一个count和char赋值给max
			if(week.charAt(i)==week.charAt(i-1)){
				count++;
			}else{
				count=1;
			}
			if(count>countMax){
				countMax=count;
				maxchar=week.charAt(i-1);
			}
		}
			if(countMax ==4){
				System.out.println("金刚");
				return 2;
			}else if(countMax ==3){
				String str = maxchar+"";
				String [] str2=week.split(str);
				str="";
				for(String s:str2){
					str=str+s;
				}
				if(getMaxCount(str)==2){
					System.out.println("葫芦");
					return 3;
				}else{
					System.out.println("三条");
					return 6;
				}
			}else if(countMax==2){
				String str = maxchar+"";
				String [] str2=week.split(str);
				str="";
				for(String s:str2){
					str=str+s;
				}
				if(getMaxCount(str)==2){
					System.out.println("两对");
					System.out.println("str:"+str);
					return 7;
				}else {
					System.out.println("一对");
					System.out.println("str:"+str);
					return 8;
				}
			}else if(countMax==1){
				System.out.println("散牌");
				return 9;
			}
		return level;
	}

	private int getMaxCount(String week) {
		int countMax=1;
		int count=1;
		for(int i =1;i<week.length();i++){
			if(week.charAt(i)==week.charAt(i-1)){
				count++;
			}else if(count>countMax){
				countMax=count;
				count=1;
			}else{
				count=1;
			}
		}
		return countMax;
	}
}

/**
 * @author zhizhiyin
 * @param name
 *            玩家名字；
 * @param position
 *            玩家位置；
 * @param fold
 *            是否弃牌，默认false不弃牌；
 * @param card
 *            玩家手牌
 */
class Player {
	private String name;
	private String card = "";
	private boolean fold = false;// 弃牌

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name.length() >= 1 && name.length() <= 4) {
			this.name = name;
			return;
		} else {
			System.out.println("name长度须在1~4之间");
		}
	}

	public boolean getFold() {
		return fold;
	}

	public void setFold(boolean fold) {
		this.fold = fold;
	}

	// 创建玩家，如果只需要五个玩家呢？怎么给这些玩家初始化呢？
	/**
	 * @param name
	 *            玩家的名字
	 * @param positioni
	 *            玩家的位置
	 */
	public Player(String name) {
		setName(name);
	}

	/**
	 * @param player
	 *            需要切换成弃牌状态的玩家
	 * @method turnFold(player)
	 *         如果用户未弃牌，置状态为弃牌，返回true，如果用户已经弃牌，置状态为false，表示转换失败，该用户已是弃牌状态
	 */
	public boolean turnFold() {
		if (this.getFold() == false) {
			this.setFold(true);
			System.out.println("弃牌啦");
			return true;
		} else {
			return false;
		}
	}
}

public class TestStud {
	public static void main(String[] args) {
		Locale currentLocale = null;
				if(args.length==2){
					//使用运行程序的两个参数构造Locale 实例
					currentLocale = new Locale(args[0],args[1]);
				}else{
					//否则使用系统默认的Locale
					currentLocale = Locale.getDefault();
				}
		ResourceBundle bundle=ResourceBundle.getBundle("mess",currentLocale);
		String message=bundle.getString("msg");
		System.out.println(MessageFormat.format(message, "user",new Date()));
		
		int playerNo = 5;
		Stud s = new Stud();
		ArrayList<String> poker = s.initPokerCard();
		poker = s.shuffleCard(poker);
		HashMap<Integer ,Player> player = new HashMap<Integer,Player>();
		for (int i = 0; i < playerNo; i++) {
			String name = bundle.getString("player") + i;
			player.put(i, new Player(name));
		}
		
		int flopNo = 1;// 轮次
		Boolean flag = false;

		while (!flag) {
			for (int i = 0; i < player.size(); i++) {
				Player currentPlayer = (Player) player.get(i);
				if (player.size() == 1) {
					System.out.println(bundle.getString("player") + currentPlayer.getName() + "，game over");
					flag = true;
					break;
				}
				s.handCard(poker, currentPlayer);
				poker = s.restCard(poker);
				System.out.println(bundle.getString("poker") + poker); // 跟弃
				System.out.println(currentPlayer.getName() + "的手牌：" + currentPlayer.getCard());
				System.out.println(bundle.getString("flop")+"?Y");
				Scanner input = new Scanner(System.in);
				String str = input.next();
				Pattern p1 =Pattern.compile("^Y$");
				Matcher m1 = p1.matcher(str);
				if (m1.matches()) { // 弃牌
					currentPlayer.turnFold();
					player.remove(i);
				}else{
					System.out.println(bundle.getString("player")+currentPlayer.getName()+" call");
				}
			}
			
			if (flopNo == 5) {
				System.out.println(bundle.getString("judge"));
				/*for(Object key :player.keySet()){
					Player p =(Player)player.get(key);
					System.out.println(p.getCard());
					System.out.println(s.levelOfCard(p.getCard()));
				}*/
				s.judge(player);
				flag = true;
				break;
			}
			flopNo = flopNo + 1;
		}

	}
}
