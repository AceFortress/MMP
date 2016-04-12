'use strict';

angular.module('myApp.view1', ['ngRoute'])

    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/view1', {
            templateUrl: 'view1/view1.html',
            controller: 'View1Ctrl'
        });
    }])

    .controller('View1Ctrl', function ($scope, $timeout) {
        var stompClient = null;

        $scope.startLoc = [];
        $scope.endLoc = [];
        $scope.connect = connect;
        $scope.disconnect = disconnect;
        $scope.sendName = sendName;
        $scope.connected = false;

        function setConnected(connected) {
            $scope.connected = connected;
        }

        function connect() {
            var socket = new SockJS('/request');
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function (frame) {
                setConnected(true);
                console.log('Connected: ' + frame);
                stompClient.subscribe('/topic/response', function (body, headers) {
                    console.log("Received response.");
                    var startLoc = [];
                    var endLoc = [];
                    var ticks = [];
                    var arr = JSON.parse(body.body);
                    //for (var i = 0; i < arr.length; i++) {
                    for (var i = 0; i < 60; i++) {
                        startLoc.push(arr[i].doubleLatitude + ", " + (arr[i].doubleLongitude))
                        endLoc.push(arr[i].doubleLatitude + ", " + arr[i].doubleLongitude);
                        ticks.push(Math.floor(Math.random() * 1000));
                    }

                    console.log(startLoc);
                    console.log(endLoc);
                    console.log(ticks);
                    setRoutes(startLoc, endLoc, ticks);
                });
            });
        }

        function disconnect() {
            if (stompClient != null) {
                stompClient.disconnect();
            }
            setConnected(false);
            console.log("Disconnected");
        }

        function sendName() {
            var name = "rnd";
            stompClient.send("/app/request", {}, JSON.stringify({'name': name}));
        }

        function showMessage(message) {
            console.log(message);
        }

        //global
        var map;
        var directionsService;
        var infowindow = null;

        //TODO Refactor this as fun params
        var step = 2;  // metres
       // var tick = 100; // milliseconds

        initialize();
        $scope.setRoutes = setRoutes;

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

        function setRoutes(startLoc, endLoc, ticks) {
            var directionsDisplay = new Array();
            for (var i = 0; i < startLoc.length; i++) {
                directionsService = new google.maps.DirectionsService();

                var travelMode = google.maps.DirectionsTravelMode.WALKING;

                var request = {
                    origin: startLoc[i],
                    destination: endLoc[i],
                    travelMode: travelMode
                };
                $timeout(function () {

                }, 10);
                $timeout(routeWrapper, 1000 * i, true, request, i, directionsDisplay[i], "", ticks[i]);
                //directionsService.route(request, makeRouteCallback(i, directionsDisplay[i], lineNumbers[i], ticks[i]));
            }
        }

        function routeWrapper(request, i, directionsDisplay, lineNumber, tick) {
            directionsService.route(request, makeRouteCallback(i, directionsDisplay, lineNumber, tick))
        }

        function makeRouteCallback(routeNum, disp, lineNumber, tick) {
            var marker = [];
            var polyline = [];
            var poly2 = [];
            var startLocation = [];
            var endLocation = [];
            if (polyline[routeNum] && (polyline[routeNum].getMap() != null)) {
                startAnimation(routeNum);
                //marker[index].setMap(null);
                return;
            }

            return function (response, status) {
                console.log("Line status: " + status + " , and response: " + response);

                var i, j, k;
                if (status == google.maps.DirectionsStatus.OK) {
                    startLocation[routeNum] = new Object();
                    endLocation[routeNum] = new Object();

                    polyline[routeNum] = new google.maps.Polyline({
                        path: [],
                        strokeColor: '#FFFF00',
                        strokeWeight: 3
                    });

                    poly2[routeNum] = new google.maps.Polyline({
                        path: [],
                        strokeColor: '#FFFF00',
                        strokeWeight: 3
                    });

                    var legs = response.routes[0].legs;

                    var rendererOptions = {
                        map: map,
                        suppressMarkers: true,
                        preserveViewport: true
                    }

                    disp = new google.maps.DirectionsRenderer(rendererOptions);
                    disp.setMap(map);
                    disp.setDirections(response);

                    for (i = 0; i < legs.length; i++) {
                        if (i == 0) {
                            startLocation[routeNum].latlng = legs[i].start_location;
                            startLocation[routeNum].address = legs[i].start_address;
                            marker[routeNum] = createMarker(legs[i].start_location, lineNumber.toString(), legs[i].start_address, "green");
                        }
                        endLocation[routeNum].latlng = legs[i].end_location;
                        endLocation[routeNum].address = legs[i].end_address;
                        var steps = legs[i].steps;

                        for (j = 0; j < steps.length; j++) {
                            var nextSegment = steps[j].path;
                            for (k = 0; k < nextSegment.length; k++) {
                                polyline[routeNum].getPath().push(nextSegment[k]);
                            }

                        }
                    }

                } else {
                    console.log("Line: " + lineNumber + " failed.");
                    console.log(response);
                    console.log(status);
                }
                if (polyline[routeNum]) {
                    console.log("Line start: " + lineNumber);
                    polyline[routeNum].setMap(map);
                    startAnimation(routeNum, polyline, poly2, marker, endLocation, tick);
                    //marker[index].setMap(null);
                }
            }
        }

//----------------------------------------------------------------------
        function updatePoly(i, d, lastVertex, polyline, poly2, endLocation) {
            // Spawn a new polyline every 20 vertices, because updating a 100-vertex poly is too slow
            if (poly2[i].getPath().getLength() > 20) {
                poly2[i] = new google.maps.Polyline([polyline[i].getPath().getAt(lastVertex - 1)]);
                // map.addOverlay(poly2)
            }

            if (polyline[i].GetIndexAtDistance(d) < lastVertex + 2) {
                if (poly2[i].getPath().getLength() > 1) {
                    poly2[i].getPath().removeAt(poly2[i].getPath().getLength() - 1)
                }
                poly2[i].getPath().insertAt(poly2[i].getPath().getLength(), polyline[i].GetPointAtDistance(d));
            } else {
               poly2[i].getPath().insertAt(poly2[i].getPath().getLength(), endLocation[i].latlng);
            }
        }

//----------------------------------------------------------------------------

        function animate(index, d, lastVertex, eol, polyline, poly2, marker, endLocation, tick) {
            if (d > eol[index]) {

                marker[index].setPosition(endLocation[index].latlng);
               //marker[index].setMap(null);
                return;
            }
            var p = polyline[index];
            p = p.GetPointAtDistance(d);

            //map.panTo(p);
            marker[index].setPosition(p);
            updatePoly(index, d, lastVertex, polyline, poly2, endLocation);
            $timeout(function () {
                animate(index, d + step, lastVertex, eol, polyline, poly2, marker, endLocation, tick)
            }, (tick/160));


        }

//-------------------------------------------------------------------------

        function startAnimation(index, polyline, poly2, marker, endLocation, tick) {
            var eol = [];
            var timerHandle = [];
            if (timerHandle[index]) clearTimeout(timerHandle[index]);
            eol[index] = polyline[index].Distance();
            //map.setCenter(polyline[index].getPath().getAt(0));

            poly2[index] = new google.maps.Polyline({
                path: [polyline[index].getPath().getAt(0)],
                strokeColor: "#FFFF00",
                strokeWeight: 3
            });
            var lastVertex = 1;
            $timeout(function () {
                animate(index, 5, lastVertex, eol, polyline, poly2, marker, endLocation, tick)
            });
        }

    });