import java.util.ArrayList;

public class Cart {
    private String id ;
    private ArrayList<Product>orders = new ArrayList<>() ;
    Cart (String id) {
        this.id = id ;
    }
    public void add_to_cart (Product product) {
        this.orders.add(product) ;
    }
    public String get_id (){
        return id ;
    }
    public void set_id (String id){
        this.id = id ;
    }
    public String toString (){
        String a = "" ;
        for (int i = 0 ; i < orders.size() ; i++){
            a += orders.get(i) ;
        }
        return "id : " + id + "\nOrders\n" + a ;
    }
    public Double calculateOverAllProducts (){
        Double sum = 0.0 ;
        for (int i = 0 ; i < this.orders.size() ; i++){
            sum += this.orders.get(i).getPrice () ;
        }
        return sum ;
    }
}
