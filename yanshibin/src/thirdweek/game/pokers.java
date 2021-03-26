package thirdweek.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class pokers {



    ArrayList<PokerInfo> cards = new ArrayList<>();
    protected pokers() {
        this.cards = new ArrayList<PokerInfo>();
    }

    protected void testadd(){
//        PokerInfo pk = new PokerInfo("黑桃","10");
        PokerInfo pk = new PokerInfo("方块","10");
        cards.add(pk);
        PokerInfo pk2 = new PokerInfo("梅花","10");
        cards.add(pk2);
//        PokerInfo cd = (PokerInfo) cards.get(0);
//
//        System.out.println(cd.color+cd.value);

//        for (PokerInfo poker: allpokers) {
//            System.out.println(poker.color);
//        }
    }

    public static void main(String[] args) {
        pokers pokers = new pokers();
        pokers.testadd();
//        pokers.createCard();
        PokerInfo bb = pokers.getcard();
        System.out.println("玩家1："+bb.color+bb.value);
        PokerInfo cc = pokers.getcard();
        System.out.println("玩家2："+cc.color+cc.value);


        PokerInfo compare =pokers.compareCard(bb,cc);
        System.out.println("结果为:"+compare.color+compare.value);

//        String test1="K";
//        String test2="J";
//        if (test1.compareTo(test2)>0){
//            System.out.println(test1);
//        }else {
//            System.out.println(test2);
//        }

//        pokers.compareCard(bb,cc);

//        PokerInfo cd = (PokerInfo) cards.get(0);

    }


    //生成扑克牌
    protected void createCard(){
        String[] value = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String[] cardColor = {"黑桃","方块","红桃","梅花"};
        for(int i=0;i<cardColor.length;i++){
            for(int j=0;j<value.length;j++){
                PokerInfo pk = new PokerInfo(cardColor[i],value[j]);
                cards.add(pk);
            }
        }
//        System.out.println(cards.size());
    }


   //随机发牌，发完删除
    protected PokerInfo getcard(){
        Random random = new Random();
        int aa = random.nextInt(cards.size());
        PokerInfo cd = (PokerInfo) cards.get(aa);
//        System.out.println(cd.color+cd.value);
        cards.remove(aa);
        return cd;
    }


    //比较两张牌的大小
    protected PokerInfo compareCard(PokerInfo card1, PokerInfo card2){
        //定义花色和数字的大小，从小到大排列
//        ArrayList<String> definecolor = new ArrayList<>(){{add("黑桃");add("红桃");add("梅花");add("方块");}};
        List<String> definecolor = Arrays.asList("方块","梅花","红桃","黑桃");
        List<String> definevalue = Arrays.asList("2","3","4","5","6","7","8","9","10","J","Q","K","A");

        int card1_index = definevalue.indexOf(card1.value);
        int card2_index = definevalue.indexOf(card2.value);
//        if (card1_index<0 ||card2_index<0){}
        if (card1_index > card2_index) {return card1;}
        else if (card1_index == card2_index) {
            if (definecolor.indexOf(card1.color) > definecolor.indexOf(card2.color)){
                return card1;
            }else{return card2;}
        }else {return card2;}
    }
}
