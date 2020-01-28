$(document).ready(function(){
	$('ul.tabs li a:first').addClass('active');
	$('.secciones article').hide();
	$('.secciones article:first').show();

	$('ul.tabs li a').click(function(){
		$('ul.tabs li a').removeClass('active');
		$(this).addClass('active');
		$('.secciones article').hide();

		var activeTab = $(this).attr('href');
		$(activeTab).show();
		return false;
	});
});

function validatenumbers(e) {
    key = e.keyCode || e.which;
    keyboard = String.fromCharCode(key);
    numbers = "0123456789";
    specials = "8-37-38-46";
    keyboard_special = false;
    for (var i in specials) {
        if (key == specials[i]) {
            keyboard_special = true;
        }
    }
    if (numbers.indexOf(keyboard) == -1 && !keyboard_special) {
        return false;
    }
}

function validatedoubles(e) {
    key = e.keyCode || e.which;
    keyboard = String.fromCharCode(key);
    numbers = "0123456789.";
    specials = "8-37-38-46";
    keyboard_special = false;
    for (var i in specials) {
        if (key == specials[i]) {
            keyboard_special = true;
        }
    }
    if (numbers.indexOf(keyboard) == -1 && !keyboard_special) {
        return false;
    }
}

function validateletters(e) {
    keyl = e.keyCode || e.which;
    keyboardl = String.fromCharCode(keyl).toLowerCase();
    letters = " abcdefghijklmnñopqrstuvxyz";
    specialsl = "8-37-38-46-164";
    keyboard_speciall = false;
    for (var i in specialsl) {
        if (keyl == specialsl[i]) {
            keyboard_speciall = true;
            break;
        }
    }
    if (letters.indexOf(keyboardl) == -1 && !keyboard_speciall) {
        return false;
    }
}

