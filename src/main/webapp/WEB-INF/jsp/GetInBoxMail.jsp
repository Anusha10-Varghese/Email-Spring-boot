
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<style>
.subject
{
width:500px;
height:auto;
min-height:80px;
background-color: black;
color:white;

}
.record{
width:500px;
height:auto;
min-height:80px;
background-color: #E6F2FF;
color:black;

}
.message{
width:500px;
height:auto;
min-height:50vh;
background-color:#F0FFF0;
margin-top:-3vh;
color:black;
}
</style>

	<br><br>
		<div class="subject">
		<br/>
		<h3>
		&nbsp;&nbsp;&nbsp;
		${ mail.subject}
		</h3>
		<br/>
		</div>
			<div class="record">
		<p>&nbsp;&nbsp;&nbsp;from : ${ mail.sender}</p>
		<p>&nbsp;&nbsp;&nbsp;to : ${ mail.reciever} </p>
		<p>&nbsp;&nbsp;&nbsp;Date : <fmt:formatDate type="both" dateStyle="short" timeStyle="short"  value="${mail.date}" /></p>
		<br/>
		</div>
		
		<div class="message">
		<p  style='white-space: pre-line' >
		&nbsp;&nbsp;&nbsp;Message :<br/>${ mail.message}</p>
		</div>

		