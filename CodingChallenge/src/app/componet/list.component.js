"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
exports.__esModule = true;
var core_1 = require("@angular/core");
var ListComponent = /** @class */ (function () {
    function ListComponent(http) {
        this.http = http;
        this.lists = [];
    }
    ListComponent.prototype.ngOnInit = function () { this.dispList(); };
    ListComponent.prototype.dispList = function () {
        var _this = this;
        this.http.get('http://localhost:9080/groceryservice/grocery-lists')
            .toPromise().then(function (r) {
            console.log(r);
            _this.lists = r;
        })["catch"](function (e) { return console.log(e); });
    };
    ListComponent.prototype.create = function (form) {
        this.http
            .post('http://localhost:9080/groceryservice/grocery-lists', {
            list_owner: form.value.owner
        })
            .toPromise()
            .then(function (r) { console.log(r); })["catch"](function (e) { return console.log(e); });
    };
    ListComponent.prototype.add = function (form) {
        this.http
            .post('http://localhost:9080/groceryservice/grocery-lists/items', {
            grocery_desc: form.value.Name,
            grocery_type: form.value.Type,
            list_id: form.value.list
        })
            .toPromise()
            .then(function (r) {
            console.log(r);
        })["catch"](function (e) { return console.log(e); });
    };
    ListComponent = __decorate([
        core_1.Component({
            selector: 'app-grocery-list',
            templateUrl: './grocery-list.component.html',
            styleUrls: ['./grocery-list.component.css']
        })
    ], ListComponent);
    return ListComponent;
}());
exports.ListComponent = ListComponent;
