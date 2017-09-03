angular.module('app', ["ngDraggable"])
.controller('controlador', function($scope, $http) {

	$scope.init = function (id, token) {
		$scope.reset();
		$scope.getTarefas();
	};
	
	$scope.reset = function () {
		$scope.tarefa = {
			id: 0,
			titulo: '',
			descricao: ''
		}
	}
	
	$scope.onDropComplete = function(tarefaMovida, evt, status) {
		if (tarefaMovida == null || tarefaMovida.status == status) {
		} else {
			tarefaMovida.status = status;
			$scope.tarefa = tarefaMovida;
			$scope.salvaTarefa(true);
		}
	}

	$scope.getTarefas = function() {
		$http.get('./rest/tarefa/')
		.then(
	       function(response){
	         $scope.tarefas = response.data;
	       }, 
	       function(response){
	         console.log(response);
	       }
	    );
	}
	
	$scope.editar = function (tarefa) {
		$scope.tarefa = tarefa;
	}
	
	$scope.validaTarefa = function() {
		if ($scope.tarefa.titulo == '') {
			alert('Favor preencher o campo do título');
			return false;
		} else if ($scope.tarefa.descricao == '') {
			alert('Favor preencher o campo da descrição');
			return false;
		}
		return true;
	}
	
	$scope.salvaTarefa = function() {
		var insercao = $scope.tarefa.id == 0;
		if($scope.validaTarefa()) {
			$http.post('./rest/tarefa/', $scope.tarefa)
			.then(
		       function(response){
		    	   $scope.reset();
		    	   if (insercao) {
		    		   $scope.tarefas.push(response.data);
		    	   }
		       }, 
		       function(response){
		         console.log(response);
		       }
		    );
		}
	}
	
	$scope.exclusaoTarefa = function (tarefa) {
		if (confirm('Excluindo desta lista não terá como recuperar esta informação. Deseja excluir a tarefa "'+tarefa.titulo+'"?')) {
			$http.delete('./rest/tarefa/'+tarefa.id)
			.then(function(response){
				for (var i = 0 ; i < $scope.tarefas.length ; i++) {
				    if ( $scope.tarefas[i].id == tarefa.id) {
				    	$scope.tarefas.splice(i,1);
						break;
				    }
				}
			}, 
	        function(response){
	          console.log(response);
	        });
		}
	}

});