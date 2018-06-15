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
        $this->alphabet = array_unique($alphabet);
    }

    /**
     * @throws \OutOfBoundsException when the letter index was not found in the alphabet.
     */
    public function letterAt(int $index): string
    {
        if (!isset($this->alphabet[$index])) {
            throw new \OutOfBoundsException('Requested index not in the alphabet.');
        }

        return $this->alphabet[$index];
    }

    /**
     * @throws \OutOfBoundsException when the letter was not found in the alphabet.
     */
    public function letterIndex(string $letter): int
    {
        $letterIndex = array_search(strtoupper($letter), $this->alphabet, true);

        if (!is_int($letterIndex)) {
            throw new \OutOfBoundsException('The specified value is not a letter of the alphabet.');
        }

        return $letterIndex;
    }
}
