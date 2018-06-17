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

public class Diamond {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        scanner.close();

        System.out.println(input);
    }

    @Override
    public String toString() {
        return " A\nB B\n A";
    }
}
