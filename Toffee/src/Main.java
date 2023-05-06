import java.util.*;
public class Main {
    public static void main(String[] args) {
        DataBase data = new DataBase() ;
        User user  = new User("Eslam" , "esla889900@gmail.com" , "01157228162" , "20211013") ;
        data.add_user(user);
        user = new User ("Eslam" , "esla889900@gmail.com" , "01157228162" , "20211012") ;
        data.add_user(user);
        //data.get_users_data();
        user = new User("Eslam" , "esla889900@gmail.com" , "01157228162" , "20211012") ;
        try {
            data.search_for_user(user);
            Cart cart = new Cart(user.get_id()) ;
            Product pro = new Product("12" , "Toffee" , "Caa" , "fsdsfsd" , 10.5) ;
            data.add_to_cart(user , pro);
            data.add_to_cart(user , pro);
            Order order = new Order(user.get_id() , "1" , user.get_name(), cart) ;
            data.add_order(user , order);
        }catch (NOT_EXIST_EXCEPTION ex) {
            System.out.print(ex);
        }
        //data.get_users_data();
        data.get_last_order(user);
    }
}