import java.util.ArrayList;
public class Order {
    private Integer order_id ;
    private Double price = 0.0 ,DiscountAmount = 0.0;
    private Customer customer;
    private ArrayList<Product>products = new ArrayList<>() ;
    private void set_Price () {
        //calculate the price of products.
        if (!products.isEmpty()) {
            Double sum = 0.0 ;
            for (int i = 0 ; i < this.products.size() ; i++){
                sum += this.products.get(i).getPrice () ;
            }
            this.price = sum;
        }
        // //calculate the price that is in the cart and add it to the price.
        // if (!customer.returnCart().isEmpty()) {
        //     this.price += customer.returnCart().calculateOverAllProducts();
        // }
        //calculate the price after discount from loyalty points
        if (DiscountAmount != 0.0) {
            this.price -= DiscountAmount;
        }  
    }
    Order(){}
    Order (Customer customer , Integer order_id ) {
        this.customer = customer ;
        this.order_id = order_id ;
        set_Price ();
    }
    // Order (Customer customer , Integer order_id ,ArrayList<Product>products) {
    //     this.customer = customer ;
    //     this.order_id = order_id ;
    //     this.products = products;
    //     set_Price ();
    // }
    
    public void setCustomer (Customer customer){
        this.customer = customer ;
    }

    public void set_order_id (Integer order_id) {
        this.order_id = order_id ;
    }

    public void set_DiscountAmount (Double DiscountAmount) {
        this.DiscountAmount = DiscountAmount ;
    }

    public void AddToOrder (Product product) {
        this.products.add(product) ;
    }

    public void removeFromOrder (Product product) {
        this.products.remove(product);
    }

    public Customer get_customer (){
        return this.customer ;
    }

    public Integer get_order_id (){
        return this.order_id ;
    }

    public Double OrderPrice(){
        set_Price();
        return price;
    }

    public void ViewOrder(){
        //all content that is in products list.
        for (int i = 0 ; i < this.products.size() ; i++){
            System.out.println( this.products.get(i).toString());
        }
        // //all content that is in cart.
        // if (!customer.returnCart().isEmpty()) {
        //     System.out.println( this.customer.returnCart().toString());
        // }
        System.out.println("Order Price is: " + OrderPrice());
       
    }

    public String toString (){
        return "Order id : " + order_id + "\nPrice : " + OrderPrice() + "\n"  ;
    }

    public ArrayList<Product> ProductsInOrder(){
        return products;
    }

}
