// Classe do Estado que é a base de dados do trabalho onde tudo é armazenado
import java.util.*;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.Serializable;

public class Estado implements Serializable
{
    private Map<String, Equipa> equipas = new HashMap<>();
    private Map<Integer, Jogador> jogadores = new HashMap<>();
    private List<Jogo> jogos = new ArrayList<>();
    
    public Estado(){
        Map<String, Equipa> equipas = new HashMap<>();
        Map<Integer, Jogador> jogadores = new HashMap<>();
        List<Jogo> jogos = new ArrayList<>();
    }
    
    public Estado(Estado e){
     this.equipas = e.getEquipa();
     this.jogadores = e.getJogador();
     this.jogos = e.getJogos();
    }
    
    public Map<String, Equipa> getEquipa(){
        return this.equipas;
    }
    
    public Map<Integer, Jogador> getJogador(){
        return this.jogadores;    
    }
    
    public List<Jogo> getJogos(){
     return this.jogos;
    }
    
    public void setEquipa(Map<String, Equipa> equipas){
        this.equipas = equipas;
    }
    
    public void setJogadores(Map<Integer, Jogador> jogadores){
     this.jogadores = jogadores;    
    }
    
    public void setJogos(List<Jogo> jogos){
     this.jogos = jogos;   
    }
    
    public void mostraEquipa(){  //metodo pra mostrar no terminal todas as equipas
        
     for (Equipa e: equipas.values()){
            System.out.println(e.toString());
        }   
    }
    
    public void mostraJogador(){  //metodo pra mostrar no terminal todos os jogadores
     for(Jogador jog : jogadores.values()){
        System.out.println(jog.toString());
        }    
    }
    
    public void mostraJogos(){  // mostrar os jogos todos
     for (Jogo jog: jogos){
            System.out.println(jog.toString());
        }   
    }
    
    public void mostraOverall(){  // mostrar overall de todos os jogadores 
     for(Jogador j : jogadores.values()){
         j.setOverall();
         System.out.println(j.getNomeJogador()+": "+j.getOverall());
        }
    }
    
    public void mostraOverallEquipa(){  // mostra o overall de todas as equipas
     for(Equipa e : equipas.values()){
         e.setOverallEquipa();
         System.out.println("Equipa:"+e.getNome()+" Overall:"+e.getOverallEquipa());
        }
    }
    
    public void mostraEquipaSemOverall(){
        for(Equipa e : equipas.values()){
         System.out.println("Equipa:"+e.getNome());
        }
    }
    
    public void mostraEquipa(String equipa) throws EquipaNaoExiste{   //mostra uma equipa pedida pelo utlizador  
     Equipa e = equipas.get(equipa);
     if (e == null) throw new EquipaNaoExiste("Nao existe");
     System.out.println(e.toString());
    }
    
    public void mostraEquipaComOverall(String nome)throws EquipaNaoExiste{
     Equipa e = equipas.get(nome);
     if (e == null) throw new EquipaNaoExiste("Nao existe\n");
     e.toStringOverall();
    }
    
    public Jogador retira(int jog,String nomeEquipa){  // metodo pra chamar o metodo que retira um jogador
        Jogador tmp = null;
        for(Equipa e : equipas.values()){
           
            if(nomeEquipa.compareTo(e.getNome())==0){
              return e.retiraJogador(jog);
            }
        }
        return tmp;
    }
    
    public Jogo esteJogo(int num){  // metodo pra encontrar o jogo selecionado pelo utilizador
     Jogo j = new Jogo();
     int i=1;
     for(Jogo jogo : jogos){
         if(i==num){
             j=jogo;
             break;
            }  
         i++;   
        }
        return j;
    }
    
