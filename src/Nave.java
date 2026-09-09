import java.util.ArrayList;

public class Nave {
    private String Name;
    private int ID;
    private String comandante;
    private Modulo[] modulo;
    private ArrayList<Planeta> planetas;
    private double ConsumoEnergia;
    private boolean Estado;

    public Nave(String Name, int ID, String comandante) {
        this.Name = Name;
        this.ID = ID;
        this.comandante = comandante;
        this.modulo = new Modulo[5];
        this.planetas = new ArrayList<Planeta>();
        this.ConsumoEnergia = 0;
        this.Estado = true;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getComandante() {
        return comandante;
    }

    public void setComandante(String comandante) {
        this.comandante = comandante;
    }

    public Modulo[] getModulo() {
        return modulo;
    }

    public void setModulo(Modulo[] modulo) {
        this.modulo = modulo;
    }

    public ArrayList<Planeta> getPlanetas() {
        return planetas;
    }

    public void setPlanetas(ArrayList<Planeta> planetas) {
        this.planetas = planetas;
    }

    public double getConsumoEnergia() {
        return ConsumoEnergia;
    }

    public void setConsumoEnergia(double ConsumoEnergia) {
        this.ConsumoEnergia = ConsumoEnergia;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }
}