package week4;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String userId;
    private String userName;

    List<Poker> cardList;

    public Player(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.cardList = new ArrayList<Poker>();
    }

    public Player() {

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
