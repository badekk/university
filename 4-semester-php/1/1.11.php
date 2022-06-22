<?php
//Pangramem nazywamy tekst, w którym każda litera alfabetu łacińskiego występuje przy najmniej raz.
//Najpopularniejszym pangramem w języku angielskim jest zdanie: The quick brown fox jumps over the lazy dog.
//Napisz program, który sprawdzi czy dany tekst jest pangramem.
//W przypadku pozytywnej odpowiedzi program powinien wyświetlić wartość true, w przeciwnym przypadku program powinien wyrzucić wartość false.
//Rozważ różne przypadki i wielkość liter (która nie powinna mieć znaczenia)!!!

function isPanagram(string $textToCheck) {
	
	$testCaseString = str_split("abcdefghijklmnopqrstuvwxyz");
	$toCheckFormated = strtolower(trim($textToCheck," \n\r\t\v\0"));
	$isPanagram = "true";
	
	foreach ($testCaseString as $character) {
		if (!strstr($toCheckFormated, $character)) {
			$isPanagram = "false";
			break;
		}
	}
	 echo("<br>'$textToCheck' Panagram: is $isPanagram <br>");
}



isPanagram("thequickbrownfoxjumpsoverthelazydog");
isPanagram("The quick brown fox jumps over the lazy dog.");
isPanagram("Ptaki latajo kluczem");
isPanagram("Sphinx of black quartz, judge my vow.");
isPanagram("The five boxing wizards jump quickly.");
isPanagram("BokuNoHeroAcademia PLUS ULTRAAA!");

?>