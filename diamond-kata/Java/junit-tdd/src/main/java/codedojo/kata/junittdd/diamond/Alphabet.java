package main.java.codedojo.kata.junittdd.diamond;

import java.util.List;

public class Alphabet {
    private final List<Character> characters;

    public Alphabet(List<Character> characters) {
        if (characters.isEmpty()) {
            throw new IllegalArgumentException("Non-empty character list required.");
        }

        this.characters = characters;
    }

    public int indexOf(Character character) {
        int index = characters.indexOf(character);

        if (-1 == index) {
            throw new IllegalArgumentException("Requested character is not in the alphabet.");
        }

        return index;
    }
}
