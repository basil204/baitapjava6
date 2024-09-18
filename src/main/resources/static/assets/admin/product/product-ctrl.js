app.controller("productCtrl", function ($scope, $http) {
    $scope.items = [];
    $scope.cates = [];
    $scope.form = {};

    $scope.initialize = function () {
        // Load data product
        $http.get("/rest/products").then((resp) => {
            $scope.items = resp.data;
            $scope.items.forEach((item) => {
                item.createDate = new Date(item.createDate);
            });
        });
        $http.get("/rest/categories").then((resp) => {
            $scope.cates = resp.data;
        });
    };

    $scope.edit = function (item) {
        $scope.form = angular.copy(item);
        $(".nav-tabs a:eq(0)").tab("show");
    };

    $scope.imageChanged = function (files) {
        var data = new FormData();
        data.append("file", files[0]);
        $http
            .post("/rest/upload/images", data, {
                transformRequest: angular.identity,
                headers: { "Content-Type": undefined },
            })
            .then((resp) => {
                $scope.form.image = resp.data.name;
            })
            .catch((error) => {
                alert("Lỗi khi tải ảnh lên");
                console.log(error);
            });
    };

    $scope.reset = function () {
        $scope.form = {
            createDate: new Date(),
            image: "cloud-upload.jpg",
            available: true,
        };
    };

    $scope.create = function () {
        var item = angular.copy($scope.form);
        $http
            .post("/rest/products", item)
            .then((resp) => {
                resp.data.createDate = new Date(resp.data.createDate);
                $scope.items.push(resp.data);
                $scope.reset();
                alert("Thêm sản phẩm thành công");
            })
            .catch((error) => {
                $scope.reset();
                alert("Lỗi thêm sản phẩm mới");
                console.log(error);
            });
    };

    $scope.update = function () {
        var item = angular.copy($scope.form);
        $http
            .put(`/rest/products/${item.id}`, item)
            .then((resp) => {
                var index = $scope.items.findIndex((p) => p.id == item.id);
                if (index !== -1) {
                    $scope.items[index] = item;
                    alert("Cập nhật thành công");
                } else {
                    alert("Sản phẩm không tìm thấy trong danh sách");
                }
            })
            .catch((error) => {
                alert("Lỗi cập nhật sản phẩm");
                console.log(error);
            });
    };

    $scope.delete = function (item) {
        $http
            .delete(`/rest/products/${item.id}`)
            .then((resp) => {
                var index = $scope.items.findIndex((p) => p.id == item.id);
                if (index !== -1) {
                    $scope.items.splice(index, 1); // Corrected the method to remove item
                    alert("Xóa thành công");
                } else {
                    alert("Sản phẩm không tìm thấy trong danh sách");
                }
            })
            .catch((error) => {
                alert("Lỗi xóa sản phẩm");
                console.log(error);
            });
    };

    $scope.pager = {
        page: 0,
        size: 10,
        get items() {
            var start = this.page * this.size;
            return $scope.items.slice(start, start + this.size);
        },
        get count() {
            return Math.ceil(1.0 * $scope.items.length / this.size);
        },
        first() {
            this.page = 0;
        },
        prev() {
            if (this.page > 0) {
                this.page--;
            }
        },
        next() {
            if (this.page < this.count - 1) {
                this.page++;
            }
        },
        last() {
            this.page = this.count - 1;
        },
    };

    $scope.initialize();
});
