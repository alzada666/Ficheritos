package salesianos.net.actividad4;

import java.io.Serializable;

public class Mesa implements Serializable {
    private String color;
    private int patas;

    public Mesa(String color, int patas) {
        this.color = color;
        this.patas = patas;
    }

    @Override
    public String toString() {
        return "Mesa [Color = " + color + ", Patas = " + patas + "]";
    }
}
