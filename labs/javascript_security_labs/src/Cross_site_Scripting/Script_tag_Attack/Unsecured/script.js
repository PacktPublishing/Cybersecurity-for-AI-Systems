function printValue(){
  var comment=document.getElementById("comment").value; 
  var data="";
  data+="Comment "+comment;
  document.write("<div align='center' style='font-size: 20px;padding:100px;color:blue;'>" + data);
  return false;
}