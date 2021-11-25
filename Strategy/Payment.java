package Strategy;

public class Payment{
    Pay pp;
    public Payment(Pay payStrategy){
        this.pp = payStrategy;
    }

    public void pay() {
        pp.pay();
    }
}
