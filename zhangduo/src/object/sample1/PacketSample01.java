package object.sample1;

public class PacketSample01 {//
    //public代表其他任何类都能访问的成员变量
    public String name;
    //private 代表只能在当前类中使用
    private void sayHello(){
       System.out.println("Hello word");
    }
    //不写访问修饰符，代表是默认修饰符，表示只能被包中其它类访问
    void sayGoodbye(){
        System.out.println("Good bye");
    }

    public static void main(String[] args) {
        PacketSample01 packetSample01=new PacketSample01();
        packetSample01.sayHello();
    }
}
