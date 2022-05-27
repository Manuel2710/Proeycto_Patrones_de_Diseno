import java.util.ArrayList;

public class Controlador {
    int Cantidad_Enemigos;
    int Cantidad_Aliados;
    Entidades nuevo;
    int Ciclo;
    int turno;
    ArrayList<Entidades> misAtacantes = new ArrayList<>();
    ArrayList<Entidades> misAliados = new ArrayList<>();
    Factory creacion;

    Principal prota = new Principal();
    public Controlador(){
        Cantidad_Aliados=0;
        Cantidad_Enemigos=0;
        Ciclo=0;
        turno=0;
    }

    public void Accion_Principal(String Mov){
        if (Mov != "Ataque"){
            prota.Movimiento(Mov);
            prota.Cambio_Posicion();
            if ((turno)%10==0){
                if (Cantidad_Aliados<5){
                    nuevo = creacion.construir("Aliado");
                    prota.agregar(nuevo);
                    misAliados.add(nuevo);
                    Cantidad_Aliados+=1;
                }
                nuevo = creacion.construir("Atacante");
                prota.agregar(nuevo);
                misAtacantes.add(nuevo);
                Cantidad_Enemigos+=1;
        }
        else{
            prota.Ataque=true;
        }
        turno=turno+1;
    }
    }

    public void Accion_Enemigo_Aliado(){
        for(Ciclo=0;Ciclo<(Cantidad_Aliados);Ciclo++){
            if(misAliados.get(Ciclo).getAyudando_Atacando()){
                prota.AumentarVida();
                misAliados.get(Ciclo).VolverAparecer();
            }
        }
        for(Ciclo=0;Ciclo<(Cantidad_Enemigos);Ciclo++){
            if(misAtacantes.get(Ciclo).getAyudando_Atacando()){
                prota.PerderVida();
                misAtacantes.get(Ciclo).VolverAparecer();
            }
        }
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
        if (Aliado_Enemigo_Principal=="Aliado"){
            for(Ciclo=0;Ciclo<(Cantidad_Aliados);Ciclo++){
                if(Ciclo==num){
                    if (X_Y=="X"){
                        return misAliados.get(Ciclo).getPosicion(X_Y);
                    }
                    else{
                        return misAliados.get(Ciclo).getPosicion(X_Y);
                    }
                }
            }
        }
        if (Aliado_Enemigo_Principal=="Enemigo"){
            for(Ciclo=0;Ciclo<(Cantidad_Enemigos);Ciclo++){
                if(Ciclo==num){
                    if (X_Y=="X"){
                        return misAtacantes.get(Ciclo).getPosicion(X_Y);
                    }
                    else{
                        return misAtacantes.get(Ciclo).getPosicion(X_Y);
                    }
                }
            }
        }
        if (Aliado_Enemigo_Principal=="Principal"){
            if (X_Y=="X"){
                return prota.PosicionX;
            }
            else{
                return prota.PosicionY;
            }
        }
        return 0;
    }

    public Boolean getVisible(int num){
        for(Ciclo=0;Ciclo<(Cantidad_Aliados);Ciclo++){
            if(Ciclo==num){
                return misAliados.get(Ciclo).getvisible();
            }
        }
        return null;
    }
    
}
