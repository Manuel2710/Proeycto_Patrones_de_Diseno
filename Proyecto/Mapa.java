import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Mapa extends JFrame implements KeyListener{
    private ListaPixeles pixeles;
    Controlador central = new Controlador();
    int Ciclo1;
    int Ciclo2;
    int CantidadAliados;
    int CantidadEnemigos;

    public Mapa(){
        pixeles = new ListaPixeles();
        CantidadAliados=20;
        CantidadEnemigos=6;
        //Se imprime el tablero
        for (Ciclo1=0;Ciclo1<51;Ciclo1++){
            for(Ciclo2=0;Ciclo2<51;Ciclo2++){
                pintar q = new pintar(Ciclo2, Ciclo1,5);
                pixeles.Agregar(q);
            }
        }
        Ciclo1=0;
        add(pixeles);
    }
    public static void main(String[] args){
        JFrame ventana = new Mapa();
        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ventana.setSize(530,580);
        ventana.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar()=='W' || e.getKeyChar()=='w'){
            System.out.println("w");
        }
        if (e.getKeyChar()=='S' || e.getKeyChar()=='s'){
            System.out.println("s");
        }
        if (e.getKeyChar()=='A' || e.getKeyChar()=='a'){
            System.out.println("a");
        }
        if (e.getKeyChar()=='D' || e.getKeyChar()=='d'){
            System.out.println("d");
        }
        
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getExtendedKeyCode()== KeyEvent.VK_UP){
            System.out.println("up");
        }
        if (e.getExtendedKeyCode()== KeyEvent.VK_DOWN){
            System.out.println("do");
        }
        if (e.getExtendedKeyCode()== KeyEvent.VK_LEFT){
            System.out.println("le");
        }
        if (e.getExtendedKeyCode()== KeyEvent.VK_RIGHT){
            System.out.println("ri");
        }
        
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    public void cuadros(){
    //Elimina los cubos de la lista-Actualiza el tablero
    CantidadAliados = central.getCantidad_entidades("Aliado");
    CantidadEnemigos = central.getCantidad_entidades("Enemigo");
    if(Ciclo1>0){
        for(Ciclo1=0;Ciclo1<(1+CantidadAliados+CantidadEnemigos);Ciclo1++){
            pixeles.Eliminar();
        }
    }

    for(Ciclo1=0;Ciclo1<CantidadAliados;Ciclo1++){

        pintar q = new pintar(central.getPosicion(Ciclo1, "X", "Aliado"),central.getPosicion(Ciclo1, "Y", "Aliado"),3);
        pixeles.Agregar(q);   
    }

    for(Ciclo1=0;Ciclo1<CantidadEnemigos;Ciclo1++){
        pintar q = new pintar(central.getPosicion(Ciclo1, "X", "Enemigo"),central.getPosicion(Ciclo1, "Y", "Enemigo"),2);
        pixeles.Agregar(q);   
    }
    pintar q = new pintar(central.getPosicion(Ciclo1, "X", "Principal"),central.getPosicion(Ciclo1, "Y", "Principal"),1);
    pixeles.Agregar(q);
    add(pixeles);
    }
}
