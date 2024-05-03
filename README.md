Instrucciones levantamiento y/o ejecución de pruebas:

Folder Autenticacion:

1). En la collection de Postman brindada, se encuentra una carpeta llamada Autenticación, donde ejecuta un Metodo Post llamado "Generar Token", allí generará un "access_token" el cual servirá para autenticarnos y asi ejecutar los consumos del api.
  - Nota: En caso de que salga el mensaje: "message": "Error validating grant. Your authorization code or refresh token may be expired or it was already used", este quiere decir que ya existe un token y se tiene que ejecutar el refresh token.

2). En la collection de Postman brindada, se encuentra una carpeta llamada Autenticación, donde ejecuta un Metodo Post llamado "Refresh Token", el cual refrescara la sesión con el token que hemos generado anteriormente.
  - Nota: El token tiene un tiempo de vida de 6 horas, después de ese tiempo se tiene hacer uso nuevamente del método.


Folder Cupon:

1). Dentro de este folder, se encuentra el metodo POST "Listar Items", donde se encuentra información acorde de los "items_id".
  - Nota: Para obtener más "items_id" de prueba se pueden consultar en el Folder Gets MercadoLibre haciendo uso de los metodos:
    - Listar todas las categorias: Donde se encuentran categorias de productos y hay que tomar como refencia el campo "id"
    - Buscar articulos por categoria: Donde se pueden encontrar "items_id" que estan identificados con el valor "id" y se pasa en el Params la categoria encontrada anteriormente.

2).  Dentro de este folder, se encuentra el metodo POST "Listar cupones", donde se pueden usar los valores suministrados en la siguiente tabla para hacer las pruebas correspondientes al Desafio 1 del Challenge de MercadoLibre.

| Items_Id | Price |
| ------------- | -------- |
| MLA1412962259 | 6304.0   |
| MLA1145029073 | 37999.05 |
| MLA1394823556 | 62235.0  |
| MLA1398389871 | 31900.0  |
| MLA1277641650 | 2960.1   |

  - Nota: Hay que tener en cuenta que nuestro token de autenticación se pasa por la cabezera (Headers) y tiene el valor de "authToken"

Folder Favoritos:

1). Dentro de este folder, se encuentra el metodo GET "Favoritos" que hace alución al Desafio 2 del Challenge de MercadoLibre y se mandan por parametros los siguientes valores por parametro:
  -  items: Los items que se quieren filtar
  -  fechaInicial: Rango de fecha inicial a filtar
  -  fechaFinal: Rango de fecha final a filtar

 - Nota: Hay que tener en cuenta que nuestro token de autenticación se pasa por la cabezera (Headers) y tiene el valor de "authToken"


URL API:

Se realizo el despliegue del .jar dentro del cloud AWS.

Metodos Post Cupon:

http://18.234.211.29:8080](http://18.234.211.29:8080/challenge/mercadolibre/items
http://18.234.211.29:8080/challenge/mercadolibre/coupon

Metodos Get Favoritos:
http://18.234.211.29:8080/challenge/mercadolibre/coupon/stats?items=MLA1277641650,MLA1412962259,MLA1394823556, MLA1398389871, MLA1145029073&fechaInicial=2024-02-04&fechaFinal=2024-03-04
