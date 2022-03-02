package tpo.lab1.text;

import lombok.Data;

@Data
public class Location {
    private String name;
    private Coordinates coordinates;
    private Size size;
}
