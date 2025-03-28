package observer.observer;

import observer.observable.StockObservable;

public class EmailAlertObserver implements NotificationAlertObserver{
    String emailId;
    StockObservable observable;

    public EmailAlertObserver(String emailId, StockObservable observable){
        this.emailId = emailId;
        this.observable = observable;
    }

    @Override
    public void update() {
        senMail(emailId, "product in stock " + observable.getStockCount() + " hurry up" );
    }

    private void senMail(String emailId, String msg){
        System.out.println("send mail to: " + emailId);
    }
}
