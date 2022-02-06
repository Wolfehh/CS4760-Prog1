<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="site"/>
    <title>Book Store Books</title>
</head>

<body>
<h1> BOOKS </h1>
<ul>
    <g:each in="${bkList}">
        <li> ${it.book.title} by ${it.author} </li>
        <img src="/cs4760progassign/book/showCover/${it.book.id}" class="img-thumbnail" alt="${it.book.title}">
    </g:each>
</ul>
</body>
</html>