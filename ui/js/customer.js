var customer = angular.module('customer', ['restangular', 'ui.utils']);
customer.config(function(RestangularProvider) {
        RestangularProvider.setBaseUrl('http://localhost:8080/oshopper/v1/');
    }
)

function searchPanelController($scope, Restangular) {
    $scope.searchForProduct = function() {
        var searchWord = $scope.searchword;
        if (searchWord.length > 3) {
            console.log('Searching for product starting with: ' + searchWord);
            Restangular.one('products').get({searchword: searchWord}).then(function(productList) {
                $scope.searchedProducts = productList;
            });
        }
    }
}


function productsController($scope, Restangular) {
    $scope.loadProducts = function() {
        Restangular.one('products').get().then(function(apiResponse) {
            $scope.products = apiResponse;
        });
    }
}

