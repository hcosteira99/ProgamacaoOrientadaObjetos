
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jogo {
    private String equipaCasa;
    private String equipaFora;
    private int golosCasa;
    private int golosFora;
    private LocalDate date;
    private List<Integer> jogadoresCasa;
    private List<Integer> jogadoresFora;
    Map<Integer, Integer> substituicoesCasa = new HashMap<>();
    Map<Integer, Integer> substitucoesFora = new HashMap<>();
    
    public Jogo(){
        equipaCasa = "";
        equipaFora = "";
        golosCasa = 0;
        golosFora = 0;
        date = LocalDate.now();
        jogadoresCasa = new ArrayList<>();
        jogadoresFora = new ArrayList<>();
        substituicoesCasa = new HashMap<>();
        substitucoesFora = new HashMap<>();
    }
    
    public Jogo(String ec, String ef, List<Integer> jc,List<Integer> jf){
        equipaCasa = ec;
        equipaFora = ef;
        jogadoresCasa = new ArrayList<>(jc);
        jogadoresFora = new ArrayList<>(jf);
    }

    public Jogo (String ec, String ef, int gc, int gf, LocalDate d,  List<Integer> jc, Map<Integer, Integer> sc,  List<Integer> jf, Map<Integer, Integer> sf){
        equipaCasa = ec;
        equipaFora = ef;
        golosCasa = gc;
        golosFora = gf;
        date = d;
        jogadoresCasa = new ArrayList<>(jc);
        jogadoresFora = new ArrayList<>(jf);
        substituicoesCasa = new HashMap<>(sc);
        substitucoesFora = new HashMap<>(sf);
    }

    public static Jogo parse(String input){
        String[] campos = input.split(",");
        String[] data = campos[4].split("-");
        List<Integer> jc = new ArrayList<>();
        List<Integer> jf = new ArrayList<>();
        Map<Integer, Integer> subsC = new HashMap<>();
        Map<Integer, Integer> subsF = new HashMap<>();
        for (int i = 5; i < 16; i++){
            jc.add(Integer.parseInt(campos[i]));
        }
        for (int i = 16; i < 19; i++){
            String[] sub = campos[i].split("->");
            subsC.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }
        for (int i = 19; i < 30; i++){
            jf.add(Integer.parseInt(campos[i]));
        }
        for (int i = 30; i < 33; i++){
            String[] sub = campos[i].split("->");
            subsF.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }
        return new Jogo(campos[0], campos[1], Integer.parseInt(campos[2]), Integer.parseInt(campos[3]),
                        LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])),
                        jc, subsC, jf, subsF);
    }

    public String toString() {
        return  "Jogo:" + equipaCasa + " - " + equipaFora;
                //+ " -> " + substituicoesCasa.toString()
                //+ " -> " + substitucoesFora.toString();
    }
    
    public String onzeCasaToString(){  // metodo pra fazer onze incial da equipa casa
        StringBuilder sb = new StringBuilder();
        sb.append(equipaCasa).append(": ");
        for(int i : jogadoresCasa){
         sb.append(i).append(" ");
        }
        return sb.toString();
    }
    
    public String onzeForaToString(){  //metodo pra fazer onze incial da equipa fora
        StringBuilder sb = new StringBuilder();
        sb.append(equipaFora).append(": ");
        for(int i : jogadoresFora){
         sb.append(i).append(" ");
        }
        return sb.toString();
    }
    
    public List<Integer> getEquipaCasa(){
     return this.jogadoresCasa;   
    }
    
    public List<Integer> getEquipaFora(){
     return this.jogadoresFora;   
    }
    
    public String getNomeFora(){
     return this.equipaFora;   
    }
    
    public String getNomeCasa(){
     return this.equipaCasa;   
    }
    
    public void setGolosCasa(int n){
     this.golosCasa=n;   
    }
    
    public void setGolosFora(int n){
     this.golosFora=n;   
    }
}
