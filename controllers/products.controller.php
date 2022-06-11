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

    public static function AddProductsController(){

        if(isset($_POST["newDescription"])){

            if(preg_match('/^[a-zA-Z0-9 ]+$/', $_POST["newDescription"]) &&
               preg_match('/^[0-9]+$/', $_POST["newStock"]) &&  
               preg_match('/^[0-9.]+$/', $_POST["newBuyingPrice"]) &&
               preg_match('/^[0-9.]+$/', $_POST["newSellingPrice"])){

                $table = "products";

                $data = array("idCategory" => $_POST["newCategory"],
                               "code" => $_POST["newCode"],
                               "product" => $_POST["newDescription"],
                               "stock" => $_POST["newStock"],
                               "buyingPrice" => $_POST["newBuyingPricePlus"],
                               "sellingPrice" => $_POST["newSellingPrice"]);

                $answer = ProductsModel::AddProductModel($table, $data);

                if($answer == "ok"){

                    echo'<script>

                        swal({
                              type: "success",
                              title: "Product Added Successfully",
                              showConfirmButton: true,
                              confirmButtonText: "Close"
                              }).then(function(result){
                                        if (result.value) {

                                        window.location = "products";

                                        }
                                    })

                        </script>';

                }


            }else{

                echo'<script>

                    swal({
                          type: "error",
                          title: "Sorry, Product Was Not Added",
                          showConfirmButton: true,
                          confirmButtonText: "Close"
                          }).then(function(result){
                            if (result.value) {

                            window.location = "products";

                            }
                        })

                </script>';
            }

        }

    }


    //edit products controller
    /**
     * takes the product from the products table and allows the user
     * to change the values , if any of the values input are invalid
     * editing will fail
     * 
     * if edit is successful user will receive a success message
     * while if edit fails user will receive an error message
     * 
     * @return void
     */
 }