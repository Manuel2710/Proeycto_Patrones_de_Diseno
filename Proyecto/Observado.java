public interface Observado {
    public void agregar(Observer o);
    public void eliminar(Observer o);
    public void notificarObserver();
}
