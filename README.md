# Proyecto Transacciones a cuenta

*El proyecto se construyo con el objetivo de separar en carpetas la lógica de negocio y otros, como tal se construyo usando arquitectura hexagonal, para ello se crearon las siguientes carpetas:*

* client
* config
* exceptions
* managedbean
* modelos
	* dto
	* entities
* repositories
* restcontroller
* services

## Tecnología usada
* spring boot 3.5.6
* postgresql para DB
* Java 17
* Kafka 
* JoinFace (Integra spring boot y JSF)

## Configuración

Se lista una serie de variables de entorno que se deben tener en cuenta al momento de levantar el proyecto, estas variables se encuentran en el archivo application.properties
* server-port: definir puerto deseado
* Sección **BASE DE DATOS** definir parametros de la DB a utilizar
* Sección **KAFKA** definir puerto de conexión al sistema de mensajería y topics
* Actualmente se cuenta con app.kafka.topic=test-topic, puede modificarse pero se debera crear un topic en KAFKA
* Sección **SWAGGER** definir path para acceder a swagger, por default se accede con http://localhost:${ server-port}//swagger-ui.html

## Base de datos

En la carpeta DDL se encontraraun archivo llamado **ScriptDB.sql**, el cual contiene los script para crear las tablas de la base de datos y INSERT para poder crear 5 clientes. 
