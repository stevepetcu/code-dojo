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

use DiamondKata\Diamond\Domain\Alphabet;
use DiamondKata\Diamond\Domain\AlphabeticDiamond;
use PhpSpec\ObjectBehavior;

class AlphabeticDiamondSpec extends ObjectBehavior
{
    function let(Alphabet $alphabet)
    {
        $alphabet->characterAt(0)->willReturn('A');
        $alphabet->characterAt(1)->willReturn('B');
        $alphabet->characterAt(2)->willReturn('C');

        $alphabet->indexOf('A')->willReturn(0);
        $alphabet->indexOf('B')->willReturn(1);
        $alphabet->indexOf('C')->willReturn(2);
    }

    function it_is_instantiable($alphabet)
    {
        $this->beConstructedWith($alphabet, 'C');

        $this->shouldHaveType(AlphabeticDiamond::class);
    }

    function it_can_output_a_diamond($alphabet)
    {
        $this->beConstructedWith($alphabet, 'C');

        $expectedOutput = "  A\n B B\nC   C\n B B\n  A";

        $this->__toString()->shouldBe($expectedOutput);
    }

    function it_correctly_handles_edge_cases_pass_in_first_character_of_alphabet($alphabet)
    {
        $this->beConstructedWith($alphabet, 'A');

        $this->__toString()->shouldBe('A');
    }

    function it_will_throw_invalid_argument_exception_if_2nd_constructor_argument_is_not_an_english_letter($alphabet)
    {
        $this
            ->shouldThrow(new \InvalidArgumentException('Invalid input. Please enter one English letter.'))
            ->during('__construct', [$alphabet, '1']);
    }
}
