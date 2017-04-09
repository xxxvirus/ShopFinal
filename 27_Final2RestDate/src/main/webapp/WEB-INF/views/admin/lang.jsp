<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<sec:csrfMetaTags />
<script type="text/javascript">
		var app = angular.module('app', ['angularUtils.directives.dirPagination']);
		app.filter('byLang', function() {
			return function(input, search) {
				if (!search) return input;
				var array = [];
				for (var i = 0; i < input.length; i++) {
					if (input[i].lang.toLowerCase().indexOf(search.toLowerCase()) !== -1) {
						array.push(input[i])
					}
				}
				return array;
			}
		});
		
		app.controller('mainCtrl', function($scope, $http){
			 $scope.language = [];
             $scope.currentItem = {};
             $scope.currentView = 'data';
             $scope.add = function(){
                 $scope.currentView = 'form';
             }
             $scope.cancel = function(){
                 $scope.currentView = 'data';
                 $scope.currentItem = {};
             }
             $scope.save = function(){
             	$http({
             		method:"PUT",
						url:"/admin/lang",
						data:$scope.currentItem,
						headers:{'X-CSRF-TOKEN':$("meta[name='_csrf']").attr("content")}
             	}).then(function(result) {
             		for(var i = 0; i < $scope.language.length; i++){
             			if(result.data.id==$scope.language[i].id){
             				$scope.language.splice(i, 1);
             			}
             		}
             		$scope.language.push(result.data);
					})
                 $scope.cancel();
             }
             $scope.update = function(item){
                 $scope.currentItem = item;
                 $scope.add();
             }
             $scope.delete = function(item){
             	$http({
             		method:"DELETE",
						url:"/admin/lang/"+item.id,
						headers:{'X-CSRF-TOKEN':$("meta[name='_csrf']").attr("content")}
             	}).then(function() {
             		for(var i = 0; i < $scope.language.length; i++){
             			if(item.id==$scope.language[i].id){
             				$scope.language.splice(i, 1);
             			}
             		}
             	});
             }
             $scope.refresh = function() {
					$http({
						method:"GET",
						url:"/admin/lang"
					}).then(function(result) {
						$scope.language = result.data;
					});
				}
             $scope.refresh();
             
             $scope.sort = function(keyname){
                 $scope.sortKey = keyname;
                 $scope.reverse = !$scope.reverse;
             }
         });
	</script>
<div class="row">
	<nav class="navbar navbar-default">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="/admin/book">Books</a></li>
					<li><a href="/admin/titleSh">TitleShop</a></li>
					<li><a href="/admin/genre">Genres</a></li>
					<li><a href="/admin/author">Authors</a></li>
					<li><a href="/admin/category">Category</a></li>
					<li class="active"><a href="/admin/lang">Languages</a><span
						class="sr-only">(current)</span></li>
					<li><a href="/admin/publisher">Publisher</a></li>
					<li><a href="/admin/seriaPub">Seria of Publish</a></li>
					<li><a href="/admin/shop">Shop</a></li>
				</ul>
			</div>
	</nav>
</div>
<div class="container-fluid text-left" ng-app="app"	ng-controller="mainCtrl">
	<div class="row" ng-show="currentView == 'data'">
		<div class="col-md-2">
			<form class="form-inline">
				<div class="form-group">
					<input type="text" ng-model="search" class="form-control"
						placeholder="Search">
				</div>
			</form>
		</div>
		<div class="col-md-10">
			<div class="alert alert-info row">
				<div class="col-md-4">Sort key: {{sortKey}}</div>
				<div class="col-md-4">Reverse: {{reverse}}</div>
				<div class="col-md-4">Search string : {{search}}</div>
			</div>
			<div class="row">
				<table class="table table-striped text-center">
					<tr>
						<th class="text-center" ng-click="sort('lang')"
							style="cursor: pointer;">Language<span
							class="glyphicon sort-icon" ng-show="sortKey=='lang'"
							ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
						<th class="text-center">Update</th>
						<th class="text-center">Delete</th>
					</tr>
					<tr
						dir-paginate="item in language|orderBy:sortKey:reverse|byLang:search|itemsPerPage:10">
						<td>{{item.lang}}</td>
						<td><button class="btn btn-warning" ng-click="update(item)">Update</button></td>
						<td><button class="btn btn-danger" ng-click="delete(item)">Delete</button></td>
					</tr>
				</table>
			</div>
			<div class="row">
				<div class="col-md-12">
					<button class="btn btn-primary" ng-click="add()">Add</button>
				</div>
			</div>
			<div class="row text-center">
				<dir-pagination-controls max-size="5" direction-links="true"
					boundary-links="true"> </dir-pagination-controls>
			</div>
		</div>
	</div>
	<div class="row" ng-show="currentView == 'form'">
		<form name='frm' class="form-horizontal" novalidate>
			<div class="form-group">
				<label for="" class="control-label col-md-2">Language</label>
				<div class="col-md-6">
					<input name="name" ng-model="currentItem.lang" class="form-control" ng-required='true' type="text"/>
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-6 col-md-offset-2">
					<button class="btn btn-success" type='submit' ng-disabled='!frm.$valid' ng-click="save()">Create</button>
					<button class="btn btn-warning" type='submit' ng-click="cancel()">Cancel</button>
				</div>
			</div>
		</form>
	</div>
</div>