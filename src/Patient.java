import java.util.Stack;
import java.util.Random;


class Patient {
    private String name;
    private String lastName;
    private String ID; //rut
    private int categoria; // del 1 al 5 C1-C5
    private long arrivalTime;
    private String state;
    private String area;
    private Stack<String> changeHistory;//categoria que ira cambaidno el paciente

    Patient(String name, String lastName, String ID, long arrivalTime) {
        this.name = name;
        this.lastName = lastName;
        this.ID = ID;
        this.arrivalTime = arrivalTime;
        this.state = "en_espera";
        this.area = "sin_asignar";
        this.changeHistory = new Stack<>();

        Random rand = new Random();

        int rango = rand.nextInt(1, 101);

        if (rango <= 10)// 10%
            this.categoria = 1;
        else if (rango <= 25)// 15%
            this.categoria = 2;
        else if (rango <= 43)// 18%
            this.categoria = 3;
        else if (rango <= 70)// 27%
            this.categoria = 4;
        else // 30%
            this.categoria = 5;

    }

    void setState(String state) {
        this.state = state;
    }

    void setArea(String area) {
        this.area = area;
    }

    void setCategoria(int categoria) {
        this.categoria = categoria;
        String x = Integer.toString(categoria);
        recordChange(x);
        System.out.println("Categoria cambiada a: " + this.categoria);
    }

    String getName() {
        return name;
    }

    String getLastName() {
        return lastName;
    }

    String getID() {
        return ID;
    }

    int getCategoria() {
        return categoria;
    }

    long getArrivalTime() {
        return arrivalTime;
    }

    String getState() {
        return state;
    }

    String getArea() {
        return area;
    }

    Stack<String> getChangeHistory() {
        return changeHistory;
    }

    long currentTimeout() {
        return (long) (System.currentTimeMillis() - arrivalTime) / 60000;

    }

    void recordChange(String cambio) {//cambia el historial del paciente
        changeHistory.push(cambio);//pila que registra cambios en categoria

    }

    public String getLastChange() {//obtiene y remueve el ultimo cambio
        if (changeHistory.size() > 0) {
            return changeHistory.pop();
        } else {
            return "No se encuentran cambios disponibles";
        }
    }
}

