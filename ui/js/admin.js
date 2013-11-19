var admin = angular.module('admin', ['restangular']);

function customerController($scope, Restangular) {
    $scope.add = function() {
        Restangular.oneUrl('root', 'http://localhost:8080/oshopper/v1/').post('customers', $scope.customer);
    }
}

function productController($scope, Restangular) {
    $scope.add = function() {
        Restangular.oneUrl('root', 'http://localhost:8080/oshopper/v1/').post('products', $scope.product);
    }
}

