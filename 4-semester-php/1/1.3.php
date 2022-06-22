<?php
//1.3 Napisz program, który wyświetla na ekranie komputera 
//pierwiastek kwadratowy z wartości PI z dokładnością do dwóch miejsc po przecinku.
// Wskazówka: Skorzystaj z funkcji pi() oraz sqrt(). W programie wypisz tylko wartość.

$piValue = pi();
$result = round(sqrt($piValue),2);
echo("Sqrt of PI to 2 decimal points is " . $result . "<br>");
echo(M_SQRTPI);




?>