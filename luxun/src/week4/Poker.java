package week4;

/**
 * 扑克牌
 */
public class Poker implements Comparable<Poker> {
    private String point;
    private String type;

    public Poker(String point, String type) {
        this.point = point;
        this.type = type;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPointsValue(String points) {
        switch (points) {
            case "A":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "10":
                return 10;
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
        }
        return -1;
    }

    public Integer getTypeValue(String type) {
        switch (type) {
            case "黑桃":
                return 1;
            case "红心":
                return 2;
            case "梅花":
                return 3;
            case "方片":
                return 4;
        }
        return -1;
    }


    @Override
    public int compareTo(Poker o) {
        int num = getPointsValue(this.point).compareTo(getPointsValue(o.point));
        if (num == 0) {
            return getTypeValue(this.type).compareTo(getTypeValue(o.type));
        }
        return num;
    }

    @Override
    public String toString() {
        return type+point;
    }

}
