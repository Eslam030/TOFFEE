public class User {
    User () {}
    private String name , Email , phone , password ;
    private Integer id ;

    // set password
    User (String name , String Email , String phone , Integer id,String password) {
        this.name = name ;
        this.Email = Email ;
        this.phone = phone ;
        this.id = id ;
        this.password = password;
    }
    public String get_password() {
        return password ;
    }
    public String get_name() {
        return name ;
    }
    public String get_Email() {
        return Email ;
    }
    public Integer get_id() {
        return id ;
    }
    public String get_phone() {
        return phone ;
    }
    public void set_name(String name) {
        this.name = name ;
    }
    public void set_password(String Pass) {
        this.password = Pass ;
    }
    public void set_Email(String Email) {
        this.Email = Email ;
    }
    public void set_id(Integer id) {
        this.id = id ;
    }
    public void set_phone(String phone) {
        this.phone = phone ;
    }
    public String toString(){
        return "Name : " + name + "\nId : " + id + "\nEmail : " + Email + "\nPhone : " + phone + "\n" ;
    }

}
