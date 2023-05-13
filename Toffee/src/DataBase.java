import java.util.*;
public class DataBase {
    private final Vector<Admin> admins = new Vector<>() ;
    private final Vector<Customer> customers = new Vector<>() ;
    private final Vector<Category> categories = new Vector<>() ;
    private final Vector<Product> products = new Vector<>() ;

    public int customersNumber(){
        return customers.size();
    }

    public Integer productsNumber(){
        return customers.size();
    }
    public boolean checkLogin(Integer id,String password){
        boolean f = false;
        for (Customer a : customers) {
            if ( a.get_password().equals(password) && a.get_id().equals(id)) { //
                f = true; 
                break;
            }
        }
        return f;
    }

    public void addAdmin(Admin a){
        this.admins.add(a);
    }

    public void addAdmin (String name , String Email , String phone , Integer id, String password){
        Admin admin = new Admin(name, Email, phone, id, password);
        // add customer to the database
        this.admins.add( admin) ;
    }

    public void deleteAdmin (Integer id) {
        for (Admin a : admins) {
            if (a.get_id() == id) {
                admins.remove(a);
                break;
            }
        }
    }

    public void addCustomer (String name , String Email , String phone , Integer id, String password){
        Customer customer = new Customer(name, Email, phone, id, password);
        // add customer to the database
        this.customers.add( customer) ;
    }

    public void addCustomer(Customer c){
        this.customers.add(c);
    }    

    public Customer rCustomer(Integer id){
        Customer c = new Customer();
        for (Customer a : customers) {
            if (a.get_id() == id) {
                c = a;
                break;
            }
        }
        return c;
    }
    // delete customer 
    public void delete_Customer (Integer id) {
        for (Customer a : customers) {
            if (a.get_id() == id) {
                customers.remove(a);
                break;
            }
        }
    }

    public void addCategory(String CatName){
        Category newCat = new Category(CatName);
        categories.add(newCat);
    }

    public void deleteCategory(String CatName){
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).get_name() == CatName) {
                categories.get(i).deleteCategory();
                categories.remove(i);
                break;
            }
        }
    }

    //return category used it to add a product.
    public Category rCategory(String CatName){
        Category category = new Category();
        for (Category a : categories) {
            if (a.get_name() == CatName) {
                category = a;
                break;
            }
        }
        return category;
    }
    
    public void DisplayAllProducts(){
        for (Product p : products) {
            System.out.println(p.toString());
        }
    }

    public Product rProduct(Integer id){
        Product p = new Product();
        for (Product a : products) {
            if (a.get_id() == id) {
                p = a;
                break;
            }
        }
        return p;
    }
    // add product to the data
    public void add_product (Integer id , String name , String brand , Double price , Category CategoryName,Boolean isLoose) {
        Product p = new Product(id, name, brand, price, CategoryName, isLoose); 
        this.products.add(p) ;
    }
    
    // delete product form list of products
    public void delete_product (Integer id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).get_id() == id){
                products.remove(i);
            }
        }
    }
    
    public void searchForProduct(Integer id){
        for (Product p : products) {
            if (p.get_id() == id) {
                System.out.println(p.toString());
                break;
            }
        }
    }

    public void searchForProduct(String name){
        for (Product p : products) {
            if (p.get_name().equals(name)) {
                System.out.println(p.toString());
            }
        }
    }

    public void searchForProductByCategory(String CategoryName){
        for (Product p : products) {
            if (p.getCategory().get_name().equals(CategoryName)) {
                System.out.println(p.toString());
            }
        }
    }

    public void searchForProductByBrand(String brand){
        for (Product p : products) {
            if (p.get_brand().equals(brand)) {
                System.out.println(p.toString());
            }
        }
    }

    // print all users in the system
    public void get_customers_data () {
        for (Customer c : customers) {
            System.out.println(c.toString());
        }
        System.out.println("-------------------------------------------");
    }
    
    public boolean searchforCustomer(Customer c2){
        boolean x = false;
        for (Customer c : customers) {
            if (c == c2) {
                x =true;
                break;
            }
        }
        return x;
    }

    // search for customer using name
    public void searchForCustomerByName (String name){
        for (Customer c : customers) {
            if (c.get_name() == name) {
                System.out.println(c.toString());
            }
        }
    }
    // search for user using id
    public void searchforCustomerByID (Integer id){
        for (Customer c : customers) {
            if (c.get_id() == id) {
                System.out.println(c.toString());
            }
        }
    }

    public void get_last_order (Customer c){
        if (searchforCustomer(c)) {
            c.LastOrder();
        }
    }

    // print orders in this class
    public void get_orders_info () {
        for (int i = 0 ; i < this.customers.size() ; i++){
            System.out.println(customers.get(i).getOrders().toString());
        }
    }
    
    // print orders based on the user id and name
    public void get_orders_info_with_id_name () {
        for (int i = 0 ; i < this.customers.size() ; i++){
            System.out.println(customers.get(i).toString()  + customers.get(i).getOrders().toString());
        }
    }
    
    // // display all products in the catalog
    // public void display_catalog (){
    //     for (Map.Entry<Integer , Product> out : this.catalog.entrySet()){
    //         System.out.println("id : " + out.getKey() + "\n" + out.getValue());
    //     }
    // }


    // public void search_for_product (Product product) throws NOT_EXIST_EXCEPTION {
    //     if (this.catalog.containsKey(product.get_id())){
    //     }else {
    //         throw new NOT_EXIST_EXCEPTION () ;
    //     }
    // }

    // public void search_for_product (Product product) throws NOT_EXIST_EXCEPTION {
    //     if (this.catalog.containsKey(product.get_id())){
    //     }else {
    //         throw new NOT_EXIST_EXCEPTION () ;
    //     }
    // }
}