validarDocumento = function() {

    numero = document.getElementById('id').value;
    /* alert(numero); */
    var suma = 0;
    var residuo = 0;
    var pri = false;
    var pub = false;
    var nat = false;
    var numeroProvincias = 22;
    var modulo = 11;

    /* Verifico que el campo no contenga letras */
    var ok = 1;
    for (i = 0; i < numero.length && ok == 1; i++) {
        var n = parseInt(numero.charAt(i));
        if (isNaN(n)) ok = 0;
    }
    if (ok == 0) {
        alert("No puede ingresar caracteres en el número");
        return false;
    }

    if (numero.length < 10) {
        alert('El número ingresado no es válido');
        return false;
    }

    /* Los primeros dos digitos corresponden al codigo de la provincia */
    provincia = numero.substr(0, 2);
    if (provincia < 1 || provincia > numeroProvincias) {
        alert('El código de la provincia (dos primeros dígitos) es inválido');
        return false;
    }

    /* Aqui almacenamos los digitos de la cedula en variables. */
    d1 = numero.substr(0, 1);
    d2 = numero.substr(1, 1);
    d3 = numero.substr(2, 1);
    d4 = numero.substr(3, 1);
    d5 = numero.substr(4, 1);
    d6 = numero.substr(5, 1);
    d7 = numero.substr(6, 1);
    d8 = numero.substr(7, 1);
    d9 = numero.substr(8, 1);
    d10 = numero.substr(9, 1);

    /* El tercer digito es: */
    /* 9 para sociedades privadas y extranjeros   */
    /* 6 para sociedades publicas */
    /* menor que 6 (0,1,2,3,4,5) para personas naturales */
    if (d3 == 7 || d3 == 8) {
        alert('El tercer dígito ingresado es inválido');
        return false;
    }

    /* Solo para personas naturales (modulo 10) */
    if (d3 < 6) {
        nat = true;
        p1 = d1 * 2;
        if (p1 >= 10) p1 -= 9;
        p2 = d2 * 1;
        if (p2 >= 10) p2 -= 9;
        p3 = d3 * 2;
        if (p3 >= 10) p3 -= 9;
        p4 = d4 * 1;
        if (p4 >= 10) p4 -= 9;
        p5 = d5 * 2;
        if (p5 >= 10) p5 -= 9;
        p6 = d6 * 1;
        if (p6 >= 10) p6 -= 9;
        p7 = d7 * 2;
        if (p7 >= 10) p7 -= 9;
        p8 = d8 * 1;
        if (p8 >= 10) p8 -= 9;
        p9 = d9 * 2;
        if (p9 >= 10) p9 -= 9;
        modulo = 10;
    }
    /* Solo para sociedades publicas (modulo 11) */
    /* Aqui el digito verficador esta en la posicion 9, en las otras 2 en la pos. 10 */
    else if (d3 == 6) {
        pub = true;
        p1 = d1 * 3;
        p2 = d2 * 2;
        p3 = d3 * 7;
        p4 = d4 * 6;
        p5 = d5 * 5;
        p6 = d6 * 4;
        p7 = d7 * 3;
        p8 = d8 * 2;
        p9 = 0;
    }

    /* Solo para entidades privadas (modulo 11) */
    else if (d3 == 9) {
        pri = true;
        p1 = d1 * 4;
        p2 = d2 * 3;
        p3 = d3 * 2;
        p4 = d4 * 7;
        p5 = d5 * 6;
        p6 = d6 * 5;
        p7 = d7 * 4;
        p8 = d8 * 3;
        p9 = d9 * 2;
    }

    suma = p1 + p2 + p3 + p4 + p5 + p6 + p7 + p8 + p9;
    residuo = suma % modulo;
    /* Si residuo=0, dig.ver.=0, caso contrario 10 - residuo*/
    digitoVerificador = residuo == 0 ? 0 : modulo - residuo;
    /* ahora comparamos el elemento de la posicion 10 con el dig. ver.*/
    if (pub == true) {
        if (digitoVerificador != d9) {
            alert('El ruc de la empresa del sector público es incorrecto.');
            return false;
        }
        /* El ruc de las empresas del sector publico terminan con 0001*/
        if (numero.substr(9, 4) != '0001') {
            alert('El ruc de la empresa del sector público debe terminar con 0001');
            return false;
        }
    } else if (pri == true) {
        if (digitoVerificador != d10) {
            alert('El ruc de la empresa del sector privado es incorrecto.');
            return false;
        }
        if (numero.substr(10, 3) != '001') {
            alert('El ruc de la empresa del sector privado debe terminar con 001');
            return false;
        }
    } else if (nat == true) {
        if (digitoVerificador != d10) {
            alert('El número de cédula de la persona natural es incorrecto.');
            return false;
        }
        if (numero.length > 10 && numero.substr(10, 3) != '001') {
            alert('El ruc de la persona natural debe terminar con 001');
            return false;
        }
    }
    return true;
}

function searchbyid() {
    var idguide = document.getElementById("idguide").value;
}

function soloLetras(e) {
    key = e.keyCode || e.which;
    tecla = String.fromCharCode(key).toLowerCase();
    letras = " áéíóúabcdefghijklmnñopqrstuvwxyz";
    especiales = "8-37-39-46";

    tecla_especial = false
    for (var i in especiales) {
        if (key == especiales[i]) {
            tecla_especial = true;
            break;
        }
    }

    if (letras.indexOf(tecla) == -1 && !tecla_especial) {
        return false;
    }
}

function verificaUser() {
    if (document.user.userU.value == "") {
        alert("El campo nombre esta vacio");
        document.getElementById('userU').style.border = 'thin solid #FF0000';
        return;
    }
}

function verificaPassword() {
    if (document.user.password.value == "") {
        alert("El campo nombre esta vacio");
        document.getElementById('password').style.border = 'thin solid #FF0000';
        return;
    }
}


function tecla() {
    alert('TECLADO BLOQUEADO')
}

function cleanCI(){
    numero = document.getElementById('id').value;
    var activo = document.activeElement.id;
    numero.innerHTML = "";
}