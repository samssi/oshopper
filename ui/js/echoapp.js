var echo = angular.module('echo',  ['restangular']);

function echoController($scope, Restangular) {
    $scope.init = function() {
        Restangular.oneUrl('apiResponse', 'http://localhost:8080/oshopper/v1/echo/ping').get().then(function(apiResponse) {
            $scope.apiResponse = apiResponse.message
        });
    }
}
