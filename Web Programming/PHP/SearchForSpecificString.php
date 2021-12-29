<?php
$word = "fox";
$mystring = "The quick brown fox jumps over the lazy dog";

if(strpos($mystring, $word) !== false){
    echo "Word Found!";
} else{
    echo "Word Not Found!";
}
?>

