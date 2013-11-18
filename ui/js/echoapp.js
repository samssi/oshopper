var echo = angular.module('echo',  ['restangular']);



function echoController($scope, Restangular) {
    $scope.init = function() {
        Restangular.oneUrl('apiResponse', 'http://localhost:8080/oshopper/v1/echo/ping').get().then(function(apiResponse) {
            $scope.apiResponse = apiResponse.message
        });
    }
}

/*function echoController($scope, Restangular) {
    $scope.init = function() {
        $http.get("http://localhost:8080/oshopper/v1/echo/ping")
            .success(function(data, status, headers, config) {
                $scope.apiResponse = data.message;
            }).error(function(data, status, headers, config) {
                $scope.apiResponse = "No response from the API!"
            });
    }
}*/
