package eventHandler;

public class EventListenerImpl implements EventListener {

    @Override
    public void invoke() {
        System.out.println("EventListener invoked");
        this.invoke(this);
    }

    @Override
    public int invoke(int number) {
        this.invoke();
        return number * number;
    }

    @Override
    public void invoke(EventListener listener) {
        System.out.println("Listener invoked");
    }
}
