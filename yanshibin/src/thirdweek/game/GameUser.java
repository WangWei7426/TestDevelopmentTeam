package thirdweek.game;

import java.util.ArrayList;

public class GameUser {
    protected int userid;
    protected String username;
    protected ArrayList<PokerInfo> pokers;
    protected GameUser(int userid, String username){
        this.userid =userid;
        this.username =username;
        this.pokers = new ArrayList<>();
    }

}
