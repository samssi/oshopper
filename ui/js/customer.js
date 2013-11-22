var customer = angular.module('customer', ['restangular']);
customer.config(function(RestangularProvider) {
        RestangularProvider.setBaseUrl('http://localhost:8080/oshopper/v1/');
    }
)

function searchPanelController($scope, Restangular) {
    $scope.searchForProduct = function() {
        alert('jee');
    }
}


function productsController($scope, Restangular) {
    $scope.loadProducts = function() {
        Restangular.one('products').get().then(function(apiResponse) {
            $scope.products = apiResponse
        });
    }
}

