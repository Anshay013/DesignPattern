package observer.observer;

import observer.observable.StockObservable;

public class MobileAlertObserver implements NotificationAlertObserver{

    String mNo;
    StockObservable observable;

    public MobileAlertObserver(String mNo, StockObservable observable){
        this.mNo = mNo;
        this.observable = observable;
    }

    @Override
    public void update() {
        senMail(mNo, "product in stock ");
    }

    private void senMail(String mNo, String msg){
            System.out.println("send msg to: " + mNo);

    }
}
