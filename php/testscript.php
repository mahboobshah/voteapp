<?php
    $username = "voteapp";
    $password = "2315boys";
    $host = "localhost";
    $database="vote";
    //$key = $_POST['key'];
    $server = mysql_connect($host, $username, $password);
    $connection = mysql_select_db($database, $server);
	
    $myquery = "
SELECT `odesc`, `oscore` FROM `options` WHERE `vid`='BCDE'
";
    $query = mysql_query($myquery);
    
    if ( ! $myquery ) {
        echo mysql_error();
        die;
    }
    
    $data = array();
    
    for ($x = 0; $x < mysql_num_rows($query); $x++) {
        $data[] = mysql_fetch_assoc($query);
    }
    header("Content-Type: application/json");
    echo json_encode($data);     
     
    mysql_close($server);
?>
