	
function getModelWindow(buttonDate){
	console.log(buttonDate);// css button with <time> tag and text value; get innerhtml
	//[Log] <button class="active_dates" onclick="getModelWindow(this);">1</button> (includes.js, line 129)
	alert(buttonDate);
	// Get the modal
	var modal = document.getElementById("myModal");
	//var parent_modal = document.getElementById("modal_component");
	var page_section = document.getElementsByClassName("page_block")[0];
	// Get the button that opens the modal
	var btn = document.getElementById(buttonDate);
	
	// Get the <span> element that closes the modal
	var span = document.getElementsByClassName("close")[0];
	var btn2 = document.getElementsByClassName("return_cal")[0];
	// When the user clicks the button, open the modal 
	//btn.onclick = function() {
	  modal.style.display = "block";
	  //parent_modal.style.display="block"; 
	//}
	
	// When the user clicks on <span> (x), close the modal
	span.onclick = function() {
	  modal.style.display = "none";
	  //parent_modal.style.display="none"; 
	  page_section.style.display="block";
	}
	btn2.onclick =function() {
	  modal.style.display = "none";
	  //parent_modal.style.display="none"; 
	  page_section.style.display="block";
	}
	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
	  if (event.target == modal) {
	    modal.style.display = "none";
	    //parent_modal.style.display="none"; 
	    page_section.style.display="block";
	  }
	}
}
