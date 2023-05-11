public class Product {
    private String  name , brand;
    // private String image;
    private Integer id = 0 ;
    private Double price ;
    private Category category;
    private Boolean isLoose;

    Product(){}

    Product (Integer id , String name , String brand , Double price , Category cat,Boolean isLoose){
        this.id = id ;
        this.name = name ;
        this.brand = brand ;
        // this.image = image ;
        this.price = price ;
        this.category = cat;
        this.isLoose = isLoose;
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

    // public String get_image (){
    //     return this.image ;
    // }

    public Double getPrice (){
        return price ;
    }

    public Category getCategory(){
        return category;
    }

    public Boolean isLoose(){
        return isLoose;
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

    // public void set_image (String image){
    //     this.image = image ;
    // }

    public void setPrice (Double price){
        this.price = price ;
    }

    public void set_category (Category cat){
        this.category =  cat;
    }

    public void set_isLooseOrNot (Boolean isLoose){
        this.isLoose = isLoose;
    }

    public String toString (){
        return "Name : " + name + " Id : " + id + " Category: "+ category.get_name() +"\nBrand : " + brand + "\nPrice : " + price + "\n----------------------------\n" ;
    }

}
