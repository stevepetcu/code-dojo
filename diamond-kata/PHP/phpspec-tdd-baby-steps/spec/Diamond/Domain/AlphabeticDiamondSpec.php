<?php

namespace spec\DiamondKata\Diamond\Domain;

use DiamondKata\Diamond\Domain\AlphabeticDiamond;
use PhpSpec\ObjectBehavior;

class AlphabeticDiamondSpec extends ObjectBehavior
{
    function let()
    {
        $this->beConstructedWith(['a', 'b', 'c'], 'b');
    }

    function it_is_instantiable()
    {
        $this->shouldHaveType(AlphabeticDiamond::class);
    }

    function it_can_output_a_letter()
    {
        $expectedOutput = " a\nb b\n a";

        $this->__toString()->shouldBe($expectedOutput);
    }
}
