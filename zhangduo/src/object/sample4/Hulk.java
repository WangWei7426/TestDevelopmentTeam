package object.sample4;


    //extends关键字用于类的继承
    //extends关键字后面是父类，关键字前是子类
    //子类会继承父类的public、protected、public修饰的成员变量与方法
    //private描述的信息不会被继承
    public class Hulk extends Mark1{

        public static void main(String[] args) {
            Hulk hulk=new Hulk();
            hulk.color="红色";
            hulk.movie="复仇者联盟3";
             hulk.title ="反浩克装甲";
            hulk.description();
        }

    }

