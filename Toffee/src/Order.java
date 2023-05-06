public class Order {
    private String customer_id , Name , order_id ;
    private Double price ;
    private Cart cart ;

    Order (String customer_id , String order_id , String Name  , Cart cart) {
        this.customer_id = customer_id ;
        this.order_id = order_id ;
        this.Name = Name ;
        this.price = cart.calculateOverAllProducts(); ;
        this.cart = cart ;
    }
    public void setCustomer_id (String customer_id){
        this.customer_id = customer_id ;
    }
    public void set_order_id (String order_id) {
        this.order_id = order_id ;
    }
    public void set_Name (String Name) {
        this.Name = Name ;
    }
    public void set_Price (Double price) {
        this.price = price ;
    }
    public void set_product (Cart cart) {
        this.cart = cart ;
    }

    public String toString (){
        return "Name : " + Name + "\nOrder id : " + order_id + "\nCustomer id : " + customer_id
        +"\nPrice : " + price + "\nProduct\n" + cart ;
    }

    public void setCart (Cart cart){
        this.cart = cart ;
    }
}
