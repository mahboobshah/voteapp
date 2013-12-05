<html>
<head>
<link rel="stylesheet" type="text/css" href="style/main.css">
</head>
<body background="../img/bg.jpg">
<form name="create" action="../frontpage.html" method="post">
<h2><?php
    $server   = "localhost";
    $database = "vote";
    $username = "voteapp";
    $password = "2315boys";
    
    $mysqlConnection = mysql_connect($server, $username, $password);
    if (!$mysqlConnection)
    {
        echo "Error connecting to database.";
    }
    else
    {
        mysql_select_db($database, $mysqlConnection);
    }
?>

<?php
    function generate_random_string($name_length) {
        $alpha_numeric = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
        return substr(str_shuffle($alpha_numeric), 0, $name_length);
    }
    $vid_len = 4;
    $vid = generate_random_string($vid_len);
    $check_vid = mysql_query("select vid from vote where vid='$vid';");
    while($vid == $check_vid){
        $vid = generate_random_string($vid_len);
        $check_vid = mysql_query("select vid from vote where vid='$vid';");
    }
    $vdesc = trim($_POST['pollQuestion']);
    //echo "Poll id: $vid | ";
    //echo "Vote Description: $vdesc | ";
    $options = $_POST['options'];
    $opt_count = count($options);
    //echo "Opt count: $opt_count | ";
    
    $ins = mysql_query("insert into vote values ('$vid','$vdesc',$opt_count)");
    //echo "Return Code: $ins\n";
    $i = 1;
   foreach($options as &$row ) {
       //echo "Row $i: $row '$vid' | ";
       $ins = mysql_query("insert into options values ($i,'$vid','$row',0)");
       //echo "Return Code: $ins | ";
       $i++;
   }
    
?>
<h1>
<?php
echo "Created your poll successfully. Here is your unique poll ID: $vid"
?>
<input type="submit" value="back">
</body>
</html>
