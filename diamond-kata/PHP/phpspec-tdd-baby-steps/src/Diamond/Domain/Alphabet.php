<?php declare(strict_types=1);

/*
 * This file is part of the DiamondKata application.
 *
 * © Stefan Petcu <hello@stefanpetcu.com>
 *
 * For the full copyright and license information, please view
 * the LICENSE file that was distributed with this source code.
 */

namespace DiamondKata\Diamond\Domain;

class Alphabet
{
    private $characterSet;

    public function __construct(array $characterSet)
    {
        $this->characterSet = array_map(
            function (string $character) {
                return strtoupper($character);
            },
            array_values(array_unique($characterSet))
        );
    }

    /**
     * @throws \OutOfBoundsException when the requested character is not in the alphabet.
     */
    public function indexOf(string $character): int
    {
        $character = strtoupper($character);

        $index = array_search($character, $this->characterSet);

        if (!is_int($index)) {
            throw new \OutOfBoundsException("Character $character is not in the alphabet.");
        }

        return $index;
    }

    /**
     * @throws \OutOfBoundsException when the requested character index is not in the alphabet.
     */
    public function characterAt(int $index): string
    {
        if (!isset($this->characterSet[$index])) {
            throw new \OutOfBoundsException("Index $index is invalid for this alphabet.");
        }

        return $this->characterSet[$index];
    }
}
