
//Classe que mostra as opçoes do menu ?? nao sei bem como explicar 
import java.util.Scanner;

public class ViewInicial
{
   private ControllerInicial c;
   
   public ViewInicial(ControllerInicial c){
     this.c =c;  
    }
   
   public void run() throws Exception{
        Scanner sc0 = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);
        Scanner sc4 = new Scanner(System.in);
        Scanner sc5 = new Scanner(System.in);
        Scanner sc6 = new Scanner(System.in);
        Scanner sc7 = new Scanner(System.in);
        Scanner sc8 = new Scanner(System.in);
        Scanner sc9 = new Scanner(System.in);
        Scanner sc10 = new Scanner(System.in);
        Scanner sc11 = new Scanner(System.in);
        MenuInical m = new MenuInical(new String[]{"Mostrar equipas","Mostrar jogadores","Mostrar historico de um Jogador","Mostrar jogos","Mostra Overall Jogadores","Mostra Overall Equipas",
                                                    "Mudar Jogador de equipa","Retirar Jogador de Equipa","Fazer jogo","Guarda Estado","Carrega Estado"});
        int op;
        do{
         m.executa();
         op = m.getOpcao();
         switch(op) {
             case 1:
                 c.mostraEquipaSemOverall();
                 System.out.println("Deseja ver jogadores de uma equipa?\n1-Sim\n2-Nao");
                 int escolha = sc0.nextInt();
                 if(escolha==1){
                     boolean flag=false;
                     while(flag==false){
                     try{
                     System.out.println("Escolha a equipa:");
                     c.mostraEquipaSemOverall();
                     String equipa1 = sc2.nextLine(); 
                     c.mostraEquipa(equipa1);
                     flag=true;
                    }
                   
                    
                    catch ( EquipaNaoExiste string){
                        flag=false;
                     System.out.print(string+"\n");
                    }
                    }
                     break;
                }
                  else break;  
             case 2:
                 c.mostraEquipas();
                 break;
             case 3:
                c.mostraEquipaSemOverall(); 
                String equipa12;
                boolean flag=false;
                 boolean flag1=false;
                     while(flag==false){
                     try{
                     System.out.println("Escolha a equipa:");
                     equipa12 = sc2.nextLine();
                     c.mostraEquipa(equipa12);
                     flag=true;
                         
                        System.out.println("Escolha o numero do jogador");
                        int jogador = sc.nextInt();
                        c.mostraHistorico(equipa12,jogador);
                    flag1=true;
                }
                   
                catch ( EquipaNaoExiste string){
                     flag=false;
                     System.out.print(string);
                    }
                }
                
               
                
                  break;
             case 4:
                 c.mostraJogos();
                 break;
             case 5:
                
                boolean flag3=false;
                  while(flag3==false){
                  try{
                      c.mostraEquipaSemOverall(); 
                    System.out.println("Escolha a equipa:");
                     String equipa11 = sc2.nextLine();
                     c.mostraEquipaComOverall(equipa11);
                     break;
                    }
                  catch (EquipaNaoExiste string){
                      flag3=false;
                     System.out.print(string);
                    }
                }
                 
                break; 
             case 6:
                 c.OverallEquipa();
                 break;
             case 7:
                 boolean flag4=false;
                 boolean flag5=false;
               
                 while(flag4==false){
                    try{
                 System.out.println("Escolha a equipa onde se encontra o Jogador");
                 c.mostraEquipaSemOverall();
                 String equipa1 = sc2.nextLine();
                 c.mostraEquipa(equipa1);
                 flag4=true;
                  
                 System.out.println("Numero do jogador a mudar");
                 int jog1 = sc3.nextInt();
                 Jogador j = c.retiraJogador2(jog1,equipa1);
                 
                   
                
                  while(flag5==false){  
                      try{
                 System.out.println("Escolha a equipa para onde o Jogador vai");
                 String equipa2 = sc4.nextLine();
                 c.adicionaJogador(j,equipa2);
                 flag5=true;
                }
                catch (EquipaNaoExiste string){
                    flag5=false;
                     System.out.print(string);
                }
            }  
        
                }
                catch (EquipaNaoExiste string){
                    flag4=false;
                     System.out.print(string);
                }
                }
                 break;
                 
             case 8:
                 boolean flag8=false;
                 while(flag8==false){
                     try{
                 System.out.println("Escolha a equipa");
                 c.mostraEquipaSemOverall();
                 String equipa = sc5.nextLine();
                 c.mostraEquipa(equipa);
                 System.out.println("Numero do jogador a retirar");
                 int jog = sc6.nextInt();
                 c.retiraJogador(jog,equipa);
                 flag8=true;
                }
                catch (EquipaNaoExiste string){
                    flag8=false;
                     System.out.print(string);
                }
                }
                 break;
             case 9:
                 System.out.println("1-Fazer jogo novo \n");
                 System.out.println("2-Fazer jogo do sistema");
                 int jog2 = sc7.nextInt();
                 if(jog2==2){
                 c.mostraJogos();
                 System.out.println("Escolha um jogo a realizar");
                 int jogo = sc8.nextInt();
                 c.iniciaJogo(jogo);
                 System.out.println("Simulando jogo...");
                 Thread.sleep(2000);
                 c.resultadoJogo(jogo);
                }
                if(jog2==1){
                    boolean flag9=false;
                 c.mostraEquipaSemOverall();
                 System.out.println("Escolha a primeira Equipa");
                 String equipa3 = sc9.nextLine();
                 System.out.println("Escolha a segunda Equipa");
                 String equipa4 = sc10.nextLine();
                 System.out.println("\n");
                 System.out.println(equipa3+" vs "+equipa4);
                 System.out.println("\n");
                 c.faznovojogo(equipa3,equipa4);
                 Thread.sleep(2000);
                
                 
                }
                 
                 break;
             case 10:
                 c.guarda();
             case 11:
                 System.out.println("Nome do ficheiro");
                 String nome = sc11.nextLine();
                 c.carrega(nome);
             //etc de casos
             default:
                 System.out.println("Adeus");
                 break;
            }
        }while(op!=0);
    } 
}
