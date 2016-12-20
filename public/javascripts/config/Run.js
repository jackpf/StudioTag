/**
 * Created by farrellyja on 20/12/2016.
 */
'use strict';

(function() {
    angular
        .module('App')
        .run(run);

    function run($rootScope, LoginService) {
        $rootScope.LoginService = LoginService;
    }
})();