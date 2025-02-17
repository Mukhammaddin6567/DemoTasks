package designPatterns.structuralPatterns;

import java.util.HashMap;
import java.util.Map;

interface CharacterFlyweight {
    void display(int x, int y); // Extrinsic state (position) passed as parameters
}

class CharacterFlyweightImpl implements CharacterFlyweight {
    private final char character; // Intrinsic state
    private final String font;    // Intrinsic state
    private final int size;       // Intrinsic state

    CharacterFlyweightImpl(char character, String font, int size) {
        this.character = character;
        this.font = font;
        this.size = size;
    }

    @Override
    public void display(int x, int y) {
        System.out.println("Character: " + character + " Font: " + font + " Size: " + size + " X: " + x + " Y: " + y);
    }
}

class CharacterFactory {
    private final Map<Character, CharacterFlyweight> characters = new HashMap<>();

    CharacterFlyweight getCharacter(char character, String font, int size) {
        // Check if the flyweight object already exists
        if (characters.containsKey(character)) return characters.get(character);

        CharacterFlyweight newCharacter = new CharacterFlyweightImpl(character, font, size);
        characters.put(character, newCharacter);
        return newCharacter;
    }
}

class Flyweight {
    public static void main(String[] args) {
        CharacterFactory characterFactory = new CharacterFactory();

        // create and display characters
        CharacterFlyweight charA = characterFactory.getCharacter('A', "Arial", 12);
        charA.display(10, 20);

        CharacterFlyweight charB = characterFactory.getCharacter('B', "Times New Roman", 14);
        charB.display(30, 40);

        // reuse the flyweight object for 'A'
        CharacterFlyweight charA2 = characterFactory.getCharacter('A', "Capital", 12);
        charA2.display(50, 60);

        // verify that the same flyweight object is reused
        if (charA == charA2) System.out.println("The same flyweight object is reused.");
    }
}
