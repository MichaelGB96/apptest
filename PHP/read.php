<?php

require_once("./producto.php");

//Si se especifica un id, se mostrará solo 1 producto
if (!empty($_POST['id'])) {
    $idProducto = $_POST['id'];

    $producto = new Producto();
    $producto->getById($idProducto);

/*     $nombre = $producto->getNombre();
    $tipo = $producto->getTipo();
    $precio = $producto->getPrecio(); */

    $json = json_encode($producto);
       
} else { // Si no se especifica id, se muestran todos los productos
    $productos = new Producto();
    $json = json_encode($productos->getProductos());
}

echo $json;