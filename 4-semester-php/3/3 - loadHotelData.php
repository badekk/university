<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Zad 3 Warsztat 3</title>
    <style>
        body {
            background: #2f9149;
            color: #FFF;
		}
    </style>
</head>
<body>
	<?php
	$row = 1;

	if (($getFile = fopen("3 - hotelData.csv", "r")) !== FALSE) {
		while (($data = fgetcsv($getFile, 1000, ",")) !== FALSE) {
			$num = count($data);
			$row++;
			for ($i = 0; $i < $num; $i++) {
				echo $data[$i] . "<br />\n";
			}
		}
		fclose($getFile);
	}
	?>
</body>

</html>