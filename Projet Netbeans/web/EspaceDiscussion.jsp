<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.medic.entities.Patient"%>
<link rel="stylesheet" type="text/css" href="CSS/ChatZone.css">
<!DOCTYPE html>
<html>
<head>
	 <jsp:include page="EnTete.jsp" />
</head>
<div class="contenu">
    
     
    <div class="container">
        <div class ="headers">
            <h1>Chat</h1>
        </div>
        <div class="body">
            <p class ="message">Bonjour Dr Tremblay, je me sens un malade ces derniers, je crois j'al Covid-19</p>
            <p class ="message user_message">...</p>
        </div>
        <div class="footer">
            <form>
                <input type="text" name="">
                <button>Envoyer</button>
            </form>
        </div>
    </div>
</div>
</body>
