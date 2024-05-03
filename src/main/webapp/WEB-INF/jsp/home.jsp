
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<jsp:include page="header.jsp"></jsp:include>
<style>
	.main{
		width: 100vw;
		display: flex;
	}
	.main-col-1{
		display: inline-block;
		width: 40%;
		border:1px solid;
		height: auto;
		min-height:100vh;
		
	}
	.main-col-2{
		width: 60%;
		display: inline-block;	
		border: 1px solid;
		height: auto;
		min-height:100vh;
	
	}
	.heading{
	
	background-color: #546b45;
	color:white;
	}
	.mails:hover{
	background-color: #ffd4fd;
	
	
	}
	
	.deletelink{
	color:red;}
	
	
</style>
<body>
			<%
				if(session.getAttribute("usermail")==null)
					response.sendRedirect("index");
			%>
<div class="main">
			<div class="main-col-1">
				
					<div>
							<h2>Welcome to Mailservices!</h2>		
					</div>
					
							<div>
							
								<h6>Welcome ${usermail}</h6>
								<c:if test="${mails.size()<=0}">
								<h5>Inbox is empty</h5>
								</c:if>		
					<c:if test="${mails.size()>0}">
		<h6>InBox Box</h6>
					<table border=4 cellspacing='4' cellpadding='5'>
		
						<tr class="heading">
						<th>Sender</th>
						<th>SUBJECT</th>
						<th>MESSAGE	</th>
						<th>DATE OF RECIEVING </th>
						<th>Delete</th>
						
						</tr>
			<c:forEach var="m" items="${mails}">	
		
		
		<tr onclick='viewMail(${m.id})' class="mails">

		<c:if test="${m.reciever.length()>=5}">
			<td> ${ m.reciever.substring(0,5)}....</td>
			</c:if>
		<c:if test="${m.reciever.length()<5}">
			<td>${ m.reciever} </td>
		</c:if>
		<c:if test="${m.subject.length()>=5}">
			<td> ${ m.subject.substring(0,5)}....</td>
			</c:if>
		<c:if test="${m.subject.length()<5}">
			<td> ${ m.subject}....</td>
			</c:if>
		<c:if test="${m.message.length()>=5}">
			<td> ${ m.message.substring(0,5)}....</td>
			</c:if>
		<c:if test="${m.message.length()<5}">
			<td> ${ m.subject}....</td>
			</c:if>
			
		<td><fmt:formatDate type="both" dateStyle="short" timeStyle="short"  value="${m.date}" />  </td>
		
		<td><a class="deletelink" href='deleteInboxMail?id=${m.id}'> Delete</a></td>

	</tr>
								
								</c:forEach>
								
								</table>
								</c:if>
							</div>
							
			</div>
			<div  class="main-col-2">
				<table>
					<tr>
						<td style="width: 25%;"></td>
						<td style="width: 65%;">
							<div id="viewInBoxMail">
			
							</div>
						</td>
						<td style="width: 10%;"></td>
					</tr>
					
				</table>
				
			</div>
		
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>

		function viewMail(id)
		{
			$.ajax({url: "getInBoxMail?id="+id, success: function(result){
				
				document.getElementById("viewInBoxMail").innerHTML=result
    	}
	});
}




</script>
	

		