package DesignPatternsLab.Facade;

public class Facade {
    private PaymentAPI paymentAPI;

    public Facade() {
        this.paymentAPI = new PaymentAPI();
    }

    public void paySubscription() {
        //this is kind of delegation, which helps to change executor if needed
       // paymentAPI.executePayment();

    }

    public void loadPayments() {
        //this is kind of delegation, which helps to change executor if needed
        //  paymentAPI.loadPayments();

    }
}
