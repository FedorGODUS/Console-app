package PartOf;

public class Coordinates {
    private Long X;
    private Long Y;
    public Coordinates(Long X, Long Y){
        this.X=X;
        this.Y=Y;
    }

    public Long getX() {
        return X;
    }
    public Long getY() {
        return Y;
    }

    @Override
    public String toString() {
        return "X = "+getX()+" Y = "+getY();
    }
}
