//CLasse da Main que faz run do menu e faz parse dos logs
import java.util.*;
import java.util.stream.Collectors;

public class Main
{

    public static void main(String[] args) throws Exception {
        Estado e = new Estado(Parser.parse());
        ControllerInicial ci = new ControllerInicial(e);
        ViewInicial v = new ViewInicial(ci);
        v.run();
        
    }


}
