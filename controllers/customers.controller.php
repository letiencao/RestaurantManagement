<?php

/**
 * Class CustomerController
 * displaying, creation, editing, deletion and searching of customers
 */
class CustomerController{

	/**
	 * fetches data from the customers table
	 * and displays the data
	 * 
     * @param mixed $item
     * @param mixed $value
     * 
     * @return void
     */
    public static function ShowCustomerController($item, $value){

		$table = "customers";

		$answer = CustomersModel::ShowCustomersModel($table, $item, $value);

		return $answer;

	}

    /**
	 * creates new customers, if all inputs are valid and do not contain any invalud chars
	 * the new customer will be created and display a success message while if anything
	 * was entered incorrectly the user will recieve an error message
	 * @return void
	 */
	public static function CreateCustomerController(){

		if(isset($_POST["newCustomer"])){

			if(preg_match('/^[a-zA-Z0-9ñÑáéíóúÁÉÍÓÚ ]+$/', $_POST["newCustomer"]) &&
			   preg_match('/^[0-9]+$/', $_POST["newId"]) &&
			   preg_match('/^[^0-9][a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[@][a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{2,4}$/', $_POST["newEmail"]) && 
			   preg_match('/^[()\-0-9 ]+$/', $_POST["newMobile"]) && 
			   preg_match('/^[#\.\-a-zA-Z0-9 ]+$/', $_POST["newAddress"])){

			   	$table = "customers";

			   	$data = array("name"=>$_POST["newCustomer"],
					           "idNumber"=>$_POST["newId"],
					           "email"=>$_POST["newEmail"],
					           "mobile"=>$_POST["newMobile"],
					           "address"=>$_POST["newAddress"],
                               "dob"=>$_POST["newDob"],
                               "discount"=>$_POST["newDiscount"]);

			   	$answer = CustomersModel::AddCustomerModel($table, $data);

			   	if($answer == "ok"){

					echo'<script>

					swal({
						  type: "success",
						  title: "Saved",
						  showConfirmButton: true,
						  confirmButtonText: "Confirm"
						  }).then(function(result){
									if (result.value) {

									window.location = "customers";

									}
								})

					</script>';

				}

			}else{

				echo'<script>

					swal({
						  type: "error",
						  title: "Please Fill in all Customer Details",
						  showConfirmButton: true,
						  confirmButtonText: "Close"
						  }).then(function(result){
							if (result.value) {

							window.location = "customers";

							}
						})

			  	</script>';

			}

		}

    }
}