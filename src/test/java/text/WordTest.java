package text;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tpo.lab1.text.Coordinates;
import tpo.lab1.text.Location;
import tpo.lab1.text.Size;
import tpo.lab1.text.Word;

import static org.junit.jupiter.api.Assertions.*;

public class WordTest {
    private Word word;

    @BeforeEach
    void init() {
        word = new Word();
    }

    @Test
    void checkAddNullLocationToList() {
        assertFalse(word.tryAddLocation(null));
    }

    @Test
    void checkLocationBasicAdd() {
        Location location = createLocation(1, 1, 10, 10, "Hell");
        assertTrue(word.tryAddLocation(location));
    }

    @Test
    void checkAddSameLocation() {
        Location location = createLocation(2, 2, 15, 20, "Heaven");
        assertAll(
                () -> assertTrue(word.tryAddLocation(location)),
                () -> assertFalse(word.tryAddLocation(location))
        );
    }

    private Location createLocation(int x, int y, int w, int h, String name) {
        Location location = new Location(new Coordinates(), new Size());
        location.getCoordinates().trySetX(x);
        location.getCoordinates().trySetY(y);
        location.getSize().trySetWidth(w);
        location.getSize().trySetHeight(h);
        location.setName(name);
        return location;
    }
}
