function Hello($scope, $http) {
    $http.get('http://localhost:8080/french/żarła żaba żur').
        success(function(data) {
            $scope.response = data;
        });
}
