var userApp = angular.module('user', []);

userApp.controller('MainController', function($http, $window) {
    var vm = this;

    vm.activeUser;
    vm.users = [];
    vm.showList = true;

    vm.add = function() {
        $http.post('/rest/user', {
            name: vm.activeUser.name,
            age: vm.activeUser.age,
            salary: vm.activeUser.salary
        }).then(function(response) {
            $window.location.reload();
        });
    };

    vm.delete = function(user) {
        $http.delete('/rest/user', {
            params: { userId: user.id }
        }).then(function(response) {
            $window.location.reload();
        });
    };

    vm.goToAdd = function() {
        vm.activeUser = null;
        vm.showList = false;
    };

    vm.goToEdit = function(user) {
        vm.activeUser = user;
        vm.showList = false;
    };

    vm.list = function() {
        $http.get('/rest/user').then(function(response) {
            vm.users = response.data;
        });
    };

    vm.save = function() {
        if (vm.activeUser.id) {
            vm.update();
        } else {
            vm.add();
        }
    };

    vm.update = function() {
        $http.put('/rest/user', {
            id: vm.activeUser.id,
            name: vm.activeUser.name,
            age: vm.activeUser.age,
            salary: vm.activeUser.salary
        }).then(function(response) {
            $window.location.reload();
        });
    };
});