package task_03;

public class Field {
    private int dimensions = 2;

    public Field(int dimensions, int size) {
        this.dimensions = dimensions;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private int size = 10;
    public Field() {
    }

    public int getDimensions() {
        return dimensions;
    }

    public void setDimensions(int dimensions) {
        this.dimensions = dimensions;
    }
}
