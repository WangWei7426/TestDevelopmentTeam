package thirdweek.game;

import java.util.*;

public class Application {
    //输入ID和姓名
    ArrayList<GameUser> userinfos = new ArrayList<>();

    private Application(){
        this.userinfos = new ArrayList<GameUser>();
    }

    private void login(){
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
            System.out.println(usif.userid+" "+usif.username);
        }
    }


    private void fapai(){
        pokers pokers = new pokers();
        pokers.createCard();
        for (int i = 1; i < 6; i++) {
            System.out.println("++++第"+i+"轮发牌：");
            for (GameUser usif:userinfos) {
                PokerInfo card = pokers.getcard();
                System.out.println(usif.username+"(ID:"+usif.userid+")获得："+card.color+card.value);
                usif.yourPoker.add(card);
                }
            }
        System.out.println("************发牌结束************");
        for (GameUser usif:userinfos) {
            System.out.println(usif.username+"手中牌如下：");
            Iterator it = usif.yourPoker.iterator();
            while (it.hasNext()) {
                PokerInfo str = (PokerInfo) it.next();
                System.out.println(str.color + str.value);
            }
        }
    }


    private void getMaxPK() {
        pokers pokers = new pokers();
        Map<PokerInfo,String> maxs = new HashMap();
        for (GameUser usif : userinfos) {
            System.out.print(usif.username + "手中最大的牌为：");
            PokerInfo max = usif.getMaxPK();
            System.out.println(max.color+max.value);
            maxs.put(max,usif.username);
        }

        Iterator<Map.Entry<PokerInfo, String>> it = maxs.entrySet().iterator();
        PokerInfo wincard = it.next().getKey();
        while (it.hasNext()) {
            Map.Entry<PokerInfo, String> entry = it.next();
            wincard = pokers.compareCard(wincard,entry.getKey());
        }
        maxs.get(wincard);
        System.out.println("++++++++++最终结果：");
        System.out.println("获胜的是玩家"+maxs.get(wincard)+",最大牌为"+wincard.color+wincard.value);

    }


    public static void main(String[] args){
        Application app = new Application();
        System.out.println("扑克牌游戏即将开始！！");
        System.out.print("请输入参与游戏的人数（1≤人数≤10）:");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 1; i < num+1; i++) {
            System.out.println("********开始输入第"+i+"个玩家的信息********");
            app.login();
        }
        System.out.println("***************************************");
        System.out.println("游戏规则为：先判断点数（2最小，A最大），点数相同则判断花色（从大到小为：黑红梅方）");
        System.out.println("***************************************");
        System.out.println("++++++++++游戏开始开始发牌：");
        app.fapai();
        System.out.println("***************************************");
        System.out.println("++++++++++结果判定：");
        app.getMaxPK();
    }


}
