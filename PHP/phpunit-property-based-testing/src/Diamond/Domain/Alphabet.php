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
    private $alphabet;

    public function __construct(array $alphabet)
    {
        $this->alphabet = array_map(
            function ($letter) {
                return strtoupper($letter);
            },
            array_values(
                array_unique($alphabet)
            )
        );
    }

    /**
     * @throws \OutOfBoundsException when the letter index was not found in the alphabet.
     */
    public function letterAt(int $index): string
    {
        if (!isset($this->alphabet[$index])) {
            throw new \OutOfBoundsException("Requested index $index not in the alphabet.");
        }

        return $this->alphabet[$index];
    }

    /**
     * @throws \OutOfBoundsException when the letter was not found in the alphabet.
     */
    public function letterIndex(string $letter): int
    {
        $letter = strtoupper($letter);

        $letterIndex = array_search($letter, $this->alphabet, true);

        if (!is_int($letterIndex)) {
            throw new \OutOfBoundsException("The specified value '$letter' is not a character of this alphabet.");
        }

        return $letterIndex;
    }
}
