function goJoin(){
	location.href = "JoinController";
}
function logout(){
	var ok = confirm("로그아웃?");
	if (ok) {
		location.href = "LoginController";
	}
}
function goMemberInfo(){
	location.href = "UpdateController";
}
function secession(){
	var ok = confirm("탈퇴?"); 
	if(ok){
		location.href = "SecessionController";
	}
}