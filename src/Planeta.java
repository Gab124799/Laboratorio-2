public class Planeta {
    private int codigo;
    private String Name;
    private double Distancia;
    private double Temperatura;
    private double NivelHabitable;

    public Planeta(int codigo, String Name, double Distancia, double Temperatura, double NivelHabitable) {
        if (Distancia <= 0) {
            throw new IllegalArgumentException("La distancia debe ser mayor que 0.");
        }
        if (NivelHabitable < 0 || NivelHabitable > 100) {
            throw new IllegalArgumentException("El nivel de habitabilidad debe estar entre 0 y 100.");
        }
        this.codigo = codigo;
        this.Name = Name;
        this.Distancia = Distancia;
        this.Temperatura = Temperatura;
        this.NivelHabitable = NivelHabitable;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getDistancia() {
        return Distancia;
    }

    public void setDistancia(double Distancia) {
        if (Distancia <= 0) {
            throw new IllegalArgumentException("La distancia debe ser mayor que 0.");
        }
        this.Distancia = Distancia;
    }

    public double getTemperatura() {
        return Temperatura;
    }

    public void setTemperatura(double Temperatura) {
        this.Temperatura = Temperatura;
    }

    public double getNivelHabitable() {
        return NivelHabitable;
    }

    public void setNivelHabitable(double NivelHabitable) {
        if (NivelHabitable < 0 || NivelHabitable > 100) {
            throw new IllegalArgumentException("El nivel de habitabilidad debe estar entre 0 y 100.");
        }
        this.NivelHabitable = NivelHabitable;
    }

    @Override
    public String toString() {
        return "Planeta: " + Name + " Codigo: " + codigo + " Distancia: " + Distancia + " Temperatura: " + Temperatura
                + " NivelHabitable: " + NivelHabitable;
    }
}