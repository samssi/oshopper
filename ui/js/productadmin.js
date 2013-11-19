var productadmin = angular.module('productadmin', ['restangular']);

function productController($scope, Restangular) {
    $scope.add = function() {
        Restangular.oneUrl('root', 'http://localhost:8080/oshopper/v1/').post('products', $scope.product);
    }
}
