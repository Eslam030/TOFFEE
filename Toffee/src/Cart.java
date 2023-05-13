import java.util.ArrayList;

public class Cart {
    private Integer id ;
    private ArrayList<Product>products = new ArrayList<>() ;

    Cart (){
    }

    Cart (Integer id) {
        this.id = id ;
    }

    Cart (Integer id , ArrayList<Product> products){
        this.id = id ;
        this.products = products ;
    }

    public void add_to_cart (Product product) {
        this.products.add(product) ;
    }

    public void deleteFromCart (Product product) {
        this.products.remove(product);
    }
    public Product returnProduct(Integer PID){
        Product returnedProduct = new Product();
        for (int i = 0 ; i < this.products.size() ; i++){
            if (products.get(i).get_id() == PID) {
                returnedProduct = products.get(i);
                break;
            }
        }
        return returnedProduct;
    }

    public Integer get_id (){
        return id ;
    }

    public void set_id (Integer id){
        this.id = id ;
    }

    public String toString (){
        String a = "" ;
        for (int i = 0 ; i < products.size() ; i++){
            a += products.get(i).toString() ;
        }
        return "Products\n" + a ;
    }

    public Double calculateOverAllProducts (){
        Double sum = 0.0 ;
        for (int i = 0 ; i < this.products.size() ; i++){
            sum += this.products.get(i).getPrice () ;
        }
        return sum ;
    }

    public boolean isEmpty(){
        return products.isEmpty();
    }

    public ArrayList<Product> getProducts () {
        return products ;
    }

    public void clear (){
        products.clear(); ;
    }
}
