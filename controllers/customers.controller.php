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
}