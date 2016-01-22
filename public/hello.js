var postApp = angular.module('postApp', []);

postApp.controller('postController', function($scope, $http) {
    $scope.response = {};
    $scope.request = {"text" : "żarła żaba żur"};
    $scope.submitForm = function() {

    	$http.get('http://localhost:8080/french/'+$scope.request.text)
    	.success(function(data) {
        if (data.errors) {
          
        } else {
          $scope.response = data;
        }
      });
    };
});