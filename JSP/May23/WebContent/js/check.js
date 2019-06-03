function joinCheck() {
	var nInput = document.joinForm.n;
	var iInput = document.joinForm.i;
	var hInput = document.joinForm.h;
	var wInput = document.joinForm.w;
	var pInput = document.joinForm.p;

	if (isEmpty(nInput)) {
		return false;
	} else if (isEmpty(iInput)) {
		return false;
	} else if (isEmpty(hInput) || isNotNumber(hInput)) {
		return false;
	} else if (isEmpty(wInput) || isNotNumber(wInput)) {
		return false;
	} else if (isEmpty(pInput)
			|| (isNotType(pInput, "png") && isNotType(pInput, "gif") && isNotType(
					pInput, "jpg"))) {
		return false;
	}
	return true;
}
function photoUploadCheck() {
	var photoInput = document.photoUploadForm.photo;
	if (isEmpty(photoInput)
			|| (isNotType(photoInput, "png") && isNotType(photoInput, "jpg")
					&& isNotType(photoInput, "gif") && isNotType(photoInput,
					"bmp"))) {
		alert("!");
		return false;
	}
	return true;
}