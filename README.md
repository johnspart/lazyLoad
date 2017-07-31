Base de datos :  MySQL
ORM librería : Eclipse link 



SQL{
	CREATE SCHEMA `db_l_l` ;
}
La tabla para el almacenamientos se crea automáticamente cuando la aplicación  es desplegada en un servidor

Server: Se utilizo WLP. Se puede utilizar cualquiera siempre y cuando este posea las librerías de eclispse link

Data source example : {
	<!-- Declare the jar files for MySQL access through JDBC. -->
	<library id="MySQLLib">
		<fileset dir="${shared.resource.dir}/mysql" includes="*.jar" />
	</library>

	<!-- Declare the Worklight Server project database -->
	<dataSource jndiName="jdbc/db_l_l">
		<jdbcDriver libraryRef="MySQLLib" />
		<properties databaseName="db_l_l" password="*****"
			portNumber="3306" serverName="localhost" user="root" />
	</dataSource>

}