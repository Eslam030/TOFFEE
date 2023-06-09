import java.util.*;
public class Main {
    public static void main(String[] args) {

        system toffeeSystem = new system() ;
        DataBase data = toffeeSystem.getDataBase() ;
        Customer current = toffeeSystem.getCurrenCustomer() ;
        boolean UserSignupLogin = false;
        Category x = new Category("Chocolate");
        Scanner sc = new Scanner(System.in); 
        data.add_product(data.productsNumber()+1,"GalaxyWhite","Galaxy",20.5,x,false);
        while (!toffeeSystem.checkLogged()){
            toffeeSystem.StartupMenu() ;
            UserSignupLogin = toffeeSystem.checkLogged();
        }
        // done login and signup
        while(true){
            data.DisplayAllProducts();
            current = toffeeSystem.getCurrenCustomer() ;
            System.out.println("\nplease Enter a choice: \n1-add product to Cart \n2-Make an order \n3-Search for a product\n=> ");
            sc = new Scanner(System.in) ;
            int a2 = sc.nextInt();
            if (a2 == 1) {
                while (!UserSignupLogin) {
                    System.out.println("\nSorry to do that You need to log-in or sign up.");
                    System.out.println("\nDo you Want to Sign-up Or Login (Enter 1 for yes 2 for no)? \n=> ");
                    int ch = sc.nextInt();
                    if (ch == 1) {
                        while (!toffeeSystem.checkLogged()){
                            toffeeSystem.StartupMenu();
                            UserSignupLogin = toffeeSystem.checkLogged();
                        }
                    }else{
                        break;
                    }
                }
                if (UserSignupLogin) {
                    current.DisplayCustomer();
                    System.out.println("\nEnter Product ID: \n=> ");
                    sc = new Scanner(System.in) ;
                    int PID = sc.nextInt();
                    Product p = new Product();
                    p = data.rProduct(PID);
                    if (p.getName() != null){
                        current.AddProductToCart(p);
                    }else {
                        System.out.println("Doesn't exist a product with this id");
                    }
                }

            } else if (a2 == 2) {
                if (UserSignupLogin) {
                    //check if the current list of order in that user is empty or not
                    if (current.returnCart().isEmpty()) {
                        System.out.println("\nSorry your order list is empty please add some products.");
                    }else{
                        //to do make the user buy or choose the payment method
                        System.out.println("Enter Your address clearly please");
                        sc = new Scanner(System.in) ;
                        String address = sc.nextLine() ;
                        System.out.println("Enter the payment method you want\n1- payment on delivery\n2- online payment using " +
                                "paypal , visa , etc ....");
                        sc = new Scanner(System.in) ;
                        int choice = sc.nextInt() ;
                        String method ;
                        while (true) {
                            if (choice == 1){
                                method = "payment on delivery" ;
                                break;
                            }else if (choice == 2) {
                                method = "online" ;
                                break;
                            }else {
                                System.out.println("Wrong choice");
                                System.out.println("Enter the payment method you want\n1- payment of delivery\n2- online payment using " +
                                        "paypal , visa , etc ....");
                                sc = new Scanner(System.in) ;
                                choice = sc.nextInt() ;
                            }
                        }
                        current.addProductSFromCartToOrder();
                        current.addAddress(address);
                        current.addPaymentMethod(method);
                        current.orderFinished();
                        current.clearCart();
                    }
                }else {
                    System.out.println("\nSorry to do that You need to log-in or sign up.");
                    System.out.println("\nDo you Want to Sign-up Or Login (Enter 1 for yes 2 for no)? \n=> ");
                    sc = new Scanner(System.in) ;
                    int ch = sc.nextInt();
                    if (ch == 1) {
                        while (!toffeeSystem.checkLogged()){
                            toffeeSystem.StartupMenu() ;
                            UserSignupLogin = toffeeSystem.checkLogged();
                        }
                    }
                }
            } else if (a2 == 3) {
                System.out.println("\nWhat do you Want to search BY?\n1-Id \n2-Name \n3-Brand \n4-Category \n => ");
                int ch = sc.nextInt();
                if (ch == 1) {
                    Integer id;
                    System.out.print("Please enter an Valid Id: ");
                    sc = new Scanner(System.in);
                    String a1 = sc.nextLine();
                    id = Integer.parseInt(a1);
                    data.searchForProduct(id);
                } else if (ch == 2) {
                    System.out.print("Please enter an Valid Name: ");
                    sc = new Scanner(System.in);
                    String a1 = sc.nextLine();
                    data.searchForProduct(a1);
                } else if (ch == 3) {
                    System.out.print("Please enter an Valid Brand: ");
                    sc = new Scanner(System.in);
                    String a1 = sc.nextLine();
                    data.searchForProduct(a1);
                } else {
                    System.out.print("Please enter an Valid Brand: ");
                    sc = new Scanner(System.in);
                    String a1 = sc.nextLine();
                    data.searchForProductByCategory(a1);
                }
            }
        }
    }
}