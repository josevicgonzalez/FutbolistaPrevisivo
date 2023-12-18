package futbolistaprevisivo.core;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;


public class TransactionManager {
    private static double saldo = 0;
    private static ArrayList<Ingress> listaIngress = new ArrayList<Ingress>();
    private static ArrayList<Egress> listaEgress = new ArrayList<Egress>();

    
    /**
     * Esta funcion devuelve el saldo total 
     * @return 
     */
    public static double getSaldo(){
        return saldo;
    }
    
    
    /**
     * Esta funcion recibe un Ingress, suma el subtotal al saldo 
     * y lo guarda en la lista de ingress
     * @param newIngress es un nuevo ingreso
     */
    public static void addIngress(Ingress newIngress){
        double subtotal = newIngress.getSubtotal();
        saldo += subtotal;
        listaIngress.add(newIngress);
    }
    
    /**
     * Esta funcion recibe un Egress, resta el subtotal al saldo 
     * y lo guarda en la lista de ingress
     * @param newEgress es un nuevo egress
     */
    public static void addEgress(Egress newEgress){
        double subtotal = newEgress.getSubtotal();
        saldo -= subtotal;
        listaEgress.add(newEgress);
    }
    
    /**
     * Devuelve la lista entera de ingress
     * @return 
     */
    public static ArrayList<Ingress> getIngresses(){
        return listaIngress;
    }
    
    /**
     * Devuelve la lista entera de egress.
     * @return 
     */
     public static ArrayList<Egress> getEgresses(){
        return listaEgress;
    }

    public static List<Ingress> getIngressesWithContrato() {
        return listaIngress.stream()
                .filter(Ingress::isIdContrato)
                .collect(Collectors.toList());
    }
     
    public static Ingress getIngressByDescripcion(String descripcion) {
        return listaIngress.stream()
                .filter(ingress -> ingress.getDescripcion().equals(descripcion))
                .findFirst()
                .orElse(null);
    }

    public static ArrayList<Egress> getEgresss() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 
     
     
}
