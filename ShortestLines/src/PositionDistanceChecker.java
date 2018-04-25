import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PositionDistanceChecker {

    public static void main(String[] args) throws IOException {

        String inputFile = "src\\sample_input_2_8.tsv";
        InputFileReader inputFileReader = new InputFileReader();

        List<Point> points = inputFileReader.readFileData(inputFile);
        OutputWriter outputWriter = new OutputWriter();

        String outputFileName = "output.txt";
        outputWriter.writeOutputData(closestPointPair(points), outputFileName);
    }

    /**
     * Method to find the two closest point from the list.
     * @param input List of Points.
     * @return List of Points containing always exactly the points with the shortest distance between them.
     */
    public static List<Point> closestPointPair(List<Point> input){
        List<Point> closestPoints = new ArrayList<>();
        double smallestDistance = input.get(0).distanceCalculator(input.get(1));

        for (int i = 0; i < input.size(); i++) {
            for (int j = i + 1; j < input.size(); j++) {
                double distance = input.get(i).distanceCalculator(input.get(j));
                if (distance < smallestDistance){
                    smallestDistance = distance;
                    closestPoints.clear();
                    closestPoints.add(input.get(i));
                    closestPoints.add(input.get(j));
                }
            }
        }
        return  closestPoints;
    }
}
