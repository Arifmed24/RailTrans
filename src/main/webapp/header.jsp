<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>${title}</title>
</head>
	<body>
		<div class="container">
			<div class="row">
				<span align="right">User: ${user.fio}</span>
				<div class="wrapper">
					<header class="main_header">
						<div>
							RailTrans
						</div>
					</header>
					<nav class="main_menu">
						<a href="/main">
							<div> Main </div>
						</a>
						<a href="/stations">
							<div> Stations </div>
						</a>
						<a href="/findway">
							<div> Tickets </div>
						</a>
						<a href="/trains">
							<div> Trains </div>
						</a>
						<a href="/logout">
							<div> Log out </div>
						</a>
						<a >
							<div class="train_head">  </div>
						</a>
					</nav>