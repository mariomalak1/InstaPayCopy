public abstract class Menu {
    protected InstaPayManager instaPayManager;
    protected Transference transference;
    protected UtilityBillsPayment Bill;
    protected BankUser user;
    protected BillsFactory billsFactory = new BillsFactory();

    public abstract void DisplayMenu();


}




