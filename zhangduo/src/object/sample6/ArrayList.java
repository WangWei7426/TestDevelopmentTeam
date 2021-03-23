package object.sample6;

import java.util.List;


public class ArrayList {
    public static void main(String[] args) {
       // List<String> bookList;
    //  bookList = (List) new ArrayList();
        List<String> bookList=new java.util.ArrayList<>();
        bookList.add("红楼梦");
        bookList.add("西游记");
        bookList.add("水浒传");
        bookList.add("三国志");
       // bookList.add(index:0,element"jinghuayuan");
        System.out.println(bookList);
        int size=bookList.size();
        System.out.println(size);
        String remove = bookList.remove(bookList.indexOf(2));
        bookList.remove(bookList.size() - 1 );
        for (String book:bookList){
            System.out.println("<"+book+">");
        }
    }
}
