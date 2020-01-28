<?php
  $mysqli = new mysqli('dbinstance.cndtjrwnep9m.us-east-1.rds.amazonaws.com', 'root', '12345678', 'database_transportes');
?>
<?php
$opcion=$_POST['option'];
if ($opcion =='Registrar'):
    $url = "http://localhost:1024/FreightTransport/project/guide/insertguide";
    $idguide = $_POST['idguide'];
    $datesent = $_POST['datesent'];
    $datereceive = $_POST['datereceive'];
    $idcustomer = $_POST['idcustomer'];
    $idcarrier = $_POST['idcarrier'];
    $codezone = $_POST['codezone'];    
    $data =array('guideId' =>$idguide, 'sendDate'=>$datesent, 'deliverDate'=>$datereceive,
    'customerId'=>$idcustomer, 'carrierCard'=>$idcarrier,'zoneCode'=>$codezone);    
    $data_json = json_encode($data);
    $cli=curl_init($url);
    curl_setopt($cli, CURLOPT_HTTPHEADER, array('Content-Type: application/json'));
    curl_setopt($cli, CURLOPT_POST,true);
    curl_setopt($cli, CURLOPT_POSTFIELDS,json_encode($data));
    curl_setopt($cli, CURLOPT_RETURNTRANSFER, true);
    $respone = curl_exec($cli);
    curl_close($cli);
    $idg = $_POST['idguide'];
    $codeproduct = $_POST['codeproduct']; 
                $dataread = json_decode(file_get_contents("http://localhost:1024/FreightTransport/project/guide/showguidebyid/$idg"),true);
                $datareadclient = json_decode(file_get_contents("http://localhost:1024/FreightTransport/project/client/searchClient/$idcustomer"),true);
                $datareadcarrier = json_decode(file_get_contents("http://localhost:1024/FreightTransport/project/carrier/showcarrierbyid/$idcarrier"),true);
                $datareadzone = json_decode(file_get_contents("http://localhost:1024/FreightTransport/project/zone/zone/$codezone"),true);

?>
                <html lang="en">
<head>
    <link rel="stylesheet" href="../css/styles.css">
    <script src="https://code.jquery.com/jquery-2.2.2.min.js"></script>
    <script src="../js/formsent.js"></script>
    <script src="../js/validations.js"></script>
    <script src="../php/json.php"></script>

    <title>Formulario Guia</title>
</head>

