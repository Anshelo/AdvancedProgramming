<?php
$opcion=$_POST['option'];
if ($opcion =='Registrar'):
    $url = "http://localhost:8080/FreightTransport/project/product/createProduct";
    $codeprod = $_POST['idproduct'];
    $nameprod = $_POST['nameproduct'];
    $description = $_POST['selectDescription'];
    $weight = $_POST['weightproduct'];
    $sensibility = $_POST['selectSen'];
    $unitvalue = $_POST['unityValueproduct'];
    
    $data =array('productCode' =>$codeprod, 'productName'=>$nameprod, 'description'=>$description,'weight'=>$weight,'sensibility'=>$sensibility,
    'unitValue'=>$unitvalue);    
    $cli=curl_init($url);
    curl_setopt($cli, CURLOPT_HTTPHEADER, array('Content-Type: application/json'));
    curl_setopt($cli, CURLOPT_POST,true);
    curl_setopt($cli, CURLOPT_POSTFIELDS,json_encode($data));
    curl_setopt($cli, CURLOPT_RETURNTRANSFER, true);
    $respone = curl_exec($cli);
    curl_close($cli);
    echo"<center> <h1>PRODUCTO REGISTRADO</h1></center>";

elseif ($opcion == 'Ver registros'):
        $data = json_decode(file_get_contents("http://localhost:8080/FreightTransport/project/product/getproducts"),true);
        ?>
        <html lang="en">
        <head>
        <link rel="stylesheet" href="../css/styles.css">
            <title>Product</title>
        </head>
        <body>
        <body class="col-sm-8 main-section mx-auto">
            <br>
        <div class="styletittle">
                                        Productos
                                    </div><br>
        <center><table class="table" border="1" >
                <tr class="table-primary">
                    <td>Codigo Producto</td>
                    <td>Nombre Producto</td>
                    <td>Descripcion</td>
                    <td>Peso</td>
                    <td>Sensibilidad</td>
                    <td>Valor Unitario</td>              
                            
                </tr>
                <?php 
                foreach ($data as $d){
                ?>
                <tr>
                            <td><?php echo $d['productCode'] ?></td>
                            <td><?php echo $d['productName'] ?></td>
                            <td><?php echo $d['description'] ?></td>
                            <td><?php echo $d['weight']?></td>
                            <td><?php echo $d['sensibility'] ?></td>
                            <td><?php echo $d['unitValue']?></td>
                </tr>
        </body>
        </html>
                <?php 
                }
                ?>
                </table>
                        
            </center>
            <?php 
            elseif ($opcion == 'Buscar'):
                $id = $_POST['idproduct'];
                $dataId = json_decode(file_get_contents("http://localhost:8080/FreightTransport/project/product/searchProduct/$id"),true);
                ?>
                <html lang="en">
        <head>
        <link rel="stylesheet" href="../css/styles.css">
            <title>Guides</title>
        </head>
        <body>
        <body class="col-sm-8 main-section mx-auto">
            <br>
        <div class="styletittle">
                                        Productos
                                    </div><br>
        <center><table class="table" border="1" >
                <tr class="table-primary">
                    <td>Codigo Producto</td>
                    <td>Nombre Producto</td>
                    <td>Descripcion</td>
                    <td>Peso</td>
                    <td>Sensibilidad</td>
                    <td>Valor Unitario</td>
                        </tr>
        
                        <tr>
                            <td><?php echo $dataId['productCode'] ?></td>
                            <td><?php echo $dataId['productName'] ?></td>
                            <td><?php echo $dataId['description'] ?></td>
                            <td><?php echo $dataId['weight']?></td>
                            <td><?php echo $dataId['sensibility'] ?></td>
                            <td><?php echo $dataId['unitValue']?></td>
                            
                            
                            
                        </tr>
        </body>
        </html>
        
                        <?php 
                        
                        ?>
                        </table>
                                
                    </center>
                    <?php 
        elseif ($opcion == 'Eliminar'):
            $idG = $_POST['idproduct'];
            $url = "http://localhost:8080/FreightTransport/project/product/deleteProduct/$idG";           
            $ch = curl_init();
            curl_setopt($ch, CURLOPT_URL, $url);
            curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "DELETE");
            curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
            $response  = curl_exec($ch);
            curl_close($ch);
            echo"<center> <h2>PRODUCTO ELIMINADO</h2></center>";   
         elseif ($opcion == 'Modificar'):  
            
            $codeprod = $_POST['idproduct'];
            $nameprod = $_POST['nameproduct'];
            $description = $_POST['selectDescription'];
            $weight = $_POST['weightproduct'];
            $sensibility = $_POST['selectSen'];
            $unitvalue = $_POST['unityValueproduct'];

            $url = "http://localhost:8080/FreightTransport/project/product/updateproduct/$codeprod";

            $data =array('productCode' =>$codeprod, 'productName'=>strval($nameprod), 'description'=>$description,'weight'=>$weight,'sensibility'=>$sensibility,
            'unitValue'=>$unitvalue); 
                
                   
            $data_json = json_encode($data);
            $ch = curl_init();
            curl_setopt($ch, CURLOPT_URL, $url);
            curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type: application/json','Content-Length: ' . strlen($data_json)));
            curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'PUT');
            curl_setopt($ch, CURLOPT_POSTFIELDS,$data_json);
            curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
            $response  = curl_exec($ch);
            curl_close($ch);
            echo"<center> <h2>PRODUCTO MODIFICADO</h2></center>"; 
            echo $data_json;
       endif;
         ?>