function encodeHTML(value){
	//Removing script injection
  value=value.replace(/</g,'&lt;').replace(/>/g,'&gt;');
  return value;
}

function printValue(){
  var comment=document.getElementById("comment").value;
  comment=encodeHTML(comment);
  console.log(comment);
  var data="";
  data+="Comment "+comment;
  document.write("<div align='center' style='font-size: 20px;padding:100px;color:blue;'>" + data);
  return false;
}