<?php 
/**
 * Class ProductsController
 * Displaying, adding, editing, deleting products and shows the adding of sales
 */

 class ProductsController{
 	/**
  * fetches the products table from the database and
  * displays the contents of the table
  * 
  * @param mixed $item
  * @param mixed $value
  * @param mixed $order
  * 
  * @return void
  */

 	static public function ShowProductsController($item,$value,$order){
 		$table = "products";

 		$answer = ProductsModel::ShowProductsModel($table, $item, $value, $order);

 		return $answer;
 	}
 	/**
	 * Create new products to be added to the products database table
	 * product details need to be correct and have no invalid chars
	 * once completed will send a success message to user
	 * if failure to enter valid chars user will recieve an error message
	 * 
     * @return void
     */
 }