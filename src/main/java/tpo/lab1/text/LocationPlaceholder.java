package tpo.lab1.text;

import lombok.Getter;
import lombok.Setter;

public class LocationPlaceholder extends CanBeLocated {
    @Getter
    private final Location location;
    @Getter
    @Setter
    private String name;

    public LocationPlaceholder(Coordinates coordinates, Size size, Location location) {
        super(coordinates, size);
        this.location = location;
    }
}
