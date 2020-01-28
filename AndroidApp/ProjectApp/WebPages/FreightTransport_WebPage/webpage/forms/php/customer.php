<?php
$opcion=$_POST['option'];
if ($opcion =='Registrar'):
    //$url = "http://localhost:1024//FreightTransport/project/client/addClient";
    
    $url = "http://localhost:8080/FreightTransport/project/client/addClient";
    $idCustomer = $_POST['idcustomer'];
    $nameCustomer = $_POST['namecustomer'];
    $rucCustomer = $_POST['ruccustomer'];
    $fonoCustomer = $_POST['fono1customer'];
    $cellphoneCustomer = $_POST['fono2customer'];
    $emailCustomer = $_POST['emailCustomer'];
    $addressCustomer = $_POST['addressCustomer'];
    
    $data =array('ciClient' =>$idCustomer, 'rucClient'=>$rucCustomer,
                 'nameClient'=>strval($nameCustomer),'addressClient'=>$addressCustomer,'phoneClient'=>$fonoCustomer,
                 'mobileClient'=>$cellphoneCustomer,'emailClient'=>$emailCustomer);    
     
    $cli=curl_init($url);
    curl_setopt($cli, CURLOPT_RETURNTRANSFER, true);
    //curl_setopt($cli, CURLOPT_URL,$url);
    curl_setopt($cli, CURLOPT_POST,true);
    curl_setopt($cli, CURLOPT_HTTPHEADER, array('Content-Type: application/json'));
    curl_setopt($cli, CURLOPT_POSTFIELDS,json_encode($data));

    $respone = curl_exec($cli);
    
    if($respone == false){    
        echo"<center> <h1>Cliente No Registrado</h1></center>";
       
    }else{
        echo"<center> <h1>Cliente Registrado</h1></center>";
        
    }
    ?>
    <br>
    <center >
        <a href="../html/Client.html">Regresar</a>
    </center>
    <?php
    curl_close($cli);
    
    elseif ($opcion == 'Buscar'):
                $id = $_POST['idcustomer'];
                echo " <center><h1>Cliente</h1></center>";
                 $dataId = json_decode(file_get_contents("http://localhost:1024/FreightTransport/project/client/searchClient/$id"),true);
                //$dataId = json_decode(file_get_contents("http://localhost:8080/FreightTransport/project/client/searchClient/$id"),true);
        if($dataId==null){
                echo "<center> <h2>No se Encontraron datos</h2></center>";
        }else{
            ?> 
                <html lang="en">
                <head>
                <link rel="stylesheet" href="../css/styles.css">
                  <title>Cliente</title>
                 </head>
                 <body>
                <body class="col-sm-8 main-section mx-auto">
                    <br>
                <div class="styletittle">
                                        Datos del cliente
                                    </div><br>
                <center><table class="table" border="1"  >
                        <tr>
                            <td>ci</td>
                            <td>ruc</td>
                            <td>nombre</td>
                            <td>direccion</td>
                            <td>telefono convencional</td>
                            <td>telefono celular</td>	
                            <td>correo</td>	
                        </tr>
        
                        <tr>
                            <td><?php echo $dataId['ciClient'] ?></td>
                            <td><?php echo $dataId['rucClient'] ?></td>
                            <td><?php echo $dataId['nameClient'] ?></td>
                            <td><?php echo $dataId['addressClient']?></td>
                            <td><?php echo $dataId['phoneClient']?></td>
                            <td><?php echo $dataId['mobileClient'] ?></td>
                            <td><?php echo $dataId['emailClient']?></td>
                        </tr>
						
						</body>
        </html>
                        <?php 
                        
                        ?>
                        </table>
                                
                    </center> <br>
    
   <?php
            }
   ?>
   <center >
        <a href="../html/Client.html">Regresar</a>
    </center>
   <?php             

        elseif ($opcion == 'Eliminar'):
            $idC = $_POST['idcustomer'];
			//$url = "http://localhost:1024/FreightTransport/project/client/deleteClient/$idC";
            $url = "http://localhost:8080/FreightTransport/project/client/deleteClient/$idC";           
            $ch = curl_init();
            curl_setopt($ch, CURLOPT_URL, $url);
            curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "DELETE");
            curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
            $response  = curl_exec($ch);
            curl_close($ch);
            echo"<center> <h2>Cliente eliminado</h2></center>";
    ?>
    <br>
    <center >
        <a href="../html/Client.html">Regresar</a>
    </center>
    <?php   
elseif ($opcion == 'Modificar'):  
            $idCustomer = $_POST['idcustomer'];
            $nameCustomer = $_POST['namecustomer'];
            $rucCustomer = $_POST['ruccustomer'];
            $fonoCustomer = $_POST['fono1customer'];
            $cellphoneCustomer = $_POST['fono2customer'];
            $emailCustomer = $_POST['emailCustomer'];
            $addressCustomer = $_POST['addressCustomer'];

            $url = "http://localhost:8080/FreightTransport/project/client/updateclient/$idCustomer";
         // $url = "http://localhost:1024/FreightTransport/project/client/updateclient/$idCustomer";  

         $data =array('ciClient' =>$idCustomer, 'rucClient'=>$rucCustomer,'nameClient'=>strval($nameCustomer),
                      'addressClient'=>$addressCustomer,'phoneClient'=>$fonoCustomer,
                     'mobileClient'=>$cellphoneCustomer,'emailClient'=>$emailCustomer);  
                
                   
            $data_json = json_encode($data);
            $ch = curl_init();
            curl_setopt($ch, CURLOPT_URL, $url);
            curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type: application/json','Content-Length: ' . strlen($data_json)));
            curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'PUT');
            curl_setopt($ch, CURLOPT_POSTFIELDS,$data_json);
            curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
            $response  = curl_exec($ch);
            curl_close($ch);
            echo"<center> <h2>Cliente Modificado</h2></center>"; 
            echo $data_json; 

    ?>
    <br>
    <center >
        <a href="../html/Client.html">Regresar</a>
    </center>
    <?php
             
elseif ($opcion == 'Ver Clientes'):
                $data = json_decode(file_get_contents("http://localhost:8080/FreightTransport/project/client/clients"),true);
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
                                                Clientes Registrados
                                            </div><br>
                <center><table class="table" border="1" >
                        <tr class="table-primary">
                            <td>ci</td>
                            <td>ruc</td>
                            <td>nombre</td>
                            <td>direccion</td>
                            <td>telefono convencional</td>
                            <td>telefono celular</td>	
                            <td>correo</td>	               
                                    
                        </tr>
                        <?php 
                        foreach ($data as $dataId){
                        ?>
                        <tr>
                            <td><?php echo $dataId['ciClient'] ?></td>
                            <td><?php echo $dataId['rucClient'] ?></td>
                            <td><?php echo $dataId['nameClient'] ?></td>
                            <td><?php echo $dataId['addressClient']?></td>
                            <td><?php echo $dataId['phoneClient']?></td>
                            <td><?php echo $dataId['mobileClient'] ?></td>
                            <td><?php echo $dataId['emailClient']?></td>
                        </tr>
                </body>
                </html>
                        <?php 
                        }
                        ?>
                        </table>
                                
                    </center>
         <center >
        <a href="../html/Client.html">Regresar</a>
         </center>
    <?php 
        endif;
 ?>