

function selectEntidade(){
		var entidadeList = document.getElementsByName('radioEntidade');
												 
		
		var i;
		
		for(i=0; i<entidadeList.length; i++){
			
			if(entidadeList[i].checked){
				document.getElementById('nomeEntidade').value = entidadeList[i].value;
				console.log("Entidade é "+document.getElementById('nomeEntidade').value);
				break;
			}
		}

	} 
	