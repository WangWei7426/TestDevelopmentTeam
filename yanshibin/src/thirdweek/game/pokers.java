package thirdweek.game;

import java.util.ArrayList;
import java.util.Random;

public class pokers {



    ArrayList<PokerInfo> cards = new ArrayList<>();
    protected pokers() {
        this.cards = new ArrayList<PokerInfo>();
    }

    protected void testadd(){
        PokerInfo pk = new PokerInfo("梅花","10");
        cards.add(pk);
        PokerInfo pk2 = new PokerInfo("黑桃","10");
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


        Boolean compare =pokers.compareCard(bb,cc);
        System.out.println("结果为"+compare);

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
        System.out.println(cards.size());
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
    protected boolean compareCard(PokerInfo card1, PokerInfo card2){
        Boolean bool = null;
        String[] definesize= new String[]{"黑桃","红桃","梅花","方块"}; //相同时，按黑红梅方的花色判断大小
        int result = card1.value.compareTo(card2.value);

        if (result>0){bool = true;}
        else if (result==0) {
            System.out.println("111111:"+result);
            int xiabiao1 = 0;
            int xiabiao2 = 0;
            for (int i = 0; i < definesize.length; i++) {
                if (definesize[i] == card1.color) {
                    xiabiao1 = i;
                }
                if (definesize[i] == card2.color) {
                    xiabiao2 = i;
                }
            }
            System.out.println("xiabiao1:" + xiabiao1);
            System.out.println("xiabiao2:" + xiabiao2);
            if (xiabiao1 < xiabiao2){bool = true;}else {bool = false;}
        }else {bool = false;}
        return bool;
    }

}
