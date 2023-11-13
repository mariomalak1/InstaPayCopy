public abstract class User {
    protected String UserName;
    protected String Email;
    protected String Password;
    protected String Phone;
    protected String Type;
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
    public void SetType(String type){
        this.Type = type;
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
    //protected Bills UtiltyBillsPayment;


}
