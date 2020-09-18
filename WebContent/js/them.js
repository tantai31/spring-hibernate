function them(maSua,slm){
	var xhr = new XMLHttpRequest();
    	xhr.onreadystatechange = function(){
    		if(this.readyState==4 && this.status==200)
    			    var kq = this.responseText;
    		    var tst,smh;
    		    tst = kq.substring(0,kq.indexOf(","));
    		    smh = kq.substr(kq.indexOf(",")+1);
    		    document.getElementById("tongSoTien").innerHTML = tst;
    		    document.getElementById("soMatHang").innerHTML = smh;
    	};
    	xhr.open("Post","them-vao-gio",true);
    	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    	xhr.send("idsp="+maSua+"&slm="+slm);
}
 