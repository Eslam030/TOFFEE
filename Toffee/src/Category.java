public class Category {
    private Integer ID = 0;
    private String Name;
    public Category(){}
    public Category(Category a){
        this.Name = a.get_name();
    }
    public Category(String Name){
        this.Name = Name;
        this.ID++;
    }
    public Integer get_id() {
        return ID ;
    }
    public String get_name() {
        return Name ;
    }
    public void ChangeCategoryName(String Name){
        this.Name = Name;
    }
    public void deleteCategory(){
        this.ID--;
    }
}
