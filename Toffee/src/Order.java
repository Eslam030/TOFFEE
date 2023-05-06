public class Order {
    private String Name  ;
    private Integer customer_id  , order_id ;
    private Double price = 0.0 ;
    private Cart cart ;

    Order (Integer customer_id , Integer order_id , String Name ) {
        this.customer_id = customer_id ;
        this.order_id = order_id ;
        this.Name = Name ;
    }
    public void setCustomer_id (Integer customer_id){
        this.customer_id = customer_id ;
    }
    public void set_order_id (Integer order_id) {
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
    public Integer get_customer_id (){
        return this.customer_id ;
    }
    public Integer get_order_id (){
        return this.order_id ;
    }

    public String toString (){
        return "Name : " + Name + "\nOrder id : " + order_id + "\nCustomer id : " + customer_id
        +"\nPrice : " + price + "\n" + cart ;
    }

    public void setCart (Cart cart){
        this.cart = cart ;
        this.price = cart.calculateOverAllProducts(); ;
    }
}
