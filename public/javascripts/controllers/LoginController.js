'use strict';

(function() {
    angular
        .module('App')
        .controller('Login', loginController);

    function loginController($scope, LoginService) {
        $scope.feedback = '';

        $scope.postLoginForm = function(username, password, loginUrl, successUrl) {
            LoginService.login(username, password, loginUrl, successUrl).success(function(data, status, headers, config) {
                if (data.valid) {
                    document.location.href = successUrl;
                } else {
                    $scope.feedback = "Invalid username / password. Try again.";
                }
            }).error(function(data, status, headers, config) {
                $scope.feedback = 'Error: ' + data + ", " + status;
            })
        };
    }
})();