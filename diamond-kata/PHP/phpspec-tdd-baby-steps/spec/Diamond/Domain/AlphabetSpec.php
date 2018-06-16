<?php

namespace spec\DiamondKata\Diamond\Domain;

use DiamondKata\Diamond\Domain\Alphabet;
use PhpSpec\ObjectBehavior;

class AlphabetSpec extends ObjectBehavior
{
    function let()
    {
        $this->beConstructedWith(['a', 'b', 'c', 'd', 'e', 'f', 'g']);
    }

    function it_is_instantiable()
    {
        $this->shouldHaveType(Alphabet::class);
    }

    function it_can_return_the_index_of_a_character()
    {
        $this->indexOf('d')->shouldBe(3);
    }

    function it_can_return_the_character_at_a_specified_index()
    {
        $this->characterAt(3)->shouldBe('d');
    }
}
