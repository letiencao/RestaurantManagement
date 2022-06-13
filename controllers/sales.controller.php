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

	// Create / Edit Sale

	/**
	 * Opens a table that can be re-opened to process the sale -
	 * sale info placed into the open sales table
	 * once order is placed user will recieve a order saved message.
	 * 
	 * Creates sale where when items are added to the order 
	 * they take the same amount is taken from their stock
	 * once sales is processed success message is delivered
	 * 
	 * 
     * @return void
     */
    public static function CreateSaleController(){

		if (isset($_POST["openTable"])) {

			// Update customer purchases, stock levels and product sale figures
			$productsList = json_decode($_POST["productsList"], true);

			$totalPurchases = array();

			foreach ($productsList as $key => $value) {

			   array_push($totalPurchases, $value["quantity"]);
				
			   $tableProducts = "products";

			    $item = "id";
			    $valueProductId = $value["id"];
			    $order = "id";

			    $getProduct = ProductsModel::ShowProductsModel($tableProducts, $item, $valueProductId, $order);

				$item1 = "sales";
				$value1 = $value["quantity"] + $getProduct["sales"];

			    $newSales = ProductsModel::UpdateProductModel($tableProducts, $item1, $value1, $valueProductId);

				$item2 = "stock";
				$value2 = $value["stock"];

				$newStock = ProductsModel::UpdateProductModel($tableProducts, $item2, $value2, $valueProductId);

			}
			
			// Save sale to database
			$table = "open_tables";
			
            $data = array("code"       => $_POST["newSale"],
                          "idSeller"   => $_POST["idSeller"],
                          "tableNo"    => $_POST["tableNo"],
                          "idCustomer" => $_POST["customerSearch"],
						  "products"   => $_POST["productsList"],
                          "netPrice"   => $_POST["newNetPrice"],
            );
            
			$answer = ModelTables::AddTableModel($table, $data);
			
            if ($answer == "ok") {
                
                echo '<script>

				localStorage.removeItem("range");

				swal({
					  type: "success",
					  title: "Order Saved",
					  showConfirmButton: true,
					  confirmButtonText: "Close"
					  }).then((result) => {
								if (result.value) {

								window.location = "open-tables";

								}
							})

				</script>';
            
            }
      

	}

}