import java.util.List;
import java.util.ArrayList;
 
public class Avancado extends Jogador{
    private String pos="Avançado";
    private int over;
    private String equipaAtual;
    private List<String> equipas;
    
    public Avancado(){
     super();
     this.equipas = new ArrayList<String>();  
    }
    
    public Avancado(String nomeJ, int numeroJ, int vel, int res, int des, int imp, int cab, int rem, int p) {
        super(nomeJ, numeroJ, vel, res, des, imp, cab, rem, p);
        this.equipas = new ArrayList<String>();  
    }
    
    public Avancado(Avancado ja){
     super(ja);
     this.equipas = new ArrayList<String>();  
    }
    
    public static Avancado parse(String input){
        String[] campos = input.split(",");
        return new Avancado(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]));
    }
    
    public Avancado clone(){
     return new Avancado(this);   
    }
    
    public void addEquipa(String nomeEquipa){
        equipas.add(nomeEquipa);
    }
    
     public void setEquipaAtual(String nome){
     this.equipaAtual = nome;   
    }
    
    public void setOverall(){
        this.over = (super.getVelocidade() + super.getResistencia() + super.getDestreza()
                    + super.getImpulsao() + super.getCabeca() + super.getRemate()*2
                    + super.getPasse()) / 7;
    }
    
    public int getOverall(){
     return this.over;   
    }
    
    public  List<String> getEquipas(){
     return this.equipas;   
    }
    
    public void setEquipasZero(){
     this.equipas = new ArrayList<String>();   
    }
    
    public String getPosicao(){
     return this.pos;   
    }
}
