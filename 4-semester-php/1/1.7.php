<?php
//Napisz program, który dla podanej liczby z odpowiedniego zakresu wyświetli jaki to miesiąc i ile ma on dni.
//Zakładamy, że rok tutaj nie jest przestępny.
//W przypadku niepoprawnych danych program ma wypisać komunikat: BŁĄD

$monthValue = rand(1,15);
echo("Month Value =".$monthValue."<br>");
switch($monthValue) {
	case 1: echo("Januray: 31 days"); break;
	case 2: echo("February: 28 days"); break;
	case 3: echo("March: 31 days"); break;
	case 4: echo("April: 30 days"); break;
	case 5: echo("May: 31 days"); break;
	case 6: echo("June: 30 days"); break;
	case 7: echo("July: 31 days"); break;
	case 8: echo("August: 31 days"); break;
	case 9: echo("September: 30 days"); break;
	case 10: echo("October: 31 days"); break;
	case 11: echo("November: 30 days"); break;
	case 12: echo("December: 31 days"); break;
	default: echo("Błąd/Error/Erreur/Fehler/erro/fel");
	
}

?>