function check() {
	var nInput = document.f.n;
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