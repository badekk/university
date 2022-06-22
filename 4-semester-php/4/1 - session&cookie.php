<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Session & Cookies</title>
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
	session_start();
	$total_count = 0;
	if(isset($_COOKIE['count'])){
		$total_count = $_COOKIE['count'];
		$total_count ++;
	}
	if(isset($_COOKIE['last_visit'])){
		$last_visit = $_COOKIE['last_visit'];
	}
	setcookie('count', $total_count,  time()+60*60*24); //+60*60*24)
	setcookie('last_visit', date("d-m-Y H:i:s"),  time()+60*60*24);
	
	echo('<article>');
	echo('<form action="1 - session&cookie.php" method="POST">');
	echo('<label>Select number of people: </label>');
	echo('<select name="NumberOfPeople">');
	echo('<option value=1>1</option>');
	echo('<option value=2>2</option>');
	echo('<option value=3>3</option>');
	echo('<option value=4>4</option>');
	echo('</select>');
	echo('<input type="submit" name="SendNumberOfPeople" value="Apply">');
	echo('<br>');
	echo('</form>');
	echo('</article>');

	if(isset($_POST['NumberOfPeople'])) {
		$peopleNumber = $_POST['NumberOfPeople'];
		
		function numberOfForms($peopleNumber) {
			echo('<form action="1 - session&cookie.php" method="POST">');
				echo('<input type="hidden" value="'.$peopleNumber.'" name="peopleNumber" /><br>');
				echo('<label>Input First Name:</label>');
				echo('<input type="text" name="firstName0" placeholder="First Name" required><br>');
				echo('<label>Input Last Name:</label>');
				echo('<input type="text" name="lastName0" placeholder="Last Name" required><br>');
				echo('<label>Input Email adress:</label>');
				echo('<input type="email" name="email0" placeholder="Email" required><br>');
				echo('<label>Input Adress:</label>');
				echo('<input type="text" name="adress0" placeholder="Address"><br>');
				echo('<label>Input Credit Card Number:</label>');
				echo('<input type="tel" inputmode="numeric" name="CardNumber" pattern="[0-9\s]{13,19}" autocomplete="CreditCard-number" maxlength="19" placeholder="xxxx xxxx xxxx xxxx" required><br>');
				echo('<label>Input Card Valid To Date:</label>');
				echo('<input type="month" min="2021-05" value="2021-05" name="CardValidationDate" required><br>');
				echo('<label>Input Check in:</label>');
				echo('<input type="datetime-local" min="2021-04-19T00:00" value="2021-04-19T12:30" name="CheckInDateTime" required><br>');
				echo('<label>Input Check out:</label>');
				echo('<input type="datetime-local" min="2021-04-21T00:00" value="2021-04-21T00:00" name="CheckOutDateTime" required><br>');
				echo('<label>Do you need bed for a child: </label>');
				echo('<label for=ExtraBedNo> No </label>');
				echo('<input type="radio" id="ExtraBedNo" name="ExtraChildBed value="No" checked>');
				echo('<label for=ExtraBedYes> Yes </label>');
				echo('<input type="radio" id="ExtraBedYes" name="ExtraChildBed value="Yes"><br>');
				echo('<label> Extras: </label><br>');
				echo('<input type="checkbox" id="AirConditioning" name="AirConditioning" value="AirConditioning">');
				echo('<label for="AirConditioning"> Air Conditioning</label><br>');
				echo('<input type="checkbox" id="MiniBar" name="MiniBar" value="MiniBar">');
				echo('<label for="MiniBar"> Mini Bar</label><br>');
				echo('<input type="checkbox" id="BirthdayPackage" name="BirthdayPackage" value="BirthdayPackage">');
				echo('<label for="BirthdayPackage"> Birthday Package</label><br>');
				echo('<input type="checkbox" id="ValentinesDayPackage" name="ValentinesDayPackage" value="ValentinesDayPackage">');
				echo('<label for="ValentinesDayPackage"> Valentines Day Package</label><br>');
				echo('<input type="checkbox" id="101JokesOnYouBook" name="101JokesOnYouBook" value="101JokesOnYouBook">');
				echo('<label for="101JokesOnYouBook"> 101 Jokes On You Book</label><br>');
				echo('<input type="checkbox" id="AdultTvChannels" name="AdultTvChannels" value="AdultTvChannels">');
				echo('<label for="AdultTvChannels"> Adult Tv Channels</label><br><br>');

			if($peopleNumber>1) {
				echo ('<form>');
				for($i = 1; $i<$peopleNumber; $i++) {	
					echo('<br><h3>'.($i+1).' Person Details </h2>');
					echo('<label>Input Firstname: <input type="text" name="firstName'.$i.'"></label><br>');
					echo('<label>Input Surname: <input type="text" name="lastName'.$i.'"></label><br>');
					echo('<label>Input Email adress: <input type="email" name="email'.$i.'"></label><br>');
				}
			}
			echo ('<br><input type="submit" name="SubmitData" value="SubmitData">');
			echo ('</form>');
		}
		numberOfForms($peopleNumber);
		
	} else {	
		if(isset($_POST['SubmitData'])){
			$peopleNumber = $_POST['peopleNumber'];
			
			echo('<h2> Your Reservation Details </h2><br>');
			for($i = 0; $i < $peopleNumber; $i++) {
				echo ('<h3> Person: '. $_POST['firstName'.$i].' '.$_POST['lastName'.$i]. '</h3>');
			
				if($i==0) {
					echo ('Address: ' . $_POST['adress'.$i] . '<br>');
					echo ('Credit card: ' . $_POST['CardNumber'] . '<br>');
					echo ('Email: ' . $_POST['email'.$i] . '<br>');
					echo ('Arrival: ' . $_POST['CheckInDateTime'] . '<br>');
					echo ('Check-Out: '. $_POST['CheckOutDateTime']. '<br>');
						if (isset($_POST['AirConditioning'])) {
							echo ('Air Conditioning?: Yes<br>');
						} else {
							echo ('Air Conditioning?: No<br>');
						}
						if (isset($_POST['MiniBar'])) {
							echo ('Mini Bar?: Yes<br>');
						} else {
							echo ('Mini Bar?: No<br>');
						}
						if (isset($_POST['BirthdayPackage'])) {
							echo ('Birthday Package?: Yes<br>');
						} else {
							echo ('Birthday Package?: No<br>');
						}
						if (isset($_POST['ValentinesDayPackage'])) {
							echo ('ValentinesDay Package?: Yes<br>');
						} else {
							echo ('ValentinesDay Package?: No<br>');
						}
						if (isset($_POST['101JokesOnYouBook'])) {
							echo ('101 Jokes On You Book?: Yes<br>');
						} else {
							echo ('101 Jokes On You Book?: No<br>');
						}
						if (isset($_POST['AdultTvChannels'])) {
							echo ('Adult Tv Channels?: Yes<br>');
						} else {
							echo ('Adult Tv Channels?: No<br>');
						}
				} else {
					echo ('Email: ' . $_POST['email'.$i] . '<br>');
				}

				if($total_count == 0){
					echo ('<br>Welcome! We are glad to see you here.');
				} else {
					echo ('This is your visit number: '.$total_count.'<br>');
					echo ('Last time, you were here at '.$last_visit);
				}
				if (session_status() == PHP_SESSION_ACTIVE) {
					echo ('<br>Session is active');
					session_destroy();
				}
			}
		}
	}

?>
</body>
</html>