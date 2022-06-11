<?php

/**
 * Class SalesController
 * This will be used to control the
 * Displaying, creation, fetching all data from table, reopen/edit, delete sales, 
 * display sales by date, sum all sales and print receipt of sale
 * 
 */
class SalesController{

	// Show Sales
    /**
	 * fetches sales table from the database
	 * and displays the contents of the table
	 * 
     * @param mixed $item
     * @param mixed $value
     * 
     * @return void
     */
    public static function ShowSalesController($item, $value){

		$table = "sales";

		$answer = ModelSales::ShowSalesModel($table, $item, $value);

		return $answer;

	}

	

}