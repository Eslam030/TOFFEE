import java.util.ArrayList;

public class Customer extends User{
    private Double LoyaltyPoints ,GiftCardCode;
    private ArrayList<Order>orders = new ArrayList<>() ;
    private Order currentOrder;
    private static Integer Numoforders = 1;
    private Cart cart ;

    public Customer(){
        // NumofCustomers++;
    }

    public Customer(Customer c){
        super(c.get_name() , c.get_Email() , c.get_phone() , c.get_id(), c.get_password());
        this.LoyaltyPoints = c.getLoyaltyPoints();
        this.GiftCardCode = c.getGiftCardCode();
        this.cart = c.returnCart();
        this.orders = c.getOrders();
        this.currentOrder = new Order(this, Numoforders);
    }

    public Customer (String name , String Email , String phone , Integer id, String password){
        super(name , Email , phone , id, password);
        cart = new Cart(id);
        // NumofCustomers++;
        //this in the parameter refers to this object.
        this.currentOrder = new Order(this, Numoforders);
    }

    public void DisplayCustomer(){
        System.out.println("User ID: " + get_id());
        System.out.println("User Name: " + get_name());
    }

    public void OrderFinished(){
        Numoforders++;
        //add the current order to the list. 
        orders.add(currentOrder);
        //make a new order.
        this.currentOrder = new Order(this, Numoforders);
    }

    public Double getLoyaltyPoints() {
        return LoyaltyPoints ;
    }

    public Double getGiftCardCode() {
        return GiftCardCode ;
    }

    public void getLoyaltyPoints (Double getLoyaltyPoints){
        this.LoyaltyPoints = getLoyaltyPoints ;
    }

    public void getGiftCardCode (Double GiftCardCode){
        this.GiftCardCode = GiftCardCode ;
    }

    public Integer Numoforders() {
        return Numoforders ;
    }

    //order functions.
    public ArrayList<Order> getOrders () {
        //TO DO Will throw exeption.
        // if (orders.isEmpty()) {
        //     System.out.println("There is no orders Exists!");
        // }
        return orders ;
    }

    public void AddProductToOrder (Product product) {
        //add product to the order.
        this.currentOrder.AddToOrder(product);
    }

    public void removeProductFromOrder (Product product) {
        //remove product from the order.
        this.currentOrder.removeFromOrder(product);
    }

    public void LastOrder(){
        System.out.println(orders.get(Numoforders).toString());
    }

    //cart functions.
    public Cart returnCart(){
        return cart;
    }

    public void AddProductToCart (Product product) {
        //add product to cart.
        this.cart.add_to_cart(product);
    }

    public void removeProductFromCart (Product product) {
        //remove product from the order.
        this.cart.deleteFromCart(product);
    }

    public void viewCart(){
        System.out.println(cart.toString());
    }
    //here one product will be added.
    public void addProductFromCartToOrder(Integer PID){
        this.currentOrder.AddToOrder(cart.returnProduct(PID));
    }
    //here all the products in cart will be added.
    public void addProductSFromCartToOrder(){
        for(int i = 0; i < cart.getProducts().size();i++){
            this.currentOrder.AddToOrder(cart.getProducts().get(i));
        }
    }

}
