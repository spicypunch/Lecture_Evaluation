function loginCheck(){
	if(document.frm.stu_id.value.length == 0) {
	alert("아이디를 써주세요");
	frm.stu_id.focus();
	return false;
	}
	if(document.frm.password.value="") {
	alert("암호를 입력해 주세요");
	frm.password.focus();
	return false;
	}
	return true;
}

function idCheck() {
	if(document.frm.stu_id.value=="") {
		alert('아이디를 입력해 주세요.');
		document.frm.stu_id.focus();
		return;
	}
	var url = "idCheck.do?stu_id=" + document.frm.stu_id.value;
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
}

function idok() {
	opener.frm.stu_id.value=document.frm.stu_id.value;
	opener.frm.reid.value=document.frm.stu_id.value;
	self.close();
}

function joinCheck() {
	if (document.frm.stu_id.value == "") {
		alert('학번을 입력해 주세요');
		frm.stu_id.focus();
		return false;
	}

	if(document.frm.stu_id.value.length != 8){
		alert('학번은 8자리입니다.');
		frm.stu_id.focus();
		return false;
	}

	if (document.frm.pwd.value == "") {
		alert('비밀번호를 입력해 주세요');
		frm.pwd.focus();
		return false;
	}

	if (document.frm.pwd.value != document.frm.pwdcheck.value){
		alert('비밀번호가 일치하지 않습니다.');
		frm.pwdcheck.focus();
		return false;
	}

	if (document.frm.name.value == "") {
		alert('이름을 입력해 주세요');
		frm.name.focus();
		return false;
	}

	if(document.frm.reid.value.length == 0){
		alert('중복 체크를 하지 않았습니다');
		frm.stu_id.focus();
		return false;
	}
	return true;
}