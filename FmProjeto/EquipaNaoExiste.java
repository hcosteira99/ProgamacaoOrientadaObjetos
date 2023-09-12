//Classe de erro se o utilizador meter um equipa que nao existe 
public class EquipaNaoExiste extends Exception
{
    public EquipaNaoExiste(){
        super();
    }
    
    public EquipaNaoExiste(String s){
        super(s);
    }
}
