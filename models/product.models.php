<?php 

require_once 'connection.php';


class ProductsModel{
	/**
	 * displays the chosen product or displays the full table
	 * 
	 * @param mixed $table
	 * @param mixed $item
	 * @param mixed $value
	 * @param mixed $order
	 * 
	 * @return void
	 */
	public static function ShowProductsModel($table, $item, $value, $order){
		if($item != null){

			$stmt = Connection::connect()->prepare("SELECT * FROM $table WHERE $item = :$item ORDER BY idCategory DESC");

			$stmt -> bindParam(":".$item, $value, PDO::PARAM_STR);

			$stmt -> execute();

			return $stmt -> fetch();

		}else{

			$stmt = Connection::connect()->prepare("SELECT * FROM $table ORDER BY $order DESC");

			$stmt -> execute();

			return $stmt -> fetchAll();

		}

		$stmt -> close();

		$stmt = null;
	}

	/**
	 * adds a product to the database table using input data from the user
     * @param mixed $table
     * @param mixed $data
     * 
     * @return void
     */

	
} 