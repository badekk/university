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
<header>
	<h2> Welcome to Plaza Hotel !</h2>
</header>
<?php
	makeForm();
	
	//zapisuje dane
	if(isset($_POST['SubmitData'])){
		//fileName
		$fileName = "./3 - hotelData.csv";
		//dataArguments
		$firstName = $_POST['firstName'];
		$lastName = $_POST['lastName'];
		$email = $_POST['email'];
		$address = $_POST['address'];
		$cardNumber = $_POST['cardNumber'];
		$cardValidationDate = $_POST['CardValidationDate'];
		$checkIn = $_POST['CheckInDateTime'];
		$checkOut = $_POST['CheckOutDateTime'];
		$guests = $_POST['NumberOfPeople'];
		
		if (!file_exists($fileName)) {
			$file = fopen($fileName, 'a');
			fputcsv($file, array('First Name', 'Last Name', 'Email', 'Address', 'CardNumber', 'CardValidationDate', 'CheckIn', 'CheckOut', 'numberOfGuests'), ';');
			fclose($file);
		}
		$file = fopen($fileName, 'a');
		$dataToWrite = array(
			$firstName, $lastName, $email, $address, $cardNumber, $cardValidationDate, $checkIn, $checkOut, $guests
		);

		fputcsv($file, $dataToWrite, ";");
		fclose($file);
	}
		
	//Functions
	function makeForm() {
		echo ('<form action="3 - csv.php" method="POST">');
		echo ('<label>Select number of people: </label>');
		echo ('<select name="NumberOfPeople">');
		echo ('<option value=1>1</option>');
		echo ('<option value=2>2</option>');
		echo ('<option value=3>3</option>');
		echo ('<option value=4>4</option>');
		echo ('</select><br>');
		echo ('<label>Input First Name:</label>');
		echo ('<input type="text" name="firstName" placeholder="First Name" required><br>');
		echo ('<label>Input Last Name:</label>');
		echo ('<input type="text" name="lastName" placeholder="Last Name" required><br>');
		echo ('<label>Input Email adress:</label>');
		echo ('<input type="email" name="email" placeholder="Email" required><br>');
		echo ('<label>Input Address:</label>');
		echo ('<input type="text" name="address" placeholder="Address"><br>');
		echo ('<label>Input Credit Card Number:</label>');
		echo ('<input type="tel" inputmode="numeric" name="cardNumber" pattern="[0-9\s]{13,19}" autocomplete="CreditCard-number" maxlength="19" placeholder="xxxx xxxx xxxx xxxx" required><br>');
		echo ('<label>Input Card Valid To Date:</label>');
		echo ('<input type="month" min="2021-05" value="2021-05" name="CardValidationDate" required><br>');
		echo ('<label>Input Check in:</label>');
		echo ('<input type="datetime-local" min="2021-04-19T00:00" value="2021-04-19T12:30" name="CheckInDateTime" required><br>');
		echo ('<label>Input Check out:</label>');
		echo ('<input type="datetime-local" min="2021-04-21T00:00" value="2021-04-21T00:00" name="CheckOutDateTime" required><br>');
		echo ('<label>Do you need bed for a child: </label>');
		echo ('<label for=ExtraBedNo> No </label>');
		echo ('<input type="radio" id="ExtraBedNo" name="ExtraChildBed value="No" checked>');
		echo ('<label for=ExtraBedYes> Yes </label>');
		echo ('<input type="radio" id="ExtraBedYes" name="ExtraChildBed value="Yes"><br>');
		echo ('<label> Extras: </label><br>');
		echo ('<input type="checkbox" id="AirConditioning" name="AirConditioning" value="AirConditioning">');
		echo ('<label for="AirConditioning"> Air Conditioning</label><br>');
		echo ('<input type="checkbox" id="MiniBar" name="MiniBar" value="MiniBar">');
		echo ('<label for="MiniBar"> Mini Bar</label><br>');
		echo ('<input type="checkbox" id="BirthdayPackage" name="BirthdayPackage" value="BirthdayPackage">');
		echo ('<label for="BirthdayPackage"> Birthday Package</label><br>');
		echo ('<input type="checkbox" id="ValentinesDayPackage" name="ValentinesDayPackage" value="ValentinesDayPackage">');
		echo ('<label for="ValentinesDayPackage"> Valentines Day Package</label><br>');
		echo ('<input type="checkbox" id="101JokesOnYouBook" name="101JokesOnYouBook" value="101JokesOnYouBook">');
		echo ('<label for="101JokesOnYouBook"> 101 Jokes On You Book</label><br>');
		echo ('<input type="checkbox" id="AdultTvChannels" name="AdultTvChannels" value="AdultTvChannels">');
		echo ('<label for="AdultTvChannels"> Adult Tv Channels</label><br><br>');
		echo ('<input type="submit" name="SubmitData" value="Save Data to CSV">');
		echo ('</form>');				
		echo ('<form action="3 - loadHotelData.php" method="POST">');
		echo ('<input type="submit" name="LoadData" value="Load All Data">');
		echo ('</form>');	
	}
?>
</body>
</html>