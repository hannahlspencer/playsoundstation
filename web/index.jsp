<%--
  Created by IntelliJ IDEA.
  User: hanna
  Date: 18/07/2018
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <link rel="stylesheet" href="style.css" />
  <script src="script.js"></script>

</head>
<body>
<form action="MusicServlet" method="POST" id='inputForm' style="align: center;">
  <label>What genre is your game?</label> <br>
  <select name="genre" id="genre">
    <option value="Action">Action</option>
    <option value="RPG">RPG</option>
    <option value="Puzzler">Puzzle</option>
    <option value="Sim">Sim</option>
    <option value="Strategy">Strategy</option>
    <option value="Horror">Horror</option>
  </select><br/><br/>
  <label>What mood are you looking for?</label> <br>
  <select name="mood" id="mood">
    <option value="Upbeat">Upbeat</option>
    <option value="Downbeat">Downbeat</option>
    <option value="Dreamy">Dreamy</option>
    <option value="Gloomy">Gloomy</option>
    <option value="Scary">Scary</option>
  </select><br/><br/>
  <input type="submit" value="Download track" />
</form>
</body>
</html>
