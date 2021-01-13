<%@page import="com.koreait.fashionshop.model.domain.TopCategory"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="../inc/header.jsp" %>
<style>
input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=button] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=button]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}

/*드래드 관련 */
#dragArea{
	width:100%;
	height:300px;
	overflow:scroll;
	border:1px solid #ccc;
}
.dragBorder{
	background:#ffffff;
}

.box{
	width:100px;
	float:left;
	padding:5px;
}
.box > img{
	width:100%; 
}
.close{
	color:red;
	cursor:pointer;
}
</style>
<script type="text/javascript">
var uploadFiles=[]; //미리보기 이미지 목록 
var psize=[] ; //유저가 선택한 사이즈를 담는 배열 

$(function(){
	CKEDITOR.replace("detail");	
	
	//상위카테고리 선택하면..
	$($("select")[0]).change(function(){
		//비동기 방식으로 서버에 요청하되, 순수 ajax보다는 jquery ajax 를 이용하자!!
		getSubList(this);
	});
	
	/*드래그 관련 이벤트 */
	
	$("#dragArea").on("dragenter", function(e){ //드래그로 영역에 진입했을때...
		$(this).append("dragenter<br>");
		$(this).addClass("dragBorder");
	});
	
	$("#dragArea").on("dragover", function(e){ //드래그영역 위에 있는 동안...
		//$(this).append("dragover<br>");
		e.preventDefault();
	});
	
	$("#dragArea").on("drop", function(e){ //드래그영역 위에서 이미지를 떨구면..
		e.preventDefault(); //여타 다른 이벤트를 비활성화시키자...
		//$(this).append("drop<br>");
		
		//자바스크립트로 드래그된 이미지 정보를 구해와서, div영역에 미리보기 효과..
		var fileList = e.originalEvent.dataTransfer.files; //드래그한 파일들에 대한 배열 얻기!!
		console.log(fileList);
		
		//배열안에 들어있는 이미지들에 대한 미리보기처리...
		for(var i=0;i<fileList.length;i++){
			uploadFiles.push(fileList[i]); //fileList안의 요소들을 일반배열에 옮겨심기 
			//왜 심었나? 배열이 지원하는 여러 메서드들을 활용하기 위해...(ex : indexOf..)
			preview(uploadFiles[i], i); //파일 요소 하나를 넘기기
		}
	});
	
	$("#dragArea").on("dragleave", function(e){ //드래그 영역에서 빠져나가면
		//$(this).append("dragleave<br>");
		$(this).removeClass("dragBorder");
	});
	
	//이미지 삭제 이벤트 처리 
	$("#dragArea").on("click", ".close", function(e){
		console.log(e);
		
		//대상 요소 배열에서 삭제
		//삭제전에 uploadFiles 라는 배열에 들어있는 file의 index를 구하자!!
		var f = uploadFiles[e.target.id];
		console.log("지우려 하는 요소의 id는 ", e.target.id);
		
		var index = uploadFiles.indexOf(f); //파일 객체가 몇번째 들어있는지 추출
		console.log("지우려 하는 요소의의 배열에서의 index는  ", index);
		
		//alert(e.target.id+"클릭햇어?");
		uploadFiles.splice(index ,1);
		
		//대상 요소 삭제 (시각적으로 삭제)
		$(e.target).parent().remove();
	});
	
	
	//체크박스 이벤트 구현 
	$("input[type='checkbox']").on("click", function(e){
		var ch = e.target;//이벤트 일으킨 주체컴포넌트 즉 체크박스
		//체크박스의 길이 얻기 
		var ch=$("input[name='size']");
		var len =$(ch).length; //반복문이용하려고..
	
		
		psize=[];//배열 초기화
		console.log("채우기 전 psize의 길이는 ",psize.length);
		
		for(var i=0;i<len;i++){
			//만일 체크가 되어있다면, 기존 배열을 모두 지우고, 체크된 체크박스 값만 배열에 넣자!!
			if($($(ch)[i]).is(":checked")){
				psize.push($($(ch)[i]).val());
			}
			//console.log(i,"번째 체크박스 상태는 ", $($(ch)[i]).is(":checked"));
		}		
		console.log("서버에 전송할 사이즈 배열의 구성은 ", psize);
	});
	
});

//업로드 이미지 미리보기
function preview(file, index){
	//js로 이미지 미리보기를 구현하려면, 파일리더를 이용하면 된다 FileReader
	var reader = new FileReader(); //아직은 읽을 대상 파일이 결정되지 않음..
	//파일일 읽어들이면, 이벤트 발생시킴 
	reader.onload=function(e){
		console.log(e.currentTarget.result);
		
		var tag="<div class=\"box\">";
		tag+="<div class=\"close\" id=\""+index+"\">X</div>";
		tag+="<img src=\""+e.currentTarget.result+"\">";
		tag+="</div>";
		
		$("#dragArea").append(tag);
		
	};
	
	reader.readAsDataURL(file); //지정한 파일을 읽는다(매개변수로는 파일이 와야함)
}


//비동기 방식으로 하위 카테고리 요청하기!!
function getSubList(obj){
	//alert($(obj).val());
	
	$.ajax({
		url:"/admin/product/sublist", 
		type:"get",
		data:{
			topcategory_id:$(obj).val()			
		},
		success:function(result){
			//alert("서버로 부터 받은 결과는 "+result);
			
			//서버가 이미  json 으로 전송해주었으므로 별도의  parsing이 필요없다!!
			//기존 option태그를 먼저 지우자!!
			$($("select")[1]).empty();
			$($("select")[1]).append("<option>하위카테고리 선택</option>");
			
			for(var i=0;i<result.length;i++){
				var subCategory = result[i]; //subcategory 1건에 대한 json 객체얻기!!
				$($("select")[1]).append("<option value=\""+subCategory.subcategory_id+"\">"+subCategory.name+"</option>");
			}
		}
	});
}

//사이즈 선택시 배열 재구성하기
function setPsizeArray(){
	
	
}

//상품 등록
function regist(){
	var formData = new FormData($("form")[0]);//<form>태그와는 틀리다..전송할때 파라미터들을 담을수있지만 이 자체가 폼태그는 아니다!!
	/*비동기 업로드*/
	$.ajax({
		url:"/admin/product/excel/regist",
		data:formData,
		contentType:false, /* false일 경우 multipart/form-data*/
		processData:false, /* false일 경우 query-string으로 전송하지 않음*/
		type:"post",
		success:function(responseData){
			var json = JSON.parse(responseData); //string --> json 으로 파싱..
			alert(json.msg);
		}
	});
}

</script>
</head>
<body>
<%@ include file="../inc/main_navi.jsp" %>

<h3>Contact Form</h3>
<div class="container">
   <form>
	<!-- 파일 최대 4개까지 지원 -->
	<p>엑셀파일 선택: <input type="file"  name="dump"></p>
    <input type="button" value="데이터 등록" onClick="regist()">
    <input type="button" value="상품목록" onClick="location.href='/client/notice/list'">
  </form>
</div>

</body>
</html>