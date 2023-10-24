
package fatec.poo.model;

/**
 *
 * @author nplay
 */
public class Recepcionista extends Pessoa {
    
    private int regFunc;
    private String turno;

    public Recepcionista(int regFunc, String nome) {
        super(nome);
        this.regFunc = regFunc;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getRegFunc() {
        return regFunc;
    }

    public String getTurno() {
        return turno;
    }

 
    
    
    
}
