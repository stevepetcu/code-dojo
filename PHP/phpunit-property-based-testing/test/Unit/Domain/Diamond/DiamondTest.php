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
use DiamondKata\Diamond\Domain\Diamond;
use PHPUnit\Framework\MockObject\MockObject;
use PHPUnit\Framework\TestCase;

class DiamondTest extends TestCase
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

    private $letterIndex = 0;

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
    }

    public function testMaximumWidthAndHeightOfDiamondAlwaysEqualDoubleTheGivenLetterIndexPlusOne()
    {
        $diamond = new Diamond(
            $this->mockAlphabet,
            static::BATPHABELT[$this->letterIndex]
        );

        $diamondStringRows = explode("\n", $diamond->__toString());

        $maxDiagonalLength = 2 * $this->letterIndex + 1;

        $this->assertEquals(
            $maxDiagonalLength,
            strlen($diamondStringRows[$this->letterIndex]),
            "The diamond should be $maxDiagonalLength characters in width at its widest point."
        );

        $this->assertEquals(
            $maxDiagonalLength,
            count($diamondStringRows),
            "The diamond should be {$this->letterIndex} characters in height."
        );
    }

    /** @depends testMaximumWidthAndHeightOfDiamondAlwaysEqualDoubleTheGivenLetterIndexPlusOne */
    public function testDiamondStartsAndEndsWithFirstLetterOfTheAlphabet()
    {
        $this->markTestIncomplete('Add code.');
    }

    /** @depends testMaximumWidthAndHeightOfDiamondAlwaysEqualDoubleTheGivenLetterIndexPlusOne */
    public function testWidestDiamondLineContainsOnlyTheGivenLetterAsTheFirstAndLastCharacter()
    {
        $this->markTestIncomplete('Add code.');
    }
}
