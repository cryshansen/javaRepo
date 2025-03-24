//global function for looping through pages 

$(function(){
	var hash = getHash();
	console.log("window function after getHash()" + hash);
	
	
    var includes = $('[data-include]');
    jQuery.each(includes, function(){
    	
	   	if($(this).data('include')=="content"){
	   		console.log("window function content include");
	   		
	   		
	   		if (performance.navigation.type == performance.navigation.TYPE_RELOAD) { 
	   			
	   			console.log("YES to reload called onhashchange"); window.onhashchange();
	   		}else{
		   		if(hash ==""){
		   			
		   			console.log($(this).data('include') + ' ; hash is empty: '+ hash);
		   			var file = 'pages/index.html';
		   			$(this).load(file);
		   		}else{
		   			if(hash=="home"){
		   				console.log($(this).data('include') + ' ; hash is : '+ hash);
			   			var file = 'pages/index.html';
			   			$(this).load(file);
		   			}else{
		   			console.log("window.function method hash is not home: " + hash);
		   			var file = 'pages/' + hash + '.html';
		   			$(this).load(file);
		   			}
		   		}
	   		}
	   	 
	    }else{
	    		
	    		console.log($(this).data('include'));
	    		var file = 'views/' + $(this).data('include') + '.html';
	    		$(this).load(file);
	    	}
	    
    });
 });


function getHash() {
	  
	  var x =  window.location.hash;
	  console.log("in getHash hash is: "+x);
	  return remove_first_character(x);
}

window.onhashchange = function() {
	
	//beware injection....
	console.log("window.onhashchangeevent");

    var hash = getHash();
    console.log(hash)
	
	
	// append hash html to data-include when hit includes of content.....add hash.html inject code there.
    var includes = $('[data-include]');
    jQuery.each(includes, function(){
    	console.log($(this).data('include'));
    	if($(this).data('include')=="content"){
    		
    		//console.log(hash + ", link : data include "+$(this).data('include'));
    		
    		if(hash ==""){
	   			
    			console.log("window.onhashchange hash is empty loading index");
	   			var file = 'pages/index.html';
	   			$(this).load(file);
	   		}else{
	   			console.log("window.onhashchange hash is not empty: " + hash);
	   			if(hash=="calendar"){
	   				console.log("in calendar if");
	   				//read hash url to #valentine?
	   			}else{
	   			 var file = 'pages/' + hash + '.html';
	   			//checkfile for /.h pattern and skip
	   			 $(this).load(file);
	   			}
	   		}
       }else{
    		
    	   if($(this).data('include')=="include_calendar"){   
    		   	console.log("include_calendar"); 
    		   	var file = 'pages/component/calendar.html';
    		   	$(this).load(file);
    	   }else if($(this).data('include')=="include_modal"){   
    		   console.log("include_modal"); 
    		   var file = 'pages/component/modal.html';
   		   		$(this).load(file);
    		   
    	   }else{
   		
    		   console.log($(this).data('include'));
   			var file = 'views/' + $(this).data('include') + '.html';
   			$(this).load(file);
    	   }
        	
    	}
      
    });
    
    
}

function remove_first_character(element) {
	  return element.slice(1)
}

function hashLink(){
	
	if(hash == ""){
		//then index
		
	}else if(hash == "calendar"){
		hash = "valentine";
	}
	
}

