<?php
//Napisz program, który pobierze od użytkownika dwa napisy (rozdzielone znakiem spacji)
// napis1 i napis2, a następnie wyświetli następujący tekst:
//“%napis2 napis1%$#”

$bokuNoHero = "Plus Ultra";
echo("String before change: ".$bokuNoHero."<br>"."<br>");
$heroes = explode(" ", $bokuNoHero);

echo("%".$heroes[1]." ".$heroes[0]."%$#");

?>