    public void calculaJogo(int num){  //metodo que calcula o resultado de um jogo 
     Jogo j = new Jogo();
     j=esteJogo(num);
     String equipaCasa = j.getNomeCasa();
     String equipaFora = j.getNomeFora();
     List<Integer> casa = j.getEquipaCasa();
     List<Integer> fora = j.getEquipaFora();
     int overCasa=0,overFora=0;
     for(Equipa e: equipas.values()){
         if(equipaCasa.compareTo(e.getNome())==0){
             System.out.println("Equipa titular "+equipaCasa);
             for(int i:casa){
                 Jogador tmp =jogadores.get(i);
                 System.out.println(tmp.getNomeJogador());
                 tmp.setOverall();
                 overCasa += tmp.getOverall(); 
                }
             System.out.println("\n");
            }
         if(equipaFora.compareTo(e.getNome())==0){
             System.out.println("Equipa titular "+equipaFora);
             for(int i:fora){
                 Jogador tmp =jogadores.get(i);
                 System.out.println(tmp.getNomeJogador());
                 tmp.setOverall();
                 overFora += tmp.getOverall();
                }
            }   
        }
       Random nmr = new Random();
       int casanmr,foranmr,golosfora,goloscasa;
     if(overCasa>overFora){
         casanmr = 25+nmr.nextInt(overCasa);
         foranmr = nmr.nextInt(overFora);
         if(casanmr>foranmr){
            goloscasa = 1+nmr.nextInt(5);
            golosfora = nmr.nextInt(goloscasa);
            j.setGolosCasa(goloscasa);
            j.setGolosFora(golosfora);
           System.out.println("Equipa "+equipaCasa+" ganhou: "+goloscasa+"-"+golosfora+"!!");
            }
            else{
            golosfora = 1+nmr.nextInt(5);
            goloscasa = nmr.nextInt(golosfora);
            j.setGolosCasa(goloscasa);
            j.setGolosFora(golosfora);   
            System.out.println("Equipa "+equipaFora+" ganhou: "+goloscasa+"-"+golosfora+"!!");  
            }
        }
     else{
         casanmr = 1+nmr.nextInt(overCasa);
         foranmr = 25+nmr.nextInt(overFora);
         if(casanmr>foranmr){
            goloscasa = 1+nmr.nextInt(5);
            golosfora = nmr.nextInt(goloscasa-1);
           System.out.println("Equipa "+equipaCasa+" ganhou: "+goloscasa+"-"+golosfora+"!!");
            }
            else{
            golosfora = nmr.nextInt(5);
            goloscasa = nmr.nextInt(golosfora-1);
            System.out.println("Equipa "+equipaFora+" ganhou: "+goloscasa+"-"+golosfora+"!!");  
            }
        } 
    }
    
    public void adiciona(Jogador j,String equipa) throws EquipaNaoExiste{  // metodo que adiciona um jogador a um equipa pedida pelo utilizador 
        for(Jogador tmp : jogadores.values()){
            if(tmp.getNumeroJogador()==j.getNumeroJogador()){
                 tmp.setEquipaAtual(equipa);
                 tmp.addEquipa(equipa);
            }
        }
       boolean flag=false;
        for(Equipa e : equipas.values()){
            if(equipa.compareTo(e.getNome())==0){
                flag=true;
              e.adicionaJogador(j,equipa);
            }
        }
        if(flag==false) throw new EquipaNaoExiste("Nao existe");
    }
    
    public Equipa getEstaEquipa(String nomeEquipa){
        Equipa e = new Equipa();
     for(String nome : equipas.keySet()){
         if(nome.compareTo(nomeEquipa)==0){
             e = equipas.get(nome);
            }
        }
        return e;
    }
    
    public void esteJogo2(String equipa1,String equipa2){
        Equipa casa = getEstaEquipa(equipa1);
        Equipa fora = getEstaEquipa(equipa2);
        /*List<Integer> casaJ = casa.getJogadores();
        List<Integer> foraJ = fora.getJogadores();
        Jogo j = new Jogo(equipa1,equipa2,casa,fora);*/
        
    }
    
    public void mostraEquipaPos(String nome) throws EquipaNaoExiste{
        Equipa e = equipas.get(nome);
     if (e == null) throw new EquipaNaoExiste("Nao existe");
     e.toString3();
    }
    
    public int getOverall(String equipa,int nmr){
        int n=0;
        for(Equipa e : equipas.values()){
         if(equipa.compareTo(e.getNome())==0){
             for(Jogador j : e.getJogadores()){
                 if(j.getNumeroJogador()==nmr){
                     j.setOverall();
                     return j.getOverall();
                    }
                }
            }
        }
        return n;
    }
    
