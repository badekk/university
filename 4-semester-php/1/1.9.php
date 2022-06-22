<?php
//Napisz program, który zadeklaruje dwie tablice typu int, 
//następnie wczyta liczby naturalne i wczyta do pierwszej tablicy liczb,
//następnie wczyta liczb do drugiej tablicy (wcześniej trzeba te tablice utworzyć), 
//a następnie wykona iloczyn skalarny tych tablic zgodnie ze wzorem:

//Zastanów się, co w przypadku gdy n<m lub m<n.
//W przypadku podania jakikolwiek błędnych danych program wypisuje komunikat BŁĄD, a następnie kończy działanie.
$doLoop = true;
while($doLoop){
	$firstTableLength = 5;
	$secondTableLength = 5;
	if(is_numeric($firstTableLength) && is_numeric($secondTableLength))
		$differenceLength = abs($firstTableLength - $secondTableLength);
	else { 
		echo("Błąd/Error/Erreur/Fehler/erro/fel");
		$doLoop = false;
		break;
	}

	$firstTable = [];
	$secondTable = [];

	for($i=0;$i<$firstTableLength;$i++) {
		$firstTable[$i] = rand(1,10);
	}
	for($i=0;$i<$secondTableLength;$i++) {
		$secondTable[$i] = rand(1,10);
	}

	$sumOfScalar = 0;

	if($differenceLength == 0) {
		for($i=0; $i<$firstTableLength;$i++) {
			for($j=0; $j<$secondTableLength; $j++) {
			echo("Table1[".$i."]: ".$firstTable[$i]. ". Table2[".$i."]: ".$secondTable[$j]."<br>");
			$sumOfScalar += $firstTable[$i]*$secondTable[$i];
			}
		} 
	}
	else if ($differenceLength >= 1) 
		echo("Tables should be equal!!<br>");
	else {
		echo("Błąd/Error/Erreur/Fehler/erro/fel");
		$doLoop = false;
		break;
	}

	echo("Result of scalar product: ". $sumOfScalar);
	$doLoop = false;
}
?>