<?php

class Producto
{
    private $db;
    private $productos = array();

    private $id;
    private $nombre;
    private $tipo;  
    private $precio;

    public function __construct()
    {
        require_once("./conn.php");
        $this->db = Conexion::conexion();
        $this->id;    
        $this->nombre = "";
        $this->tipo = "";
        $this->precio = 0.0;
    }

    // GETTERS Y SETTERS

    public function getId(){
        return $this->id;
    }

    public function setId($id){
        $this->id = $id;
    }  

    public function getNombre(){
        return $this->nombre;
    }

    public function setNombre($nombre){
        $this->nombre = $nombre;
    }

    public function getTipo(){
        return $this->tipo;
    }

    public function setTipo($tipo){
        $this->tipo = $tipo;
    }

    public function getPrecio(){
        return $this->precio;
    }

    public function setPrecio($precio){
        $this->precio = $precio;
    }

    // Obtiene todos los productos de la base de datos
    public function getProductos()
    {
        $consulta = $this->db->query("SELECT * FROM platos");

        while ($fila = $consulta->fetch(PDO::FETCH_ASSOC)) {
            $this->productos[] = $fila;
        }
        return $this->productos; 
    }

    // Devuelve un objeto de la clase producto según el id introducido
    public function getById($idProducto)
    {   
        $product = new Producto();

        $sql = "SELECT * FROM productos WHERE id = ?";
        $consulta = $this->db->prepare($sql);
        $consulta->execute(array($idProducto));
        $resultado = $consulta->fetch(PDO::FETCH_ASSOC);

        $product->setId($idProducto);
        $product->setNombre($resultado["nombre"]);
        $product->setTipo($resultado["tipo"]);
        $product->setPrecio($resultado["precio"]);

        return $product;
    }

    // Crea un producto con los parámetros introducidos
    public function crearProducto()
    {
        $sql = "INSERT INTO platos (nombre, tipo, precio, foto) VALUES (?,?,?,'')";
        $consulta = $this->db->prepare($sql);
        $consulta->bindParam(1, $this->nombre, PDO::PARAM_STR);
        $consulta->bindParam(2, $this->tipo, PDO::PARAM_STR);       
        $consulta->bindParam(3, $this->precio, PDO::PARAM_INT);
        if($consulta->execute()){
            $consulta->closeCursor();
            return 1;
        } else {
            $consulta->closeCursor();
            return 0;
        }
    }

    // Modifica un producto existente en la base de datos
    public function modificarProducto($idProducto, $tipo, $nombre, $alcoholica, $precio, $descripcion, $imagen)
    {
        $sql = "UPDATE productos SET nombre = ?, tipo = ?, precio = ? WHERE id = ?";
        $consulta = $this->db->prepare($sql);
        $consulta->bindParam(1, $nombre, PDO::PARAM_STR);    
        $consulta->bindParam(2, $tipo, PDO::PARAM_STR);
        $consulta->bindParam(3, $precio, PDO::PARAM_INT);
        $consulta->bindParam(4, $idProducto, PDO::PARAM_STR);
        if($consulta->execute()){
            $consulta->closeCursor();
            return 1;
        } else {
            $consulta->closeCursor();
            return 0;
        }
    }

}
