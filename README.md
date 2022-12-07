# Spring-Boot
A Java Spring Boot Web GIS Application that displays the residential water consumption by each ward in Bengaluru, India. 
This application helps researchers and administrators in planning and forecasting.
- Converted the GeoJSON data of the Bengaluru wards to SHP (Shapefile) format
- Used QGIS Geometry tools to create a centroid point layer and made a table join
- Exported the resulting layer’s attribute table as a csv file
- Applied data processing techniques in Java to extract data from the csv file, transform and load the data into the PostGIS (PostgreSQL) spatial database. 
- On the server side used Java Spring Boot MVC and combined with the use of libraries like Hibernate-Spatial and JPA for the data transformation/conversion 
- In the front-end used Leaflet, Thymeleaf, JavaScript and JQuery to visualize the results
