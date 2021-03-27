package object.sample7;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("查询最近天气预报:");
        System.out.println("输入1:查询未来24小时天气预报");
        System.out.println("输入2:查询未来3天天气预报");
        System.out.println("输入3:查询未来7天天气预报");
        System.out.println("请输入你的选择:");
        Scanner scanner=new Scanner(System.in);
        int i=scanner.nextInt();
        System.out.println("用户输入数字"+i);


    }
}
