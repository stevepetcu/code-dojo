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

public class Diamond {
    private List<Character> alphabet;
    private Character character;

    // TODO: refactor class (and tests) to take an Alphabet type, instead of a List of characters.
    public Diamond(List<Character> alphabet) {
        this(alphabet, null);
    }

    public Diamond(List<Character> alphabet, Character character) {
        if (alphabet.isEmpty()) {
            throw new IllegalArgumentException("Non-empty character set is required.");
        }

        if (null == character) {
            character = alphabet.get(alphabet.size() - 1);
        }

        this.alphabet = alphabet;
        this.character = character;
    }

    @Override
    public String toString() {
        StringBuilder rendering = new StringBuilder();

        for (Character character : alphabet) {
            rendering.append(character);
        }

        rendering.append(" ").append(character);

        return rendering.toString();
    }
}
