import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OutputWriter {

    private static final Logger LOGGER = Logger.getLogger(OutputWriter.class.getName());

    public void writeOutputData(final List<Point> points, final String fileName){
        final File file = new File(fileName);
        final String separator = System.getProperty("line.separator");

        if(points != null){
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
                for(Point point : points) {
                    final StringBuilder builder = new StringBuilder();
                    builder.append(point.toString())
                            .append(separator);
                    writer.write(builder.toString());
                }
            } catch (IOException e) {
                LOGGER.log(Level.WARNING, "IO exception occured: " + fileName, e);
            }
        }
    }
}
