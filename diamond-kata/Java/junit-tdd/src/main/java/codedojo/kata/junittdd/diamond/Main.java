/*
 * This file is part of the DiamondKata application.
 *
 * © Stefan Petcu <hello@stefanpetcu.com>
 *
 * For the full copyright and license information, please view
 * the LICENSE file that was distributed with this source code.
 */
package main.java.codedojo.kata.junittdd.diamond;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<Character> ALPHABET =
            new ArrayList<Character>(
                    Arrays.asList(
                            'A',
                            'B',
                            'C',
                            'D',
                            'E',
                            'F',
                            'G',
                            'H',
                            'I',
                            'K',
                            'L',
                            'M',
                            'N',
                            'O',
                            'P',
                            'Q',
                            'R',
                            'S',
                            'T',
                            'V',
                            'X',
                            'Y',
                            'Z'
                    )
            );

    public static void main(String[] args) {
        System.out.print("Please enter a letter between A and Z: ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        scanner.close();

        // Do some validation...

        Character inputCharacter = input.charAt(0);

        Diamond diamond = new Diamond(ALPHABET, inputCharacter);

        System.out.println(diamond);
    }
}
