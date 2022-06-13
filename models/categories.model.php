<?php

require_once "connection.php";
/**
 * Class CategoriesModel
 */
class CategoriesModel{

	// Add Categories
	/**
	 * inserts input data into the table 
	 * 
	 * @param mixed $table
	 * @param mixed $data
	 * 
	 * @return void
	 */
	public static function AddCategoryModel($table, $data){

		$stmt = Connection::connect()->prepare("INSERT INTO $table(category, vat, tax) VALUES (:category, :vat, :tax)");

		$stmt -> bindParam(":category", $data["category"], PDO::PARAM_STR);
		$stmt -> bindParam(":vat", $data["vat"], PDO::PARAM_STR);
		$stmt -> bindParam(":tax", $data["tax"], PDO::PARAM_STR);

		if ($stmt->execute()) {

			return 'ok';

		} else {

			return 'error';

		}
		
		$stmt -> close();

		$stmt = null;
    }