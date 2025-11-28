package observer;

import java.util.ArrayList;
import java.util.List;

public class LoginSubject {
    private List<LoginObserver> observers = new ArrayList<>();

    public void addObserver(LoginObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(String message) {
        for (LoginObserver o : observers) {
            o.onLoginEvent(message);
        }
    }
}
