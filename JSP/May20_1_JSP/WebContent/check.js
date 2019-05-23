function check() {
	var nInput = document.f.n;
	var hInput = document.f.h;
	var wInput = document.f.w;
	var pInput = document.f.p;

	if (isEmpty(nInput)) {
		return false;
	} else if (isEmpty(hInput) || isNotNumber(hInput)) {
		return false;
	} else if (isEmpty(wInput) || isNotNumber(wInput)) {
		return false;
	} else if (isEmpty(pInput)
			|| (isNotType(pInput, "png") && isNotType(pInput, "gif"))) {
		return false;
	}

	return true;
}