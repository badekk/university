<?php
//1.4 Napisz program, który pobierze dwie liczby naturalne
// i poda ich wynik dodawania, odejmowania, mnożenia, dzielenia modulo.

$firstNumber = rand(1,1000);
$secondNumber = rand(1,1000);

echo("First number: " . $firstNumber . "<br>");
echo("Second number: " . $secondNumber . "<br>" . "<br>");

echo("Addition: " . $firstNumber+$secondNumber . "<br>");
echo("Subtraction: " . $firstNumber-$secondNumber . "<br>");
echo("Multiplication: " . $firstNumber*$secondNumber . "<br>");
echo("Division: " . $firstNumber/$secondNumber . "<br>");
echo("Modulo: " . $firstNumber%$secondNumber . "<br>" . "<br>");

echo("Press F5 to refresh page to get other results (numbers are random from 1-1000 range)");
?>
