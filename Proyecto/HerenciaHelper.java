
/**
 * HerenciaHelper
 */
import herencia.Persona;
import herencia.Profesor;
import herencia.TestHerencia;
public class HerenciaHelper {
    public static void main(String[] args) {

        Persona a = new Persona();
        a.add();

        Profesor p = new Profesor();
        p.add();

        TestHerencia th = new TestHerencia();
        th.eat();
    }

}