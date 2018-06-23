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
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class DiamondTest {
    private Alphabet alphabet;

    @Before
    public void setUp() {
        alphabet = mock(Alphabet.class);

        when(alphabet.characterAt(anyInt())).thenAnswer((Answer<Character>) invocationOnMock -> {
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
        });

        when(alphabet.indexOf(anyChar())).thenAnswer((Answer<Integer>) invocationOnMock -> {
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
                    throw new IllegalArgumentException();
            }
        });

        when(alphabet.lastCharacter()).thenReturn('F');
    }

    @Test
    public void initialisation_WillWork_GivenOnlyAnAlphabet() {
        // WHEN
        Diamond diamond = new Diamond(alphabet);

        // THEN
        assertThat(diamond, instanceOf(Diamond.class));
    }

    @Test
    public void initialisation_WillWork_GivenAnAlphabetAndACharacter() {
        // WHEN
        Diamond diamond = new Diamond(alphabet, 'C');

        // THEN
        assertThat(diamond, instanceOf(Diamond.class));
    }

    @Test
    public void toString_WillOutputADiamondWithAnOddNumberOfRows_GivenAnyTargetCharacterInItsAlphabet() {
        // GIVEN
        Random randomNumberGenerator = new Random();
        Character randomCharacter = alphabet.characterAt(randomNumberGenerator.nextInt(5));
        Diamond diamond = new Diamond(alphabet, randomCharacter);

        // WHEN
        ArrayList<String> renderedRows = new ArrayList<>();
        Collections.addAll(renderedRows, diamond.toString().split("\n"));

        // THEN
        assertThat(renderedRows.size() % 2, equalTo(1));
    }

    @Test
    public void toString_WillOutputADiamondThatIsAsWideAsItIsHigh_GivenAnyTargetCharacterInItsAlphabet() {
        // GIVEN
        Random randomNumberGenerator = new Random();
        Character randomCharacter = alphabet.characterAt(randomNumberGenerator.nextInt(5));
        Diamond diamond = new Diamond(alphabet, randomCharacter);

        // WHEN
        ArrayList<String> renderedRows = new ArrayList<>();
        Collections.addAll(renderedRows, diamond.toString().split("\n"));
        String centerRow = renderedRows.get(renderedRows.size() / 2);

        // THEN
        assertThat(centerRow.length(), equalTo(renderedRows.size()));
    }

    @Test
    public void toString_WillOutputAHorizontallySymmetricDiamond_GivenAnyTargetCharacterInItsAlphabet() {
        // GIVEN
        Random randomNumberGenerator = new Random();
        Character randomCharacter = alphabet.characterAt(randomNumberGenerator.nextInt(5));
        Diamond diamond = new Diamond(alphabet, randomCharacter);

        // WHEN
        ArrayList<String> renderedRows = new ArrayList<>();
        Collections.addAll(renderedRows, diamond.toString().split("\n"));
        int previousRowIndex, nextRowIndex;
        previousRowIndex = nextRowIndex = renderedRows.size() / 2;

        // THEN
        do {
            assertThat(renderedRows.get(previousRowIndex), equalTo(renderedRows.get(nextRowIndex)));

            --previousRowIndex;
            ++nextRowIndex;
        } while (previousRowIndex > 0);
    }

    @Test
    public void toString_WillOutputAVerticallySymmetricDiamond_GivenAnyTargetCharacterInItsAlphabet() {
        // GIVEN
        Random randomNumberGenerator = new Random();
        Character randomCharacter = alphabet.characterAt(randomNumberGenerator.nextInt(5));
        Diamond diamond = new Diamond(alphabet, randomCharacter);

        // WHEN
        ArrayList<String> renderedRows = new ArrayList<>();
        Collections.addAll(renderedRows, diamond.toString().split("\n"));
        ArrayList<ArrayList<String>> transposedDiamondRendering = transposeDiamondRendering(renderedRows);

        int previousRowIndex, nextRowIndex;

        previousRowIndex = nextRowIndex = transposedDiamondRendering.size() / 2;

        // THEN
        do {
            assertThat(renderedRows.get(previousRowIndex), equalTo(renderedRows.get(nextRowIndex)));

            --previousRowIndex;
            ++nextRowIndex;
        } while (previousRowIndex > 0);
    }

    @Test
    public void toString_WillOutputAPyramidOfCharactersUpToTheAlphabetLastCharacter_GivenATargetCharacterWasNotProvided() {
        // GIVEN
        Diamond diamond = new Diamond(alphabet);

        // WHEN
        ArrayList<String> renderedRows = new ArrayList<>();
        Collections.addAll(renderedRows, diamond.toString().split("\n"));
        String centerRow = renderedRows.get(renderedRows.size() / 2);

        // THEN
        assertThat(centerRow, equalTo("F         F"));
    }

    @Test
    public void toString_WillOutputAPyramidOfCharactersInOrderUpToTheTargetCharacter_GivenAnyTargetCharacterProvided() {
        // GIVEN
        Random randomNumberGenerator = new Random();
        Character randomCharacter = alphabet.characterAt(randomNumberGenerator.nextInt(5));
        Diamond diamond = new Diamond(alphabet, randomCharacter);

        // WHEN
        ArrayList<String> renderedRows = new ArrayList<>();
        Collections.addAll(renderedRows, diamond.toString().split("\n"));

        // THEN
        int index = 0;
        while (index <= renderedRows.size() / 2) {
            char expectedCharacter = alphabet.characterAt(index);
            assertTrue(renderedRows.get(index).matches("^(\\s*" + expectedCharacter + "){1,2}$"));
            ++index;
        }
    }

    private ArrayList<ArrayList<String>> transposeDiamondRendering(ArrayList<String> renderedRows) {
        ArrayList<ArrayList<String>> splitRows = new ArrayList<>();

        for (String renderedRow : renderedRows) {
            ArrayList<String> splitRow = new ArrayList<>();
            Collections.addAll(splitRow, renderedRow.split(""));
            splitRows.add(splitRow);
        }

        ArrayList<ArrayList<String>> transposedDiamond = new ArrayList<>();

        for (int row = 0; row < splitRows.size(); ++row) {
            ArrayList<String> transposedDiamondColumn = new ArrayList<>();
            for (int column = 0; column < splitRows.get(row).size(); ++column) {
                if (splitRows.get(column).size() > row && !splitRows.get(column).get(row).matches("\\s+")) {
                    transposedDiamondColumn.add(splitRows.get(column).get(row));
                }
            }

            transposedDiamond.add(transposedDiamondColumn);
        }

        return transposedDiamond;
    }
}
