import java.util.ArrayList;

public class Principal implements Observado{
    public String Movimiento;//Ultimo movimiento a realizado
    public int PosicionX;
    public int PosicionY;
    public boolean Ataque;
    public int Vida;
    private ArrayList<Observer> observadores;


    public Principal(){
        PosicionX = 0;
        PosicionY = 0;
        Ataque = false;
        Vida = 3;
        observadores = new ArrayList<Observer>();
    }
    public void Reinicio(){
        PosicionX = 0;
        PosicionY = 0;
        Ataque = false;
        Vida = 3;
    }
    public void Movimiento (String Mover){
        Movimiento = Mover;
    }
    public void Cambio_Posicion(){
        switch (Movimiento){
            case "Izquierda":
                if (PosicionX>0){
                    PosicionX=PosicionX-1;
                }
                break;
            case "Derecha":
                if (PosicionX<50){
                    PosicionX=PosicionX+1;
                }
                break;
            case "Arriba":
                if (PosicionY>0){ 
                    PosicionY=PosicionY-1;
                }
                break;
            case "Abajo":
                if (PosicionY<50){
                    PosicionY=PosicionY+1;
                }
                break;
            }
        notificarObserver();
    }
    public void PerderVida(){
        Vida=Vida-1;
    }
    public void AumentarVida(){
        Vida=Vida+1;
    }

    public void atacar(){
        Ataque=true;
        notificarObserver();
        Ataque=false;
    }

    @Override
    public void agregar(Observer o) {
        observadores.add(o);
    }
    @Override
    public void eliminar(Observer o) {
        for (int Ciclo=observadores.size();Ciclo==0;Ciclo--){
            observadores.remove (observadores.size() - 1);
        }
        
    }
    @Override
    public void notificarObserver() {
        for(Observer observer : observadores){
            observer.update(PosicionX, PosicionY, Ataque, Movimiento);
    }
}
}
