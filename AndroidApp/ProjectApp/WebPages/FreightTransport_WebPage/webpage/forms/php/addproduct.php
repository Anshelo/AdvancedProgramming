<?php

    $url = "http://localhost:1024/FreightTransport/project/guide/calculatetotal/addguidedetail";
    $idguidedetail = $_POST['idguide'];
    $codeproduct = $_POST['codeproduct'];
    $quantityproduct = $_POST['quantityproduct'];
       
    $data =array('guideId' =>$idguidedetail, 'productCode'=>$codeproduct, 'quantity'=>$quantityproduct);    
    $cli=curl_init($url);
    curl_setopt($cli, CURLOPT_HTTPHEADER, array('Content-Type: application/json'));
    curl_setopt($cli, CURLOPT_POST,true);
    curl_setopt($cli, CURLOPT_POSTFIELDS,json_encode($data));
    curl_setopt($cli, CURLOPT_RETURNTRANSFER, true);
    $respone = curl_exec($cli);
    curl_close($cli);

?>