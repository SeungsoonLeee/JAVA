function check() {
	var wheelInput = document.f.wheel;
	var frontInput = document.f.front;
	var backInput = document.f.back;
	var countInput = document.f.count;

	if (isEmpty(wheelInput) || isNotNumber(wheelInput)) {
		return false;
	} else if (isEmpty(frontInput) || isNotNumber(frontInput)) {
		return false;
	} else if (isEmpty(backInput) || isNotNumber(backInput)) {
		return false;
	} else if (isEmpty(countInput) || isNotNumber(countInput)) {
		return false;
	}

	return true;
}