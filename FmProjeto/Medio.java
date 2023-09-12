import java.util.List;
import java.util.ArrayList;

public class Medio extends Jogador {
    private String pos="Medio";
    private int recuperacao;
    private int over;
    private String equipaAtual;
    private List<String> equipas;
    
    public Medio(){
     super();
     this.equipas = new ArrayList<String>();  
    }
    
    public Medio(String nomeJ, int numeroJ, int vel, int res, int des, int imp, int cab, int rem, int p, int rec) {
        super(nomeJ, numeroJ, vel, res, des, imp, cab, rem, p);
        recuperacao = rec;
        this.equipas = new ArrayList<String>();  
    }
    
     public Medio(Medio jm){
     super(jm);
     this.equipas = new ArrayList<String>();  
    }
    
    public static Medio parse(String input){
        String[] campos = input.split(",");
        return new Medio(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                Integer.parseInt(campos[9]));
    }
    
    
     public Medio clone(){
     return new Medio(this);   
    }
    
    public void addEquipa(String nomeEquipa){
        equipas.add(nomeEquipa);
    }
    
     public void setOverall(){
        this.over = (super.getVelocidade() + super.getResistencia() + super.getDestreza()
                    + super.getImpulsao() + super.getCabeca() + super.getRemate()
                    + super.getPasse()*2) / 8;
    }
    
    public int getOverall(){
     return this.over;   
    }
    
    public void setEquipaAtual(String nome){
     this.equipaAtual = nome;   
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
