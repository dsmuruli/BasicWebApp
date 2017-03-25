<%@include file="/WEB-INF/jsp/include.jsp" %>

<stripes:layout-render name="/WEB-INF/jsp/layout/standard.jsp">


    <stripes:layout-component name="content">
        <stripes:form beanclass="co.ds.stripes.SubscriberAction">
            <div class="banner">
                <div class="banner-title"><h1>Topics</h1></div>
                <div class="clear"></div>
            </div>
            <div class="clear"></div>
            <div class="button-bar">
                <div class="box-right">
                    <stripes:submit name="cancelList" value="Back" id="cancel-button"/>
                </div>
                <div class="clear"></div>
            </div>
            <table class="grid-list" cellspacing="0">
                <thead>
                <tr>
                    <th><div>Topic</div></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${actionBean.topics}" var="topic" >
                    <tr class="subscriber-row"><td>${topic.name}</td></tr>
                </c:forEach>

                </tbody>
                <tfoot>
                <tr>
                    <td colspan="2"><div>&nbsp;</div></td>
                </tr>
                </tfoot>
            </table>
        </stripes:form>
    </stripes:layout-component>

</stripes:layout-render>