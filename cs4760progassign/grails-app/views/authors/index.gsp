<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="site"/>
    <title>Book Store Books</title>
</head>

<body>
<h1> AUTHORS </h1>
<ul>
    <g:each in="${bkList}">
        <li> ${it.author} </li>
        <ul>
            <g:each in="${it.books}" var="book">
                <li>${book.value}</li>
            </g:each>
        </ul>
    </g:each>
</ul>
</body>
</html>