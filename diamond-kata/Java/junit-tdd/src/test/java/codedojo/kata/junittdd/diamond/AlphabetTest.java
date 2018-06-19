package test.java.codedojo.kata.junittdd.diamond;

import main.java.codedojo.kata.junittdd.diamond.Alphabet;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

public class AlphabetTest {
    private static final List<Character> CHARACTERS
            = new ArrayList<Character>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G'));

    private Alphabet alphabet;

    @Before
    public void setUp()
    {
        // GIVEN
        alphabet = new Alphabet(CHARACTERS);
    }

    @Test
    public void can_BeInitialised_WithAListOfCharacters() {
        // THEN
        assertThat(alphabet, CoreMatchers.<Alphabet>instanceOf(Alphabet.class));
    }

    @Test(expected = IllegalArgumentException.class)
    public void initialisation_WillThrowException_GivenCharacterSetIsEmpty() {
        // GIVEN
        ArrayList<Character> emptyList = new ArrayList<Character>();

        // WHEN
        Alphabet alphabet = new Alphabet(emptyList);
    }

    @Test
    public void indexOf_WillReturnTheIndexOfARequestedCharacter_GivenTheCharacterIsInTheList() {
        // GIVEN
        char requestedCharacter = 'F';

        // WHEN
        int index = alphabet.indexOf(requestedCharacter);

        // THEN
        assertThat(5, CoreMatchers.equalTo(index));
    }

    @Test(expected = IllegalArgumentException.class) // TODO: Replace with a custom exception.
    public void indexOf_WillThrowException_GivenTheCharacterIsNotInTheList()
    {
        // GIVEN
        char requestedCharacter = 'H';

        // WHEN
        alphabet.indexOf(requestedCharacter);
    }
}
