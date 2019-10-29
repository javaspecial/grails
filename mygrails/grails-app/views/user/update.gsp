<html>
<head>
    <title>Grails - User update</title>
    <meta name="layout" content="main"/>
</head>

<body>
<g:form class="simpleform" controller="user" action="update" method="PUT">
    <fieldset>
        <legend>User update</legend>

        <p class="info">
            Complete the form below to update an account!
            <g:hiddenField name="id" value="${user?.id}"></g:hiddenField>
        </p>
        <g:hasErrors bean="${user}">
            <div class="errors">
                <g:renderErrors bean="${user}"/>
            </div>
        </g:hasErrors>
%{--        <p>--}%
%{--            <label for="username">Username</label>--}%
%{--            <g:textField name="username" value="${user?.username}"--}%
%{--                         class="${hasErrors(bean: user, field: 'username', 'errors')}"/>--}%
%{--        </p>--}%

        <p>
            <label for="firstName">First Name</label>
            <g:textField name="firstName" value="${user?.firstName}"
                         class="${hasErrors(bean: user, field: 'firstName', 'errors')}"/>
        </p>

        <p>
            <label for="lastName">Last Name</label>
            <g:textField name="lastName" value="${user?.lastName}"
                         class="${hasErrors(bean: user, field: 'lastName', 'errors')}"/>
        </p>

        <p class="button">
            <label>&nbsp;</label>
            <g:submitButton class="button" name="submitButton" value="Update Account"/>
        </p>
    </fieldset>
</g:form>
</body>
</html>