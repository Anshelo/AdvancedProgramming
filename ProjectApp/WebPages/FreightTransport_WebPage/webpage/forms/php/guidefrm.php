<?php
  $mysqli = new mysqli('dbinstance.cndtjrwnep9m.us-east-1.rds.amazonaws.com', 'root', '12345678', 'database_transportes');
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
                                <br>
                                <div class="ImaCustomer">
                                    <IMG SRC="../images/guide.png" width="150"><br>
                                </div>
                                <tbody>
                                    <tr>
                                        <div class="form-group">
                                            <td>
                                                <div class="label">Id Guia: </div>
                                            </td>
                                            <td><input type="number" class="form-control" id="idguide" name="idguide" placeholder="1" autofocus min="0"></td>
                                            <td colspan="4"></td>
                                        </div>
                                    </tr>
                                    <tr>
                                        <div class="form-group">
                                            <td>
                                                <div class="label">Fecha envio: </div>
                                            </td>
                                            <td><input type="date" value="" class="form-control" min="2018-01-01" max="2025-12-31" step="1" name="datesent" placeholder="2019-02-30">
                                            </td>
                                            <td></td>
                                            <td>
                                                <div class="label">Fecha llegada: </div>
                                            </td>
                                            <td><input type="date" value="" class="form-control" min="2018-01-01" max="2025-12-31" step="1" name="datereceive" placeholder="2019-02-30">
                                            </td>
                                            <td colspan="4"></td>
                                        </div>
                                    </tr>
                                    <tr>
                                        <div class="form-group">
                                            <td colspan="3">
                                                <subtitles>
                                                    Cliente
                                                </subtitles>

                                            </td>
                                            <td colspan="3">
                                                <subtitles>
                                                    Transportista
                                                </subtitles>

                                            </td>
                                        </div>
                                    </tr>
                                    <tr>
                                        <div class="form-group">
                                            <td>
                                                <div class="label">Nombre: </div>
                                            </td>
                                            <td>
                                            <select name="idcustomer" id="idcustomer"class="form-control">
                                                <option value="0">Seleccione:</option>
                                                <?php
                                                $query = $mysqli -> query ("SELECT * FROM cliente");
                                                while ($valores = mysqli_fetch_array($query)) {
                                                    echo '<option value="'.$valores[ci].'">'.$valores[nombre].'</option>';
                                                }
                                                ?>
                                            </select>
                                            </td><td></td>
                                            <td>
                                                <div class="label">Nombre: </div>
                                            </td>
                                            <td>
                                            <select name="idcarrier" id="idcarrier"class="form-control">
                                                <option value="0">Seleccione:</option>
                                                <?php
                                                $query = $mysqli -> query ("SELECT * FROM transportista");
                                                while ($valores = mysqli_fetch_array($query)) {
                                                    echo '<option value="'.$valores[ci].'">'.$valores[nombre].'</option>';
                                                }
                                                ?>
                                            </select>
                                            </td>
                                        </div>
                                    </tr>

                                    <tr>
                                        <div class="form-group">
                                            <td>
                                                <div class="label">Zona de envio: </div>
                                            </td>
                                            <td>
                                            <select name="codezone" id="codezone"class="form-control">
                                                <option value="0">Seleccione:</option>
                                                <?php
                                                $query = $mysqli -> query ("SELECT * FROM zona");
                                                while ($valores = mysqli_fetch_array($query)) {
                                                    echo '<option value="'.$valores[codigozona].'">'.$valores[nombrezona].'</option>';
                                                }
                                                ?>
                                            </select>
                                            </td>
                                            <td colspan="4"></td>
                                        </div>
                                    </tr>
                                    <tr>
                                        <div class="form-group label">
                                            <td colspan="7">
                                                <subtitles>
                                                    Productos
                                                </subtitles>
                                            </td>

                                        </div>
                                    </tr>
                                </tbody>
                                <table class="table">
                                   <body>
                                   <tr>
                                        <div class="form-group">
                                            <td colspan="3">
                                                <div class="label">Descripcion </div>
                                            </td><td></td>
                                            <td >
                                                <div class="label">Cantidad </div>
                                            </td><td></td><td></td>
                                        </div>
                                    </tr>
                                    <tr>
                                    <div class="form-group">
                                    <td colspan="3">
                                            <select name="codeproduct" id="codeproduct"class="form-control">
                                                <option value="0">Seleccione:</option>
                                                <?php
                                                $query = $mysqli -> query ("SELECT * FROM producto");
                                                while ($valores = mysqli_fetch_array($query)) {
                                                    echo '<option value="'.$valores[codigoprod].'">'.$valores[nombreprod].'</option>';
                                                }
                                                ?>
                                            </select>
                                            </td><td></td>
                                        <td>
                                            <input type="number" min="1" class="form-control" id="quantityproduct" name="quantityproduct" placeholder="4" onkeypress="return validatedoubles(event)" onpaste="return false">
                                        </td><td></td>
                                        <td >
                                            <input style="background-color: rgb(52, 162, 212); object-position: right;" class="btn btn-primary  center " type="submit" class="" id="addproduct" name="option" value="+">
                                        <p class="respuesta"></p></td>       
                                    </div>
                                    </tr>
                                            </body>                 
                                </table>
                            </table>
                            <table class="table">

                                <body>
                                    <tr>
                                        <div class="form-group">
                                            <td>
                                                <input style="background-color: rgb(52, 162, 212);" class="btn btn-primary btn-block  center " type="submit" class="" name="option" value="Registrar">
                                            </td>
                                            <td>
                                                <input style="background-color: rgb(52, 162, 212);" type="submit" class="btn btn-primary btn-block center " name="option" value="Modificar">
                                            </td>
                                            <td>
                                                <input style="background-color: rgb(52, 162, 212);" type="submit" class="btn btn-primary btn-block center " name="option" value="Eliminar">
                                            </td>
                                            <td>
                                                <input style="background-color: rgb(52, 162, 212);" type="submit" class="btn btn-primary btn-block center " name="option" value="Buscar">
                                            </td>
                                            <td>
                                                <input style="background-color: rgb(52, 162, 212);" type="submit" class="btn btn-primary btn-block center " name="option" value="Ver registros">
                                            </td>
                                        </div>

                                    </tr>
                                    <tr>
                                        <td>
                                            <td colspan="3">
                                                <center>
                                                    <a href="../html/home.html">Menu Principal</a>
                                                </center>

                                            </td>
                                        </td>
                                    </tr>
                                </body>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        </div>
    </form>
</body>

</html>