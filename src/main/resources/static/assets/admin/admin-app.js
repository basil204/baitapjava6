var app = angular.module("adminApp", ["ngRoute"]);

app.config(function ($routeProvider) {
  $routeProvider
    .when("/product", {
      templateUrl: "/assets/admin/product/index.html",
      controller: "productCtrl",
    })
    .when("/authorize", {
      templateUrl: "/assets/admin/authority/index.html",
      controller: "authorizeCtrl",
    })
    .when("/unauthorized", {
      templateUrl: "/assets/admin/authority/index.html",
      controller: "authorityCtrl",
    })
    .otherwise({
      template: "<h1 class='text-center'>FPT ADMIN</h1>",
    });
});
