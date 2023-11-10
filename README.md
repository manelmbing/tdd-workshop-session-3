# Chicago School of TDD

1. A qué llamamos la Escuela de Chicago
    * Es el estilo de TDD "original" promulgado por **Kent Beck**, **Uncle Bob**, **Martin Fowler**, etc.
    * También se conoce esta estrategia como **TDD clásico**, **Detroit School** o **Inside Out**.
    * Pone el foco en los **cambios de estado** de nuestros objetos y los **valores de retorno**.
    * Orientado a probar el comportamiento y no la implementación. 
    * Los tests deben ser casos de uso, pero son tests unitarios no de aceptación o End to End. 
    * Para ello, el **SUT** puede ser **desde una clase a un subconjunto de módulos** (Sociable tests). 
      > "Una pequeña colección de piezas que juntas proveen el comportamiento deseado" -Dave Farley.
2. En qué consiste esta estratégia
    * Empezamos probando nuestra lógica en la **capa de dominio**, y de ahí construimos hacia las capas superiores o externas (aplicación, infraestructura, ...).
    * La **triangulación** es la estrategia principal para pasar de RED a GREEN. De esta manera, se favorece el descubrimiento de la estructura del código a partir de la práctica de la **refactorización**.
    * A medida que **refactorizamos**, simplificamos la lógica de los métodos, las clases y los módulos dividiendo la funcionalidad y reorganizando el código.
    * La idea es probar la **interfaz**, o contrato, de nuestro módulo de manera que los tests no estén acoplados a la implementación.
    * Los tests deben comportarse como cualquier **usuario**, o consumidor, de nuestro servicio. Y solo deberían cambiar cuando se modifique o añada funcionalidad a la aplicación. 
    * Lo que pretendemos es que nuestro diseño se oriente a la experiencia de usuario, al uso que se va a hacer de nuestra funcionalidad. 
    * Al validar el estado de los objetos, necesitamos trabajar con **objetos reales** desde el inicio. Por este motivo no es muy común el uso de dobles de test, salvo para las dependencias externas.
3. Ventajas
    * Permite centrarnos en **una sola cosa cada vez**, sin necesidad de conocer la imagen completa de nuestro sistema.
    * Permite el **trabajo en paralelo** sobre distintos módulos de la aplicación. 
    * Permite grandes refactorizaciones con **poco riesgo** de romper los tests.
    * Favorece la cohesión y el **bajo acoplamiento** en el código.
    * Evitamos código YAGNI (You Aren't Gonna Need It)
4. Desventajas
    * Se corre el riesgo de tener **problemas de integración* entre las diferentes partes de la aplicación si solo nos concentramos en las partes individuales y no prestamos la debida atención a la imagen completa. 
5. Cuándo elegir esta estratégia
    * Cuando no tenemos del todo clara la arquitectura o nos planteamos **posibles cambios**.
    * Cuando se quiera verificar el estado de los objetos (por ejemplo en flujos o lógica de negocio con mucha complejidad).
    * Cuando las colaboraciones entre módulos, las integraciones, son sencillas.
    * Si no se quiere acoplar la implementación a los test.
    * Si se prefiere no pensar demasiado en la implementación mientras se escriben los test porque queremos empezar a implementar lo antes posible.
