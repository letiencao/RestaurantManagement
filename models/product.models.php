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
	public static function AddProductModel($table, $data){

		$stmt = Connection::connect()->prepare("INSERT INTO $table(idCategory, code, product, stock, buyingPrice, sellingPrice) VALUES (:idCategory, :code, :product, :stock, :buyingPrice, :sellingPrice)");

		$stmt->bindParam(":idCategory", $data["idCategory"], PDO::PARAM_INT);
		$stmt->bindParam(":code", $data["code"], PDO::PARAM_STR);
		$stmt->bindParam(":product", $data["product"], PDO::PARAM_STR);
		$stmt->bindParam(":stock", $data["stock"], PDO::PARAM_STR);
		$stmt->bindParam(":buyingPrice", $data["buyingPrice"], PDO::PARAM_STR);
		$stmt->bindParam(":sellingPrice", $data["sellingPrice"], PDO::PARAM_STR);

		if($stmt->execute()){

			return "ok";

		}else{

			return "error";
		
		}

		$stmt->close();
		$stmt = null;

	}

	
} 