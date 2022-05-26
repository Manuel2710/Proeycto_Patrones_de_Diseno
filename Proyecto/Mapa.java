import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ClientInfoStatus;

public class Mapa extends JFrame implements KeyListener{
    private ListaPixeles pixeles;
    
    int Ciclo1;
    int Ciclo2;
    int cantAgent;
    int cantObj;

    public Mapa(){
        pixeles = new ListaPixeles();
        cantAgent=20;
        cantObj=6;
        //Se imprime el tablero
        for (Ciclo1=0;Ciclo1<51;Ciclo1++){
            for(Ciclo2=0;Ciclo2<51;Ciclo2++){
                pintar q = new pintar(Ciclo2, Ciclo1,5);
                pixeles.Agregar(q);
            }
        }
        Ciclo1=0;
        
            //Elimina los cubos de la lista-Actualiza el tablero
        if(Ciclo1>0){
            for(Ciclo1=0;Ciclo1<(4+cantAgent+cantObj*12);Ciclo1++){
                pixeles.Eliminar();
            }
        }

        for(Ciclo1=0;Ciclo1<cantAgent;Ciclo1++){
            pintar q = new pintar(0,0,0);
            pixeles.Agregar(q);   
            }

        pintar q = new pintar(0,0,0);
        pixeles.Agregar(q);


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

        }
        if (e.getKeyChar()=='S' || e.getKeyChar()=='s'){

        }
        if (e.getKeyChar()=='A' || e.getKeyChar()=='a'){

        }
        if (e.getKeyChar()=='D' || e.getKeyChar()=='d'){

        }
        
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getExtendedKeyCode()== KeyEvent.VK_UP){

        }
        if (e.getExtendedKeyCode()== KeyEvent.VK_DOWN){

        }
        if (e.getExtendedKeyCode()== KeyEvent.VK_LEFT){

        }
        if (e.getExtendedKeyCode()== KeyEvent.VK_RIGHT){

        }
        
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
