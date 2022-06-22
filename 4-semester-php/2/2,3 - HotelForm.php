<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Zad 2 i 3 Warsztat 2</title>
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
	echo('	
		<article>
			<form action="2,3 - HotelForm.php" method="POST">
				<label>Select number of people: </label>
				<select name="NumberOfPeople">
				  <option value=1>1</option>
				  <option value=2>2</option>
				  <option value=3>3</option>
				  <option value=4>4</option>
				</select>
				<input type="submit" name="SendNumberOfPeople" value="Apply">
				<br>
			</form>
		</article>
	');
	if(isset($_POST['NumberOfPeople'])) {
		$peopleNumber = $_POST['NumberOfPeople'];
		
		function numberOfForms($peopleNumber) {
			echo ('
			<form action="2,3 - HotelForm.php" method="POST">
				<input type="hidden" value="'.$peopleNumber.'" name="peopleNumber" />
				<br>
				<label>Input First Name:</label>
				<input type="text" name="firstName0" placeholder="First Name" required>
				<br>
				<label>Input Last Name:</label>
				<input type="text" name="lastName0" placeholder="Last Name" required>
				<br>
				<label>Input Email adress:</label>
				<input type="email" name="email0" placeholder="Email" required>
				<br>
				<label>Input Adress:</label> 
				<input type="text" name="adress0" placeholder="Address">
				<br>
				<label>Input Credit Card Number:</label> 
				<input type="tel" inputmode="numeric" name="CardNumber" pattern="[0-9\s]{13,19}" autocomplete="CreditCard-number" maxlength="19" placeholder="xxxx xxxx xxxx xxxx" required>
				<br>
				<label>Input Card Valid To Date:</label>
				<input type="month" min="2021-05" value="2021-05" name="CardValidationDate" required>
				<br>
				<label>Input Check in:</label>
				<input type="datetime-local" min="2021-04-19T00:00" value="2021-04-19T12:30" name="CheckInDateTime" required>
				<br>
				<label>Input Check out:</label>
				<input type="datetime-local" min="2021-04-21T00:00" value="2021-04-21T00:00" name="CheckOutDateTime" required>
				<br>
				<label>Do you need bed for a child: </label>
				<label for=ExtraBedNo> No </label>
				<input type="radio" id="ExtraBedNo" name="ExtraChildBed value="No" checked>
				<label for=ExtraBedYes> Yes </label>
				<input type="radio" id="ExtraBedYes" name="ExtraChildBed value="Yes">
				<br>
				<label> Extras: </label>
				<br>
				<input type="checkbox" id="AirConditioning" name="AirConditioning" value="AirConditioning">
				<label for="AirConditioning"> Air Conditioning</label><br>
				
				<input type="checkbox" id="MiniBar" name="MiniBar" value="MiniBar">
				<label for="MiniBar"> Mini Bar</label><br>
				
				<input type="checkbox" id="BirthdayPackage" name="BirthdayPackage" value="BirthdayPackage">
				<label for="BirthdayPackage"> Birthday Package</label><br>
				
				<input type="checkbox" id="ValentinesDayPackage" name="ValentinesDayPackage" value="ValentinesDayPackage">
				<label for="ValentinesDayPackage"> Valentines Day Package</label><br>
				
				<input type="checkbox" id="101JokesOnYouBook" name="101JokesOnYouBook" value="101JokesOnYouBook">
				<label for="101JokesOnYouBook"> 101 Jokes On You Book</label><br>
				
				<input type="checkbox" id="AdultTvChannels" name="AdultTvChannels" value="AdultTvChannels">
				<label for="AdultTvChannels"> Adult Tv Channels</label><br><br>
				
				
				');
			if($peopleNumber>1) {
				echo ('<form>');
				for($i = 1; $i<$peopleNumber; $i++) {
					echo('
					<br>
					<h3>'.($i+1).' Person Details </h2>
					<label>Input Firstname: <input type="text" name="firstName'.$i.'"></label>
					<br>
					<label>Input Surname: <input type="text" name="lastName'.$i.'"></label>
					<br>
					<label>Input Email adress: <input type="email" name="email'.$i.'"></label>
					<br>
					');
				}
			}
			echo ('
				<br>
				<input type="submit" name="SubmitData" value="SubmitData">
				</form>'
				);
		}
		numberOfForms($peopleNumber);
		
	} else {	
		if(isset($_POST['SubmitData'])){
			$peopleNumber = $_POST['peopleNumber'];
			
			echo('<h2> Your Reservation Details </h2><br>');
			for($i = 0; $i < $peopleNumber; $i++) {
				echo ('<h3> Person: '. $_POST['firstName'.$i].' '.$_POST['lastName'.$i]. '</h3>');
			
				if($i==0) {
					echo 'Address: ' . $_POST['adress'.$i] . '<br>';
					echo 'Credit card: ' . $_POST['CardNumber'] . '<br>';
					echo 'Email: ' . $_POST['email'.$i] . '<br>';
					echo 'Arrival: ' . $_POST['CheckInDateTime'] . '<br>';
					echo 'Check-Out: '. $_POST['CheckOutDateTime']. '<br>';
						if (isset($_POST['AirConditioning'])) {
							echo 'Air Conditioning?: Yes<br>';
						} else {
							echo 'Air Conditioning?: No<br>';
						}
						if (isset($_POST['MiniBar'])) {
							echo 'Mini Bar?: Yes<br>';
						} else {
							echo 'Mini Bar?: No<br>';
						}
						if (isset($_POST['BirthdayPackage'])) {
							echo 'Birthday Package?: Yes<br>';
						} else {
							echo 'Birthday Package?: No<br>';
						}
						if (isset($_POST['ValentinesDayPackage'])) {
							echo 'ValentinesDay Package?: Yes<br>';
						} else {
							echo 'ValentinesDay Package?: No<br>';
						}
						if (isset($_POST['101JokesOnYouBook'])) {
							echo '101 Jokes On You Book?: Yes<br>';
						} else {
							echo '101 Jokes On You Book?: No<br>';
						}
						if (isset($_POST['AdultTvChannels'])) {
							echo 'Adult Tv Channels?: Yes<br>';
						} else {
							echo 'Adult Tv Channels?: No<br>';
						}
				} else {
					echo 'Email: ' . $_POST['email'.$i] . '<br>';
				}
			}
		}
	}
?>
</body>
</html>