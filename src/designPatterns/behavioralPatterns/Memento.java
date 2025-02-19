package designPatterns.behavioralPatterns;

import java.util.Stack;

// Memento class
record MementoClass(String content) {
}

// Originator class
class Editor {
    private String content;

    void setContent(String content) {
        this.content = content;
    }

    String getContent() {
        return content;
    }

    // Save the current state into a Memento
    MementoClass save() {
        return new MementoClass(this.content);
    }

    // Restore the state from a Memento
    void restore(MementoClass memento) {
        this.content = memento.content();
    }
}

// Caretaker class
class Caretaker {
    private final Stack<MementoClass> mementoHistory = new Stack<>();

    // Save a Memento to the history
    void saveState(Editor editor) {
        this.mementoHistory.push(editor.save());
    }

    // Restore the previous state
    void undo(Editor editor) {
        if (!this.mementoHistory.isEmpty()) {
            editor.restore(this.mementoHistory.pop());
        }
    }
}

class Memento {
    public static void main(String[] args) {
        Editor editor = new Editor();
        Caretaker caretaker = new Caretaker();

        // Initial content in the editor
        editor.setContent("Hello");
        System.out.println("Editor content: " + editor.getContent());

        // Save the state
        caretaker.saveState(editor);

        // Change the content
        editor.setContent("Hello, World!");
        System.out.println("Editor content: " + editor.getContent());

        // Save the new state
        caretaker.saveState(editor);

        // Change the content again
        editor.setContent("Hello, Memento Pattern!");
        System.out.println("Editor content: " + editor.getContent());

        // Undo the last change
        caretaker.undo(editor);
        System.out.println("After undo: " + editor.getContent());

        // Undo again to the previous state
        caretaker.undo(editor);
        System.out.println("After undo again: " + editor.getContent());
    }
}