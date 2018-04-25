import java.util.List;
import java.util.Objects;

public class Point extends Object {

    private int lineNumber;
    private List<Double> listOfCoordinates;

    public Point(int lineNumber, List<Double> listOfCoordinates) {
        this.lineNumber = lineNumber;
        this.listOfCoordinates = listOfCoordinates;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public List<Double> getListOfCoordinates() {
        return listOfCoordinates;
    }

    /**
     * Method to calculate the distance between two points.
     * @param pointFrom A point to calculate from.
     * @return A double distance.
     */
    public double distanceCalculator(Point pointFrom){
        double sum = 0;
        for (int i = 0; i < listOfCoordinates.size(); i++) {
            double diff = pointFrom.listOfCoordinates.get(i) - this.listOfCoordinates.get(i);
            sum += Math.pow(diff, 2);
        }
        return Math.sqrt(sum);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(lineNumber)
                .append(":");
        for (int i = 0; i < listOfCoordinates.size(); i++) {
            builder.append(listOfCoordinates.get(i))
                    .append("\t");
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return getLineNumber() == point.getLineNumber() &&
                Objects.equals(getListOfCoordinates(), point.getListOfCoordinates());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLineNumber(), getListOfCoordinates());
    }
}
