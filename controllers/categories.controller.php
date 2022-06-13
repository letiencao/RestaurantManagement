<?php
 
 /**
 * Class ControllerCategories
 * creation, displaying, editing and deletion of categories
 */
 class ControllerCategories{

	// Create Category
	/**
	 * Creates a new category and places it in the categories table
	 * if the category is successfully created the user will be given a success message
	 * while if it fails the user will be given an error message
	 * @return void
	 */
	public static function CreateCategoryController(){

		if(isset($_POST['newCategory'])){

			if(preg_match('/^[a-zA-Z0-9]+$/', $_POST["newCategory"])){

				$table = 'categories';

				$data = array("category"=>$_POST["newCategory"],
							  "vat"=>$_POST["newVat"],
							  "tax"=>$_POST["newTax"]);

				$answer = CategoriesModel::AddCategoryModel($table, $data);

				if($answer == 'ok'){

					echo '<script>
						
						swal({
							type: "success",
							title: "Category created successfully",
							showConfirmButton: true,
							confirmButtonText: "Close"

							}).then(function(result){
								if (result.value) {

									window.location = "categories";

								}
							});
						
					</script>';
				}
				

			}else{

				echo '<script>
						
						swal({
							type: "error",
							title: "Please fill in all fields, no special characters allowed",
							showConfirmButton: true,
							confirmButtonText: "Close"
				
							 }).then(function(result){

								if (result.value) {
									window.location = "categories";
								}
							});
						
				</script>';
				
			}
		}
    }