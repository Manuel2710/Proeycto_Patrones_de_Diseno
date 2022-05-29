import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Mapa extends JFrame{
    private ListaPixeles pixeles;
    Controlador central = new Controlador();
    int Ciclo1;
    int Ciclo2;
    int CantidadAliados;
    int CantidadEnemigos;
    int Atacando;
    JLabel texto;
    JPanel PanelTexto;

    public Mapa(){
        pixeles = new ListaPixeles();
        texto = new JLabel("Vida: "); 
        PanelTexto = new JPanel();
        PanelTexto.add(texto, BorderLayout.SOUTH);
        Atacando=1;
        CantidadAliados=0;
        CantidadEnemigos=0;
        //Se imprime el tablero
        for (Ciclo1=0;Ciclo1<51;Ciclo1++){
            for(Ciclo2=0;Ciclo2<51;Ciclo2++){
                pintar q = new pintar(Ciclo2, Ciclo1,5);
                pixeles.Agregar(q);
            }
        }
        Ciclo1=0;
        EventosDeTeclado teclado = new EventosDeTeclado();
        addKeyListener(teclado);
        //////////////////////////////////////////////////////////////
        add(pixeles);
        add(PanelTexto,BorderLayout.NORTH);
    }
    
    public void cuadros(){
        texto.setText("Vida: "+central.getVida());
        //Elimina los cubos de la lista-Actualiza el tablero
        if(Ciclo1>0){
            if (Atacando==1 || Atacando==2){
                for(Ciclo1=0;Ciclo1<(1+CantidadAliados+CantidadEnemigos);Ciclo1++){
                    pixeles.Eliminar();
                }
            }
            else{
                if (Atacando == 3){
                    for(Ciclo1=0;Ciclo1<(2+CantidadAliados+CantidadEnemigos);Ciclo1++){
                        pixeles.Eliminar();
                    }
                    Atacando=1;
                }
            }
        }
        CantidadAliados = central.getCantidad_entidades("Aliado");
        CantidadEnemigos = central.getCantidad_entidades("Enemigo");

        for(Ciclo1=0;Ciclo1<CantidadAliados;Ciclo1++){
            if (central.getVisible(Ciclo1)==true){
                pintar q = new pintar(central.getPosicion(Ciclo1, "X", "Aliado"),central.getPosicion(Ciclo1, "Y", "Aliado"),3);
                pixeles.Agregar(q); 
            }
            else{
                pintar q = new pintar(central.getPosicion(Ciclo1, "X", "Aliado"),central.getPosicion(Ciclo1, "Y", "Aliado"),5);
                pixeles.Agregar(q); 
            }
              
        }

        for(Ciclo1=0;Ciclo1<CantidadEnemigos;Ciclo1++){
            pintar q = new pintar(central.getPosicion(Ciclo1, "X", "Enemigo"),central.getPosicion(Ciclo1, "Y", "Enemigo"),2);
            pixeles.Agregar(q);   
        }
        if (Atacando==2){
            if (central.getPosicion_Ataque()=="Arriba"){
                pintar q = new pintar(central.getPosicion(Ciclo1, "X", "Principal"),central.getPosicion(Ciclo1, "Y", "Principal")-1,0);
                pixeles.Agregar(q);
            }
            if (central.getPosicion_Ataque()=="Abajo"){
                pintar q = new pintar(central.getPosicion(Ciclo1, "X", "Principal"),central.getPosicion(Ciclo1, "Y", "Principal")+1,0);
                pixeles.Agregar(q);
            }
            if (central.getPosicion_Ataque()=="Derecha"){
                pintar q = new pintar(central.getPosicion(Ciclo1, "X", "Principal")+1,central.getPosicion(Ciclo1, "Y", "Principal"),0);
                pixeles.Agregar(q);
            }
            if (central.getPosicion_Ataque()=="Izquierda"){
                pintar q = new pintar(central.getPosicion(Ciclo1, "X", "Principal")-1,central.getPosicion(Ciclo1, "Y", "Principal"),0);
                pixeles.Agregar(q);
            }
            Atacando=3;
        }
        Ciclo1=1;
        pintar q = new pintar(central.getPosicion(Ciclo1, "X", "Principal"),central.getPosicion(Ciclo1, "Y", "Principal"),1);
        pixeles.Agregar(q);
        add(pixeles);
        if (central.getVida()<=0){
            JOptionPane.showMessageDialog(PanelTexto, "Reiniciar la partidad");
            central.Reiniciar();
        }
    }

    public static void main(String[] args){
        JFrame ventana = new Mapa();
        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ventana.setSize(530,580);
        ventana.setVisible(true);
    }

    class EventosDeTeclado implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
                
        }

        @Override
        public void keyPressed(KeyEvent e) {
                
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyChar()=='W' || e.getKeyChar()=='w'){
                central.Accion_Principal("Arriba");
                cuadros();
                central.Accion_Enemigo_Aliado();
                cuadros();
            }
            if (e.getKeyChar()=='S' || e.getKeyChar()=='s'){
                central.Accion_Principal("Abajo");
                cuadros();
                central.Accion_Enemigo_Aliado();
                cuadros();
            }
            if (e.getKeyChar()=='A' || e.getKeyChar()=='a'){
                central.Accion_Principal("Izquierda");
                cuadros();
                central.Accion_Enemigo_Aliado();
                cuadros();
            }
            if (e.getKeyChar()=='D' || e.getKeyChar()=='d'){
                central.Accion_Principal("Derecha");
                cuadros();
                central.Accion_Enemigo_Aliado();
                cuadros();
            }
            if (e.getKeyChar()==' '){
                central.Accion_Principal("Ataque");
                cuadros();
                central.Accion_Enemigo_Aliado();
                Atacando=2;
                cuadros();
            }
        }
    }
    
}