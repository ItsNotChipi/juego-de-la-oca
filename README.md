# algo3-tp-2022c2

Integrantes : 
  Ivan Park 100557, 
  Magalí Burstein, 105727
  
Trabajo práctico : Juego de la Oca

La Oca es un juego de mesa para dos o más jugadores. 
Cada jugador tira un dado y avanza su ficha (de acuerdo al número obtenido) por un tablero en forma de caracol con 63 casillas (o lo que indiquemos). 
Dependiendo de la casilla en la que se caiga, hay diferentes consecuencias explicadas más adelante
En su turno cada jugador tira 1 o 2 dados (según el tamaño del tablero) que le indican el número de casillas que debe avanzar. 
Gana el juego el primer jugador que llega a la casilla 63, «el jardín de la oca».

https://www.youtube.com/watch?v=O7qOkLchANM

Para otorgarle al usuario mayor interacción con el juego decidimos unas nuevas reglas :
  - En caso de caer en una casilla avanzar, el usuario podrá elegir entre avanzar 3 casilleros o elegir a otro jugador para que los retroceda
  - En caso de caer en una casilla retroceder, el usuario podrá elegir entre arrojar los dados y retroceder esa cantidad de casillas o perder el próximo turno
  - En caso de caer en una casilla swap el usuario deberá elegir un jugador para intercambiar posiciones
  - En caso de caer en una casilla suerte el usuario volverá a tirar los dados, ganando un nuevo turno

## Patrones de diseño a utilizar :
  
  Game Loop
    Este patrón lo utilizaremos para generar una dinámica dentro del juego donde este continue activo, con música y movimientos
    a pesar de que el jugador aún no haya ingresado su siguiente acción, el cual en este caso sería arrojar los dados
  
  Command
    Este patrón lo utilizaremos para definir los distintos objetos que comparten capacidades similares pero para poder utilizar 
    unicamente las que sean necesarias y no tener que redefinir sin necesidad. Estos objetos serían los diferentes casilleros
    que según lo que represente el jugador obtendrá una consecuencia diferente. Es decir, cada casillero especial estará compuesto
    por el objeto pasa casillero.

### Patrones revisitados V1:

  Strategy:
    Reemplazaremos Command por este patrón a la hora de definir los distintos objetos que comparten capacidades similares pero para poder utilizar unicamente las que sean necesarias y no tener que redefinir sin necesidad. Se implementarán los casilleros especiales de esta manera.

  State:
    Este patrón será utilizado para indicar el estado del juego ya que permite a un objeto alterar su comportamiento cuando su estado interno cambia. Por ej, jugador tiene que tirar los dados, jugador x gana la partida, etc.
    
### Patrones revisitados V2:

  Facade:
    Este patrón será implementado mediante la clase **JuegoDeLaOca** y nos permitirá simplificar la interacción entre el cliente y el juego, sin dar lugar a conocer la implementación interna y su complejidad.

  State:
    Este patrón será utilizado para indicar el estado del juego ya que permite a un objeto alterar su comportamiento cuando su estado interno cambia. Por ej, jugador tiene que tirar los dados, jugador x gana la partida, etc.
  
