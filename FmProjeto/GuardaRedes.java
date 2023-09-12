import java.util.List;
import java.util.ArrayList;

public class GuardaRedes extends Jogador{
    private String pos = "GR";
    private int elasticidade;
    private int over;
    private String equipaAtual;
    private List<String> equipas;
    
    public GuardaRedes(){
     super();
     this.elasticidade = 0;
     this.equipas = new ArrayList<String>();  
    }
    
    public GuardaRedes (String nomeJ, int numeroJ, int vel, int res, int des, int imp, int cab, int rem, int p, int elast) {
        super(nomeJ, numeroJ, vel, res, des, imp, cab, rem, p);
        elasticidade = elast;
        this.equipas = new ArrayList<String>();  
    }
    
    public GuardaRedes(GuardaRedes njg){
     super(njg);
     this.elasticidade = njg.getElasticidade();
     this.equipas = new ArrayList<String>();  
    }
    
    public static GuardaRedes parse(String input){
        String[] campos = input.split(",");
        return new GuardaRedes(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                Integer.parseInt(campos[9]));
    }
    
    public int getElasticidade(){
     return this.elasticidade;   
    }
    
    public void setElasticidade(int elastico){
     this.elasticidade = elastico;
    }
    
    public GuardaRedes clone(){
     return new GuardaRedes(this);   
    }
    
    public void addEquipa(String nomeEquipa){
        equipas.add(nomeEquipa);
    }
    
     public void setOverall(){
        this.over = (super.getVelocidade() + super.getResistencia() + super.getDestreza()
                    + super.getImpulsao() + super.getCabeca() + super.getRemate()
                    + super.getPasse()+ getElasticidade()*2) / 8;
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
