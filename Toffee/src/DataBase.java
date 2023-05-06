import java.util.*;
public class DataBase {
    // Map for users
    private HashMap<Integer , User> users = new HashMap<>() ;
    // Map for Orders
    private HashMap<Integer , Cart> carts = new HashMap<>() ;
    // Map for cart
    private HashMap<Integer , ArrayList<Order>> orders_per_user = new HashMap<>() ;
    // Map for Products
    private HashMap<Integer , Product> catalog = new HashMap<>() ;
    private ArrayList<Integer> product_ids = new ArrayList<>() ;
    //private ArrayList<Order> orders = new ArrayList<>() ;
    private HashMap<Integer , Order> orders = new HashMap<>() ;
    private HashMap<Integer , Order> waitedOrders = new HashMap<>() ;


    public void add_user (User user){
        // add user to the database
        this.users.put(user.get_id() , user) ;
        // create a cart for this user
        Cart cart = new Cart (user.get_id()) ;
        this.carts.put(user.get_id() , cart) ;
        // create an empty list of orders for this user
        ArrayList<Order> orders  = new ArrayList<>() ;
        this.orders_per_user.put(user.get_id() , orders) ;
    }
    // add products to the user's cart
    public void add_to_cart (User user ,  Product product){
        this.carts.get(user.get_id()).add_to_cart(product);
    }
    // return the cart of the current user
    public Cart get_cart (User user) {
        return this.carts.get(user.get_id()) ;
    }
    // add order to specific user
    public void add_order (User user , Order order){
        Cart cart = this.get_cart(user) ;
        Cart newCart = new Cart(cart.get_id() , cart.getProducts()) ;
        order.setCart(newCart);
        this.orders_per_user.get(user.get_id()).add(order) ;
        this.orders.put(order.get_order_id() , order) ;
        cart = new Cart(user.get_id()) ;
        carts.put(user.get_id() , cart) ;
    }
    // add product to the catalog
    public void add_product (Product product) {
        this.catalog.put(product.get_id() , product) ;
        this.product_ids.add(product.get_id()) ;
    }
    // print all users in the system
    public void get_users_data () {
        for (Map.Entry<Integer , User> out: this.users.entrySet()) {
            System.out.println("User info\n" + out.getValue());
        }
        System.out.println("-------------------------------------------");
    }
    // search for user using User object
    public void search_for_user (User user) throws NOT_EXIST_EXCEPTION{
        if (!this.users.containsKey(user.get_id())){
            throw new NOT_EXIST_EXCEPTION() ;
        }
    }
    // search for user using name
    public void search_for_user (String name) throws NOT_EXIST_EXCEPTION{
        Boolean exist = false ;
        User user = new User() ;
        for (Map.Entry<Integer , User> out : this.users.entrySet()){
            if (out.getValue().get_name() == name){
                user = out.getValue() ;
                exist = true ;
                break;
            }
        }
        if (!exist){
            throw new NOT_EXIST_EXCEPTION () ;
        }
    }
    // search for user using id
    public void search_for_user (Integer id) throws NOT_EXIST_EXCEPTION {
        if (!this.users.containsKey(id)){
            throw new NOT_EXIST_EXCEPTION() ;
        }
    }
    public void get_last_order (User user){
        try  {
            this.search_for_user(user) ;
            System.out.println(this.orders_per_user.get(user.get_id()).get(orders_per_user.get(user.get_id()).size() - 1)) ;
        }catch (NOT_EXIST_EXCEPTION ex) {

        }
    }
    // print orders in this class
    public void get_orders_info () {
        for (int i = 0 ; i < this.orders.size() ; i++){
            System.out.println(orders.get(i));
        }
    }
    // print orders based on the user id and name
    public void get_orders_info_with_id_name () {
        for (Map.Entry<Integer , ArrayList<Order>> out : this.orders_per_user.entrySet()){
            System.out.println("id : " + out.getKey());
            for (int i = 0 ; i < out.getValue().size() ; i++){
                System.out.println(out.getValue().get(i));
            }
        }
    }
    // display all products in the catalog
    public void display_catalog (){
        for (Map.Entry<Integer , Product> out : this.catalog.entrySet()){
            System.out.println("id : " + out.getKey() + "\n" + out.getValue());
        }
    }
    public void history (User user) {
        ArrayList<Order> userHistory = this.orders_per_user.get(user.get_id()) ;
        for (int i = 0 ; i < userHistory.size() ; i ++){
            System.out.println(userHistory.get(i));
        }
    }
    public void display_cart (User user){
        System.out.println(carts.get(user.get_id()));
    }

    public void search_for_product (Product product) throws NOT_EXIST_EXCEPTION {
        if (this.catalog.containsKey(product.get_id())){
        }else {
            throw new NOT_EXIST_EXCEPTION () ;
        }
    }
    // delete user and cart and all of his info and orders
    public void delete_user (User user) {
        try {
            this.search_for_user(user);
            this.users.remove(user.get_id()) ;
            this.carts.remove(user.get_id()) ;
            ArrayList<Order> orderList = orders_per_user.get(user.get_id()) ;
            this.orders_per_user.remove(user.get_id()) ;
            for (int i = 0 ; i < orderList.size() ; i ++){
                this.orders.remove(orderList.get(i).get_order_id()) ;
            }
        }catch (NOT_EXIST_EXCEPTION ex){
            System.out.println(ex);
        }

    }
    // delete order using order id
    public void delete_order (Order order ){
        // delete the order from orders
        this.orders.remove(order.get_order_id()) ;
        ArrayList<Order> ordersList = this.orders_per_user.get(order.get_customer_id()) ;
        for (int i = 0 ; i < ordersList.size() ; i ++){
            if (ordersList.get(i).get_order_id() == order.get_order_id()){
                ordersList.remove(i) ;
                break;
            }
        }
        // delete the order from the user's orders
        this.orders_per_user.put(order.get_customer_id() , ordersList) ;
    }
    // delete product form list of products
    public void delete_product (Product product) {
        this.catalog.remove(product.get_id()) ;
    }
}
