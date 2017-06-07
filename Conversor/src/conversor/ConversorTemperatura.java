package conversor;

public class ConversorTemperatura {
    //private double temperatura;
    
    public static double CelciusFahrenheit(double tempCelcius){
        return (9 * tempCelcius / 5) + 32;
    }
    
    public static double FahrenheitCelcius(double tempFahrenheit){
        return (tempFahrenheit-32)*5/9;
    }
    
    public static double CelciusKelvin(double tempCelcius){
        return tempCelcius + 273.15;
    }
    
    public static double KelvinCelcius(double tempKelvin){
        return tempKelvin - 273.15;
    }
    
    public static double CelciusReaumur(double tempCelcius){
        return tempCelcius * 4/5;
    }
    
    public static double ReaumurCelcius(double tempReaumur){
        return tempReaumur * 5/4;
    }
    
    public static double KelvinRankine(double tempKelvin){
        return tempKelvin * 1.8;
    }
    
    public static double RankineKelvin(double tempRankine){
        return tempRankine/1.8;
    }
    
}
