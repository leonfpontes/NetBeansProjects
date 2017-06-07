package numeroserie;

public class SerieLimitada {
    private static final int MAXSERIE = 100;
    private static int serie;
    
    public SerieLimitada(){}
    
    public static int geraSerie(){

        if (serie <= MAXSERIE){
            return serie++;
        }else{
            return 0;
        }
    }
}
