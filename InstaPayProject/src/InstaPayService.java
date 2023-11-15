public abstract class InstaPayService {
    protected User user;

    public void SetUser(User us){
        this.user=us;
    }

    public User GetUser(){
        return this.user;    }

}
