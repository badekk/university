<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Zad 2 Warsztat 3</title>
    <style>
        html {
            background: #876969;
            color: #FFF;
        }
    </style>
</head>
<body>
<form action="2 - formToFile.php" method="POST">
	<h2> Creating story! </h2>
	<p> 
	Write one sentence at the time, 
	it will be added at the end of our file
	creating random story made by milions of people! 
	</p>
	<br>
	<textarea id="newSentence" name="newSentence" rows="4" cols="60">And then....</textarea>
    <br><input type="submit" name="send" value="Send">
    <br>
</form>
<?php
if(isset($_POST['newSentence'])){
	$file = "2 - storyTell.txt";
	$sentence = $_POST['newSentence'];
	
	if (file_put_contents($file, $sentence."\n", FILE_APPEND) === false) {
        echo "Error. Data not saved.";
    }
    else {
        echo "Thank you. Data saved.";
    }
}
?>
</body>
</html>