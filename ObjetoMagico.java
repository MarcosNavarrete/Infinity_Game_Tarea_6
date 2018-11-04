/*
 Se incluye un objeto mágico al juego: reliquia. 
Al momento de que un jugador lanza los dados, existe 1% de probabilidad de 
activar la reliquia para restaurar la vida original del jugador; 
en el caso de que al lanzar los dados el resultado sea 12 (doble seis),
la probabilidad sube a un 50%. Por otro lado, si un jugador cae en la casilla
de salud, éste tendrá un 5% de probabilidad de activar la reliquia pero en este
caso para conseguir una meditación extra a su colección.
 */
package infinitygame;

import java.util.*;

public class ObjetoMagico {
  private Random azar = new Random();
  private int guardian;

 
  public void reliquia(int saludJugadores[], int meditacionJugador[],int dado,int turno){
    int valor=0;  
      if (dado == 12){
          valor = azar.nextInt(2);
          if(valor==1 ){
              saludJugadores[turno]= 15;
              System.out.println("Vida reestablecida");
          }
      }else{
          valor = azar.nextInt(20);
          if(valor == 0){
              meditacionJugador[turno]+= 1;
              System.out.println("Se ha ganado una meditacion ");
          }
      }
    valor = azar.nextInt(100);
    if(valor == 0){
        saludJugadores[turno]= 15;
        System.out.println("Vida reestablecida");
    }
       
  }  
  
  public void guardianArena(int dado){
    if (dado == 12){
        guardian = guardian - 3;
        System.out.println("Se le han quitado 3 puntos de vida al guardian");
        }else{
        guardian = guardian -1;
    }
  }
  public void furiaGuardian(int saludJugadores[]){
      int valor;
      valor = azar.nextInt(50);
      if(valor == 0){
          System.out.println("El guardian ha lanzado su furia, se restara 1 punto de salud a cada jugador");
          for (int i = 0; i < saludJugadores.length; i++) {
                saludJugadores[i]= saludJugadores[i]-1;
          }
      }
  }
  
  public void crearGuardian(int saludJugadores[]){
      for (int i = 0; i < saludJugadores.length; i++) {
          guardian = saludJugadores[i]+guardian;
      }
    }
}

