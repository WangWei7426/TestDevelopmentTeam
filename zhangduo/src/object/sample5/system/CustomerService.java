package object.sample5.system;

public class CustomerService {

    public  Language contact(int areaCode){
        if(areaCode==86){
            return new Chinese();
        }else if (areaCode==33){
            return new French();
        }else{
            return new English();
        }
    }
    public static void main(String[] args) {
        Language language=new English();
        language.voice();
        Language language1=new Chinese();
        language.voice();
        CustomerService cs =new CustomerService();
      Language language2=cs.contact(33);
      language2.voice();

    }
}
