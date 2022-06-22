<?php
//Napisz program, który pobierze trzy liczby rzeczywiste, 
//a następnie wyświetli je w kolejności od najmniejszej do największej,
//a potem od największej do najmniejszej.
$randomMinRange = -99.99;
$randomMaxRange = 99.99;
$randomMixingValue = 100;

$firstNumber = mt_rand($randomMinRange*$randomMixingValue,$randomMaxRange*$randomMixingValue)/$randomMixingValue;
$secondNumber = mt_rand($randomMinRange*$randomMixingValue,$randomMaxRange*$randomMixingValue)/$randomMixingValue;
$thirdNumber = mt_rand($randomMinRange*$randomMixingValue,$randomMaxRange*$randomMixingValue)/$randomMixingValue;

$numberArray = array($firstNumber,$secondNumber,$thirdNumber);
echo("Unsorted array"."<br>");
print_r($numberArray);
echo("<br>");
echo("<br>");


//Sorting ascending
for($i=0; $i<count($numberArray);$i++){
		for($j=0; $j<count($numberArray)-1; $j++) {
			if($numberArray[$j] > $numberArray[$j+1]){
				$temporary = $numberArray[$j+1];
				$numberArray[$j+1] = $numberArray[$j];
				$numberArray[$j] = $temporary;
			}
		}
}
echo("Sorted ascending list with for loop"."<br>");
print_r($numberArray);
echo("<br>");


//Sorting descending
for($i=0; $i<count($numberArray);$i++){
		for($j=0; $j<count($numberArray)-1; $j++) {
			if($numberArray[$j] < $numberArray[$j+1]){
				$temporary = $numberArray[$j+1];
				$numberArray[$j+1] = $numberArray[$j];
				$numberArray[$j] = $temporary;
			}
		}
}
echo("<br>");
echo("Sorted descending list with for loop"."<br>");
print_r($numberArray);



?>