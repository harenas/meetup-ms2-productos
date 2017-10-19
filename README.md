# Meetup Microservices Session2
### Productos Service

Servicio encargado de las siguientes operaciones

* Mostrar todos los productos con información de venta para cada cliente, dependiendo del tipo BASICO o PREMIUM que será obtenido según el parámetro GET 'rut'

	http://localhost:16000/productos/?rut={rut}


* Mostrar información de un producto en particular según su {id} y el {rut} del cliente

	http://localhost:16000/productos/{id}/?rut={rut}
    
    
* Mostrar información de todos los productos pertenecientes a la categoría {id} para un cliente {rut}

	http://localhost:16000/productos/categoria/{id}/?rut={rut}


*Para efectos de este meetup, todos los servicios son GET.*



La configuración de la aplicación se encuentra en el archivo:

	$RUTA_BASE/src/main/resources/application.yml

### Instalación ###
```console

[user@machine]$ cd $RUTA_BASE
[user@machine]$ mvn install

```

### Ejecución ###
```console

[user@machine]$ java -jar target/productos-0.0.1-SNAPSHOT.jar

```




