package series.serie2.parte2;

public class ResultSet {

    private String label;

    private double value;

    public ResultSet(String label, double value) {
        this.label = label;
        this.value = value;

    }

    @Override
    public String toString() {
        return label + " " + value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

}
