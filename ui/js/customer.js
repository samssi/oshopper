var customer = angular.module('customer', ['restangular', 'ui.utils']);
customer.config(function(RestangularProvider) {
        RestangularProvider.setBaseUrl('http://localhost:8080/oshopper/v1/');
    }
)

function searchPanelController($scope, Restangular) {
    $scope.searchForProduct = function($event) {
        var searchWord = $scope.searchword;
        var escKeyCode = 27;
        if ($event.keyCode == escKeyCode) {
            $scope.resetSearch();
        }
        else if (searchWord.length > 3) {
            console.log('Searching for product starting with: ' + searchWord);
            Restangular.one('products').get({searchword: searchWord}).then(function(productList) {
                $scope.searchedProducts = productList;
            });
        }
        else {
            $scope.resetSearch();
        }
    }

    $scope.resetSearch = function() {
        $scope.searchedProducts = '';
    }
}


function productsController($scope, Restangular) {
    $scope.loadCampaignProducts = function() {
        Restangular.one('products').get().then(function(apiResponse) {
            $scope.products = apiResponse;
        });
    }
}

