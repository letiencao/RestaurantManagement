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

/**
	 * fetches all data from the sales table 
	 * and returns it
	 * @return void
	 */
	public static function index () {
        return ModelSales::getAll();
	}
	
	/**
	 * Re-opens saved orders from the opentables
	 * and processes them as a sale.
	 * 
	 * 
	 * @return void
	 */
	public static function ReOpenTableController(){

        // Make Sale
		if(isset($_POST["reopenSale"])){

			$table = "sales";

			$item = "code";
			$value = $_POST["reopenSale"];
			$getSale = ModelSales::ShowSalesModel($table, $item, $value);
   
			// if statement checking if the sale was actually changed
			if($_POST["productsList"] == ""){
				$productsList = $getSale["products"];
				$productChange = false;
			}else{
				$productsList = $_POST["productsList"];
				$productChange = true;
			}
   
			if($productChange){

				$products =  json_decode($getSale["products"], true);

				$totalPurchasedProducts = array();

				foreach ($products as $key => $value) {
        
					array_push($totalPurchasedProducts, $value["quantity"]);
					
					$tableProducts = "products";

					$item = "id";
					$value = $value["id"];
					$order = "id";

					$getProduct = ProductsModel::ShowProductsModel($tableProducts, $item, $value, $order);

					$item1a = "sales";
					$value1a = $getProduct["sales"] - $value["quantity"];
					$newSales = ProductsModel::UpdateProductModel($tableProducts, $item1a, $value1a, $value1);

					$item1b = "stock";
					$value1b = $value["quantity"] + $getProduct["stock"];

					$newStock = ProductsModel::UpdateProductModel($tableProducts, $item1b, $value1b, $value1);

				}
				
				$tableCustomers = "customers";

				$itemCustomer = "idNumber";
				$valueCustomer = $_POST["customerSearch"];

				$getCustomer = CustomersModel::ShowCustomersModel($tableCustomers, $itemCustomer, $valueCustomer);

				$item1a = "purchases";
				$value1a = $getCustomer["purchases"] - array_sum($totalPurchasedProducts);

				$customerPurchases = CustomersModel::UpdateCustomerModel($tableCustomers, $item1a, $value1a, $valueCustomer);

				$productsList_2 = json_decode($productsList, true);

				$totalPurchasedProducts_2 = array();
    
				foreach ($productsList_2 as $key => $value) {

					array_push($totalPurchasedProducts_2, $value["quantity"]);
					
					$tableProducts_2 = "products";

					$item_2 = "id";
					$value_2 = $value["id"];
					$order = "id";

					$getProduct_2 = ProductsModel::ShowProductsModel($tableProducts_2, $item_2, $value_2, $order);

					$item1a_2 = "sales";
					$value1a_2 = $value["quantity"] + $getProduct_2["sales"];

					$newSales_2 = ProductsModel::UpdateProductModel($tableProducts_2, $item1a_2, $value1a_2, $value_2);

					$item1b_2 = "stock";
					$value1b_2 = $getProduct_2["stock"] - $value["quantity"];

					$newStock_2 = ProductsModel::UpdateProductModel($tableProducts_2, $item1b_2, $value1b_2, $value_2);

				}

				$tableCustomers_2 = "customers";

				$item_2 = "idNumber";
				$value_2 = $_POST["customerSearch"];

				$getCustomer_2 = CustomersModel::ShowCustomersModel($tableCustomers_2, $item_2, $value_2);

				$item1a_2 = "purchases";
				$value1a_2 = array_sum($totalPurchasedProducts_2) + $getCustomer_2["purchases"];

				$customerPurchases_2 = CustomersModel::UpdateCustomerModel($tableCustomers_2, $item1a_2, $value1a_2, $value_2);

				$item1b_2 = "lastPurchase";

				date_default_timezone_set("Europe/Dublin");

				$date = date('Y-m-d');
				$hour = date('H:i:s');
				$value1b = $date.' '.$hour;

				$dateCustomer_2 = CustomersModel::UpdateCustomerModel($tableCustomers_2, $item1b_2, $value1b, $value_2);

			}
			
			if (isset($_POST['newPaymentMethod'])) {
                $data = array("code"          => $_POST["reopenSale"],
                              "idSeller"      => $_POST["idSeller"],
                              "tableNo"       => $_POST["tableNo"],
                              "idCustomer"    => $_POST["customerSearch"],
                              "products"      => $productsList,
                              "netPrice"      => $_POST["newNetPrice"],
                              "discount"      => $_POST["newDiscountSale"],
                              "totalPrice"    => $_POST["newSaleTotal"],
                              "paymentMethod" => $_POST["newPaymentMethod"]);
                
                $answer = ModelSales::ReopenSaleModel($table, $data);
                
                if ($answer == "ok") {
                    
                    echo '<script>

				localStorage.removeItem("range");

				swal({
					  type: "success",
					  title: "Sale Successful",
					  showConfirmButton: true,
					  confirmButtonText: "Close"
					  }).then((result) => {
								if (result.value) {

								window.location = "sales";

								}
							})

				</script>';
                
                }
            } else {
                
                ModelSales::DeleteSalesModel('sales',$getSale['id']);
                
			    $table = "open_tables";
                
                $data = array("code"       => $_POST["reopenSale"],
                              "idSeller"   => $_POST["idSeller"],
                              "tableNo"    => $_POST["tableNo"],
                              "idCustomer" => $_POST["customerSearch"],
                              "products"   => $productsList,
                              "netPrice"   => $_POST["newNetPrice"],
                );
                $answer = ModelTables::AddTableModel($table, $data);
                if ($answer == "ok") {
                    ModelSales::DeleteSalesModel('sales',$getSale['id']);
                    echo '<script>

				localStorage.removeItem("range");

				swal({
					  type: "success",
					  title: "Sale Successfull",
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

	}