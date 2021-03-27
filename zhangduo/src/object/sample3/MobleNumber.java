package object.sample3;

public class MobleNumber {
    //成员变量私有化
    private String ower;//所有者
    private String areasCode="86";//国家区号
    private long mobileNumber;//手机号

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    //getter方法，getter方法用于读取成员变量的内容
    //getter书写格式:成员变量类型，get成员变量名(),首字母大写
    public  String getOwer(){
        //this关键字代表当前对象的...
        return this.ower;
    }
    //setter方法，setter方法用于设置成员变量内容
    //setter书写格式，public void set成员变量名(新的数据参数)
    public void setOwer(String ower){
        this.ower=ower;
    }
}
