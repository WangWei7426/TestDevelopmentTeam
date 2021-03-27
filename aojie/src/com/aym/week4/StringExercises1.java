package com.aym.week4;

import java.util.*;

public class StringExercises1 {

    private Map <String,Player>plays = new HashMap<String,Player>();
    private List strList = new ArrayList();

    public static class Player implements Comparable<Player>{
        public String id;
        public String name;
        public List pokers;

        public Player(String id, String name) {
            this.id = id;
            this.name = name;
            this.pokers = new ArrayList();
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Player{");
            sb.append("id='").append(id).append('\'');
            sb.append(", name='").append(name).append('\'');
            sb.append('}');
            return sb.toString();
        }

        public  String maxPoker(String var1, String var2){
            String num = "2,3,4,5,6,7,8,9,10,J,Q,K,A";
            String color = "方块，梅花，红桃，黑桃";
            if (num.indexOf(var1.substring(2))>num.indexOf(var2.substring(2))){
                return var1;
            }else if(var1.substring(2).compareTo(var2.substring(2)) == 0){
                if(color.indexOf(var1.substring(0,2))>color.indexOf(var2.substring(0,2))){
                    return var1;
                }else{
                    return var2;
                }

            }else{
                return var2;
            }
        }

        @Override
        public int compareTo(Player player) {
            List strList1 = this.pokers;
            List strList2 = player.pokers;
            String maxpoker1 = this.maxPoker(strList1.get(0).toString(),strList1.get(1).toString());
            String maxpoker2 = this.maxPoker(strList2.get(0).toString(),strList2.get(1).toString());
            String result = this.maxPoker(maxpoker1,maxpoker2);
            if(result == maxpoker1){
                return 1;
            }else{
            return 0;
            }
        }
    }



    public void createPlayer(){
        System.out.println("-------创建玩家-------");
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while (i <2 ) {
            System.out.println("输入id:");
            String ID = scanner.next();
            System.out.println("输入name:");
            String name = scanner.next();
            Player player = this.plays.get(ID);
            if(player == null){
                Player newplayer = new Player(ID,name);
                this.plays.put(String.valueOf(i),newplayer);
                i++;
                System.out.println("欢迎玩家" + name);
            }else{
                System.out.println("该玩家已存在");
                String tmp = scanner.next();
                continue;
            }
        }
        System.out.println("-------创建玩家结束-------");
        System.out.println(this.plays.toString());

    }

    public void createPoker(){
        String[] ds = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        String[] hs = {"方块","梅花","红桃","黑桃"};
        System.out.println("---------创建扑克牌----------");
        for (String h : hs) {
            for (String d : ds) {
                this.strList.add(h+d);
            }
        }
        System.out.println(this.strList.toString());
        System.out.println("-------创建成功-------");
    }

    public void deal(){
        System.out.println("-------开始洗牌-------");
        Collections.shuffle(this.strList);
        System.out.println(this.strList.toString());
        System.out.println("-------洗牌结束-------");
        System.out.println("-------开始发牌-------");
        Player play1 = (Player) this.plays.get("0");
        Player play2 = (Player) this.plays.get("1");
        for (int i = 0; i < 4 ; i++) {
            if (i%2 == 0) {
                play1.pokers.add(this.strList.get(i));
                System.out.println(play1.name + "拿牌");
            } else {
                play2.pokers.add(this.strList.get(i));
                System.out.println(play2.name + "拿牌");
            }
        }
        System.out.println("-------发牌结束-------");
        System.out.println(play1.name + "的牌:" + play1.pokers.toString());
        System.out.println(play2.name + "的牌:" + play2.pokers.toString());
    }


    public static void main(String[] args) {
        StringExercises1 puck = new StringExercises1();
        puck.createPoker();
        puck.createPlayer();
        puck.deal();
        System.out.println(puck.plays.get("0").name + "手牌是： "  + puck.plays.get("0").pokers.toString());
        System.out.println(puck.plays.get("1").name + "手牌是： "  + puck.plays.get("1").pokers.toString());
        if(puck.plays.get("0").compareTo(puck.plays.get("1")) > 0){
            System.out.println(puck.plays.get("0").name + " is win");
        }
        else{
            System.out.println(puck.plays.get("0").name + " is win");
        }
   }
}
