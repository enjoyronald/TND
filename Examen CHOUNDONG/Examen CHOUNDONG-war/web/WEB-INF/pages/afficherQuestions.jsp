<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/ListQuestions" />
<c:set var="questions" value="${requestScope.questions}" />

<fieldset>
    <legend>Les Questions</legend>
    <c:choose>
        <c:when test="${questions.size() != 0}">
            <div class="table-responsive">
                <table id="myTable1" class="display table">
                    <thead>
                        <tr>
                            <th>Nom Question</th>
                            <th>Categorie</th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="question" items="${questions}" varStatus="loop">
                            <tr>
                                <td><a href="AfficherUneQuestion?id=${question.getId()}">${question.getNom()}</a></td>
                                <td>${question.getCategorie().getNom()}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-md-12 text-center">
                <ul class="pagination pagination-lg pager" id="myPager1"></ul>
            </div>
        </c:when>
        <c:otherwise>
            Aucune question dans la base de donnée
        </c:otherwise>
    </c:choose>
</fieldset>
<script>
        $(document).ready(function () {
            $('#myTable1').dataTable();
        });
</script>
