# RestLocalService

## Acceso a Servicios SOAP y REST

### Servicio SOAP: Acceso al WSDL

Para acceder al archivo WSDL del servicio SOAP que has creado, puedes utilizar la siguiente URL en tu navegador web o en una herramienta como **SOAP UI**:


#### Pasos para acceder al WSDL en SOAP UI:

1. Abre **SOAP UI**.
2. En el menú principal, selecciona `File > New SOAP Project`.
3. Ingresa un nombre para tu proyecto en el campo `Project Name`.
4. En el campo `Initial WSDL`, ingresa la URL:

5. Haz clic en `OK`.

SOAP UI importará la definición del servicio y generará automáticamente las operaciones disponibles según el WSDL.

#### Información adicional

- **Puerto**: Asegúrate de que el puerto `8080` esté correcto según la configuración de tu aplicación. Si estás utilizando otro puerto, actualiza la URL en consecuencia.
- **Path del servicio**: El path `/soapws/ws/` está definido en la configuración de tu `WebServiceConfig` y puede ser diferente si decides cambiarlo.
- **Nombre del WSDL**: El WSDL es generado bajo el nombre `paises.wsdl` según la configuración de Spring Boot.

### Servicio REST: Acceso a un Recurso REST

Puedes acceder al recurso `Libro` a través de la siguiente URL:

`http://localhost:8090/api/paises`


