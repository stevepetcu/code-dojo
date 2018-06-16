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

class AlphabeticDiamond
{
    private $alphabet;

    private $output = [];

    private $fillerCharacter;

    public function __construct(Alphabet $alphabet, string $letter, string $fillerCharacter = ' ')
    {
        $this->validateInput($letter, $fillerCharacter);

        $this->alphabet = $alphabet;
        $this->fillerCharacter = $fillerCharacter;

        $vIndex = 0;
        $letterIndex = $firstOccurrence = $alphabet->letterIndex($letter);

        while ($vIndex <= $letterIndex) {
            $this->addRow($vIndex, $firstOccurrence, $letterIndex);

            --$firstOccurrence;
            ++$vIndex;
        }

        $vIndex -= 2;
        $firstOccurrence = 1;

        while ($vIndex >= 0) {
            $this->addRow($vIndex, $firstOccurrence, $letterIndex);

            ++$firstOccurrence;
            --$vIndex;
        }
    }

    private function validateInput(string $letter, string $fillerCharacter): void
    {
        if (!preg_match('/^[A-Za-z]$/', $letter)) {
            throw new \InvalidArgumentException(
                'Invalid input. Please enter one English alphabetical letter.'
            );
        }

        if (!preg_match('/^\W$/', $fillerCharacter)) {
            throw new \InvalidArgumentException(
                'Invalid input. Please enter one non-word character as filler.'
            );
        }
    }

    private function addRow(int $vIndex, int $firstOccurrence, int $letterIndex): void
    {
        $lastOccurrence = $vIndex + $letterIndex;

        for ($hIndex = 0; $hIndex <= $lastOccurrence; ++$hIndex) {
            if ($hIndex == $firstOccurrence || $hIndex == $lastOccurrence) {
                $this->output[] = $this->alphabet->letterAt($vIndex);
            } else {
                $this->output[] = $this->fillerCharacter;
            }
        }

        $this->output[] = "\n";
    }

    public function __toString(): string
    {
        array_pop($this->output); // Remove last newline. TODO: find a more elegant solution to avoid this.

        return implode($this->output);
    }
}
