<?php
//1.2 Napisz program, 
//który oblicza pole prostokąta o bokach a i b wprowadzanych przez użytkownika 
//(każda wartość w osobnej linii).

//$a = readline("Please enter rectangle's first side: ");
//$b = readline("Please enter rectangle's second side: ");

$a = rand(1,1000);
$b = rand(1,1000);
$result = $a*$b;
echo("Area of rectangle with sides:<br> a=" .$a . "<br>b=".$b."<br> Area=".$result);

?>