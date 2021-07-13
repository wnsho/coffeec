let index={
	init:function(){
		$("#btn-save").on("click",()=>{
			this.save();
		});
		$("#btn-login").on("click",()=>{
			this.login();
		});
	},
	
	save: function(){
		//alert('user의 save함수 호출됨')
		let data={
			username:$("#username").val(),
			password:$("#password").val(),
			email:$("#email").val(),
		};
		
		//console.log(data);
		
		//ajax호출시 default가 비동기 호출
		//ajax통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청
		$.ajax({	//회원가입 수행 요청
			type:"POST",
			url:"/coffeec/api/user",
			data:JSON.stringify(data), //http body데이터
			contentType:"application/json; charset=utf-8",//body데이터가 어떤 타입인지(MIME)
			dataType:"json"//요청을 서버로해서 응답이 왔을 떄 기본적으로 모든 것이 문자열 (생긴게 json이라면)->자바스크립스 옵젝으로 변경해줌
		}).done(function(resp){		//정상일때
			alert("회원가입이 완료되었습니다.");
			//console.log(resp);
			location.href="/coffeec";
		}).fail(function(error){		//실패했을떄
			alert(JSON.stringify(error));
		}); 
	},
	
	login: function(){
		//alert('user의 save함수 호출됨')
		let data={
			username:$("#username").val(),
			password:$("#password").val()
		};
		
		$.ajax({	//회원가입 수행 요청
			type:"POST",
			url:"/coffeec/api/user/login",
			data:JSON.stringify(data), //http body데이터
			contentType:"application/json; charset=utf-8",//body데이터가 어떤 타입인지(MIME)
			dataType:"json"//요청을 서버로해서 응답이 왔을 떄 기본적으로 모든 것이 문자열 (생긴게 json이라면)->자바스크립스 옵젝으로 변경해줌
		}).done(function(resp){		//정상일때
			alert("로그인이 완료되었습니다.");
			location.href="/coffeec";
		}).fail(function(error){		//실패했을떄
			alert(JSON.stringify(error));
		}); 
	}
}

index.init();