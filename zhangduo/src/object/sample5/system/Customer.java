package object.sample5.system;

public class Customer {
    public static void main(String[] args) {
        CustomerService customerService=new CustomerService();
        Language language;
        language = customerService.contact(66);
        language.voice();
    }

}
