import java.io.BufferedReader;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InputFileReader {

    private static final Logger LOGGER = Logger.getLogger(InputFileReader.class.getName());

    public List<Point> readFileData(final String fileName) {
        final List<Point> listOfPoints = new ArrayList<>();
        final File file = new File(fileName);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int lineCounter = 1;
            while ((line = reader.readLine()) != null) {
                final String[] splitData = line.split("\t");
                List<Double> coordinates = new ArrayList<>();
                for (int i = 0; i < splitData.length; i++) {
                    coordinates.add(Double.valueOf(splitData[i]));
                }
                Point point = new Point(lineCounter++, coordinates);
                listOfPoints.add(point);
            }
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "Exception occured during file reading: " + fileName, e);
        }
        return listOfPoints;
    }
}
