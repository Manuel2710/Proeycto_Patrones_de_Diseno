public class Controlador {
    int Cantidad_Enemigos;
    int Cantidad_Aliados;
    public Controlador(){
        Cantidad_Aliados=0;
        Cantidad_Enemigos=0;
    }

    public void Accion(){

    }

    public int getCantidad_entidades(String Aliado_Enemigo){
        if (Aliado_Enemigo=="Aliado"){
            return Cantidad_Aliados;
        }
        else {
            if (Aliado_Enemigo=="Enemigo"){
                return Cantidad_Enemigos;
            }
        }
        return 0;
        
    }

    public int getPosicion(int num, String X_Y, String Aliado_Enemigo_Principal){
        return 1;
    }
}
