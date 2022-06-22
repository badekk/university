<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Zad 4 Warsztat 2</title>
    <style>
        html {
            background: #c46969;
            color: #FFF;
        }
    </style>
</head>
<body>
<h2> Prime number checker! </h2>
<form action="4 - isPrime.php" method="POST">
    <label>Please input your number: <input type="number" min='0' name="number"></label>
    <br>
    <input type="submit" name="checkNumber" value="Check">
    <br>
</form>

<?php
	if(isset($_POST['checkNumber'])){
		if (is_numeric($_POST['number']) && ($_POST['number']) > 0) {
			
			$numberToCheck = ($_POST['number']);
		} else {
			echo("<br>Please enter NATURAL numbers only!");
		}
	}
	
	function isPrimeNumber($numberToCheck) {
		// 1 is not prime
		if ( $numberToCheck == 1 ) {
			return false;
		}
		// 2 is the only even prime number
		if ( $numberToCheck == 2 ) {
			return true;
		}
		// square root algorithm speeds up testing of bigger prime numbers
		$x = sqrt($numberToCheck);
		$x = floor($x);
		for ( $i = 2 ; $i <= $x ; ++$i ) {
			if ( $numberToCheck % $i == 0 ) {
				break;
			}
		}
	 
		if( $x == $i-1 ) {
			return true;
		} else {
			return false;
		}
	}
	;
	
	if(isPrimeNumber($numberToCheck)) {
		echo("<p> The number " . $numberToCheck . " is a PRIME number!</p>");
	} else {
		echo("<p> The number " . $numberToCheck . " is NOT a PRIME number!</p>");
	}
?>
</body>
</html>