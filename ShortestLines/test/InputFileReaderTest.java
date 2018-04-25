import org.junit.After;
import org.junit.Before;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class InputFileReaderTest {

    String fileName;
    String fileNameFail;
    List<Point> points;
    InputFileReader reader;

    @Before
    public void setUp() throws Exception {

        points = Arrays.asList(new Point(1, Arrays.asList(1.0, 1.0)));
        fileName = "testInput.txt";
        fileNameFail = "testInputWrongFormat.txt";
    }

    @After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void readFileDataFromInputFileSuccess() {
        reader = new InputFileReader();
        assertEquals(points, reader.readFileData(fileName));
    }

    @org.junit.Test
    public void readFileDataFromInputEmptyFileFail() {
        reader = new InputFileReader();
        assertFalse(points == reader.readFileData(fileNameFail));
    }
}