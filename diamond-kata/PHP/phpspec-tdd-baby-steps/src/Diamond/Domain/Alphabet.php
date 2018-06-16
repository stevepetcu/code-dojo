<?php

namespace DiamondKata\Diamond\Domain;

class Alphabet
{
    private $characterSet;

    public function __construct(array $characterSet)
    {
        $this->characterSet = $characterSet;
    }

    public function indexOf(string $character): int
    {
        $index = array_search($character, $this->characterSet);

        if (!is_int($index)) {
            throw new \OutOfBoundsException("Character $character is not in the alphabet.");
        }

        return $index;
    }

    public function characterAt(int $index): string
    {
        if (!isset($this->characterSet[$index])) {
            throw new \OutOfBoundsException("Index $index is invalid for this alphabet.");
        }

        return $this->characterSet[$index];
    }
}
