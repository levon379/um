(function () {
    'use strict';

    angular.module('HelloWorldApp').factory('UserService', UserService);

    UserService.$inject = ['$http'];
    function UserService($http) {


        return {
            getUsers: getUsers,
            createUser: createUser,
        };

        function getUsers() {

            return $http.get('/user');
        }

        function createUser(userData) {
            return $http({
                url: "/user",
                method: 'POST',
                headers: {'Content-Type': 'application/json'},
                data: userData
            });
        }


    }
})();