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

    private $letter;

    private $rendering = [];

    public function __construct(Alphabet $alphabet, string $letter)
    {
        if (!preg_match('/^[A-Za-z]$/', $letter)) {
            throw new \InvalidArgumentException('Invalid input. Please enter one English letter.');
        }

        $this->alphabet = $alphabet;
        $this->letter = $letter;

        $letterPosition = $this->alphabet->indexOf($letter);

        $firstOccurrence = $lastOccurrence = $letterPosition;

        [
            'verticalPosition' => $verticalPosition,
            'firstOccurrence' => $firstOccurrence,
            'lastOccurrence' => $lastOccurrence
        ] = $this->buildTopHalf($letterPosition, $firstOccurrence, $lastOccurrence);

        $this->buildBottomHalf($verticalPosition, $firstOccurrence, $lastOccurrence);
    }

    public function __toString(): string
    {
        return implode($this->rendering);
    }

    private function buildTopHalf(int $letterPosition, int $firstOccurrence, int $lastOccurrence): array
    {
        $verticalPosition = 0;

        while ($verticalPosition <= $letterPosition) {
            $this->buildRow($verticalPosition, $firstOccurrence, $lastOccurrence);

            if ($verticalPosition == $letterPosition) {
                break;
            }

            ++$verticalPosition;
            ++$lastOccurrence;
            --$firstOccurrence;

            $this->rendering[] = "\n";
        }

        return compact('verticalPosition', 'firstOccurrence', 'lastOccurrence');
    }

    private function buildBottomHalf(int $verticalPosition, int $firstOccurrence, int $lastOccurrence): void
    {
        while ($verticalPosition > 0) {
            $this->rendering[] = "\n";

            --$verticalPosition;
            --$lastOccurrence;
            ++$firstOccurrence;

            $this->buildRow($verticalPosition, $firstOccurrence, $lastOccurrence);
        }
    }

    private function buildRow(int $verticalPosition, int $firstOccurrence, int $lastOccurrence)
    {
        for ($horizontalPosition = 0; $horizontalPosition <= $lastOccurrence; ++$horizontalPosition) {
            if ($horizontalPosition == $firstOccurrence || $horizontalPosition == $lastOccurrence) {
                $this->rendering[] = $this->alphabet->characterAt($verticalPosition);
            } else {
                $this->rendering[] = ' ';
            }
        }
    }
}
