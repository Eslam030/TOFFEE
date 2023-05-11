public class Admin extends User{
    Admin (String name , String Email , String phone , Integer id,String password){
        super(name , Email , phone , id,password);
    }
    Admin (Admin a){
        super(a.get_name(), a.get_Email(), a.get_phone(), a.get_id(), a.get_password());
    }
}
