/*
 * This file is part of the DiamondKata application.
 *
 * © Stefan Petcu <hello@stefanpetcu.com>
 *
 * For the full copyright and license information, please view
 * the LICENSE file that was distributed with this source code.
 */
package test.java.codedojo.kata.junittdd.diamond;

import main.java.codedojo.kata.junittdd.diamond.Alphabet;
import main.java.codedojo.kata.junittdd.diamond.Diamond;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class DiamondTest {
    // TODO: Refactor method names.

    private Alphabet alphabet;

    @Before
    public void setUp() {
        alphabet = mock(Alphabet.class);

        when(alphabet.characterAt(anyInt())).thenAnswer(new Answer<Character>() {
            @Override
            public Character answer(InvocationOnMock invocationOnMock) throws IllegalArgumentException {
                int index = invocationOnMock.getArgument(0);

                switch (index) {
                    case 0:
                        return 'A';
                    case 1:
                        return 'B';
                    case 2:
                        return 'C';
                    case 3:
                        return 'D';
                    case 4:
                        return 'E';
                    case 5:
                        return 'F';
                    default:
                        throw new IllegalArgumentException("Requested character is not in the alphabet.");
                }
            }
        });

        when(alphabet.indexOf(anyChar())).thenAnswer(new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocationOnMock) throws IllegalArgumentException {
                char character = invocationOnMock.getArgument(0);

                switch (character) {
                    case 'A':
                        return 0;
                    case 'B':
                        return 1;
                    case 'C':
                        return 2;
                    case 'D':
                        return 3;
                    case 'E':
                        return 4;
                    case 'F':
                        return 5;
                    default:
                        throw new IllegalArgumentException("Non-empty character list required.");
                }
            }
        });

        when(alphabet.lastCharacter()).thenReturn('F');
    }

    @Test
    public void initialisation_WillWork_GivenOnlyAnAlphabet() {
        // WHEN
        Diamond diamond = new Diamond(alphabet);

        // THEN
        assertThat(diamond, CoreMatchers.<Diamond>instanceOf(Diamond.class));
    }

    @Test
    public void initialisation_WillWork_GivenAnAlphabetAndACharacter() {
        // WHEN
        Diamond diamond = new Diamond(alphabet, 'C');

        // THEN
        assertThat(diamond, CoreMatchers.<Diamond>instanceOf(Diamond.class));
    }

    @Test
    @Ignore
    public void toString_WillOutputADiamondThatIsAsWideAsItIsHigh_GivenAnyTargetCharacterInItsAlphabet() {
        // TODO: Implement method.
    }

    @Test
    @Ignore
    public void toString_WillOutputASymmetricDiamondOnBothAxes_GivenAnyTargetCharacterInItsAlphabet()
    {
        // TODO: Implement method.
    }

    @Test
    public void toString_WillOutputAPalindromeOfAlphabeticCharactersUpToTheAlphabetLastCharacter_GivenATargetCharacterWasNotProvided() {
        // WHEN
        Diamond diamond = new Diamond(alphabet);

        // THEN // TODO: Replace with property-based test that "middle row" character is the alphabet's last character.
        assertThat("FEDCBA F", equalTo(diamond.toString()));
    }

    @Test
    public void toString_WillOutputAPalindromeOfAlphabeticCharactersUpToTheTargetCharacter_GivenAnyTargetCharacterProvided() {
        // WHEN
        Diamond diamond = new Diamond(alphabet, 'C');

        // THEN // TODO: Replace with property-based test that "middle row" character is the target character.
        assertThat("CBA C", equalTo(diamond.toString()));
    }
}
