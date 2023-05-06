public class User {
    private String name , Email , phone , id ;

    public User (String name , String Email , String phone , String id) {
        this.name = name ;
        this.Email = Email ;
        this.phone = phone ;
        this.id = id ;
    }
    public String get_name () {
        return name ;
    }
    public String get_Email () {
        return Email ;
    }
    public String get_id () {
        return id ;
    }
    public String get_phone () {
        return phone ;
    }
    public void set_name (String name) {
        this.name = name ;
    }
    public void set_Email (String Email) {
        this.Email = Email ;
    }
    public void set_id (String id) {
        this.id = id ;
    }
    public void set_phone (String phone) {
        this.phone = phone ;
    }
    public String toString (){
        return "Name : " + name + "\nId : " + id + "\nEmail : " + Email + "\nPhone : " + phone + "\n" ;
    }

}
