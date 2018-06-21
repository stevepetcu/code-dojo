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

        int characterIndex, firstCharacterPosition, lastCharacterPosition, verticalPosition, horizontalPosition;

        characterIndex = firstCharacterPosition = lastCharacterPosition = alphabet.indexOf(character);
        verticalPosition = 0;

        while (verticalPosition <= characterIndex) {
            renderRow(rendering, verticalPosition, firstCharacterPosition, lastCharacterPosition);

            if (verticalPosition == characterIndex) {
                break;
            }

            --firstCharacterPosition;
            ++lastCharacterPosition;
            ++verticalPosition;

            rendering.append("\n");
        }

        while (verticalPosition > 0) {
            rendering.append("\n");

            ++firstCharacterPosition;
            --lastCharacterPosition;
            --verticalPosition;

            renderRow(rendering, verticalPosition, firstCharacterPosition, lastCharacterPosition);
        }

        return rendering.toString();
    }

    private void renderRow(
            StringBuilder rendering,
            int verticalPosition,
            int firstCharacterPosition,
            int lastCharacterPosition
    ) {
        int horizontalPosition = 0;
        while (horizontalPosition <= lastCharacterPosition) {
            if (horizontalPosition == firstCharacterPosition || horizontalPosition == lastCharacterPosition) {
                rendering.append(alphabet.characterAt(verticalPosition));
            } else {
                rendering.append(" ");
            }

            ++horizontalPosition;
        }
    }
}
