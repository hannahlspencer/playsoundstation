
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <link rel="stylesheet" href="style.css" />
  <script src="script.js"></script>
  <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Tajawal" rel="stylesheet">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
        crossorigin="anonymous">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
        crossorigin="anonymous">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
          crossorigin="anonymous"></script>
  <script src="script.js"></script>
</head>
<body class="container-fluid">
<div class="section first-section" id="first">
  <h1 class="text-center" id="intro-name">PlaySoundStation</h1><br>
  <h3 class="text-center" id="blurb">
    This program algorithmically generates music based on the parameters that you set.<br>
    Once you set your preferences and click Download, you'll receive a MIDI file that you can place straight into
    your game.
  </h3>
</div>
<form action="MusicServlet" method="POST" id='inputForm' style="align: center;">
  <table>
    <tr>
      <td>
        <div class="section second-section" id="second">
          <label>What genre is your game?</label> <br>
          <div class="menu">
            <select name="genre" id="genre">
              <option value="Action">Action</option>
              <option value="RPG">RPG</option>
              <option value="Puzzler">Puzzle</option>
              <option value="Sim">Sim</option>
              <option value="Strategy">Strategy</option>
              <option value="Horror">Horror</option>
            </select>
          </div><br/><br/>
        </div>
      </td>
      <td>

        <div class="section third-section" id="third">

          <label>What mood are you looking for?</label> <br>

          <div class="menu">
            <select name="mood" id="mood">
              <option value="Upbeat">Upbeat</option>
              <option value="Downbeat">Downbeat</option>
              <option value="Dreamy">Dreamy</option>
              <option value="Gloomy">Gloomy</option>
              <option value="Scary">Scary</option>
            </select>
          </div><br/><br/>
        </div>
      </td>
    </tr>
    <tr>
      <td>
        <div class="section fourth-section" id="fourth">
          <label>How long do you want the piece to be?</label>
          <div class="menu">
            <select name="bars" id="bars">
              <option value="32">Under one minute</option>
              <option value="64">One to three minutes</option>
              <option value="106">Three to five minutes</option>
              <option value="160">Five to ten minutes</option>
            </select></div><br/><br/>
        </div>
      </td>
      <td>
        <div class="section fifth-section" id="fifth">
          <label>How many lines of melody would you like?</label> <br>
          <div class="menu">
            <select name="melody" id="melody">
              <option value="1">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
            </select>
          </div><br/><br/>
        </div>
      </td>
    </tr>
  </table>

  <div class="section sixth-section" id="sixth">

    <input type="submit" value="Download track" />
  </div>
</form>
<h3>Convert your MIDI file into an MP3/WAV file with an <a href="https://www.conversion-tool.com/midi">online conversion tool</a></h3>
<div align="center" id="info"><h3>What do these options mean?</h3></div><br>
<p class="definitions"><em>Genre:</em> Genre changes the instruments used and the length of the notes in the bass line. Within Genre the options are <br> <ul class="definitions">
  <li>Action - uses more rock-style instruments like electric guitar, and shorter, faster notes in the bass line</li>
  <li>RPG - uses MIDI-style strings and woodwind instruments, and long sustained notes in the bass line</li>
  <li>Puzzle - uses sharp synth instruments and any notes in the bass</li>
  <li>Sim - uses smoother synth instruments and medium-to-long bass notes</li>
  <li>Strategy - uses MIDI-style brass instruments and long, sustained bass line notes</li>
  <li>Horror - uses strings, but also unconventional instruments like a music box and tubular bells, and long bass line notes</li>
</ul>
</p>
<p class="definitions"><em>Mood:</em> Mood changes the key, the tempo, the percussion used and the frequency of percussive beats each bar<br> <ul class="definitions">
  <li>Downbeat - sets a minor key, a tempo between 80 and 140bpm, and one percussive beat per bar from bass drum, crash cymbal, and hi-hat.</li>
  <li>Dreamy - major key, tempo between 80 and 110bpm, and one percussive beat per bar from snare, hi-hat, and hand clap. </li>
  <li>Excited - major key, tempo of 110 to 220bpm, two percussive beats per bar from bass drum, hi-hat, crash cymbal, and snare.</li>
  <li>Gloomy - minor key, tempo of 40 to 80bpm, one percussive beat per bar from hi-hat and bass drum. </li>
  <li>Scary - minor key, tempo of 110 to 220bpm, one percussive beat per two bars from hi-hat. </li>
  <li>Upbeat - major key, tempo of 120 to 160bpm, three percussive beats per bar from bass drum, hi-hat, crash cymbal, and snare.</li>
</ul>
</p>
<p class="definitions"><em>Lines of melody:</em> this is when there's more than one instrument playing notes at a time,<br> eg.
for one line of melody you'd only have one instrument, say a piano, playing its track.<br>With two lines of melody you would have
that piano playing its track, but, for example, a violin would also be playing a melody on top of it.</p> <br/>

</body>
</html>

