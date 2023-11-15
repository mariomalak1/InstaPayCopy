public abstract class User {
    public User() {
    }
    protected String UserName;
    protected String Email;
    protected String Password;
    protected String Phone;
    protected String Type;


    public User(String username,String pass,String mail,String phone){
        this.UserName=username;
        this.Password = pass;
        this.Email = mail;
        this.Phone = phone;
    }
    public void setUserName(String name){
        this.UserName = name;
    }
    public void setEmail(String Mail){
        this.Email = Mail;
    }
    public void SetPassword(String pass){
        this.Password = pass;
    }
    public void SetPhone(String phone){
        this.Phone = phone;
    }
    public String GetUserName(){
        return this.UserName;
    }
    public String GetPhone(){
        return this.Phone;
    }
    public String GetEmail(){
        return this.Email;
    }
    public String GetPassword(){
        return this.Password;
    }
    public String GetType(){
        return this.Type;
    }
    public abstract void SetType();
    public abstract double GetBalance();

}
