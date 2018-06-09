<?php declare(strict_types=1);

use DiamondKata\Diamond\Domain\Alphabet;
use DiamondKata\Diamond\Domain\Diamond;

require __DIR__ . "/../vendor/autoload.php";

$letter = readline('Please enter a letter: ');

$alphabet = new Alphabet(require __DIR__ . '/../config/bootstrap.php');

echo new Diamond($alphabet, $letter) . "\n";
