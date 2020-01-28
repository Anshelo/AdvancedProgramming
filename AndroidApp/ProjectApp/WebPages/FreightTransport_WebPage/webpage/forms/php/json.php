<?php>
    if ($_POST[btnsearch]) 
    { 
        $url="http://dacruzvi.webcindario.com";
        echo "<SCRIPT>window.location='$url';</SCRIPT>"; 
    }
    $st1="http://localhost:1024/FreightTransport/project/guide/showguidebyid/"; //a qui pones tu url externa
$st2=$st1."1";
$url=$st2;
echo "<SCRIPT>window.location='$url';</SCRIPT>";

</?>