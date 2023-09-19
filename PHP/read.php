<?php

    require_once("./producto.php");

    $productos = new Producto();
    $json = json_encode($productos->getProductos());

?>