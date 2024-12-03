<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>
  <h1>Updation Page</h1>
<form action="/updateLaptopData" method="post">
 Enter the laptop id:<input type="text" name="id"><br><br>
 Enter the laptop brand:<input type="text" name="brand"><br><br>
 Enter the laptop price:<input type="text" name="price"><br><br>
 <button>Submit</button>
</form>
</body>
</html>