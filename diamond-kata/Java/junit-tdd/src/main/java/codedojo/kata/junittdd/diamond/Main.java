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
import java.util.Scanner;

class Main {
    private static final List<Character> ALPHABET =
            List.of(
                    'A', 'B', 'C', 'D', 'E', 'F',
                    'G', 'H', 'I', 'K', 'L', 'M',
                    'N', 'O', 'P', 'Q', 'R', 'S',
                    'T', 'V', 'X', 'Y', 'Z'
            );

    public static void main(String[] args) {
        System.out.print("Please enter a letter between A and Z: ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        scanner.close();

        Character inputCharacter = input.charAt(0);

        Alphabet alphabet = new Alphabet(ALPHABET);

        Diamond diamond = new Diamond(alphabet, Character.toUpperCase(inputCharacter));

        System.out.println(diamond);
    }
}
