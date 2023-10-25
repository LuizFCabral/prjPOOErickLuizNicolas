
package fatec.poo.model;

import java.util.ArrayList;

/**
 *
 * @author nplay
 */
public class Recepcionista extends Pessoa {
    
    private int regFunc;
    private String turno;
    private ArrayList<Registro> registro;

    public Recepcionista(int regFunc, String nome){
        super(nome);
        this.regFunc = regFunc;
        registro = new ArrayList<Registro>();
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