    public void novojogo(String equipa1,String equipa2) throws EquipaNaoExiste{
     List<Integer> casa = new ArrayList<>();
     List<Integer> fora = new ArrayList<>();
     List<Integer> overCasa = new ArrayList<>();
     List<Integer> overFora = new ArrayList<>();
     int casaOver=0,foraOver=0;
     System.out.println("Escolha o 11 da "+equipa1);
     mostraEquipaPos(equipa1);
     Scanner sc = new Scanner(System.in);
     Scanner sc1 = new Scanner(System.in);
     int i=0;
     System.out.println(equipa1);
     while(i<11){
        int numeroJogador = sc.nextInt();
        casa.add(numeroJogador);
        overCasa.add(getOverall(equipa1,numeroJogador));
        i++;
        }
     System.out.println("Escolha o 11 da "+equipa2);
     mostraEquipaPos(equipa2);
     System.out.println(equipa2);
     i=0;
     while(i<11){
        int numeroJogador = sc1.nextInt();
        fora.add(numeroJogador);
        overFora.add(getOverall(equipa2,numeroJogador));
        i++;
        } 
     for(int d:overCasa){
         casaOver+=d;
        }
     for(int t:overFora){
         foraOver+=t;
        }  
     Jogo j = new Jogo(equipa1,equipa2,casa,fora);
     Random nmr = new Random();
       int casanmr,foranmr,golosfora,goloscasa;
     if(casaOver>foraOver){
         casanmr = 25+nmr.nextInt(casaOver);
         foranmr = nmr.nextInt(foraOver);
         if(casanmr>foranmr){
            goloscasa = 1+nmr.nextInt(5);
            golosfora = nmr.nextInt(goloscasa-1);
            j.setGolosCasa(goloscasa);
            j.setGolosFora(golosfora);
           System.out.println("Equipa "+equipa1+" ganhou: "+goloscasa+"-"+golosfora+"!!");
            }
            else{
            golosfora = 1+nmr.nextInt(5);
            goloscasa = nmr.nextInt(golosfora-1);
            j.setGolosCasa(goloscasa);
            j.setGolosFora(golosfora);   
            System.out.println("Equipa "+equipa2+" ganhou: "+goloscasa+"-"+golosfora+"!!");  
            }
        }
     else{
         casanmr = 1+nmr.nextInt(casaOver);
         foranmr = 25+nmr.nextInt(foraOver);
         if(casanmr>foranmr){
            goloscasa = 1+nmr.nextInt(5);
            golosfora = nmr.nextInt(goloscasa-1);
           System.out.println("Equipa "+equipa1+" ganhou: "+goloscasa+"-"+golosfora+"!!");
            }
            else{
            golosfora = nmr.nextInt(5);
            goloscasa = nmr.nextInt(golosfora-1);
            System.out.println("Equipa "+equipa2+" ganhou: "+goloscasa+"-"+golosfora+"!!");  
            }
        } 
     
    }
    
    public void mostrahistorico(String nome,int numero) throws JogadorNaoExiste{
        List<String> tmp = new ArrayList<>();
        
      for(Equipa esta: equipas.values()){
          if(esta.getNome().compareTo(nome)==0){
     for(Jogador j : esta.getJogadores()){
         
         if(j.getNumeroJogador()==numero){
             
             tmp = j.getEquipas();
            }
        }
        }
    }
    //if(tmp.size()==0) throw new JogadorNaoExiste("Nao existe");  
    
        for(String s : tmp){
         System.out.println(s);   
        }
    }
    
    
    public void saveEstado() throws IOException  {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Estado.txt"));
        oos.writeObject(this);
        oos.flush();
        oos.close();
    }
    
    public Estado loadAux(String file) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Estado e = (Estado) ois.readObject();
        ois.close();
        return e;
    }

    //carregar de ficheiro objeto
    public void loadEstadoObj(String file) throws IOException, ClassNotFoundException {
        Estado e = loadAux(file);
        this.equipas = e.equipas;
        this.jogadores = e.jogadores;
        this.jogos = e.jogos;
    }
}
