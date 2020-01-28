$(document).ready(function() {
    $('#addproduct').click(function() {
        event.preventDefault();
        var idguide = document.getElementById("idguide").value;
        var codeprouct = document.getElementById("codeproduct").value;
        var quantityproduct = document.getElementById("quantityproduct").value;
        $.ajax({
            type: 'POST',
            url: '../php/addproduct.php',
            data: [{
                name: 'idguide',
                value: idguide
            }, {
                name: 'codeproduct',
                value: codeprouct
            }, {
                name: 'quantityproduct',
                value: quantityproduct
            }],
            success: function(response) {
                alert("Agregado Correctamente");
            },
            error: function(response) {
                alert("Error al Agregar");
            }
        });
    });
});