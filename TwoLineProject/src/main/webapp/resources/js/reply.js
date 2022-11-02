console.log("Reply Module.....");

var replyService = (function() {
	
	/*# 댓글 추가*/
	function add(reply, callback, error) {
		console.log("reply........");
		
		$.ajax({
			type : 'post',
			url : '/replies/new',
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8",
			success : function(result, status, xhr) {
				if(callback) {
					callback(result);
				}
			},
			error : function(xhr,status, er) {
				if(error) {
					error(er);
				}
			}
		})
	}
	
	/*# 전체 댓글 조회*/
	function getList(param,callback,error) {
		
		console.log("전체 댓글 조회....");
		
		var bno = param.bno;
		var page = param.page || 1;
		
		$.getJSON("/replies/pages/" + bno + "/" + page + ".json",
			function(data) {
				if(callback) {
					callback(data);
				}
			}).fail(function(xhr,status,err) {
				if(error) {
					error();
				}
			});
	}
	
	return {
		add : add,
		getList : getList
		};
})();