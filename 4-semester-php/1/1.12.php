<?php
//Napisz program, który będzie miał utworzoną statycznie tablicę dwuwymiarową o wymiarach AxB.
//Następnie program ma pobrać od użytkownika liczby
//A i B, które mają oznaczać ilość wierszy oraz kolumn tablicy.
//Następnie ma pobrać AxB liczb i wypisać transpozycję tej macierzy (patrz poniższy test).
//Transpozycja oznacza, że wypisujemy najpierw kolumny, a potem wiersze danej macierzy.
//W przypadku sytuacji błędnych program ma wypisać komunikat: BŁĄD i zakończyć działanie.

//function transposeMatrix (int $rows, int $columns) {
	
	$rows = 6;
	$columns = 2;
	
	if(!is_numeric($rows) || !is_numeric($columns)){
		echo("Błąd/Error/Erreur/Fehler/erro/fel");
		return ;
	}
	
	$matrixArray = array(array());
	
	for($i=0;$i<$rows;$i++) {
		for($j=0;$j<$columns;$j++) {
			$matrixArray[$i][$j] = rand(1,100);
		}
	}	
	
	echo("Before Transposition<br>");
	for($i=0;$i<$rows;$i++) {
		for($j=0;$j<$columns;$j++) {
			echo($matrixArray[$i][$j]." ");
		}
		echo("<br>");
	}
	
	echo("<br>After Transposition<br>");
	for($i=0;$i<$columns;$i++) {
		for($j=0;$j<$rows;$j++) {
			echo($matrixArray[$j][$i]." ");
		}
		echo("<br>");
	//}
}

//transposeMatrix(6,2);


?>