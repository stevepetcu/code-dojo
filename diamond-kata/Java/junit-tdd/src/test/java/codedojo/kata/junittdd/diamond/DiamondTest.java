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
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class DiamondTest {
    // TODO: Refactor method names.
    // TODO: Mock alphabet (use Alphabet class) - research Mockito.
    private static final List<Character> ALPHABET =
            new ArrayList<Character>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G'));

    @Test
    public void initialisation_WillWork_GivenAnAlphabet() {
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
        assertThat("ABCDEFG G", equalTo(diamond.toString()));
    }

    @Test
    public void itWillOutputItsAlphabetAndTargetCharacter_GivenTargetCharacterProvided() {
        // WHEN
        Diamond diamond = new Diamond(ALPHABET, 'E');

        // THEN
        assertThat("ABCDEFG E", equalTo(diamond.toString()));
    }

    @Test
    @Ignore
    public void itWillOutputASymmetricDiamond_BasedOnTheAlphabetAndItsLastCharacter_WhenTargetCharacterNotProvided() {
        fail();
    }
}
