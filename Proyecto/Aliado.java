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

    public int getPosicion(String cual){
        if (cual=="X"){
            return PosicionX;
        }
        else{
            return PosicionY;
        }
    }

    public boolean getvisible(){
        return visible;
    }

    public void update(int CordenadaX, int CordenadaY, boolean Ataque, String Direccion) {
                if (PosicionX == CordenadaX && PosicionY == CordenadaY){
                    Ayudando_Atacando=true;
                }
                if ((PosicionX-CordenadaX)<5 && (PosicionY-CordenadaY)<5){
                    if ((PosicionX-CordenadaX)>-5 && (PosicionY-CordenadaY)>-5){
                        visible=true;
                    }
                    else{
                        visible=false;
                    }
                }
                else{
                    visible=false;
                }
                PosicionXPrincipal = CordenadaX;
                PosicionYPrincipal = CordenadaY;
            }
}