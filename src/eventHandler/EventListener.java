package eventHandler;

public interface EventListener {

    void invoke();
    int invoke(int number);
    void invoke(EventListener listener);

}
