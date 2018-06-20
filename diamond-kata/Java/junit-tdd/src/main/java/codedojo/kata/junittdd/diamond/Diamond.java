/*
 * This file is part of the DiamondKata application.
 *
 * © Stefan Petcu <hello@stefanpetcu.com>
 *
 * For the full copyright and license information, please view
 * the LICENSE file that was distributed with this source code.
 */
package main.java.codedojo.kata.junittdd.diamond;

public class Diamond {
    private Alphabet alphabet;
    private Character character;

    public Diamond(Alphabet alphabet) {
        this(alphabet, null);
    }

    public Diamond(Alphabet alphabet, Character character) {
        this.alphabet = alphabet;
        this.character = null == character ? alphabet.lastCharacter() : character;
    }

    @Override
    public String toString() {
        StringBuilder rendering = new StringBuilder();

        int index = alphabet.indexOf(character);

        while (index >= 0) {
            rendering.append(alphabet.characterAt(index));
            --index;
        }

        rendering.append(" ").append(character);

        return rendering.toString();
    }
}
