package object.sample1;

import com.imooc.object.sample2.PacketSemple02;

public class PacketSample03 {
    public static void main(String[] args) {
        //同一个包下的类无需import导入
        PacketSample01 packetSample01=new PacketSample01();
        PacketSemple02 packetSemple02=new PacketSemple02();
       // PacketSample03.name="lily";
        packetSample01.sayGoodbye();

        //packetSample01.sayHello();报错，并不允许在类之外访问
    }
}
