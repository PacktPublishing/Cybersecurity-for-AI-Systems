document.getElementById('search').onclick = function() {
	var url=document.getElementById("url").value;
	url=encodeURIComponent(url);
	// url=decodeURIComponent(url);
	console.log("url",url);
    window.open(url);
};