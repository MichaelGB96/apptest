<?php

require_once("./config.php");

class Conexion{

    public function conexion(){
        try {
            $con_bd = new PDO('mysql:host='.DB_HOST.'; dbname='.DB_NOMBRE, DB_USUARIO, DB_CONTRA);
            $con_bd->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            $con_bd->exec("SET CHARACTER SET ".DB_CHARSET);
        } catch (Exception $e) {
            die("Error. " . $e->getMessage());
            echo "Linea del error " . $e->getLine();
        }
        return $con_bd;
    }

}
?>
