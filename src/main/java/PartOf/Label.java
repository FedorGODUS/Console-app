package PartOf;

public class Label {
    private Double sales;
    public Label(double sales){
        this.sales=sales;
    }

    public double getSales() {
        return sales;
    }

    @Override
    public String toString() {
        return "Sales = "+getSales();
    }
}
