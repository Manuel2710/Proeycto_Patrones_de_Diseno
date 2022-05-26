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
        if (Ayudando_Atacando==true){
            Ayudando_Atacando = false;
            PosicionX=rand.nextInt(50+1);
            PosicionY=rand.nextInt(50+1);
        }
        return;
    }
    public boolean getAyudando_Atacando() {
        return Ayudando_Atacando;
    }

    public void Mover(){
        boolean ciclo =true;
        while (ciclo){//En caso de que de un numero que lo vaya a sacar de pantalla
            switch (rand.nextInt(4+1)){//Se estipula el proximo movimiento
                case 1:
                    if (PosicionX>0){
                        PosicionX=PosicionX-1;
                        ciclo=false;
                        break;
                    }
                case 2:
                    if (PosicionX<50){
                        PosicionX=PosicionX+1;
                        ciclo=false;
                        break;
                    }
                case 3:
                    if (PosicionY>0){ 
                        PosicionY=PosicionY-1;
                        ciclo=false;
                        break;
                    }
                case 4:
                    if (PosicionY<50){
                        PosicionY=PosicionY+1;
                        ciclo=false;
                        break;
                    }
            }
        }
    }

    public void update(int CordenadaX, int CordenadaY, boolean Ataque, String Direccion) {
        if (PosicionX == CordenadaX && PosicionY == CordenadaY){
            Ayudando_Atacando=true;
            PosicionXPrincipal = CordenadaX;
            PosicionYPrincipal = CordenadaY;
        }
        else{
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
}