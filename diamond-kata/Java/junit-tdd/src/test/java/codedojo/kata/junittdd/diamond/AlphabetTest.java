/*
 * This file is part of the DiamondKata application.
 *
 * © Stefan Petcu <hello@stefanpetcu.com>
 *
 * For the full copyright and license information, please view
 * the LICENSE file that was distributed with this source code.
 */
package codedojo.kata.junittdd.diamond;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class AlphabetTest {
    private static final List<Character> CHARACTERS = List.of('A', 'B', 'C', 'D', 'E', 'F', 'G');

    private Alphabet alphabet;

    @Before
    public void setUp() {
        // GIVEN
        alphabet = new Alphabet(CHARACTERS);
    }

    @Test
    public void initialisation_WillWork_GivenANonEmptyCharacterList() {
        // THEN
        assertThat(alphabet, instanceOf(Alphabet.class));
    }

    @Test(expected = IllegalArgumentException.class)
    public void initialisation_WillThrowException_GivenAnEmptyCharacterList() {
        // GIVEN
        ArrayList<Character> emptyList = new ArrayList<>();

        // WHEN
        new Alphabet(emptyList);
    }

    @Test
    public void indexOf_WillReturnTheIndexOfARequestedCharacter_GivenTheCharacterIsInTheAlphabet() {
        // GIVEN
        char requestedCharacter = 'F';

        // WHEN
        int index = alphabet.indexOf(requestedCharacter);

        // THEN
        assertThat(index, equalTo(5));
    }

    @Test(expected = IllegalArgumentException.class) // TODO: Replace with a custom exception.
    public void indexOf_WillThrowException_GivenTheCharacterIsNotInTheAlphabet() {
        // GIVEN
        char requestedCharacter = 'H';

        // WHEN
        alphabet.indexOf(requestedCharacter);
    }

    @Test
    public void characterAt_WillReturnTheCharacterAtTheGivenIndex_GivenTheIndexIsInTheAlphabet() {
        // GIVEN
        int index = 5;

        // WHEN
        char character = alphabet.characterAt(index);

        // THEN
        assertThat(character, equalTo('F'));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void characterAt_WillThrowIndexOutOfBoundException_GivenTheIndexIsNotInTheAlphabet() {
        // GIVEN
        int index = -1;

        // WHEN
        alphabet.characterAt(index);
    }

    @Test
    public void lastCharacter_WillReturnTheLastCharacterOfTheAlphabet() {
        // WHEN
        Character character = alphabet.lastCharacter();

        // THEN
        assertThat(character, equalTo('G'));
    }
}
