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

class Diamond
{
    private $alphabet;

    private $output = [];

    public function __construct(Alphabet $alphabet, String $letter)
    {
        if (!(ctype_alpha($letter) && strlen($letter) === 1)) {
            throw new \InvalidArgumentException(
                'Invalid input. Please enter one English alphabetical letter.'
            );
        }

        $this->alphabet = $alphabet;

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

    private function addRow(int $vIndex, int $firstOccurrence, int $letterIndex): void
    {
        $lastOccurrence = $vIndex + $letterIndex;

        for ($hIndex = 0; $hIndex <= $lastOccurrence; ++$hIndex) {
            if ($hIndex == $firstOccurrence || $hIndex == $lastOccurrence) {
                $this->output[] = $this->alphabet->letterAt($vIndex);
            } else {
                $this->output[] = '-';
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
