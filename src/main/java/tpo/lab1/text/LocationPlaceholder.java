package tpo.lab1.text;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class LocationPlaceholder {
    @Getter
    private final Location location;
    @Getter
    @Setter
    private String name;
    @Getter
    private Coordinates coordinates;
    @Getter
    @Setter
    private Size size;

    public boolean trySetCoordinates(Coordinates coordinates) {
        if (location != null) {
            boolean isMoreToTheLeft = location.getCoordinates().getX() > coordinates.getX();
            boolean isMoreToTheRight = location.getCoordinates().getX() + location.getSize().getWidth() < coordinates.getX();
            boolean isMoreToTheUp = location.getCoordinates().getY() + location.getSize().getHeight() < coordinates.getY();
            boolean isMoreToTheBottom = location.getCoordinates().getY() > coordinates.getY();
            if (isMoreToTheLeft || isMoreToTheRight || isMoreToTheUp || isMoreToTheBottom) return false;
        }
        this.coordinates = coordinates;
        return true;
    }
}
