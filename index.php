<?php
    require_once "controllers/template.controller.php";
    require_once "controllers/users.controller.php";
    require_once "controllers/products.controller.php";



    require_once "models/users.model.php";
    require_once "models/products.model.php";
    

    
    $template = new TemplateController();
    $template -> TemplatesController();