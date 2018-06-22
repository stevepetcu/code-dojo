/*
 * This file is part of the DiamondKata application.
 *
 * © Stefan Petcu <hello@stefanpetcu.com>
 *
 * For the full copyright and license information, please view
 * the LICENSE file that was distributed with this source code.
 */
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

    public Character characterAt(int index) throws IndexOutOfBoundsException {
        return characters.get(index);
    }

    public Character lastCharacter() {
        return characters.get(characters.size() - 1);
    }
}
