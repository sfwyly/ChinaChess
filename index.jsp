<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>中国象棋</title>
<meta name="description" content="">
<meta name="keywords" content="">
<link href="css/index.css" rel="stylesheet" >
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
</head>
<body>
    <div id="container">
    	<div class="head">
    		<p><h1>中国象棋</h1></p>
    	</div>
    	<div class="chessboard">
    		<div class="inform">
    			<p>
    			<b>模式选择：</b><br />
    			<input type="radio" value="single" name="mode" checked="checked">单人模式&nbsp;
    				<select>
    					<option>低</option>
    					<option selected="selected">中</option>
    					<option>高</option>
    				</select><br />
    				<input type="radio" name="mode" value="double">双人模式<br />
    				系统提示:<font></font>
    				<br /><br /><br />
    				<a>提示</a>&nbsp;<a>重来</a>&nbsp;<a>退出</a>
    			
    		</p>
    		</div>
    	<div class="chess">
    		<div>
    			<span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span>
    		</div>
    		<div>
    			<span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span>
    		</div>
    		<div>
    			<span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span>
    		</div>
    		<div>
    			<span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span>
    		</div>
    		<div>
    			<span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span>
    		</div>
    		<div>
    			<span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span>
    		</div>
    		<div>
    			<span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span>
    		</div>
    		<div>
    			<span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span>
    		</div>
    		<div>
    			<span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span>
    		</div>
    		<div>
    			<span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span>
    		</div>
    	</div>
    	</div>
    </div>
</body>
</html>