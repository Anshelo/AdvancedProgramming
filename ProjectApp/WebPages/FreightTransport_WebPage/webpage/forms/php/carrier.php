<?php
$opcion=$_POST['option'];
if ($opcion =='Registrar'):
    //$url = "http://localhost:1024//FreightTransport/project/client/addClient";
    
    $url = "http://localhost:8080/FreightTransport/project/carrier/addcarrier";
    $idCarrier = $_POST['idcarrier'];
    $ciCarrier = $_POST['cicarrier'];
	$birthdateCarrier = $_POST['birthDate'];
    $nameCarrier= $_POST['namecarrier'];
    $addressCarrier = $_POST['addresscarrier'];
    $phoneCarrier= $_POST['phone'];
    $mobileCarrier = $_POST['mobile'];
    $emailCarrier = $_POST['emailcarrier'];
    $truckPlate = $_POST['truckplate'];
    $truckType = $_POST['trucktype'];

    $data =array('idCarrier' =>$idCarrier, 'ci'=>$ciCarrier,'birthDate'=>$birthdateCarrier,
                'name'=>$nameCarrier,'address'=>$addressCarrier,'phone'=>$phoneCarrier,
                'mobile'=>$mobileCarrier,'email'=>$emailCarrier,'truckPlate'=>$truckPlate,'truckType'=> $truckType);    
    
    $cli=curl_init($url);
    curl_setopt($cli, CURLOPT_RETURNTRANSFER, true);
    //curl_setopt($cli, CURLOPT_URL,$url);
    curl_setopt($cli, CURLOPT_POST,true);
    curl_setopt($cli, CURLOPT_HTTPHEADER, array('Content-Type: application/json'));
    curl_setopt($cli, CURLOPT_POSTFIELDS,json_encode($data));

    $respone = curl_exec($cli);
    
    if($respone == false){    
        echo"<center> <h1>Transportista No Registrado</h1></center>";
       
    }else{
        echo"<center> <h1>Transportista Registrado</h1></center>";
        
        
    }
	?>
	<br>
    <center >
        <a href="../html/Carrier.html">Regresar</a>
    </center>
	<?php
	
    
    curl_close($cli);
    elseif ($opcion == 'Buscar'):
                $id = $_POST['idcarrier'];
                echo " <center><h1>Carrier</h1></center>";
                //$dataId = json_decode(file_get_contents("http://localhost:1024/FreightTransport/project/carrier/getcarrierbyid/$id"),true);
                $dataId = json_decode(file_get_contents("http://localhost:8080/FreightTransport/project/carrier/getcarrierbyid/$id"),true);
                if($dataId==null){
					echo "<center> <h2>No se Encontraron datos</h2></center>";
                }else{
					?>
					<html lang="en">
					<head>
					<link rel="stylesheet" href="../css/styles.css">
					  <title>Transportista</title>
					 </head>
					 <body>
					<body class="col-sm-8 main-section mx-auto">
						<br>
					<div class="styletittle">
                                        Datos del Transportista
                                    </div><br>
					<center><table class="table" border="1" >
                        <tr class="table-primary">
                            <td>codigotransp</td>
							<td>ci</td>
							<td>birthdate</td>
							<td>nombre</td>
							<td>direccion</td>
							<td>telfconvencional</td>	
							<td>telfcelular</td>
							<td>correo</td>
							<td>placaCamion</td>
							<td>tipoCamion</td>
                        </tr>
        
                        <tr>
                            <td><?php echo $dataId['idCarrier']?></td>
							<td><?php echo $dataId['ci'] ?></td>
							<td><?php echo $dataId['birthDate'] ?></td>
							<td><?php echo $dataId['name']?></td>
							<td><?php echo $dataId['address']?></td>
							<td><?php echo $dataId['phone'] ?></td>
							<td><?php echo $dataId['mobile']?></td>
							<td><?php echo $dataId['email']?></td>
							<td><?php echo $dataId['truckPlate']?></td>
							<td><?php echo $dataId['truckType']?></td>>
                        </tr>
						</body>
						</html>
                        <?php 
                        
                        ?>
                        </table>
                                
                    </center><br>
                    <?php
					}
			   ?>
			   <center >
					<a href="../html/Carrier.html">Regresar</a>
				</center>
		<?php
		elseif ($opcion == 'Eliminar'):
            $idC = $_POST['idcarrier'];
			//$url = "http://localhost:1024/FreightTransport/project/client/deleteClient/$idC";
            $url = "http://localhost:8080/FreightTransport/project/carrier/deletecarrier/$idC";           
            $ch = curl_init();
            curl_setopt($ch, CURLOPT_URL, $url);
            curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "DELETE");
            curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
            $response  = curl_exec($ch);
            curl_close($ch);
            echo"<center> <h2>Transportista Eliminado</h2></center>"; 
	?>
	<br>
    <center >
        <a href="../html/Carrier.html">Regresar</a>
    </center>
    <?php
	
         elseif ($opcion == 'Modificar'):  
            $idCarrier = $_POST['idcarrier'];
			$ciCarrier = $_POST['cicarrier'];
			$birthdateCarrier = $_POST['birthDate'];
			$nameCarrier= $_POST['namecarrier'];
			$addressCarrier = $_POST['addresscarrier'];
			$phoneCarrier= $_POST['phone'];
			$mobileCarrier = $_POST['mobile'];
			$emailCarrier = $_POST['emailcarrier'];
			$truckPlate = $_POST['truckplate'];
			$truckType = $_POST['trucktype'];
            
            $url = "http://localhost:8080/FreightTransport/project/carrier/updatecarrier/$idCarrier";
         // $url = "http://localhost:1024/FreightTransport/project/client/updateclient/$idCustomer";  

            
        
            $data =array('idCarrier' =>$idCarrier, 'ci'=>$ciCarrier,'birthDate'=>$birthdateCarrier,
                'name'=>$nameCarrier,'address'=>$addressCarrier,'phone'=>$phoneCarrier,
                'mobile'=>$mobileCarrier,'email'=>$emailCarrier,'truckPlate'=>$truckPlate,'truckType'=> $truckType);          
                   
            $data_json = json_encode($data);
            $ch = curl_init();
            curl_setopt($ch, CURLOPT_URL, $url);
            curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type: application/json','Content-Length: ' . strlen($data_json)));
            curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'PUT');
            curl_setopt($ch, CURLOPT_POSTFIELDS,$data_json);
            curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
            
            $response  = curl_exec($ch);
            curl_close($ch);
            echo"<center> <h2>Transportista Modificado</h2></center>"; 
            echo $data_json; 
	?>
	<br>
    <center >
        <a href="../html/Carrier.html">Regresar</a>
    </center>
    <?php
    elseif ($opcion == 'Ver Transportistas'):
    
        $data = json_decode(file_get_contents("http://localhost:8080/FreightTransport/project/carrier/getcarriers"),true);
        ?>
		<html lang="en">
                <head>
                <link rel="stylesheet" href="../css/styles.css">
                    <title>Carriers</title>
                </head>
                <body>
                <body class="col-sm-8 main-section mx-auto">
                    <br>
                <div class="styletittle">
                                                Transportistas Registrados
                                            </div><br>
        <div style="text-align:center;">
		<table class ="table" border="1" style="margin: 0 auto;">
                <tr class="table-primary">
                    <td>codigotransp</td>
                    <td>ci</td>
                    <td>birthdate</td>
                    <td>nombre</td>
                    <td>direccion</td>
                    <td>telfconvencional</td>	
                    <td>telfcelular</td>
                    <td>correo</td>
                    <td>placaCamion</td>
                    <td>tipoCamion</td>	
					
                </tr>

                <?php 
                foreach ($data as $dataId){
                ?>
                <tr>
                    <td><?php echo $dataId['idCarrier']?></td>
                    <td><?php echo $dataId['ci']?></td>
                    <td><?php echo $dataId['birthDate']?></td>
                    <td><?php echo $dataId['name']?></td>
                    <td><?php echo $dataId['address']?></td>
                    <td><?php echo $dataId['phone']?></td>
                    <td><?php echo $dataId['mobile']?></td>
                    <td><?php echo $dataId['email']?></td>
                    <td><?php echo $dataId['truckPlate']?></td>
                    <td><?php echo $dataId['truckType']?></td>
                </tr>
				</body>
				</html>
                <?php 
                }
                ?>
                </table>
				</div>
            </center>
			 <center >
			<a href="../html/Carrier.html">Regresar</a>
			 </center>
            <?php 
            elseif ($opcion == 'BuscarPorPlaca'):
                $truck = $_POST['truckplate'];
                echo " <center><h1>Carrier</h1></center>";
                //$dataId = json_decode(file_get_contents("http://localhost:1024/FreightTransport/project/carrier/getcarrierbyid/$id"),true);
                $dataId = json_decode(file_get_contents("http://localhost:8080/FreightTransport/project/carrier/getcarrierbytruck/$truck"),true);
                if($dataId==null){
					echo "<center> <h2>No se Encontraron datos</h2></center>";
                }else{
					?>
					<html lang="en">
					<head>
					<link rel="stylesheet" href="../css/styles.css">
					  <title>Transportista</title>
					 </head>
					 <body>
					<body class="col-sm-8 main-section mx-auto">
						<br>
					<div class="styletittle">
                                        Lista de Transportistas - Camiones
                                    </div><br>
					<center><table class="table" border="1" >
                        <tr class="table-primary">
                            <td>codigotransp</td>
							<td>ci</td>
							<td>birthdate</td>
							<td>nombre</td>
							<td>direccion</td>
							<td>telfconvencional</td>	
							<td>telfcelular</td>
							<td>correo</td>
							<td>placaCamion</td>
							<td>tipoCamion</td>
                        </tr>
        
                        <tr>
                            <td><?php echo $dataId['idCarrier']?></td>
							<td><?php echo $dataId['ci'] ?></td>
							<td><?php echo $dataId['birthDate'] ?></td>
							<td><?php echo $dataId['name']?></td>
							<td><?php echo $dataId['address']?></td>
							<td><?php echo $dataId['phone'] ?></td>
							<td><?php echo $dataId['mobile']?></td>
							<td><?php echo $dataId['email']?></td>
							<td><?php echo $dataId['truckPlate']?></td>
							<td><?php echo $dataId['truckType']?></td>>
                        </tr>
						</body>
						</html>
                        <?php 
                        
                        ?>
                        </table>
                                
                    </center><br>
                    <?php
					}
			   ?>
			   <center >
					<a href="../html/Carrier.html">Regresar</a>
				</center>
		<?php 
        
             
    endif;
 ?>