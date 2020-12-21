angular.module('app').controller('tasksController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/ezplan';

    $scope.getTasks = function () {
        $http({
            url: contextPath + '/api/v1/tasks',
            method: 'GET'
        })
            .then(function (response) {
                $scope.tasks = response.data;
            });
    };

    $scope.getTasks();
});
