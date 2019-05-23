function check() {
	var nInput = document.f.n;
	var bInput = document.f.b;
	if (isEmpty(nInput)) {
		alert("!");
		return false;
	} else if (isEmpty(bInput) || 
			isNotNumber(bInput) || 
			lessThan(bInput, 6)) {
		alert("!");
		return false;
	}
	return true;
}