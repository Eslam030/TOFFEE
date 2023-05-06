public class Product {
    private String  name , brand , image;
    private Integer id = 0 ;
    private Double price ;
    Product (Integer id , String name , String brand , String image , Double price){
        this.id = id ;
        this.name = name ;
        this.brand = brand ;
        this.image = image ;
        this.price = price ;
    }
    public Integer get_id (){
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
    public void set_id (Integer id){
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
        return "Name : " + name + "Id : " + id + "\nBrand : " + brand + "\nPrice : " + price + "\n----------------------------\n" ;
    }
}
