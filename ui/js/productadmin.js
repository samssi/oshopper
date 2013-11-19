var productadmin = angular.module('productadmin', ['restangular']);

function productController($scope, Restangular) {
    $scope.add = function() {
        Restangular.oneUrl('root', 'http://localhost:8080/oshopper/v1/').post('products', $scope.product);
        console.log($scope.product);
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
