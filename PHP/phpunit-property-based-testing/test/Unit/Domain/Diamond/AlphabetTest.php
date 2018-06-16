<?php declare(strict_types=1);

/*
 * This file is part of the DiamondKata application.
 *
 * © Stefan Petcu <hello@stefanpetcu.com>
 *
 * For the full copyright and license information, please view
 * the LICENSE file that was distributed with this source code.
 */

namespace Test\Diamond\Domain;

use DiamondKata\Diamond\Domain\Alphabet;
use PHPUnit\Framework\TestCase;

class AlphabetTest extends TestCase
{
    /** @var Alphabet */
    private $alphabet;

    /** @var array */
    private $characterSet;

    public function setUp()
    {
        parent::setUp();

        $this->characterSet = ['a', 'B', 'c'];

        $this->alphabet = new Alphabet($this->characterSet);
    }

    public function testAlphabetNormalisesAllArgumentsByCapitalisingLetters()
    {
        foreach ($this->characterSet as $character) {
            $failMessage = 'Alphabet should contain character "' . strtoupper($character) . '".';
            try {
                $this->assertTrue(
                    is_int($this->alphabet->letterIndex($character)),
                    $failMessage
                );
            } catch (\OutOfBoundsException $exception) {
                $this->fail($failMessage);
            }
        }
    }

    /** @depends testAlphabetNormalisesAllArgumentsByCapitalisingLetters */
    public function testAlphabetOnlyKeepsUniqueLettersWhenInstantiated()
    {
        $redundantCharacterSet = [
            'a',
            'b',
            'b',
            'a',
            'a',
            'k',
            'k',
            'a'
        ];

        $alphabet = new Alphabet($redundantCharacterSet);

        $this->assertEquals
        (
            0,
            $alphabet->letterIndex('a'),
            'Expected to find letter "A" at index 0.'
        );
        $this->assertEquals
        (
            1,
            $alphabet->letterIndex('b'),
            'Expected to find letter "B" at index 1.'
        );
        $this->assertEquals
        (
            2,
            $alphabet->letterIndex('k'),
            'Expected to find letter "C" at index 2.'
        );

        $this->expectException(\OutOfBoundsException::class);
        $this->expectExceptionMessage('Requested index 3 not in the alphabet.');

        $alphabet->letterAt(3);
    }

    /** @depends testAlphabetNormalisesAllArgumentsByCapitalisingLetters */
    public function testLetterAtWithValidIntegerReturnsLetterAtGivenPosition()
    {
        $this->assertEquals(
            'C',
            $this->alphabet->letterAt(2),
            'Expected to find letter "C" at index 2 in the alphabet.'
        );
    }

    /** @depends testAlphabetNormalisesAllArgumentsByCapitalisingLetters */
    public function testLetterIndexWithValidCharacterReturnsIndexOfLetter()
    {
        $this->assertEquals(
            1,
            $this->alphabet->letterIndex('B'),
            'Expected index 2 for character "B".'
        );
    }

    /** @depends testAlphabetNormalisesAllArgumentsByCapitalisingLetters */
    public function testLetterIndexWithOutOfBoundsCharacterThrowsException()
    {
        $this->expectException(\OutOfBoundsException::class);
        $this->expectExceptionMessage("The specified value 'Z' is not a character of this alphabet.");

        $this->alphabet->letterIndex('z');
    }
}
