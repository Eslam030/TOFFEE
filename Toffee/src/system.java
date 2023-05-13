import java.util.Scanner;

public class system {
    private static DataBase data  ;
    private static Customer currenCustomer ;
    private static  Boolean logged = false ;
    system () {
        data = new DataBase() ;
        currenCustomer = new Customer() ;
    }
    DataBase getDataBase () {
        return data ;
    }
    Customer getCurrenCustomer (){
        return currenCustomer ;
    }
    void setCurrenCustomer (Customer customer) {
        currenCustomer = customer ;
    }
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

    private static void Login(){
        System.out.println("Log in\n------------------------------------------------");
        Customer customer = new Customer();
        Integer id;
        // Scanner sc = new Scanner(System.in);
        Scanner myObj = new Scanner(System.in);
        while (true) {
            // add name or name
            System.out.println("Enter Your ID: ");
            String a1 = myObj.nextLine();
            id = Integer.parseInt(a1);
            System.out.println("Enter Your Password: ");
            String a2 = myObj.nextLine();
            if (data.checkLogin(id, a2)) {
                break;
            }else{
                System.out.println("there must be something Wrong in Your id or Password!");
                return;
            }
        }
        currenCustomer = data.rCustomer(id);
        logged = true ;
    }

    private static boolean signUP(){
        System.out.println("Sign up\n------------------------------------------------");
        Scanner sc = new Scanner(System.in);
        // String name , String Email , String phone , Integer id, String password
        System.out.println("Enter Your Name: ");
        String name = sc.nextLine();
        String Email  ;
        System.out.println("Enter Your Email: ");
        sc = new Scanner(System.in) ;
        Email = sc.nextLine();
        while (!isValidEmailAddress(Email)) {
            System.out.println("non-valid Email-format\nplease enter it correctly");
            sc = new Scanner(System.in) ;
            Email = sc.nextLine();
        }
        System.out.println("Enter Your phone: ");
        String phone = sc.nextLine();
        System.out.println("Enter Your password: ");
        String password = sc.nextLine();
        OTP message = new OTP(Email) ;
        try  {
            System.out.println("We will check if your email exist\nplease wait ...");
            message.sendOTP("For Sign up");
            System.out.println("We send you a message which has an otp please enter the otp to check if this is your mail");
            sc = new Scanner(System.in) ;
            String code = sc.nextLine() ;
            while (true){
                if (message.valid(code)) {
                    System.out.println("Congrats continue setting your have signed up");
                    data.addCustomer(name, Email, phone, data.customersNumber() + 1, password);
                    System.out.println("Signed up successfully\nYour Id is " + (data.customersNumber())
                            +"\nPlease login to get in the system\nDon't forget this id!!!!!!!\n");
                    return true ;
                }else {
                    System.out.println("If you want to re enter otp enter 1\nIf you want to re-send an OTP enter 2\nif you want to exit sign up enter 0");
                    sc = new Scanner(System.in) ;
                    int a2 = sc.nextInt();
                    if (a2 == 0){
                        System.out.println("Ok you will be returned to the main menu");
                        return false ;
                    }else if (a2 == 1){
                        sc = new Scanner(System.in) ;
                        code = sc.nextLine() ;
                    }else if (a2 == 2){
                        message.sendOTP("For Sign up");
                    }else {
                        System.out.println("Wrong answer");
                    }
                }
            }
        }catch (Exception ex) {
            return false ;
        }
    }
    public static void StartupMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Our Shop TOFFEE ");
        System.out.println("please Enter a choice: \n1-Login \n2-Sign-In\n3-continue as guest");
        int a = sc.nextInt();
        if (a == 1) {
            Login();
            return;
        } else if (a == 2) {
            if (signUP()) {
                Login();
            }
            return;
        }
        logged = true ;
    }
    public static Boolean checkLogged () {
        return logged ;
    }
}
