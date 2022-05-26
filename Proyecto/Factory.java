public class Factory {
    
    public static Entidades construir(String cual){
        switch (cual){
            case "Aliado":
                return new Aliado();

            case "Atacante":
                return new Atacante();
        }
        return null;
    }
}
