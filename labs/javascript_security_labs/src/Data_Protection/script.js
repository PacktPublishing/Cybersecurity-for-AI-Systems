//Store data in local storage in an encoded format.
document.getElementById('store').onclick = function() {
  data=document.getElementById("data").value;
  data=encode(data,"2");
  document.getElementById("edata").value=data;
  localStorage.setItem("data", data);	
};

document.getElementById('retrieve').onclick = function() {
  var data=localStorage.getItem("data", data);	
  data=encode(data,"2");
  document.getElementById("rdata").value=data;
};

//Data protection 

function encode(value, code) {
  /*Description:Encrypting data
  params:Value to be encrypted
          Encrypting code
  return: Encrypted data*/
  var encoded = "";
  var checkstr = "";
  // make sure that input is string
  checkstr = value.toString();
  for (var loop = 0; loop < value.length; loop++) {
  	// create block
  	var character = value.charCodeAt(loop);
  	// bitwise XOR
  	var encodedchar = character ^ code;
	encoded = encoded + String.fromCharCode(encodedchar);
  }
  return encoded;
}