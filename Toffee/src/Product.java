public class Product {
    private String id , name , brand , image;
    private Double price ;
    Product (String id , String name , String brand , String image , Double price){
        this.id = id ;
        this.name = name ;
        this.brand = brand ;
        this.image = image ;
        this.price = price ;
    }
    public String get_id (){
        return this.id ;
    }
    public String get_name (){
        return this.name ;
    }
    public String get_brand (){
        return this.brand ;
    }
    public String get_image (){
        return this.image ;
    }
    public Double getPrice (){
        return price ;
    }
    public void set_id (String id){
        this.id = id ;
    }
    public void set_name (String name){
        this.name = name ;
    }
    public void set_brand (String brand){
        this.brand = brand ;
    }
    public void set_image (String image){
        this.image = image ;
    }
    public void setPrice (Double price){
        this.price = price ;
    }
    public String toString (){
        return "Name : " + name + "\nBrand : " + brand + "\nPrice : " + price + "\n----------------------------\n" ;
    }
}
