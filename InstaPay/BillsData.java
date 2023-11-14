public class BillsData {
    private String Consumption;
    private double Cost;
    protected String billNum;
    protected String type;


    public void SetConsumption(String Consumption){
        this.Consumption = Consumption;
    }

    public void SetCost(double ConsumptionCost) {
        this.Cost = ConsumptionCost;
    }

    public void SetType(String type){
        this.type = type;
    }

    public String GetType() {
         return type;}

    public String GetConsumption(){
        return Consumption;
    }

    public double GetCost(){
        return Cost;
    }

    public void SetbillNum(String billNum){
        this.billNum = billNum;
    }
    public String GetbillNum(){
        return billNum;
    }
    }



