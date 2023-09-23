<?php

require_once("./producto.php");

//Si se especifica un id, se mostrará solo 1 producto
if (!empty($_POST['id'])) {
    $idProducto = $_POST['id'];

    $producto = new Producto();
    $producto = $producto->getById($idProducto);

    $nombre = $producto->getNombre();
    $tipo = $producto->getTipo();
    $precio = $producto->getPrecio();

    $productoInfo = array(
        "id" => $idProducto,
        "nombre" => $nombre,
        "tipo" => $tipo,
        "precio" => $precio
    );

    $json = json_encode($productoInfo);
       
} else { // Si no se especifica id, se muestran todos los productos
    $productos = new Producto();
    $json = json_encode($productos->getProductos());
}

echo $json;