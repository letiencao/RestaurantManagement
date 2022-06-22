<?php

require_once "connection.php";

/**
 * Class CustomersModel
 */
class CustomersModel{

	// Create Customer
	/**
	 * creates customer using input data 
	 * 
	 * @param mixed $table
	 * @param mixed $data
	 * 
	 * @return void
	 */
    public static function AddCustomerModel($table, $data){

		$stmt = Connection::connect()->prepare("INSERT INTO $table(name, idNumber, address, email, mobile, dob, discount) VALUES (:name, :idNumber, :address, :email, :mobile, :dob, :discount)");

		$stmt->bindParam(":name", $data["name"], PDO::PARAM_STR);
        $stmt->bindParam(":idNumber", $data["idNumber"], PDO::PARAM_INT);
        $stmt->bindParam(":address", $data["address"], PDO::PARAM_STR);
		$stmt->bindParam(":email", $data["email"], PDO::PARAM_STR);
		$stmt->bindParam(":mobile", $data["mobile"], PDO::PARAM_STR);
        $stmt->bindParam(":dob", $data["dob"], PDO::PARAM_STR);
        $stmt->bindParam(":discount", $data["discount"], PDO::PARAM_INT);

		if($stmt->execute()){

			return "ok";

		}else{

			return "error";
		
		}

		$stmt->close();
		$stmt = null;

    }
    
	// Show Customers
	/**
	 * displays the chosen customer or displays all customers
     * @param mixed $table
     * @param mixed $item
     * @param mixed $value
     * 
     * @return void
     */
    public static function ShowCustomersModel($table, $item, $value){

		if($item != null){

			$stmt = Connection::connect()->prepare("SELECT * FROM $table WHERE $item = :$item");

			$stmt -> bindParam(":".$item, $value, PDO::PARAM_STR);

			$stmt -> execute();

			return $stmt -> fetch();

		}else{

			$stmt = Connection::connect()->prepare("SELECT * FROM $table");

			$stmt -> execute();

			return $stmt -> fetchAll();

		}

		$stmt -> close();

		$stmt = null;

    }
    
	// Edit Customer
	/**
	 * edits customer using new input data
	 * @param mixed $table
	 * @param mixed $data
	 * 
	 * @return void
	 */

	public static function EditCustomerModel($table, $data){

        $stmt = Connection::connect()->prepare("UPDATE $table SET name = :name, idNumber = :idNumber, address = :address, email = :email, mobile = :mobile, dob = :dob, discount = :discount WHERE id = :id");
        
        $stmt->bindParam(":id", $data["id"], PDO::PARAM_INT);
        $stmt->bindParam(":name", $data["name"], PDO::PARAM_STR);
        $stmt->bindParam(":idNumber", $data["idNumber"], PDO::PARAM_INT);
        $stmt->bindParam(":address", $data["address"], PDO::PARAM_STR);
		$stmt->bindParam(":email", $data["email"], PDO::PARAM_STR);
		$stmt->bindParam(":mobile", $data["mobile"], PDO::PARAM_STR);
        $stmt->bindParam(":dob", $data["dob"], PDO::PARAM_STR);
        $stmt->bindParam(":discount", $data["discount"], PDO::PARAM_INT);

		if($stmt->execute()){

			return "ok";

		}else{

			return "error";
		
		}

		$stmt->close();
		$stmt = null;

    }

}