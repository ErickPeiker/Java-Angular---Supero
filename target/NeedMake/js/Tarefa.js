angular.module('app', ["ngDraggable"])
.controller('controlador', function($scope, $http) {

	$scope.init = function (id, token) {
		$scope.getTarefas();
	};

	$scope.getTarefas = function() {
		$http.get('/rest/tarefa/')
		.then(
	       function(response){
	         $scope.todasTarefas = response.data;
	       }, 
	       function(response){
	         console.log(response);
	       }
	    );
	}
	
	$scope.salvaTarefa = function() {
		$http.post('/rest/tarefa/')
		.then(
	       function(response){
	         $scope.todasTarefas = response.data;
	       }, 
	       function(response){
	         console.log(response);
	       }
	    );
	}

	/*$scope.getClientes = function () {
		$http.get('/get-clientes?ativo=1')
		.then(
	       function(response){
	         $scope.todosClientes = response.data;
	       }, 
	       function(response){
	         console.log(response);
	       }
	    );
	}

	$scope.getNomeCliente = function (idCliente) {
		for (index in $scope.todosClientes) {
			 if($scope.todosClientes[index].ID == idCliente){
			 	return $scope.todosClientes[index].NOME_CLI;
			 }
		}
	}

	$scope.selecionaUsuario = function (idUsuario) {
		$scope.usuario.ID = idUsuario;
		$scope.clienteSelecionado.ID = 0;
		$scope.todosHosts = [];

		//Limpa destaque botão selecionado
		$('.tokenContainerAtivo').each(function (index) {
			$(this).removeClass("tokenContainerAtivo");
			$(this).addClass("tokenContainer");
		});

		//Busca informações do usuario selecionado
		$http.get('/get-hosts-usuario?idusuario='+$scope.usuario.ID)
		.then(
	       function(response){
	       		var novosHosts = [];
	       		for (index in response.data) {
	       			novosHosts.push({
	       				CLIENTEID : response.data[index].host.ID_CLIENTE,
						HOST : response.data[index].host.NOME,
						HOSTID : response.data[index].host.ID_EXTERNO,
						NAME : response.data[index].host.NOME,
						NOME_CLI : $scope.getNomeCliente(response.data[index].host.ID_CLIENTE)
	       			});
	       		}
	         	$scope.usuario.HOSTS = novosHosts;

	         	//Destaque no usuario selecionado
				$('#tag-usuario'+$scope.usuario.ID).removeClass("tokenContainer");
				$('#tag-usuario'+$scope.usuario.ID).addClass("tokenContainerAtivo");
	       }, 
	       function(response){
	        	console.log(response);
	       }
	    );
	}

	//Após clicar em algum cliente trazer todos seus hosts
	$scope.selecionaCliente = function (idCliente) {
		$scope.clienteSelecionado.ID = idCliente;
		$scope.getHostsMaster();
	    
	}

	//Após clicar em algum cliente trazer todos seus hosts
	$scope.getHostsMaster = function () {
		$scope.todosHosts = [];
		$http.post('/get-master-hosts', $scope.clienteSelecionado)
		.then(
			function(response){
				if (response.data.length > 0) {
					$scope.todosHosts = response.data;
					$('.tag-cliente').removeClass("tokenContainerAtivo");
					$('.tag-cliente').addClass("tokenContainer");

					$('#tag-cliente'+$scope.clienteSelecionado.ID).removeClass("tokenContainer");
					$('#tag-cliente'+$scope.clienteSelecionado.ID).addClass("tokenContainerAtivo");
				}
			}, 
			function(response){
				$scope.clienteSelecionado.ID = 0;
				$scope.todosHosts = [];
				$('.tag-cliente').removeClass("tokenContainerAtivo");
				$('.tag-cliente').addClass("tokenContainer");
				alert('Não foi possível comunicação com o banco de dados deste cliente');
				console.log(response.data.error);
			}
	    )
	}

	//Após dar um duplo clique
	$scope.removeHost = function (idcliente, idHost) {
		$scope.usuario.HOSTS = 
		$.grep($scope.usuario.HOSTS, function (host) {
			return host.HOSTID != idHost || host.CLIENTEID != idcliente
		});
	}

	//Duplo clique sobre um host para vincular ele com cliente
	$scope.hostEmUsuario = function(data){
		if (data != undefined) {
			var repetido = false;
			for (var i=0; i<$scope.usuario.HOSTS.length; i++)  {
				if (data.CLIENTEID == $scope.usuario.HOSTS[i].CLIENTEID && 
						data.HOSTID == $scope.usuario.HOSTS[i].HOSTID) {
					repetido = true;
					break;
				}
			}
			if (!repetido) {
				console.log(data);
				$scope.usuario.HOSTS.push(data);
			}
	    }
	}

	//Adicionar todos os hosts do cliente selecionado
	$scope.todosHostsEmUsuario = function(){
		for (index in $scope.todosHosts) {
			$scope.hostEmUsuario($scope.todosHosts[index]);
		}
	}

	$scope.gravaUsuarioHosts = function () {
		var lista = [];
		for (var i=0;i<$scope.usuario.HOSTS.length; i++) {
			lista.push({
				IDUSUARIO : $scope.usuario.ID,
				IDHOST : $scope.usuario.HOSTS[i].HOSTID,
				NOMEHOST : $scope.usuario.HOSTS[i].NAME,
				IDCLIENTE : $scope.usuario.HOSTS[i].CLIENTEID
			});
		}

		if ($scope.usuario.HOSTS.length == 0) {
			lista.push({
				IDUSUARIO : $scope.usuario.ID,
				IDHOST : 0,
				NOMEHOST : '',
				IDCLIENTE : 0
			});
		}

		$http.post('/novo-vinculo', lista)
		.then(
	       function(response){
	         	if (response.data.message) {
	         		alert('Dados salvos com sucesso!');
	         	}
	       }, 
	       function(response){
	        	console.log(response);
	       }
	    );
	}*/

});