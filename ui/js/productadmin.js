var echo = angular.module('productadmin', []);

function productController($scope, $http) {
    $scope.add = function() {
        console.log($scope.product);
    }
    $scope.updateModel = function() {

    }
    /*$scope.init = function() {
        $http.post("http://localhost:8080/oshopper/v1/products", json)
            .success(function(data, status, headers, config) {
                console.log(status);
            }).error(function(data, status, headers, config) {
                console.log("No response from the API!")
            });
    }*/
}
