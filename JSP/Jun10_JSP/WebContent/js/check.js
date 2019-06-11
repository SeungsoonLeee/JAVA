function joinCheck() {
	var idInput = document.joinForm.id;
	var pwInput = document.joinForm.pw;
	var pwChkInput = document.joinForm.pwChk;
	var nameInput = document.joinForm.name;
	var cmtInput = document.joinForm.comment;
	var photoInput = document.joinForm.photo;

	if (isEmpty(idInput) || containsHangul(idInput)) {
		alert("ID확인");
		idInput.focus();
		idInput.value = "";
		return false;
	} else if (isEmpty(pwInput) || notEquals(pwInput, pwChkInput)
			|| notContains(pwInput, "qwertyuiopasdfghjklzxcvbnm")
			|| notContains(pwInput, "1234567890")) {
		alert("PW확인");
		pwInput.focus();
		pwInput.value = "";
		pwChkInput.value = "";
		return false;
	} else if (isEmpty(nameInput)) {
		alert("이름확인");
		nameInput.focus();
		nameInput.value = "";
		return false;
	} else if (isEmpty(cmtInput)) {
		alert("인사말확인");
		cmtInput.focus();
		cmtInput.value = "";
		return false;
	} else if (isEmpty(photoInput)
			|| (isNotType(photoInput, "jpg") && isNotType(photoInput, "gif")
					&& isNotType(photoInput, "png") && isNotType(photoInput,
					"bmp"))) {
		alert("사진확인");
		photoInput.focus();
		photoInput.value = "";
		return false;
	}
	return true;
}

function loginCheck() {
	var idInput = document.loginForm.id;
	var pwInput = document.loginForm.pw;

	if (isEmpty(idInput)) {
		alert("ID확인");
		idInput.focus();
		idInput.value = "";
		return false;
	} else if (isEmpty(pwInput)) {
		alert("PW확인");
		pwInput.focus();
		pwInput.value = "";
		return false;
	}
	return true;
}

function memberUpdateCheck() {
	var pwInput = document.memberUpdateForm.pw;
	var pwChkInput = document.memberUpdateForm.pwChk;
	var nameInput = document.memberUpdateForm.name;
	var cmtInput = document.memberUpdateForm.comment;
	var photoInput = document.memberUpdateForm.photo;

	if (isEmpty(pwInput) || notEquals(pwInput, pwChkInput)
			|| notContains(pwInput, "qwertyuiopasdfghjklzxcvbnm")
			|| notContains(pwInput, "1234567890")) {
		alert("PW확인");
		pwInput.focus();
		pwInput.value = "";
		pwChkInput.value = "";
		return false;
	} else if (isEmpty(nameInput)) {
		alert("이름확인");
		nameInput.focus();
		nameInput.value = "";
		return false;
	} else if (isEmpty(cmtInput)) {
		alert("인사말확인");
		cmtInput.focus();
		cmtInput.value = "";
		return false;
	}
	return true;
}

function snsWriteCheck(){
	
}