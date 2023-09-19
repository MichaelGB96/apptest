<?php

require_once("./producto.php");

$producto = new Producto();

if (!empty($_POST['name'] | $_POST['type'] | $_POST['price']))
{
    $nombre = $_POST['name'];
    $tipo = $_POST['type'];
    $precio = $_POST['price'];

    $producto->setNombre($nombre);
    $producto->setTipo($tipo);
    $producto->setPrecio($precio);
    
    if($producto->crearProducto()==1)
    {
        echo "Success";
    } else {
        echo "Fallo en la inserción";
    }  
} 

?>