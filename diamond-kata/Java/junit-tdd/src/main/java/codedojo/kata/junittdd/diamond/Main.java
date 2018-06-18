/*
 * This file is part of the DiamondKata application.
 *
 * © Stefan Petcu <hello@stefanpetcu.com>
 *
 * For the full copyright and license information, please view
 * the LICENSE file that was distributed with this source code.
 */
package main.java.codedojo.kata.junittdd.diamond;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Please enter a letter between A and Z: ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        scanner.close();

        System.out.println(input);
    }
}
