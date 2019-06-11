// 다양한 검사 상황에 쓸수있는 함수들
// 문제가 되면 true, 문제가 없으면 false

// <input>을 넣었을 때
// 비어있으면 true, 글자가 들어있으면 false
function isEmpty(input){
	return (!input.value);
}

// <input>, 글자수를 넣었을 때
// 그 글자수보다 적게 적어놨으면 true, 아니면 false
function lessThan(input, min){
	return (input.value.length < min);
}

// <input>넣었을 때
// 한글 들어있으면 true, 없으면 false
function containsHangul(input){
	var str = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM@._";
	for (var i = 0; i < input.value.length; i++) {
		if (str.indexOf(input.value[i]) == -1){
			return true;
		}
	}
	return false;
}

// input 두 개 넣으면
// 두 값이 다르면 true, 같으면 false
function notEquals(input1, input2){
	return (input1.value != input2.value);
}

// <input>, 문자열세트를 넣으면
// 그 문자열이 포함되어있지 않으면 true, 
// 포함되어있으면 false
function notContains(input, set){
	for (var i = 0; i < set.length; i++) {
		if (input.value.indexOf(set[i]) != -1){
			return false;
		}
	}
	return true;
}

// <input>넣으면
// 숫자아닌게 있으면 true, 숫자면 false
function isNotNumber(input){
	return isNaN(input.value);
}

// <input type="file">, 확장자넣으면
// 그 파일이 아니면 true, 그 파일이면 false
function isNotType(input, type){
	// input.value // 선택한 파일명
	return (input.value.toLowerCase().indexOf("." + type) == -1);
}
