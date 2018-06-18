/*
 * This file is part of the DiamondKata application.
 *
 * © Stefan Petcu <hello@stefanpetcu.com>
 *
 * For the full copyright and license information, please view
 * the LICENSE file that was distributed with this source code.
 */
package test.java.codedojo.kata.junittdd.diamond;

import main.java.codedojo.kata.junittdd.diamond.Diamond;
import org.hamcrest.CoreMatchers;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class DiamondTest {
    private static final List<Character> ALPHABET = new ArrayList<Character>(10);

    static {
        ALPHABET.add('A');
        ALPHABET.add('B');
        ALPHABET.add('C');
        ALPHABET.add('D');
        ALPHABET.add('E');
        ALPHABET.add('F');
        ALPHABET.add('G');
        ALPHABET.add('H');
        ALPHABET.add('I');
        ALPHABET.add('J');
    }

    @Test(expected = IllegalArgumentException.class)
    public void will_ThrowException_DuringConstruction_GivenAlphabetIsEmpty() {
        // GIVEN
        List<Character> alphabet = new ArrayList<Character>();

        // WHEN
        Diamond diamond = new Diamond(alphabet);
    }

    @Test
    public void itCanBeBuilt_WithJustAListOfCharacters() {
        // WHEN
        Diamond diamond = new Diamond(ALPHABET);

        // THEN
        assertThat(diamond, CoreMatchers.<Diamond>instanceOf(Diamond.class));
    }

    @Test
    public void itCanBeBuilt_WithAListOfCharactersAndTheTargetCharacter() {
        // WHEN
        Diamond diamond = new Diamond(ALPHABET, 'C');

        // THEN
        assertThat(diamond, CoreMatchers.<Diamond>instanceOf(Diamond.class));
    }

    @Test
    public void itWillOutputItsAlphabetAndLastAlphabetCharacter_GivenTargetCharacterNotProvided() {
        // WHEN
        Diamond diamond = new Diamond(ALPHABET);

        // THEN
        assertThat("ABCDEFGHIJ J", equalTo(diamond.toString()));
    }

    @Test
    public void itWillOutputItsAlphabetAndTargetCharacter_GivenTargetCharacterProvided() {
        // WHEN
        Diamond diamond = new Diamond(ALPHABET, 'E');

        // THEN
        assertThat("ABCDEFGHIJ E", equalTo(diamond.toString()));
    }

    @Test
    @Ignore
    public void itWillOutputASymmetricDiamond_BasedOnTheAlphabetAndItsLastCharacter_WhenTargetCharacterNotProvided() {
        fail();
    }
}
