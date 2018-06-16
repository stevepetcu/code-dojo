<?php declare(strict_types=1);

/*
 * This file is part of the DiamondKata application.
 *
 * © Stefan Petcu <hello@stefanpetcu.com>
 *
 * For the full copyright and license information, please view
 * the LICENSE file that was distributed with this source code.
 */

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
