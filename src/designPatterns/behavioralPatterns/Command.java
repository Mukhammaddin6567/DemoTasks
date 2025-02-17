package designPatterns.behavioralPatterns;

import java.util.Stack;

// Command interface with execute and undo methods
interface DoCommand {
    void execute();

    void undo();
}

// Receiver class (Light)
class Light {
    void turnOn() {
        System.out.println("Light is ON");
    }

    void turnOff() {
        System.out.println("Light is OFF");
    }
}

class LightOnCommand implements DoCommand {
    private final Light light;

    LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void undo() {
        light.turnOff();
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

class LightOffCommand implements DoCommand {
    private final Light light;

    LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void undo() {
        light.turnOn();
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

class RemoteControl {
    private DoCommand command;
    private Stack<DoCommand> history = new Stack<>();

    void setCommand(DoCommand command) {
        this.command = command;
    }

    void pressButton() {
        command.execute();
        history.push(command);
    }

    void pressUndo() {
        if (history.isEmpty()) System.out.println("No commands to undo");
        else {
            DoCommand lastCommand = history.pop();
            lastCommand.undo();
        }
    }
}

class Command {
    public static void main(String[] args) {
        Light light = new Light();

        DoCommand lightOn = new LightOnCommand(light);
        DoCommand lightOff = new LightOffCommand(light);

        RemoteControl remoteControl = new RemoteControl();

        // turn the light on
        remoteControl.setCommand(lightOn);
        remoteControl.pressButton();

        // undo turning the light on (turn it off)
        remoteControl.pressUndo();

        // turn the light off
        remoteControl.setCommand(lightOff);
        remoteControl.pressButton();

        // undo turning the light off (turn it on)
        remoteControl.pressUndo();
        remoteControl.pressUndo();
    }
}
