package thirdweek.game;

import java.util.*;

public class GameUser {
    protected int userid;
    protected String username;
    protected Set<PokerInfo> yourPoker;
    protected GameUser(int userid, String username){
        this.userid =userid;
        this.username =username;
        this.yourPoker = new HashSet<PokerInfo>();
    }



    protected PokerInfo getMaxPK(){
        pokers poker = new pokers();
        Iterator it = yourPoker.iterator();
        PokerInfo maxPK = (PokerInfo) it.next();
        while (it.hasNext()) {
            PokerInfo str = (PokerInfo) it.next();
            maxPK = poker.compareCard(maxPK,str);
        }
        return maxPK;
    }
}
