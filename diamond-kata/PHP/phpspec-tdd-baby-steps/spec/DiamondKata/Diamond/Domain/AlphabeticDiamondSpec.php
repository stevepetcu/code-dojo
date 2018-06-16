<?php

namespace spec\DiamondKata\Diamond\Domain;

use DiamondKata\Diamond\Domain\AlphabeticDiamond;
use PhpSpec\ObjectBehavior;
use Prophecy\Argument;

class AlphabeticDiamondSpec extends ObjectBehavior
{
    function it_is_initializable()
    {
        $this->shouldHaveType(AlphabeticDiamond::class);
    }
}
