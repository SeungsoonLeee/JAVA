function snackUpdateCheck() {
	var priceInput = document.snackUpdateForm.price;

	if (isEmpty(priceInput) || isNotNumber(priceInput)) {
		alert("!");
		priceInput.focus();
		priceInput.value = "";
		return false;
	}
	return true;
}
function snackSearchCheck() {
	var searchInput = document.snackSearchForm.search;

	if (isEmpty(searchInput)) {
		alert("!");
		searchInput.focus();
		searchInput.value = "";
		return false;
	}
	return true;
}
function productUpdateCheck() {
	var priceInput = document.snackUpdateForm.price;

	if (isEmpty(priceInput) || isNotNumber(priceInput)) {
		alert("!");
		priceInput.focus();
		priceInput.value = "";
		return false;
	}
	return true;
}
function productSearchCheck() {
	var searchInput = document.snackSearchForm.search;

	if (isEmpty(searchInput)) {
		alert("!");
		searchInput.focus();
		searchInput.value = "";
		return false;
	}
	return true;
}
function snackRegCheck() {
	var nameInput = document.snackRegForm.s_name;
	var priceInput = document.snackRegForm.s_price;
	var descInput = document.snackRegForm.s_desc;

	if (isEmpty(nameInput)) {
		alert("!");
		nameInput.focus();
		nameInput.value = "";
		return false;
	} else if (isEmpty(priceInput) || isNotNumber(priceInput)) {
		alert("!");
		priceInput.focus();
		priceInput.value = "";
		return false;
	} else if (isEmpty(descInput)) {
		alert("!");
		descInput.focus();
		descInput.value = "";
		return false;
	}
	return true;
}

function productRegCheck() {
	var nameInput = document.productRegForm.name;
	var priceInput = document.productRegForm.price;
	var photoInput = document.productRegForm.photo;
	var descInput = document.productRegForm.desc;

	if (isEmpty(nameInput)) {
		alert("!");
		nameInput.focus();
		nameInput.value = "";
		return false;
	} else if (isEmpty(priceInput) || isNotNumber(priceInput)) {
		alert("!");
		priceInput.focus();
		priceInput.value = "";
		return false;
	} else if (isEmpty(descInput)) {
		alert("!");
		descInput.focus();
		descInput.value = "";
		return false;
	} else if (isEmpty(photoInput)
			|| (isNotType(photoInput, "png") && isNotType(photoInput, "gif") && isNotType(
					photoInput, "jpg") && isNotType(photoInput, "bmp"))){
		alert("!");
		return false;
	}
		return true;
}