<?php

/**
 * Class UserController
 * UserLogin, creation, displaying ,editing and deletion of users
 */
class UserController{

	// User Login
	/**
	 * Checks if the user login credentials are correct and dont have special chars
	 * then logs the user in
	 * If user account is deactivated tell the user account is deactivated
	 * else tell user that the User/Password is incorrect
	 * @return void
	 */
	public static function UserLoginController(){

		if (isset($_POST["loginUser"])) {
			
			if (preg_match('/^[a-zA-Z0-9]+$/', $_POST["loginUser"]) && 
				preg_match('/^[a-zA-Z0-9]+$/', $_POST["loginPassword"])) {
				
				$table = 'users';

				$item = 'user';
				$value = $_POST["loginUser"];

				$crypt = crypt($_POST["loginPassword"], '$2a$07$asxx54ahjppf45sd87a5a4dDDGsystemdev$');

				$answer = UserModel::ShowUsersModel($table, $item, $value);

				if($answer["user"] == $_POST["loginUser"] && $answer["password"] == $crypt){

					if($answer["status"] == 1){

						$_SESSION["loggedIn"] = "ok";
						$_SESSION["id"] = $answer["id"];
						$_SESSION["name"] = $answer["name"];
						$_SESSION["user"] = $answer["user"];
						$_SESSION["profile"] = $answer["profile"];

						// Last Login (https://www.php.net/manual/en/timezones.europe.php)
						// https://stackoverflow.com/questions/44193842/php-date-default-timezone-set-not-working-why
						date_default_timezone_set("Europe/Dublin");

						$date = date('Y-m-d');
						$hour = date('H:i:s');

						$actualDate = $date.' '.$hour;

						$item1 = "lastLogin";
						$value1 = $actualDate;

						$item2 = "id";
						$value2 = $answer["id"];

						$lastLogin = UserModel::UpdateUserModel($table, $item1, $value1, $item2, $value2);
					
						echo '<script>

							window.location = "till";

						</script>';

					}else{
							
						echo '<br><div class="alert alert-danger">Sorry, User is Deactivated</div>';
					
					}

				}else{

					echo '<br><div class="alert alert-danger">Username or Password Incorrect</div>';

				}
			}
		}
	}

// Create User
	/**
	 * If the post variable is set to newUser and then check if the new Name/User/Password are valid characters
	 * go to the users table hash the new password and input the users data unto the table.
	 * Send success message to the user that new user was added.
	 * 
	 * else send error message telling the user that there was an error, fill in all fields making sure there are
	 * no special characters allowed.
	 * 
	 * @return void
	 */
	public static function CreateUserController(){

		if (isset($_POST["newUser"])) {
			
			if (preg_match('/^[a-zA-Z0-9]+$/', $_POST["newName"]) &&
				preg_match('/^[a-zA-Z0-9]+$/', $_POST["newUser"]) &&
				preg_match('/^[a-zA-Z0-9]+$/', $_POST["newPassword"])){

				$table = 'users';

				$crypt = crypt($_POST["newPassword"], '$2a$07$asxx54ahjppf45sd87a5a4dDDGsystemdev$');

				$data = array('name' => $_POST["newName"],
							  'user' => $_POST["newUser"],
							  'password' => $crypt,
							  'profile' => $_POST["newProfile"]);

				$answer = UserModel::AddUserModel($table, $data);

				if ($answer == 'ok') {

						echo '<script>
						
						swal({
							type: "success",
							title: "User Added Successfully!",
							showConfirmButton: true,
							confirmButtonText: "Close"
						}).then(function(result){
							if(result.value){
								window.location = "users";
							}
						});
						
						</script>';

				}
			
			}else{

				echo '<script>
					
					swal({
						type: "error",
						title: "Please fill in all fields, no special characters allowed",
						showConfirmButton: true,
						confirmButtonText: "Close"
			
						}).then(function(result){
							if(result.value){
								window.location = "users";
							}
						});
					
				</script>';
			}
			
		}
	}