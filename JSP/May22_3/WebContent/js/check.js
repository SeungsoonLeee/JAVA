function converterCheck() {
	var nInput = document.converterForm.n;
	if (isEmpty(nInput) || isNotNumber(nInput)) {
		alert("���� �ʼ�");
		nInput.value = "";
		nInput.focus();
		return false;
	}
	return true;
}

function bbCheck() {
	var nInput = document.bbForm.n;
	if (isEmpty(nInput) || isNotNumber(nInput) ||
		lessThan(nInput, 3) ||
		nInput.value[0] == nInput.value[1] ||
		nInput.value[1] == nInput.value[2] ||
		nInput.value[0] == nInput.value[2]){
		
		alert("!");
		nInput.value = "";
		nInput.focus();
		return false;
	}
	return true;
}
function calculatorCheck() {
	var xInput = document.calculatorForm.x;
	var yInput = document.calculatorForm.y;
	if (isEmpty(xInput) || isNotNumber(xInput)){
		alert("x");
		return false;
	} else if (isEmpty(yInput) || isNotNumber(yInput)){
		alert("y");
		return false;
	} 
	return true;
}