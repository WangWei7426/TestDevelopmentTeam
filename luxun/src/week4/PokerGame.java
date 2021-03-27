package week4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 一、创建一副扑克牌
 * 包括
 * 四种花色：黑桃、红桃、梅花、方片
 * 十三种点数：2-10，J、Q、K、A，不考虑大小王
 * 二、创建两名玩家
 * 玩家只有要有ID、姓名、手牌等属性，手牌为扑克牌的集合
 * 三、洗牌
 * 将之前创建的"一副扑克牌"打乱顺序
 * 四、发牌
 * 将洗牌之后的扑克牌集合，从第一张开始，发给两名玩家，按照一人一张的方式，没人发两张
 * 五、游戏
 * 比较两名玩家手中的扑克牌，规则为：取两人各自手中点数最大的牌进行比较，点数大的赢；若两人各自的点数最大的牌相等，则再按花色比较。
 * 黑>红>梅>方
 */

public class PokerGame {
    String[] points = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    String[] types = {"黑桃", "红心", "梅花", "方片"};

    List<Poker> pokerList;
    List<Player> playerList;

    public PokerGame() {
        this.pokerList = new ArrayList<Poker>();
        this.playerList = new ArrayList<Player>();
    }

    private void createPocker() {
        System.out.println("开始初始化一副扑克牌");
        for (String pts : points) {
            for (String tps : types) {
                pokerList.add(new Poker(pts, tps));
            }
        }
        System.out.println("初始化成功： ");
        for (Poker poker : pokerList) {
            System.out.print(poker.toString() + " ");
        }
        System.out.println("");
    }

    private void flushPoker() {
        System.out.println("开始洗牌");
        Collections.shuffle(pokerList);
        for (Poker poker : pokerList) {
            System.out.print(poker.toString() + " ");
        }
        System.out.println("牌洗好了");
    }

    /**
     * @param pokerNums 每人发牌张数
     */
    private void pickPokers(Integer pokerNums) {
        if (pokerNums > 1 && pokerNums < 52) {
            System.out.println("开始发牌");
            for (int i = 0; i < pokerNums; i++) {

                for (Player p : playerList) {
                    p.cardList.add(pokerList.get(i));
                    System.out.println("玩家" + p.getUserName() + "拿到了" + pokerList.get(i));
                }
            }
            System.out.println("发牌结束");

        }

    }

    public String inputID() {
        System.out.println("请输入玩家ID");
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }

    public String inputName() {
        System.out.println("请输入玩家姓名");
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }

    /**
     * @param pNum 玩家数量
     */
    private void createPlayers(Integer pNum) {
        if (pNum > 0 && pNum < 52) {
            for (int i = 0; i < pNum; i++) {
                playerList.add(new Player(inputID(), inputName()));
            }
            String pn = "";
            for (Player player : playerList) {
                pn = pn + " " + player.getUserName();
            }
            System.out.println("----欢迎玩家 :" + pn);
        }
    }

    private void game() {
        System.out.println("开始游戏：");
        Poker luckyCard = new Poker("0", "方片");
        Player winner = new Player();
        for (Player p : playerList) {
            List<Poker> list = p.cardList;
            Collections.sort(p.cardList);
            System.out.println("玩家：" + p.getUserName() + " 拿到的牌（排序后的）：");
            System.out.println(p.cardList);
            Poker pr = list.get(list.size() - 1);
            if (luckyCard.compareTo(pr) < 0) {
                luckyCard = pr;
                winner = p;
            }
        }
        System.out.println("-----------玩家:" + winner.getUserName() + "获胜----------");
    }


    public static void main(String[] args) {
        PokerGame pg = new PokerGame();
        pg.createPocker();
        pg.flushPoker();
        pg.createPlayers(4);
        pg.pickPokers(3);
        pg.game();
    }
}
