function boardCheck() {
	if(document.frm.title.value.length == 0) {
		alert('글 제목을 입력하시오');
		return false;
	}
	if(document.frm.content.value.length == 0){
		alert('글 내용를 입력하시오');
		return false;
	}
	if(document.frm.score.value == ""){
		alert('점수를 입력하시오');
		return false;
	}
	return true;
}

function open_win(url, name) {
	window.open(url, name, "width=500, height=230");
}
function writerupdate() {
	var num = document.frm.num.value;
	if(document.frm.board.value != document.frm.user.value) {
		alert('본인이 작성한 글만 수정 할 수 있습니다!!');
	} else {
	alert('페이지를 이동합니다');
		location.href = "BoardServlet?command=board_update_form&num="+num;
	}
}
function writerdelete() {
	var num = document.frm.num.value;
	if(document.frm.board.value != document.frm.user.value) {
		alert('본인이 작성한 글만 삭제 할 수 있습니다!!');
	} else {
	alert('게시글이 삭제되었습니다!!');
	location.href="BoardServlet?command=board_delete&num="+num;
		}
}