package eventHandler;

public class EventListenerDemo {
    public static void main(String[] args) {
        EventListener eventListener = new EventListenerImpl();

        eventListener.invoke();
//
//        eventListener.invoke(5);
    }
}
