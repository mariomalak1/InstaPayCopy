public abstract class Payment {
    User user = null;
    double ConsumptionCost = 0;
    public abstract double PayBills();
    public void setUser(User user){
        this.user = user;
    }
    public void SetCost(double Cost){
        this.ConsumptionCost=Cost;
    }
}
