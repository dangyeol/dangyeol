<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<
<script type="text/javascript">
	var check = false;

	function CheckAll() {

		var chk = document.getElementsByName("del_id");

		if (check == false) {

			check = true;

			for (var i = 0; i < chk.length; i++) {

				chk[i].checked = true; //모두 체크

			}

		} else {

			check = false;

			for (var i = 0; i < chk.length; i++) {

				chk[i].checked = false; //모두 해제

			}

		}

	}
	
	 $(document).ready(function() {
	   	  $("#submitFrm").on("click", function() {
	   	         
	   	    if ( $(".chkclass :checked").val()==null ) {
	   	      alert("사용자를 체크해주세요");
	   	      return;
	   	    }
	   	    else {
	   	      var param = "";
	   	      var pro_Name = "&pro_Name="+$('#pro_Name').val();
	   	      var mem_Point = "&mem_Point="+$('#mem_Point').val();
	   	      alert(pro_Name);
	   	      alert(mem_Point);
	   	      $('input:checkbox[name=del_id]').each(function() {
	   	        if($(this).is(':checked'))
	   	    	  if( param=="" )
	   	          param = "name="+$(this).val();
	   	        else param = param + "&name="+$(this).val();
	   	      });
	   	      param = param+pro_Name+mem_Point;
	   	        alert(param); 
	   	       
	   	        
	   	        $.ajax({
	   	        url : '/dangyeol/main/memapproval',
	   	        type : 'post',
	   	        data : param,
	   	        success : function(data) {
	   	         alert("완료하였습니다");
	   	        },
	   	        error : function() { console.log('error');}
	   	      }); 
	   	    }
	   	  });
	   	});
	
	
</script>

<div class="container">
	<h2>회원 리스트</h2>
	<p>(${param.pro_Name })상품을 현대카드로 구입한 회원 목록입니다.</p>
	포인트:<input type="text" class="form-control" id="mem_Point">
	<input type="button" value="전체선택" onClick="CheckAll();" class="btn btn-default" />
	<input type="hidden" value="${param.pro_Name }" id="pro_Name"/>
		 <input type="button" value="승인"
		 class="btn btn-default" id="submitFrm"/>
		<!--   <input type="button" value="이응이응"
		 class="btn btn-default" onClick="modal()"/> -->
	<div class="chkclass">
	<table class="table table-striped">
	
		<thead>
			<tr>
				<th>Member_Email</th>
				<th>상세보기</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="list" items="${purchaselist}">
				<tr>
					<td><input type="checkbox" id="del_id" class="del_id"
						name="del_id" value=${list }>${list }
						
					<td>
				</tr>
			</c:forEach>
		</tbody>
		
	</table>
	</div>
</div>

 
