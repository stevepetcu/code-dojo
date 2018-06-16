<?php declare(strict_types=1);

/**
 * This file is part of the DiamondKata application.
 *
 * © Stefan Petcu <hello@stefanpetcu.com>
 *
 * For the full copyright and license information, please view
 * the LICENSE file that was distributed with this source code.
 */

namespace Test\Unit\Diamond\Domain;

use DiamondKata\Diamond\Domain\Alphabet;
use DiamondKata\Diamond\Domain\AlphabeticDiamond;
use PHPUnit\Framework\MockObject\MockObject;
use PHPUnit\Framework\TestCase;

class AlphabeticDiamondTest extends TestCase
{
    const BATPHABELT = [
        'I',
        'M',
        'B',
        'T',
        'M',
        'A',
        'N'
    ];

    /** @var Alphabet|MockObject */
    private $mockAlphabet;

    /** @var AlphabeticDiamond */
    private $diamond;

    private $letterIndex = 0;

    private $diamondRows;

    public function setUp()
    {
        parent::setUp();

        $this->mockAlphabet = $this->createMock(Alphabet::class);

        try {
            $this->letterIndex = random_int(0, count(static::BATPHABELT) - 1);
        } catch (\Exception $exception) {
            $infoMessage = "\nThe entropy gods have not smiled upon us this time."
                . " Falling back on letterIndex: {$this->letterIndex}.";

            fwrite(STDERR, print_r($infoMessage, true));
        }

        $this
            ->mockAlphabet
            ->method('letterIndex')
            ->willReturn($this->letterIndex);

        $this
            ->mockAlphabet
            ->method('letterAt')
            ->willReturnCallback(
                function (int $index) {
                    return static::BATPHABELT[$index];
                }
            );

        $this->diamond = new AlphabeticDiamond(
            $this->mockAlphabet,
            static::BATPHABELT[$this->letterIndex],
            '-'
        );

        $this->diamondRows = explode("\n", $this->diamond->__toString());
    }

    /** @expectedException \InvalidArgumentException */
    public function testAcceptsOnlyAlphabeticalCharacters()
    {
        $this->expectException(\InvalidArgumentException::class);
        $this->expectExceptionMessage('Invalid input. Please enter one English alphabetical letter.');

        /** @var Alphabet|MockObject $alphabetMock */
        $alphabetMock = $this->createMock(Alphabet::class);

        new AlphabeticDiamond($alphabetMock, '3');
    }

    public function testAcceptsOnlyNonWordCharactersAsFillerCharacter()
    {
        $this->expectException(\InvalidArgumentException::class);
        $this->expectExceptionMessage('Invalid input. Please enter one non-word character as filler.');

        /** @var Alphabet|MockObject $alphabetMock */
        $alphabetMock = $this->createMock(Alphabet::class);

        new AlphabeticDiamond($alphabetMock, 'A', 'B');
    }

    public function testMaximumWidthAndHeightOfDiamondAlwaysEqualDoubleTheGivenLetterIndexPlusOne()
    {
        $maxDiagonalLength = 2 * $this->letterIndex + 1;

        $this->assertEquals(
            $maxDiagonalLength,
            strlen($this->diamondRows[$this->letterIndex]),
            "The diamond should be $maxDiagonalLength characters in width at its widest point."
        );

        $this->assertEquals(
            $maxDiagonalLength,
            count($this->diamondRows),
            "The diamond should be {$this->letterIndex} characters in height."
        );
    }

    /** @depends testMaximumWidthAndHeightOfDiamondAlwaysEqualDoubleTheGivenLetterIndexPlusOne */
    public function testDiamondStartsAndEndsWithFirstLetterOfItsAlphabet()
    {
        $this->assertEquals(
            'I',
            ltrim($this->diamondRows[0], '-'),
            "The diamond should start with the letter 'I'."
        );

        $this->assertEquals(
            'I',
            ltrim(end($this->diamondRows), '-'),
            "The diamond should start with the letter 'I'."
        );
    }

    /** @depends testMaximumWidthAndHeightOfDiamondAlwaysEqualDoubleTheGivenLetterIndexPlusOne */
    public function testWidestDiamondLineContainsOnlyTheGivenLetterAsTheFirstAndLastCharacter()
    {
        $this->assertEquals(
            static::BATPHABELT[$this->letterIndex] . static::BATPHABELT[$this->letterIndex],
            str_replace('-', '', $this->diamondRows[$this->letterIndex]),
            'Expected the widest diamond line to only contain the given letter '
            . $this->diamondRows[$this->letterIndex] . ' (twice) as relevant characters.'
        );
    }
}
