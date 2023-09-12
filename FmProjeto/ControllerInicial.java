import java.io.IOException;

//Classe controladora do menu
public class ControllerInicial
{
    Estado e;
    
     public ControllerInicial(Estado e){
        this.e=e;
    }
    
    /*USO*/public void mostraEquipas(){  // metodo que mostra todas as equipas
        e.mostraEquipa();
    }
    
    public void mostraJogador(){ //metodo que mostra todos os jogadores
     e.mostraJogador();
    }
    
    /*USO*/public void mostraJogos(){ // metodo que mostra todos os jogos 
     e.mostraJogos();   
    }
    
    public void OverallEquipa(){ // metodo que mostra o overall de todas as equipas
     e.mostraOverallEquipa();   
    }
    
    /*USO*/public void mostraEquipaSemOverall(){  
     e.mostraEquipaSemOverall();   
    }
    
    /*USO*/public void mostraEquipa(String equipa) throws EquipaNaoExiste{  // mostra uma equipa pedida pelo utilizador    
     e.mostraEquipa(equipa);
    }
    
    public void retiraJogador(int jog,String equipa){ // metodo pra retirar um jogador
        e.retira(jog,equipa); 
    }
    
    public Jogador retiraJogador2(int jog,String equipa){ // metodo pra retirar um jogador
        return e.retira(jog,equipa); 
    }
    
    public void iniciaJogo(int num){  // metodo pra iniciar um jogo 
        Jogo j = new Jogo();
        j= e.esteJogo(num);
        System.out.println("Jogo selecionado: "+j.toString());
    }
    
    public void resultadoJogo(int num){ // metodo pra calcular i resultado de um jogo
      e.calculaJogo(num);   
    }
    
     public void adicionaJogador(Jogador j,String equipa)throws EquipaNaoExiste{ // metodo que adiciona um jogador
     e.adiciona(j,equipa);   
    }
    
    public void faznovojogo(String equipa1,String equipa2)throws EquipaNaoExiste{
     e.novojogo(equipa1,equipa2);   
    }
    
    public void mostraHistorico(String nome,int numero) throws JogadorNaoExiste{
     e.mostrahistorico(nome,numero);
    }
    
    public void guarda() throws IOException{
     e.saveEstado();   
    }
    
    public void carrega(String name) throws IOException{
     try
     {
         e.loadEstadoObj(name);
     }
     catch (java.lang.ClassNotFoundException cnfe)
     {
         System.out.println("ups");
     }   
    }
    
    /*USO*/public void mostraEquipaComOverall(String nome) throws EquipaNaoExiste{
     e.mostraEquipaComOverall(nome);   
    }
}
