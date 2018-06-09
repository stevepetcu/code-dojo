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

use PHPUnit\Framework\TestCase;

class AlphabetTest extends TestCase
{
    public function testAlphabetOnlyContainsUniqueCharacters()
    {
        $this->markTestIncomplete('Add code.');
    }

    /** @depends testAlphabetOnlyContainsUniqueCharacters */
    public function testLetterAtWithValidIntegerReturnsLetterAtGivenPosition()
    {
        $this->markTestIncomplete('Add code.');
    }

    /** @depends testAlphabetOnlyContainsUniqueCharacters */
    public function testLetterAtWithOutOfBoundsIntegerThrowsException()
    {
        $this->markTestIncomplete('Add code.');
    }

    /** @depends testAlphabetOnlyContainsUniqueCharacters */
    public function testLetterIndexWithValidCharacterReturnsIndexOfLetter()
    {
        $this->markTestIncomplete('Add code.');
    }

    /** @depends testAlphabetOnlyContainsUniqueCharacters */
    public function testLetterIndexWithOutOfBoundsCharacterThrowsException()
    {
        $this->markTestIncomplete('Add code.');
    }
}
