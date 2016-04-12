'use strict';

angular.module('myApp.view1', ['ngRoute'])

    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/view1', {
            templateUrl: 'view1/view1.html',
            controller: 'View1Ctrl'
        });
    }])

    .controller('View1Ctrl', function ($scope, $http) {

        //global
        var map;
        var infowindow = null;
        var currentMarker = null;

        $scope.getLastestPosition = getLastestPosition;

        initialize();

        function initialize() {

            infowindow = new google.maps.InfoWindow(
                {
                    size: new google.maps.Size(150, 50)
                });

            var myOptions = {
                zoom: 16,
                mapTypeId: google.maps.MapTypeId.ROADMAP
            }
            map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);

            var address = 'Stare Miasto, Kraków, Polska';
            var geocoder = new google.maps.Geocoder();
            geocoder.geocode({'address': address}, function (results, status) {
                map.fitBounds(results[0].geometry.viewport);

            });
        }

        function getLastestPosition() {
            $http.get('http://localhost:8080/getLastLocation')
                .then(function successCallback(response) {
                    console.log(response);
                    createMarker(new google.maps.LatLng(response.data.x, response.data.y), 'lastLocation', '');
                }, function errorCallback(response) {
                    console.log("error");
                });
        }


        function createMarker(latlng, label, html) {
            var contentString = '<b>' + label + '</b><br>' + html;
            var marker = new google.maps.Marker({
                position: latlng,
                map: map,
                title: label,
                zIndex: Math.round(latlng.lat() * -100000) << 5
            });
            marker.myname = label;


            google.maps.event.addListener(marker, 'click', function () {
                infowindow.setContent(contentString);
                infowindow.open(map, marker);
            });
            return marker;
        }




    });