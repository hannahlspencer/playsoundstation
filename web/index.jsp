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
    <option value="upbeat">Upbeat</option>
    <option value="downbeat">Downbeat</option>
    <option value="dreamy">Dreamy</option>
    <option value="gloomy">Gloomy</option>
    <option value="scary">Scary</option>
  </select><br/><br/>
  <label>What length would you like this piece of music to be?</label> <br>
  <select name="length" id="length">
    <option value="shortest">Under 10 seconds</option>
    <option value="short">10 - 30 seconds</option>
    <option value="shortish">30 - 60 seconds</option>
    <option value="medium">1 - 2 minutes</option>
    <option value="longer">2 - 5 minutes</option>
    <option value="longest">Over 5 minutes</option>
  </select>
  <input type="submit" value="options" />
</form>
<button type="button" id="downloadButton">Download track</button>
</body>
</html>
