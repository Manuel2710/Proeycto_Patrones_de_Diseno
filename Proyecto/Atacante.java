import java.util.Random;

public class Atacante extends Entidades implements Observer{
    Random rand = new Random();
    public Atacante(){
        Ayudando_Atacando=false;
        PosicionX=rand.nextInt(50+1);
        PosicionY=rand.nextInt(50+1);
        
    }
    //Se restablece la vida y se genera una nueva ubicación
    public void VolverAparecer(){
        Ayudando_Atacando = false;
        PosicionX=rand.nextInt(50+1);
        PosicionY=rand.nextInt(50+1);
        return;
    }
    public boolean getAyudando_Atacando() {
        Mover();
        return Ayudando_Atacando;
    }

    public int getPosicion(String cual){
        if (cual=="X"){
            return PosicionX;
        }
        else{
            return PosicionY;
        }
    }

    public boolean getvisible(){
        return true;
    }

    public void Mover(){
        if (PosicionXPrincipal>PosicionX){
            PosicionX=PosicionX+1;
        }
        if (PosicionXPrincipal<PosicionX){
            PosicionX=PosicionX-1;
        }
        if (PosicionXPrincipal==PosicionX){
            if (PosicionYPrincipal>PosicionY){
                PosicionY=PosicionY+1;
            }
            if (PosicionYPrincipal<PosicionY){
                PosicionY=PosicionY-1;
            }
            if (PosicionXPrincipal == PosicionX && PosicionYPrincipal == PosicionY){
                Ayudando_Atacando=true;
            }
        }
    }

    public void update(int CordenadaX, int CordenadaY, boolean Ataque, String Direccion) {
        PosicionXPrincipal = CordenadaX;
        PosicionYPrincipal = CordenadaY;
        if (PosicionX == CordenadaX && PosicionY == CordenadaY){
            Ayudando_Atacando=true;
        }
        if(Ataque==true){
            switch(Direccion){
                case "Abajo":
                    if (PosicionX == CordenadaX && (PosicionY - CordenadaY) == 1){
                        VolverAparecer();
                    }
                    break;
                case "Arriba":
                    if (PosicionX == CordenadaX && (PosicionY - CordenadaY) == -1){
                        VolverAparecer();
                    }
                    break;
                case "Derecha":
                    if (PosicionY == CordenadaY && (PosicionX - CordenadaX) == 1){
                        VolverAparecer();
                    }
                    break;
                case "Izquierda":
                    if (PosicionY == CordenadaY && (PosicionX - CordenadaX) == -1){
                        VolverAparecer();
                    }
                    break;
                }
        }
    }
}