<body>
    <form name="guide" id="guideproduct" method="post" action="../php/guide.php">
        <div class="modal-body text-center">
            <div class="col-sm-8 main-section mx-auto">
                <div class="modal-content">
                    <div class="col-33 ">
                        <form class="col-33"><br>
                            <table class="table">

                                <head>
                                    <div class="styletittle">
                                        Guia de remision
                                    </div>
                                </head>
                                <tbody>
                                    <tr>
                                        <div class="form-group">
                                            <td>
                                                <div class="label">Id Guia: </div>
                                            </td>
                                            <td><input type="number" class="form-control" id="idguide" name="idguide" disabled value="<?php echo $dataread['guideId'] ?>"></td>
                                            <td colspan="4"></td>
                                        </div>
                                    </tr>
                                    <tr>
                                        <div class="form-group">
                                            <td>
                                                <div class="label">Fecha envio: </div>
                                            </td>
                                            <td><input type="date" value="<?php echo $dataread['sendDate'] ?>" disabled class="form-control" name="datesent" >
                                            </td>
                                            <td></td>
                                            <td>
                                                <div class="label">Fecha llegada: </div>
                                            </td>
                                            <td><input type="date" value="<?php echo $dataread['deliverDate'] ?>" disabled  class="form-control" name="datereceive" >
                                            </td>
                                            <td colspan="4"></td>
                                        </div>
                                    </tr>
                                    <tr>
                                        <div class="form-group">
                                            <td colspan="6">
                                                <subtitles>
                                                    Datos cliente
                                                </subtitles>

                                            </td>
                                        </div>
                                        <tr>
                                            <div class="form-group">
                                                <td>
                                                    <div class="label">Cedula </div>
                                                </td>
                                                <td><input type="text" class="form-control" name="idcustomer" disabled  id="id" value="<?php echo $dataread['customerId'] ?>"></td>
                                                <td></td>
                                                <td >
                                                    <div class="label">Nombre </div>
                                                </td>
                                                <td ><input type="text" class="form-control" name="idcustomer" disabled  id="id" value="<?php echo $datareadclient['nameClient'] ?>"></td>
                                            
                                               
                                        </tr>
                                        <tr>
                                            <div class="form-group">
                                            <td>
                                                    <div class="label">Direccion </div>
                                                </td>
                                                <td ><input type="text" class="form-control" name="idcustomer" disabled  id="id" value="<?php echo $datareadclient['addressClient'] ?>"></td>
                                                <td></td>
                                                <td >
                                                    <div class="label">Email </div>
                                                </td>
                                                <td><input type="text" class="form-control" name="idcustomer" disabled  id="id" value="<?php echo $datareadclient['emailClient'] ?>"></td>
                                                
                                                
                                            </div>
                                        </tr>
                                        <tr>
                                            <div class="form-group">
                                            <td >
                                                    <div class="label">Celular </div>
                                                </td>
                                                <td><input type="text" class="form-control" name="idcustomer" disabled  id="id" value="<?php echo $datareadclient['mobileClient'] ?>"></td>
                                                <td></td>
                                                <td >
                                                    <div class="label">RUC </div>
                                                </td>
                                                <td ><input type="text" class="form-control" name="idcustomer" disabled  id="id" value="<?php echo $datareadclient['rucClient'] ?>"></td>
                                            
                                            </div>
                                        </tr>
                                       
                                        <tr>
                                            <div class="form-group label">
                                                <td colspan="7">
                                                    <subtitles>
                                                        Datos Transportista
                                                    </subtitles>
                                                </td>

                                            </div>
                                        </tr>
                                        <tr>
                                            <div class="form-group">
                                                <td>
                                                    <div class="label">Cedula: </div>
                                                </td>
                                                <td><input type="text" class="form-control" disabled  value="<?php echo $dataread['carrierCard']?>" name="idcarrier" >
                                                </td>
                                                <td></td>
                                                <td>
                                                    <div class="label">Nombre: </div>
                                                </td>
                                                <td >
                                                    <input type="text" class="form-control" disabled name="codezone" value="<?php echo $datareadcarrier['name']?>">
                                                </td>
                                            </div>
                                        </tr>
                                        <tr>
                                            <div class="form-group">
                                                <td>
                                                    <div class="label">Tipo Camion: </div>
                                                </td>
                                                <td><input type="text" class="form-control" disabled  value="<?php echo $datareadcarrier['truckType']?>" name="idcarrier" >
                                                </td>
                                                <td></td>
                                                <td>
                                                    <div class="label">Placa: </div>
                                                </td>
                                                <td><input type="text" class="form-control" disabled  value="<?php echo $datareadcarrier['truckPlate']?>" name="idcarrier" >
                                                </td>
                                            </div>
                                        </tr>
                                        <tr>
                                            <div class="form-group">
                                                <td>
                                                    <div class="label">Codigo zona envio: </div>
                                                </td>
                                                <td >
                                                    <input type="text" class="form-control" disabled name="codezone" value="<?php echo $dataread['zoneCode']?>">
                                                </td>
                                                <td></td>
                                                <td>
                                                    <div class="label">Ciudad: </div>
                                                </td>
                                                <td >
                                                    <input type="text" class="form-control" disabled name="codezone" value="<?php echo $datareadzone['nombrezona']?>">
                                                </td>
                                            </div>
                                        </tr>
                                        <tr>
                                            <div class="form-group">
                                                <td>
                                                    <div class="label">Codigo </div>
                                                </td>
                                                <td>
                                                    <div class="label">Descipcion </div>
                                                </td>
                                                <td>
                                                    <div class="label">Cantidad </div>
                                                </td>
                                                <td>
                                                    <div class="label">Peso </div>
                                                </td>
                                                <td>
                                                    <div class="label">Valor Unitario</div>
                                                </td>
                                            </div>
                                        </tr>
                                        <tr>
                                            <div class="form-group">
                                            <table class="table">
                                                <?php
                                                $query = $mysqli -> query ("SELECT d.codproducto, p.nombreprod, d.cantidad, p.valorunit, p.peso FROM detalleguia d, producto p where d.codproducto=p.codigoprod and d.idguia like $idguide");
                                                    while($valores=mysqli_fetch_array($query))
                                                    {
                                                        echo "<tr>"
                                                            ."<td>".$valores['codproducto']."</td>"
                                                            ."<td>".$valores['nombreprod']."</td>"
                                                            ."<td>".$valores['cantidad']."</td>"
                                                            ."<td>".$valores['peso']."</td>"
                                                            ."<td>".$valores['valorunit']."</td>"
                                                            ."</tr>";
                                                    }
                                                    ?>
                                            </table>
                                            
                                            </div>
                                        </tr>
                                </tbody>
                            </table>
                            <table class="table">
                                <body>
                                <tr>
                                            <div class="form-group">
                                                <td>
                                                    <div class="label">Cantidad total:</div>
                                                </td>
                                                <td>
                                                    <input type="text" class="form-control" disabled  id="quantityguide"name="quantityguide" value="<?php echo $dataread['quantity']?>">
                                                </td>
                                            </div>
                                            <div class="form-group">
                                                <td>
                                                    <div class="label">Total a pagar: </div>
                                                </td>
                                                <td>
                                                    <input type="text" class="form-control" disabled name="totalguide" value="<?php echo $dataread['total']?>">
                                                </td>
                                                <td></td>
                                                <td></td>
                                            </div>

                                        </tr>
                                        <tr>
                                        <td colspan="3">
                                                <center>
                                                    <a href="../html/home.html">Menu Principal</a>
                                                </center>

                                            </td>
                                    </tr>
                                </body>
                            </table>
                    </div>
                </div>
            </div>
        </div>
        </div>
    </form>
