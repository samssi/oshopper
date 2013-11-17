var echo = angular.module('echo', []);

function echoController($scope, $http) {
    $scope.init = function() {
        $http.get("http://localhost:8080/oshopper/v1/echo/ping")
            .success(function(data, status, headers, config) {
                $scope.apiResponse = data.message;
            }).error(function(data, status, headers, config) {
                $scope.apiResponse = "No response from the API!"
            });
    }
}
