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
        var directionsService;
        var directionsDisplay;

        var labels = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
        var labelIndex = 0;

        $scope.getLastestPosition = getLastestPosition;

        initialize();

        function initialize() {
            var rendererOptions = {
                map: map,
                suppressMarkers: true,
                preserveViewport: true
            }
            directionsDisplay = new google.maps.DirectionsRenderer(rendererOptions);
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
            directionsDisplay.setMap(map);
        }

        function getLastestPosition() {
            $http.get('http://localhost:8080/getLastLocation')
                .then(function successCallback(response) {
                    console.log(response);
                    getRoute(response.data);
                }, function errorCallback(response) {
                    console.log("error");
                });
        }


        function getRoute(data) {
            directionsService = new google.maps.DirectionsService();

            var travelMode = google.maps.DirectionsTravelMode.WALKING;

            var request = {
                origin: new google.maps.LatLng(data.fromX, data.fromY),
                destination: new google.maps.LatLng(data.toX, data.toY),
                travelMode: travelMode
            };
            directionsService.route(request, function (result, status) {
                if (status == google.maps.DirectionsStatus.OK) {
                    directionsDisplay.setDirections(result);
                    createMarker(new google.maps.LatLng(data.fromX, data.fromY), data.titleForm, data.descriptionFrom);
                    createMarker(new google.maps.LatLng(data.toX, data.toY), data.titleTo, data.descriptionTo);
                    labelIndex = 0;
                }
            });
        }

        function createMarker(latlng, label, html) {
            var contentString = '<b>' + label + '</b><br>' + html;
            var marker = new google.maps.Marker({
                position: latlng,
                map: map,
                label: labels[labelIndex++ % labels.length],
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