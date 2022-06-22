<?php
//Napisz program, który dla trzech boków podanych przez użytkownika stwierdzi czy da się z tych boków zbudować trójkąt.
//Trójkąt da się zbudować z boków wtedy i tylko wtedy gdy zachodzą następujące warunki: a+b>c, a+c>b, b+c>a.
//W przypadku wprowadzenia niepoprawnych danych program ma wyrzucić komunikat: BŁĄD

$a = rand(5,30);
$b = rand(1,20);
$c = rand(3,25);

//$a = 5;
//$b = 10;
//$c = 14;

echo("a=".$a." b=".$b." c=".$c."<br>"."<br>");
echo("Triangle is TRUE if this coditions are met (a+b)>c && (a+c)>$b && (b+c)>a"."<br>");
echo("($a+$b)>$c && ($a+$c)>$b && ($b+$c)>$a"."<br>"."<br>");

if(($a+$b)>$c && ($a+$c)>$b && ($b+$c)>$a)
		echo("Traingle is buildable");
	else 
		echo("Błąd/Error/Erreur/Fehler/erro/fel");
?>