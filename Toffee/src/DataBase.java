import java.util.*;
public class DataBase {
    // Map for users
    private HashMap<String , User> users = new HashMap<>() ;
    // Map for Orders
    private HashMap<String , Cart> cart = new HashMap<>() ;
    // Map for cart
    private HashMap<String , ArrayList<Order>> orders_per_user = new HashMap<>() ;
    // Map for Products
    private HashMap<String , Product> products = new HashMap<>() ;
    private ArrayList<String> user_ids = new ArrayList<>() ;
    private ArrayList<String> product_ids = new ArrayList<>() ;
    private ArrayList<Order> orders = new ArrayList<>() ;


    public void add_user (User user){
        // add user to the database
        this.users.put(user.get_id() , user) ;
        // create a cart for this user
        Cart cart = new Cart (user.get_id()) ;
        this.cart.put(user.get_id() , cart) ;
        // create an empty list of orders for this user
        ArrayList<Order> orders  = new ArrayList<>() ;
        this.orders_per_user.put(user.get_id() , orders) ;
        // add user id in the list of ids
        this.user_ids.add(user.get_id()) ;
    }
    public void add_to_cart (User user ,  Product product){
        this.cart.get(user.get_id()).add_to_cart(product);
    }
    public Cart get_cart (User user) {
        return this.cart.get(user.get_id()) ;
    }
    public void add_order (User user , Order order){
        order.setCart(get_cart(user));
        this.orders_per_user.get(user.get_id()).add(order) ;
        this.orders.add(order) ;
    }
    public void add_product (Product product) {
        this.products.put(product.get_id() , product) ;
        this.product_ids.add(product.get_id()) ;
    }
    public void get_users_data () {
        for (Map.Entry<String , User> out: this.users.entrySet()) {
            System.out.println("id " + out.getKey());
            System.out.println("User info\n" + out.getValue());
        }
    }
    public void search_for_user (User user) throws NOT_EXIST_EXCEPTION{
        if (this.users.containsKey(user.get_id())){

        }else {
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
    public void get_orders_info () {

    }
    public void get_cart_into () {

    }

    public void delete_user () {

    }
    public void delete_order (){

    }
    public void delete_product () {

    }

    public boolean search_for_product () {
        return true ;
    }
}
