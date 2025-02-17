package designPatterns.behavioralPatterns;

import java.util.ArrayList;
import java.util.List;

// Mediator Interface
interface ChatRoomMediator {
    void sendMessage(String message, UserM UserM);

    void addUserM(UserM UserM);
}

// Concrete Mediator class
class ChatRoom implements ChatRoomMediator {
    private final List<UserM> UserMs;

    ChatRoom() {
        this.UserMs = new ArrayList<>();
    }

    @Override
    public void addUserM(UserM UserM) {
        UserMs.add(UserM);
    }

    @Override
    public void sendMessage(String message, UserM UserM) {
        for (UserM u : UserMs) {
            if (u != UserM) {
                u.receive(message);
            }
        }
    }
}

// Colleague clas
abstract class UserM {
    protected ChatRoomMediator mediator;
    protected String name;

    UserM(ChatRoomMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    abstract void send(String message);

    abstract void receive(String message);
}

// Concrete Colleague class
class ConcreteUserM extends UserM {

    ConcreteUserM(ChatRoomMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    void send(String message) {
        System.out.println(this.name + " sends message " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    void receive(String message) {
        System.out.println(this.name + " receives message " + message);
    }
}

class Mediator {
    public static void main(String[] args) {
        ChatRoomMediator mediator = new ChatRoom();

        // create users
        UserM user1 = new ConcreteUserM(mediator, "Alice");
        UserM user2 = new ConcreteUserM(mediator, "Bob");
        UserM user3 = new ConcreteUserM(mediator, "Charlie");

        // add users to the mediator
        mediator.addUserM(user1);
        mediator.addUserM(user2);
        mediator.addUserM(user3);

        // send messages
        user1.send("Hello, everyone!");
        System.out.println();
        user2.send("Hi, Alice!");
        System.out.println();
        user3.send("Hi, Charlie!");
        System.out.println();
    }
}
