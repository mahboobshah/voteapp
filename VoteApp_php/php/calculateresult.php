<html>
<head>
<link rel="stylesheet" type="text/css" href="main2.css">
</head>
<body background="../img/bg.jpg">
<form name="vote" action="../result.html" method="post">
<h2><?php
    $username = "voteapp";
    $password = "2315boys";
    $host = "localhost";
    $database="vote";
    //$key = $_POST['key'];
    $server = mysql_connect($host, $username, $password);
    $connection = mysql_select_db($database, $server);


$key = $_POST['key'];

$my_query = "select vdesc from vote where vid='$key';";

$query1 = mysql_query($my_query);
    
    if ( ! $query1 ) {
        echo mysql_error();
        die;
    }

print_r(mysql_fetch_assoc($query1));

echo "</ br> </br>";
?>
</h2>
<?php

$myquery = "select odesc from options where vid='$key';";

$query2 = mysql_query($myquery);
    
    if ( ! $query2 ) {
        echo mysql_error();
        die;
    }
$data = array();

for ($x = 0; $x < mysql_num_rows($query2); $x++) {
	$data[] = mysql_fetch_assoc($query2);
       echo "<input type='radio' name='id' value='$x' >";
echo $data[$x]['odesc'];	
	echo "</br>";
    }
/*$i=0;
foreach($query2 as &$opt) {
  $i++;
  echo "<input type='radio' name='' value='$opt[1]' >";
}*/

?>

      <input type="submit" value="Vote">
</body>
</html>
