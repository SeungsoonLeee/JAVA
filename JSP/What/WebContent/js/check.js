function locSearchCheck() {
	var locSearchCheck = document.locSearchForm.search;

	if (isEmpty(locSearchCheck)) {
		alert("!");
		return false;
	}
	return true;
}
function wordInputCheck() {
	var wordInput = document.wordInputForm.say;

	if (isEmpty(wordInput) || lessThan(wordInput, 2)) {
		return false;
	}
	return true;
}
function snailInputCheck() {
	var sizeInput = document.snailInputForm.size;

	if (isEmpty(sizeInput) || isNotNumber(sizeInput) || sizeInput.value > 25) {
		alert("!");
		return false;
	}
	return true;
}

function starInputCheck() {
	var floorInput = document.starInputForm.floor;

	if (isEmpty(floorInput) || isNotNumber(floorInput)) {
		alert("!");
		return false;
	}
	return true;
}
