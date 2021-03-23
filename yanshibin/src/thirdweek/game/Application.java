package thirdweek.game;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    //输入ID和姓名
    ArrayList<GameUser> userinfos = new ArrayList<>();

    private Application(){
        this.userinfos = new ArrayList<GameUser>();
    }

    private void login(){
        System.out.println("扑克牌游戏即将开始！！");
        while (true) {
            int userid;
            try {System.out.print("请输入玩家ID(数字)：");
                Scanner sc = new Scanner(System.in);
                userid = sc.nextInt();
            } catch (Exception e) {
                System.out.println("ID格式不正确，请输入纯数字ID");
                continue;
            }
            System.out.print("请输入玩家姓名：");
            Scanner sc2 = new Scanner(System.in);
            String username = sc2.next();
            GameUser uf = new GameUser(userid, username);
            userinfos.add(uf);
            break;
        }
        System.out.println("+++++++当前系统录入玩家如下：");
        for (GameUser usif:userinfos) {
            System.out.println(usif.userid+usif.username);
        }

    }



    public static void main(String[] args){
        Application app = new Application();
        System.out.println("扑克牌游戏即将开始！！");
        System.out.println("********开始输入玩家1的信息********");
        app.login();
        System.out.println("********开始输入玩家2的信息********");
        app.login();
        System.out.println("***************************************");
        System.out.println("+++++游戏开始开始发牌：");
        pokers pokers = new pokers();
        pokers.createCard();
        PokerInfo aa = pokers.getcard();
        System.out.println("玩家1："+aa.color+aa.value);
        PokerInfo bb = pokers.getcard();
        System.out.println("玩家2："+bb.color+bb.value);

        System.out.println("***************************************");
        System.out.println("+++++结果判定：");
        Boolean compare =pokers.compareCard(aa,bb);
        System.out.println("结果为"+compare);


//
//        GameUser gu = (GameUser) userinfos.get(0);
//        System.out.println(gu.userid+gu.username);

    }


}
