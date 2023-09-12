 

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Equipa {
    private int over;
    private String nome;
    private List<Jogador> jogadores;
    
    public Equipa(){
        this.over =0;
        this.nome = " ";
        this.jogadores = new ArrayList<Jogador>();
    }
    
    public Equipa(String nomeE) {
        nome=nomeE;
        jogadores = new ArrayList<>();
    }
    
    public Equipa(String nome,List<Jogador> j){
        
    }

    public static Equipa parse(String input){
        String[] campos = input.split(",");
        return new Equipa(campos[0]);
    }

    public void insereJogador(Jogador j) {
        jogadores.add(j.clone());
    }

    public String getNome(){
        return nome;
    }
    
    public List<Jogador> getJogadores(){
     return this.jogadores;
    }
    
    public Jogador getJogador(int num){
     Jogador tmp = null;   
     Iterator<Jogador> iter = jogadores.iterator();
     while(iter.hasNext()){
         Jogador j = iter.next();
         if(j.getNumeroJogador()==num){
             System.out.println(j.toString());
             return j; 
            }
        }
     return tmp;
    }

    public String toString(){
        String r =  "Equipa:" + nome + "\n";
        for (Jogador j : jogadores){
            r += j.toString()+ "\n";
        }
        return r;
    }
    
    public void toStringOverall(){
        String r =  "Equipa:" + nome + "\n";
        for (Jogador j : jogadores){
            System.out.println(j.toString()+j.getOverall());
        }
        
    }
    
    public void toString3(){
        String r =  "Equipa:" + nome + "\n";
        for (Jogador j : jogadores){
            System.out.println(j.toString()+j.getPosicao());
        }
        
    }
    
    public void setOverallEquipa(){
        int conta=0,tal=0;
     for(Jogador j : jogadores){
         conta++;
         j.setOverall();
         tal +=j.getOverall();
        }
        this.over = tal/conta;
    }
    
    public int getOverallEquipa(){
     return this.over;   
    }
    
    public boolean equals(Object obj) {
        if(obj==this) return true;
        if(obj==null || obj.getClass() != this.getClass()) return false;
        Equipa le = (Equipa) obj;
        return le.getNome().equals(this.nome);    
    }
   
    public Jogador retiraJogador(int numero){
        Jogador tmp = null;
        Iterator<Jogador> iter = jogadores.iterator();
        while(iter.hasNext()){
         Jogador j = iter.next();
         if(j.getNumeroJogador()==numero){
             j.addEquipa(this.nome);
             iter.remove();
             System.out.println("Retirado com sucesso!!");
             return j;
            }
        }
        return tmp;
    }
    
    public void adicionaJogador(Jogador j,String nomeEquipa){
        jogadores.add(j);
        j.setEquipaAtual(nomeEquipa);
        j.addEquipa(nomeEquipa);
    }
    
}


