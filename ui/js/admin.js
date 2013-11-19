var admin = angular.module('admin', ['restangular']);
admin.config(function(RestangularProvider) {
        RestangularProvider.setBaseUrl('http://localhost:8080/oshopper/v1/');
    }
)

function customerController($scope, Restangular) {
    $scope.add = function() {
        Restangular.one('customers').post('', $scope.customer);
    }
}

function productController($scope, Restangular) {
    $scope.add = function() {
        Restangular.one('products').post('', $scope.product);
    }
}

