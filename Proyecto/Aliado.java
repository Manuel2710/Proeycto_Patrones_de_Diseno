import java.util.Random;

public class Aliado extends Entidades implements Observer{
    Random rand = new Random();
    Boolean visible; 
    public Aliado(){
        Ayudando_Atacando=false;
        visible = false;
        PosicionX=rand.nextInt(50+1);
        PosicionY=rand.nextInt(50+1);
        
        
    }
    //Se restablece la vida y se genera una nueva ubicación
    public void VolverAparecer(){
        if (Ayudando_Atacando==true){
            Ayudando_Atacando = false;
            visible=false;
            PosicionX=rand.nextInt(50+1);
            PosicionY=rand.nextInt(50+1);
        }
        return;
    }
    public boolean getAyudando_Atacando() {
        return Ayudando_Atacando;
    }

    public void update(int CordenadaX, int CordenadaY, boolean Ataque, String Direccion) {
                if (PosicionX == CordenadaX && PosicionY == CordenadaY){
                    Ayudando_Atacando=true;
                    PosicionXPrincipal = CordenadaX;
                    PosicionYPrincipal = CordenadaY;
                }
            }
}