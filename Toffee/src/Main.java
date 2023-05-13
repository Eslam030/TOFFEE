import java.util.*;
public class Main {
    static DataBase data = new DataBase() ;
    static Customer currenCustomer = new Customer();
    
    public static boolean isValidEmailAddress(String email) {
        if (email == null || email.length() == 0) {
            return false;
        }
        int atIndex = email.indexOf("@");
        if (atIndex < 1) {
            return false;
        }
        String beforaAT = email.substring(0, atIndex);
        String afterAT = email.substring(atIndex + 1);
        if (beforaAT.length() == 0 || beforaAT.endsWith(".") || beforaAT.startsWith(".")) {
            return false;
        }
        if (afterAT.length() == 0 || afterAT.endsWith(".") || afterAT.startsWith(".")) {
            return false;
        }
        String[] afterATParts = afterAT.split("\\.");
        if (afterATParts.length < 2) {
            return false;
        }
        for (String part : afterATParts) {
            if (part.length() == 0) {
                return false;
            }
        }
        return true;
    }
    
    static Customer Login(){
        Customer c = new Customer();
        Integer id;
        // Scanner sc = new Scanner(System.in);
        Scanner myObj = new Scanner(System.in);
        while (true) {
            System.out.println("Enter Your ID: ");
            String a1 = myObj.nextLine();
            id = Integer.parseInt(a1);
            System.out.println("Enter Your Password: ");
            String a2 = myObj.nextLine();
            if (data.checkLogin(id, a2)) {
                break;
            }else{
                System.out.println("there must be something Wrong in Your id or Password!");
            }
        }
        c = data.rCustomer(id);
        return c;
    }
    
    static void signUP(){
        Scanner sc = new Scanner(System.in);
        // String name , String Email , String phone , Integer id, String password
        System.out.println("Enter Your Name: ");
        String name = sc.nextLine();
        String Email = "";
        while (true) {
            System.out.println("Enter Your Email: ");
            Email = sc.nextLine();
            if (isValidEmailAddress(Email)) {
                break;
            }
        }
        System.out.println("Enter Your phone: ");
        String phone = sc.nextLine();
        System.out.println("Enter Your password: ");
        String password = sc.nextLine();
        data.addCustomer(name, Email, phone, data.customersNumber()+1, password);
    }

    static boolean StartupMenu(){
        boolean f = false;
        Scanner sc = new Scanner(System.in);    
        System.out.println("Welcome to Our Shop TOFFE ");
        System.out.println("please Enter a choice: \n1-Login \n2-Sign-In\n3-continuo as guest");
        int a = sc.nextInt(); 
        if (a == 1) {
           currenCustomer = Login();
            f = true;
        } else if (a == 2) {
            signUP();
            f = true;
        }
        return f;
    }
 
    public static void main(String[] args) {

        boolean UserSignupLogin = false;
        Category x = new Category("Chocolate");
        Scanner sc = new Scanner(System.in); 
        data.add_product(data.productsNumber()+1,"GalaxyWhite","Galaxy",20.5,x,false);
        data.addCustomer("Mina", "Mena@gmail.com", "0114040", data.customersNumber()+1, "asd");
        StartupMenu();

        while(true){
            data.DisplayAllProducts();
            System.out.println("\nplease Enter a choice: \n1-add product to Cart \n2-Make an order \n3-Search for a product\n=> ");
            int a2 = sc.nextInt();
            if (a2 == 1) {
                while (!UserSignupLogin) {
                    System.out.println("\nSorry to do that You need to log-in or sign up.");
                    System.out.println("\nDo you Want to Sign-up Or Login (Enter 1 for yes 2 for no)? \n=> ");
                    int ch = sc.nextInt();
                    if (ch == 1) {
                        UserSignupLogin = StartupMenu();
                    }else{
                        break;
                    }
                }
                if (UserSignupLogin) {
                    currenCustomer.DisplayCustomer();
                    System.out.println("\nEnter Product ID: \n=> ");
                    int PID = sc.nextInt();
                    Product p = new Product();
                    p = data.rProduct(PID);
                    currenCustomer.AddProductToCart(p);
                }

            } else if (a2 == 2) {
                if (UserSignupLogin) {
                    //check if the current list of order in that user is empty or not
                    if (currenCustomer.getOrders().get(currenCustomer.Numoforders()).ProductsInOrder().isEmpty()) {
                        System.out.println("\nSorry your order list is empty please add some products.");
                    }else{
                        //to do make the user buy or choose the payment method
                    }
                }
            } else if (a2 == 3) {
                System.out.println("\nWhat do you Want to search BY?\nn1-Id \n2-Name \n3-Brand \n4-Category \n => ");
                int ch = sc.nextInt();
                    if (ch == 1) {
                        Integer id;
                        System.out.print("Please enter an Valid Id: ");
                        String a1 = sc.nextLine();
                        id = Integer.parseInt(a1);
                        data.searchForProduct(id);
                    }else if(ch == 2){
                        System.out.print("Please enter an Valid Name: ");
                        String a1 = sc.nextLine();
                        data.searchForProduct(a1);
                    }else if(ch == 3){
                        System.out.print("Please enter an Valid Brand: ");
                        String a1 = sc.nextLine();
                        data.searchForProduct(a1);
                    }else{
                        System.out.print("Please enter an Valid Brand: ");
                        String a1 = sc.nextLine();
                        data.searchForProductByCategory(a1);
                    }
            }
            break;
        }
        // User user  = new User("Eslam" , "esla889900@gmail.com" , "01157228162" , 20211013, "mmm") ;
        // data.add_user(user);
        // user = new User ("Eslam" , "esla889900@gmail.com" , "01157228162" , 20211012,"nnn") ;
        // data.add_user(user);
        // //data.get_users_data();
        // user = new User("Eslam" , "esla889900@gmail.com" , "01157228162" , 20211014,"lll") ;
//        try {
//            data.search_for_user(user);
//            Product pro = new Product(12 , "Toffee" , "Caa" , "fsdsfsd" , 10.5) ;
//            data.add_to_cart(user , pro);
//            data.add_to_cart(user , pro);
//            Order order = new Order(user.get_id() , 1 , user.get_name()) ;
//            data.add_order(user , order);
//        }catch (NOT_EXIST_EXCEPTION ex) {
//            System.out.println(ex);
//        }
        //data.get_users_data();
//        data.get_last_order(user);
//        try {
//            data.search_for_user("Eslam") ;
//        }catch (NOT_EXIST_EXCEPTION ex){
//            System.out.println(ex);
//        }
//        try {
//            data.search_for_user(20211012) ;
//        }catch (NOT_EXIST_EXCEPTION ex){
//            System.out.println(ex);
//        }
//        try {
//            data.search_for_user(user) ;
//        }catch (NOT_EXIST_EXCEPTION ex){
//            System.out.println(ex);
//        }
        // data.delete_user(user);
        // data.get_users_data();
    }
}