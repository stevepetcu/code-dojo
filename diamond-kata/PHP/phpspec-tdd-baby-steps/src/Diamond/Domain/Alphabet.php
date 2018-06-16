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
        return array_search($character, $this->characterSet);
    }
}
