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

    public function __construct(array $alphabet, string $letter)
    {
        $this->alphabet = $alphabet;
        $this->letter = $letter;
    }

    public function __toString(): string
    {
        $letterPosition = array_search($this->letter, $this->alphabet);

        $firstOccurrence = $lastOccurrence = $letterPosition;

        $output = [];

        $verticalPosition = 0;

        while ($verticalPosition <= $letterPosition) {
            for ($horizontalPosition = 0; $horizontalPosition <= $lastOccurrence; ++$horizontalPosition) {
                if ($horizontalPosition == $firstOccurrence || $horizontalPosition == $lastOccurrence) {
                    $output[] = $this->alphabet[$verticalPosition];
                } else {
                    $output[] = ' ';
                }
            }

            ++$verticalPosition;
            ++$lastOccurrence;
            --$firstOccurrence;

            $output[] = "\n";
        }

        --$verticalPosition;
        --$lastOccurrence;
        ++$firstOccurrence;

        while ($verticalPosition > 0) {

            --$verticalPosition;
            --$lastOccurrence;
            ++$firstOccurrence;

            for ($horizontalPosition = 0; $horizontalPosition <= $lastOccurrence; ++$horizontalPosition) {
                if ($horizontalPosition == $firstOccurrence || $horizontalPosition == $lastOccurrence) {
                    $output[] = $this->alphabet[$verticalPosition];
                } else {
                    $output[] = ' ';
                }
            }

            $output[] = "\n";
        }

        return implode($output);
    }
}