</body>
</html>  

<?php
elseif ($opcion == 'Ver registros'):
        $data = json_decode(file_get_contents("http://localhost:1024/FreightTransport/project/guide/showallguides"),true);
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
                                        Guías de Remisión
                                    </div><br>
        <center><table class="table" border="1" >
                <tr class="table-primary">
                    <td>ID</td>
                    <td>Fecha envio</td>
                    <td>Fecha recepcion</td>
                    <td>ID transportista</td>
                    <td>Ci Cliente</td>
                    <td>Cod. Zona envio</td>
                    <td>Cantidad</td>
                    <td>Total</td>                
                    		
                </tr>
                <?php 
                foreach ($data as $d){
                ?>
                <tr>
                    <td><?php echo $d['guideId'] ?></td>
                    <td><?php echo $d['sendDate'] ?></td>
                    <td><?php echo $d['deliverDate'] ?></td>
                    <td><?php echo $d['carrierCard']?></td>
                    <td><?php echo $d['customerId'] ?></td>
                    <td><?php echo $d['zoneCode']?></td>
                    <td><?php echo $d['quantity']?></td>
                    <td><?php echo $d['total']?></td> 
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
                $id = $_POST['idguide'];
                $dataId = json_decode(file_get_contents("http://localhost:1024/FreightTransport/project/guide/showguidebyid/$id"),true);
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
                                        Guías de Remisión
                                    </div><br>
        <center><table class="table" border="1" >
                <tr class="table-primary">
                <td>ID</td>
                    <td>Fecha envio</td>
                    <td>Fecha recepcion</td>
                    <td>ID transportista</td>
                    <td>Ci Cliente</td>
                    <td>Cod. Zona envio</td>
                    <td>Cantidad</td>
                    <td>Total</td> 		
                        </tr>
        
                        <tr>
                            <td><?php echo $dataId['guideId'] ?></td>
                            <td><?php echo $dataId['sendDate'] ?></td>
                            <td><?php echo $dataId['deliverDate'] ?></td>
                            <td><?php echo $dataId['carrierCard']?></td>
                            <td><?php echo $dataId['customerId'] ?></td>
                            <td><?php echo $dataId['zoneCode']?></td>
                            <td><?php echo $dataId['quantity']?></td>
                            <td><?php echo $dataId['total']?></td>
                            
                            
                            
                        </tr>
        </body>
        </html>
        
                        <?php 
                        
                        ?>
                        </table>
                                
                    </center>
                    <?php 
        elseif ($opcion == 'Eliminar'):
            $idG = $_POST['idguide'];
            $url = "http://localhost:1024/FreightTransport/project/guide/removeguide/$idG";   
            $url2="http://localhost:1024/FreightTransport/project/guide/removeguidedetail/$idG";     
            $ch = curl_init();
            $ch2 = curl_init();
            curl_setopt($ch, CURLOPT_URL, $url);
            curl_setopt($ch2, CURLOPT_URL, $url2);
            curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "DELETE");
            curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
            curl_setopt($ch2, CURLOPT_CUSTOMREQUEST, "DELETE");
            curl_setopt($ch2, CURLOPT_RETURNTRANSFER, true);
            $response  = curl_exec($ch);
            $response2  = curl_exec($ch2);
            curl_close($ch);
            curl_close($ch2);
            echo"<center> <h2>GUIDE DELETE</h2></center>"; ?>  
            <td colspan="3">
                                                <center>
                                                    <a href="../html/home.html">Menu Principal</a>
                                                </center>

                                            </td>
         <?php elseif ($opcion == 'Modificar'):  
            
            $idgui = $_POST['idguide'];
            $datesentm = $_POST['datesent'];
            $datereceivem = $_POST['datereceive'];
            $quantitym = $_POST['quantityguide'];
            $totalm = $_POST['totalguide'];
            $idcustomerm = $_POST['idcustomer'];
            $idcarrierm = $_POST['idcarrier'];
            $codezonem = $_POST['codezone'];          
            $url = "http://localhost:1024/FreightTransport/project/guide/updateguide/$idgui";         
            $data =array('sendDate'=>$datesentm, 'deliverDate'=>$datereceivem,'quantity'=>$quantitym,'total'=>$totalm,
            'customerId'=>$idcustomerm, 'carrierCard'=>$idcarrierm,'zoneCode'=>$codezonem);  
            $data_json = json_encode($data);
            $ch = curl_init();
            curl_setopt($ch, CURLOPT_URL, $url);
            curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type: application/json','Content-Length: ' . strlen($data_json)));
            curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'PUT');
            curl_setopt($ch, CURLOPT_POSTFIELDS,$data_json);
            curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
            $response  = curl_exec($ch);
            curl_close($ch);
            echo"<center> <h2>GUIDE MODIFY</h2></center>"; 
            echo $data_json; 
       endif;
		 ?>