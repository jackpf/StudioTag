/**
 * Created by farrellyja on 20/12/2016.
 */

'use strict';

(function() {
    angular
        .module('App')
        .factory('LoginService', loginService);

    function loginService($http) {
        return {
            login: function(username, password, loginUrl, successUrl) {
                var data = {
                    username : username,
                    password : password
                };

                return $http.post(loginUrl, data);
            },

            logout: function(logoutUrl, successUrl) {
                $http.post(logoutUrl, {}).success(function(data, status, headers, config) {
                    document.location.href = successUrl;
                }).error(function(data, status, headers, config) {
                    alert('Error: ' + data + ", " + status);
                });
            }
        };
    }
})();