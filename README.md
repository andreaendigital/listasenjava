# Venta de Entradas en Java. Uso de Listas

## Descripción del Proyecto :scroll:

Gestionaremos un sistema de venta de entradas, se ha solicitado la implementación de un programa en Java que permita realizar diferentes operaciones como generación de tickets, boletas y resúmenes de venta, usando listas, estructuras de control, condicionales, modularizando e identificando variables.

## Sobre el proyecto 🚀

### ✨ Requerimientos ✨

👌 1. Se ha solicitado la creación de un programa en Java para gestionar la venta de entradas de sus funciones. El sistema debe considerar diferentes ubicaciones en el teatro y aplicar descuentos del 10% para estudiantes y del 15% para personas de la tercera edad:

- Presentar un menú interactivo para que el usuario elija la operación deseada.
- Utilizar listas y arreglos para almacenar la información de las ventas.
- Aplicar estructuras condicionales para determinar los descuentos y el costo final de las entradas.
- Implementar ciclos iterativos para permitir al usuario realizar varias operaciones consecutivas.
- Generar la impresión de una boleta detallada con el agradecimiento final.


Para llevar a cabo esta solución, es necesario que tomes en cuenta los siguientes pasos:

Paso 1: Declara variables para almacenar información relevante, como el nombre del teatro, la capacidad de la sala, el número de entradas disponibles y el precio unitario de las entradas. Luego, inicializa las variables de la siguiente manera:

- 4 variables locales o más para almacenar temporalmente datos como el tipo de entrada, descuentos temporales, etc.
- 4 variables de instancia o más para almacenar información persistente sobre las entradas vendidas, como el número, ubicación, precio final, etc.
- 3 variables estáticas o más para contabilizar estadísticas globales, como el total de ingresos o la cantidad de entradas vendidas.

Paso 2: Menú interactivo deberá considerar lo siguiente:

A)	Venta de entradas

El programa debe: 

- Permitir al usuario elegir la ubicación deseada en el teatro (por ejemplo, "VIP", "Platea", "Balcón").
- Calcular el costo base de la entrada según la ubicación seleccionada.
- Preguntar si el comprador es estudiante o persona de la tercera edad y aplicar un descuento del 10% o 15%, respectivamente.
- Almacenar la información de la venta, incluyendo la ubicación, el costo final y el descuento aplicado, en una lista o arreglo.
 
B)	Visualizar resumen de ventas. Esto lo debes realizar en una lista o arreglo definida previamente. 
  
C)	Generar boleta : El programa debe Implementar la generación de una boleta detallada para cada venta realizada. La boleta debe incluir la ubicación, el costo base, el descuento aplicado, el costo final y un mensaje agradable.

D)	 Calcular Ingresos Totales acumulados por todas las ventas. 
 
E)	Salir del Programa : Deberás añadir el mensaje “Gracias por su compra”


## Visuales :mage_woman:

Menú interactivo inicial con manjeo de errores según inputs del usuario:
![Captura de pantalla 2025-04-24 103700](https://github.com/user-attachments/assets/437dec87-dd4a-4aac-bb7c-197f8c9c6d26)

Si no hay compras realizadas, las opciones indican al usuario realizar una compra para proceder:
![Captura de pantalla 2025-04-24 103903](https://github.com/user-attachments/assets/15a996b8-2640-483d-999b-91c8a2b8371b)

![Captura de pantalla 2025-04-24 103918](https://github.com/user-attachments/assets/e9d61c35-9878-4a98-a6dd-d8b5d5c2bc62)

En la compra de Entradas, validación de inputs del usuario manejando errores y mensaje de valor de la entrada de manera clara: 
![Captura de pantalla 2025-04-24 104039](https://github.com/user-attachments/assets/34d2f72e-8c50-4298-8dcf-ba7454295eab)

En la validación de cantidad de entradas, se informa cuando desea comprar más entradas de las disponibles, se maneja el input en caso de ser cero y se valida la información retroalimentando al usuario con la información correcta:
![Captura de pantalla 2025-04-24 104226](https://github.com/user-attachments/assets/215d9bff-3530-4417-a323-0bef581bdbc9)

Se valida descuentos a aplicar según edad se determina el tipo de Descuento, si es estudiante o tercera edad:
estudiante:
![Captura de pantalla 2025-04-24 104356](https://github.com/user-attachments/assets/97ec0731-6652-4186-a5e4-41884a31a952)

tercera edad:
![Captura de pantalla 2025-04-24 105056](https://github.com/user-attachments/assets/bf1b71c9-63c6-46dc-819a-9975d9defd94)

tarifa normal:
![Captura de pantalla 2025-04-24 105126](https://github.com/user-attachments/assets/2e3d9e3f-2e63-43fc-8107-2a644f64a1fd)


Se solicita el nombre y se genera el resumen de compra con simulación de proceso de compra inmediato:
![Captura de pantalla 2025-04-24 104412](https://github.com/user-attachments/assets/bcf88164-87a7-4510-b172-c4e729e3a90e)

Con la opción 2 se generan tickets de cada entrada con su detalle y su respectivo id:
![Captura de pantalla 2025-04-24 104643](https://github.com/user-attachments/assets/1ec2a1e5-787d-489a-8a8f-d38ca60cfe51)

Con la opción 3 se genera la boleta que tiene toda la información de la venta en detalle incluyendo el id de la boleta que pasa a ser correlativo con el id de la venta:
![Captura de pantalla 2025-04-24 104916](https://github.com/user-attachments/assets/7fe8b4fb-0c13-44ae-a8de-5e3a90188880)

Con la opción 4 se genera un resumen general de las ventas:
![Captura de pantalla 2025-04-24 104936](https://github.com/user-attachments/assets/8e572d80-3eef-4cc4-bc43-b7428975cc63)

![Captura de pantalla 2025-04-24 105250](https://github.com/user-attachments/assets/cff5d22b-79a0-4a81-902e-f3b5d8e42edb)


Con la opción 5 enlista un detalle resumido de las ventas realizadas:
![Captura de pantalla 2025-04-24 105321](https://github.com/user-attachments/assets/1b253cc1-77f6-4076-ba55-ec9b0bf63e55)

Al no haber entradas disponibles a la venta, entrega un mensaje: 
![Captura de pantalla 2025-04-24 105345](https://github.com/user-attachments/assets/9944318b-7c95-4efc-b9e3-cdf63fab3fc6)

Con la opción 6 se entrega un mensaje de salida y se cierra el programa:
![Captura de pantalla 2025-04-24 105427](https://github.com/user-attachments/assets/e8cfaac8-ee7c-4653-9b9d-64f79a26c742)




















## Autora ⚡ 

- **Andrea Rosero** ⚡  - [Andrea Rosero](https://github.com/andreaendigital)
