<?php

require_once 'connection.php';

/**
 * Class ModelSales
 */
class ModelSales{
	
	// Show Sales
	/**
	 * displays selected sale or displays the whole table
	 * 
	 * 
	 * @param mixed $table
	 * @param mixed $item
	 * @param mixed $value
	 * 
	 * @return void
	 */
	public static function ShowSalesModel($table, $item, $value){

		if($item != null){

			$stmt = Connection::connect()->prepare("SELECT * FROM $table WHERE $item = :$item ORDER BY id ASC");

			$stmt -> bindParam(":".$item, $value, PDO::PARAM_STR);

			$stmt -> execute();

			return $stmt -> fetch();

		}else{

			$stmt = Connection::connect()->prepare("SELECT * FROM $table ORDER BY id ASC");

			$stmt -> execute();

			return $stmt -> fetchAll();

		}

		$stmt -> close();

		$stmt = null;

	}

	
}