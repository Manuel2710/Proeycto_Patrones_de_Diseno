public abstract class Entidades implements Observer{
    public boolean Ayudando_Atacando;
    public int PosicionX;
    public int PosicionY;
    public int PosicionXPrincipal;
    public int PosicionYPrincipal;

        
        public abstract void VolverAparecer();
        public abstract boolean getAyudando_Atacando();
        public abstract int getPosicion(String cual);
        public abstract boolean getvisible();
}
