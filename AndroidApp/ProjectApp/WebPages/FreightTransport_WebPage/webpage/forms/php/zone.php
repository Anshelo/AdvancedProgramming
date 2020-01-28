<?php
$opcion=$_POST['option'];
if ($opcion =='Registrar'):
    
    $url = "http://localhost:1024/FreightTransport/project/zone/insertzone";

    $codezone = $_POST['codigozona'];
    $namezone = $_POST['nombrezona'];
      
    $data =array('codigozona' =>$codezone, 'nombrezona'=>$namezone);    
     
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
        <a href="../html/Zone.html">Regresar</a>
    </center>
    <?php
    curl_close($cli);
    
    elseif ($opcion == 'Buscar'):
                $id = $_POST['codigozona'];
                echo " <center><h1>Zona</h1></center>";
                $dataId = json_decode(file_get_contents("http://localhost:1024/FreightTransport/project/zone/zone/$id"),true);
                
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
                                        Datos Zona
                                    </div><br>
                <center><table class="table" border="1"  >
                        <tr>
                            <td>Codigo Zona</td>
                            <td>Nombre Zona</td>
                        </tr>
        
                        <tr>
                            <td><?php echo $dataId['codigozona'] ?></td>
                            <td><?php echo $dataId['nombrezona'] ?></td>
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
        <a href="../html/Zone.html">Regresar</a>
    </center>
   <?php             

        elseif ($opcion == 'Eliminar'):
            $idC = $_POST['codigozona'];
            $url = "http://localhost:1024/FreightTransport/project/zone/removezone/$idC";           
            $ch = curl_init();
            curl_setopt($ch, CURLOPT_URL, $url);
            curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "DELETE");
            curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
            $response  = curl_exec($ch);
            curl_close($ch);
            echo"<center> <h2>Zona Eliminada</h2></center>";
    ?>
    <br>
    <center >
        <a href="../html/Zone.html">Regresar</a>
    </center>
    <?php   
elseif ($opcion == 'Modificar'):  
            $codezone = $_POST['codigozona'];
            $namezone = $_POST['nombrezona'];
            
            $url = "http://localhost:1024/FreightTransport/project/zone/modify/$codezone"; 

            $data =array('codigozona' =>$codezone, 'nombrezona'=>$namezone); 
                
                   
            $data_json = json_encode($data);
            $ch = curl_init();
            curl_setopt($ch, CURLOPT_URL, $url);
            curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type: application/json','Content-Length: ' . strlen($data_json)));
            curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'PUT');
            curl_setopt($ch, CURLOPT_POSTFIELDS,$data_json);
            curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
            $response  = curl_exec($ch);
            curl_close($ch);
            echo"<center> <h2>Zona Modificada</h2></center>"; 
            echo $data_json; 

    ?>
    <br>
    <center >
        <a href="../html/Zone.html">Regresar</a>
    </center>
    <?php
             
             elseif ($opcion == 'Ver registros'):
                $data = json_decode(file_get_contents("http://localhost:1024/FreightTransport/project/zone/zones"),true);
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
                                                Zonas Registradas
                                            </div><br>
                <center><table class="table" border="1" >
                        <tr class="table-primary">
                            <td>Codigo Zona</td>
                            <td>Nombre Zona</td>            
                                    
                        </tr>
                        <?php 
                        foreach ($data as $d){
                        ?>
                        <tr>
                            <td><?php echo $d['codigozona'] ?></td>
                            <td><?php echo $d['nombrezona'] ?></td>
                        </tr>
                </body>
                </html>
                        <?php 
                        }
                        ?>
                        </table>
                                
                    </center>
         <center >
        <a href="../html/Zone.html">Regresar</a>
         </center>
    <?php 
        endif;
 ?>