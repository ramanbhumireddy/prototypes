var app = angular.module('app', ['ngRoute','ngResource']);
app.run(function($rootScope) {
    $rootScope.appcontext = appName;
})

app.config(function($routeProvider, $scope){
	
    $routeProvider
        .when('/users',{
            templateUrl: $rootScope.appcontext + '/views/users.html',
            controller: 'usersController'
        })
        .when('/roles',{
            templateUrl: $rootScope.appcontext + '/views/roles.html',
            controller: 'rolesController'
        })
        .otherwise(
            { redirectTo: '/' + $rootScope.appcontext }
        );
});

