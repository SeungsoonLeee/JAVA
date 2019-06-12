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
function deleteMsg(no){
	var ok = confirm("삭제?");
	if (ok) {
		location.href = "DeleteController?no=" + no;
	}
}
function goModifyMsg(no){
	location.href = "ModifyController?no=" + no;
}
function updateMsg(no){
	var ok = confirm("수정 완료?");
	var newMsg = document.getElementById("msg").value;
	if (ok) {
		location.href = "SNSUpdateController?no=" + no + "&msg=" + newMsg;
	}
}
function goSnsPage(){
	location.href = "SNSController";
}
function updateMsgJS(no, msg, p){
	var newMsg = prompt("수정할 내용", msg);
	if(newMsg != null)	{
		if(newMsg.length > 0 && newMsg.length<150){
			location.href = "SNSUpdateJSController?no=" + no + "&msg=" + newMsg + "&p=" + p;
		}
	}
}