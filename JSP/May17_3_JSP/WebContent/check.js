function check() {
	var nInput = document.f.n;
	if (isEmpty(nInput) || isNotNumber(nInput)) {
		alert("숫자 필수");
		nInput.value = "";
		nInput.focus();
		return false;
	}
	return true;
}