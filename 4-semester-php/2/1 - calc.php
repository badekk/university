<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Zad 1 Warsztat 2</title>
    <style>
        html {
            background: #876969;
            color: #FFF;
        }
    </style>
</head>
<body>
<form action="1 - calc.php" method="POST">
    <label>Input first number: <input type="number" step="0.01" name="num_1"></label>
    <br>
    <label>Input second number: <input type="number" step="0.01" name="num_2"></label>
    <br>
	<label>Input type of action: </label>
	<select name="actionNumber">
	  <option value="add">Add</option>
	  <option value="sub">Subtract</option>
	  <option value="mul">Multiply</option>
	  <option value="div">Divide</option>
	</select>
	<br>
    <input type="submit" name="send">
    <br>
</form>
<?php
if(isset($_POST['actionNumber'])){
	if (is_numeric($_POST['num_1']) && is_numeric($_POST['num_2'])) {
		
		$num_1 = floatval($_POST['num_1']);
		$num_2 = floatval($_POST['num_2']);

		$action = $_POST['actionNumber'];
		
		switch( $action ) {
			case $action === 'add':
				echo ("<br>Addition: " . ($num_1 + $num_2));
				break;
			case $action === 'sub':
				echo ("<br>Subtracting: " . ($num_1 - $num_2));
				break;
			case $action === 'mul':
				echo "<br>Multiply: " . ($num_1 * $num_2);
				break;
			case $action === 'div':
				if($num_2 == 0) {
					echo("<br> You cannot divide by 0!");
				} else {
					echo "<br>Division: " . ($num_1 / $num_2);
				}
				break;
			default:
				echo("<br>Błąd/Error/Erreur/Fehler/erro/fel");
		}
	} else {
		echo("<br>Please enter numbers only!");
	}
}
?>
</body>
</html>