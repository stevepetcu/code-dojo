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

    function it_can_return_the_index_of_a_character_in_a_case_insensitive_way()
    {
        $this->indexOf('a')->shouldBe(0);
        $this->indexOf('D')->shouldBe(3);
        $this->indexOf('G')->shouldBe(6);
    }

    function it_can_return_the_normalised_character_at_a_specified_index()
    {
        $this->characterAt(0)->shouldBe('A');
        $this->characterAt(3)->shouldBe('D');
        $this->characterAt(6)->shouldBe('G');
    }

    function it_should_throw_out_of_bounds_exception_when_requesting_a_character_not_in_the_alphabet()
    {
        $this
            ->shouldThrow(new \OutOfBoundsException('Character Z is not in the alphabet.'))
            ->during('indexOf', ['Z']);
    }

    function it_should_throw_out_of_bounds_exception_when_requesting_an_out_of_bounds_index()
    {
        $this
            ->shouldThrow(new \OutOfBoundsException('Index -1 is invalid for this alphabet.'))
            ->during('characterAt', [-1]);

        $this
            ->shouldThrow(new \OutOfBoundsException('Index 7 is invalid for this alphabet.'))
            ->during('characterAt', [7]);
    }

    function it_should_normalise_its_input_character_set_to_all_uppercase_and_only_unique_characters()
    {
        $this->beConstructedWith(['a', 'b', 'b', 'a', 'a', 'k', 'k', 'a']);

        $this
            ->shouldThrow(new \OutOfBoundsException('Index 3 is invalid for this alphabet.'))
            ->during('characterAt', [3]);

        $this->characterAt(0)->shouldBe('A');
        $this->characterAt(1)->shouldBe('B');
        $this->characterAt(2)->shouldBe('K');
    }
}
