var customer = angular.module('customer', ['restangular', 'ui.utils']);
customer.config(function(RestangularProvider) {
        RestangularProvider.setBaseUrl('http://localhost:8080/oshopper/v1/');
    }
)


customer.controller('searchPanelController', function($scope, Restangular) {
    var position = -1;
    $scope.searchForProduct = function($event) {
        console.log($event);
        var searchWord = $scope.searchword;
        var escKeyCode = 27;
        if ($event.keyCode == escKeyCode) {
            $scope.resetSearch();
        }
        else if ($event.keyIdentifier === 'Down') {
            $scope.moveCursorDown();
        }
        else if ($event.keyIdentifier === 'Up') {
            $scope.moveCursorUp();
        }
        else if ($event.keyCode == escKeyCode) {
            $scope.resetSearch();
        }
        else if (searchWord.length > 3) {
            // Make into service
            console.log('Searching for product starting with: ' + searchWord);
            Restangular.one('products').get({searchword: searchWord}).then(function(productList) {
                $scope.searchedProducts = productList;
            });
        }
        else {
            $scope.resetSearch();
        }
    }

    $scope.moveCursorDown = function() {
        if ($scope.searchedProducts != null && position < $scope.searchedProducts.length-1) {
            position = position + 1;
            console.log('position: ' + position + " id: " + $scope.searchedProducts[position].id)
        }
    }

    $scope.moveCursorUp = function() {
        if ($scope.searchedProducts != null && position > 0) {
            position = position - 1;
            //console.log(angular.element($scope.searchedProducts[position].id))
            //console.log(angular.element.find($scope.searchedProducts[position].id))
            document.getElementById($scope.searchedProducts[position].id).className = 'selected';
            console.log('position: ' + position + " id: " + $scope.searchedProducts[position].id)
        }
    }

    $scope.selectProduct = function(name) {
        $scope.searchword = name;
        $scope.resetSearch();
    }

    $scope.resetSearch = function() {
        $scope.searchedProducts = '';
    }
});


customer.controller('productsController', function($scope, Restangular) {
    $scope.shoppingCart = [];

    $scope.loadCampaignProducts = function() {
        Restangular.one('products').get().then(function(apiResponse) {
            $scope.products = apiResponse;
        });
    }

    $scope.addToCart = function(product) {
        console.log(product);
        $scope.shoppingCart.push(product);
        console.log($scope.shoppingCart);
    }
});

