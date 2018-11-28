/**
 * 
 */

$( document ).ready(function() {
		mapa = L.map('mapa', {
	   // center: [-34.598313, -58.463745],
	    center: [ -34.6083, -58.3712],
	    zoom: 10,  
	    minZoom: 4,
	    maxZoom:17,
	    zoomControl:true 
		});
		L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
	    attribution: ''}).addTo(mapa);
		
		//miTablaTransformador
		var table = document.getElementById('miTablaTransformador');
		var latitud, longitud
		var rowLength = table.rows.length;

		for(var i=1; i<rowLength; i+=1){
		  var row = table.rows[i];
		  var cellLength = row.cells.length; 
		 // alert(row.cells[0].innerHTML +" "+" " + row.cells[1].innerHTML);
		  	L.marker([row.cells[0].innerHTML, row.cells[1].innerHTML]).addTo(mapa)
		}

           

		
//		var marker = L.marker([-34.598494, -58.420186]).addTo(mapa).bindPopup("<button class='btn btn-info' onclick='alert(\"Soy medrano\")'>No me toques(o Si)</button>");
//		
//		var marker2 = L.marker([-34.659438,-58.4704135]).addTo(mapa).on('click', onClick);
//		
//		var marker3 = L.marker([-34.582965, -58.381756]).addTo(mapa).on('click', onClick);					
//		marker3.bindPopup("<b>Martin!</b><br>Que haces Martín????.").openPopup();
//
//		var marker4 = L.marker([-34.697800, -58.468810]).addTo(mapa).on('click', onClick);					
//		marker4.bindPopup("<b>Gaby!</b><br>????.").openPopup();
//
//
//		var marker5 = L.marker([-34.697850, -58.468890]).addTo(mapa).on('click', onClick);					
//		marker5.bindPopup("<b>Jorge!</b><br>????.").openPopup();

//		var polygon = L.polygon([
//				[-34.697878, -58.468897],
//			    [-34.686919, -58.486813],
//			    [-34.651905, -58.530758],
//			    [-34.614052, -58.529385],
//			    [-34.552432, -58.499172],
//			    [-34.533202, -58.46484],
//			    [-34.582965, -58.381756],
//			    [-34.634075, -58.35159],
//			    [-34.65924, -58.418313]
//			],{
//				 color: 'red',
//				 fillColor: 'blue',
//			    fillOpacity: 0.1,
//			    radius: 500
//			}).addTo(mapa).on('click', onMapClick);
//		function onMapClick(e) {
//		    alert("Latitud y Longitud: " + e.latlng);
//		}
	}); 
	function onClick(e){
//		var r = confirm("");
//		if (r == true) {
//			mapa.setView(new L.LatLng((-34.598494), (-58.420186)), parseInt(17));
//		} else {
//		    
//		}
	}