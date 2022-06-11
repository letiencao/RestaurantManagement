<?php

/**
 * Class OpenTableController
 * showing of the openedtables and displays all tables
 */
class OpenTableController{

    // Show Sales
    /**
	 * fetches the open_tables table from the database 
	 * displays the table
     * @param mixed $item
     * @param mixed $value
     * 
     * @return void
     */
    public static function ShowTableController($item, $value){

		$table = "open_tables";

		$answer = ModelTables::ShowTablesModel($table, $item, $value);

		return $answer;

	}
	
	public static function index () {
        return ModelTables::all();
    }
    

    
}

