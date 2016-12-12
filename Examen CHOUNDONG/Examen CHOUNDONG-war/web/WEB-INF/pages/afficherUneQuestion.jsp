<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:set var="question" value="${requestScope.question}" />

<div>
    <fieldset>
        <legend >
            <h1>${question.getNom()} ?</h1>
        </legend>
        <div class="col-md-12">
            <div class="col-md-10"><p>${question.getReponse()}</p></div>
        </div>    
    </fieldset>
</div>

