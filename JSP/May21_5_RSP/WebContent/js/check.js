function go(h){
	location.href = "HomeController?h=" + h;
}

function check() {
	var hInput = document.f.h;
	if (isEmpty(hInput) || isNotNumber(hInput) || hInput.value < 1
			|| hInput.value > 3 || hInput.value.indexOf(".") != -1) {
		alert("!");
		return false;
	}
	return true;
}