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

}