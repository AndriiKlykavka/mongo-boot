package ua.pp.voronin.serhii.tommy;

import ua.pp.voronin.serhii.tommy.exception.PackagingException;
import ua.pp.voronin.serhii.tommy.model.packaging.Box;
import ua.pp.voronin.serhii.tommy.model.part.Cube;
import ua.pp.voronin.serhii.tommy.model.part.Part;
import ua.pp.voronin.serhii.tommy.model.part.Sphere;
import ua.pp.voronin.serhii.tommy.model.part.Tetrahedron;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class PartsProcessor {

    public void packageParts(Collection<Part> parts, Collection<Box> boxes, int boxPackagingPricePerMillimeter) {
        List<Box> availableBoxes = new ArrayList<>(boxes);

        availableBoxes.sort(Comparator.comparing(Box::getSide));

        for (Part part : parts) {
            try {
                Box box = selectSmallestBox(part, availableBoxes);
                int boxSize = box.getSide();
                int boxArea = 6 * boxSize * boxSize;
                int boxPrice = (int) Math.ceil(boxArea * boxPackagingPricePerMillimeter);

                reportRecommendedPackaging(part, box, boxPrice);
                availableBoxes.remove(box);
            } catch (PackagingException e) {
                reportUnableToPackage(part);
            }
        }
    }

    private Box selectSmallestBox(Part part, List<Box> boxesSorted) {

        int boxSizeRequired = calculateRequiredBoxSize(part);
        int volume = calculatePartVolume(part);

        int weight = (int) Math.ceil(volume * part.getDensity());
        double protectiveLayerThickness = part.getProtectiveLayerThickness(weight);
        double finalSizeOfBox = boxSizeRequired + protectiveLayerThickness * 2;

        for (Box box : boxesSorted) {
            if (box.getSide() >= finalSizeOfBox) {
                return box;
            }
        }
        throw new PackagingException();
    }

    private int calculateRequiredBoxSize(Part part) {
        int boxSizeRequired = 0;
        if (part instanceof Cube) {
            boxSizeRequired = ((Cube) part).getSide();
        } else if (part instanceof Sphere) {
            boxSizeRequired = ((Sphere) part).getRadius() * 2;
        } else if (part instanceof Tetrahedron) {
            double cubeSide = ((Tetrahedron) part).getSide() / Math.sqrt(2);
            boxSizeRequired = (int) Math.ceil(cubeSide);
        }
        return boxSizeRequired;
    }

    private int calculatePartVolume(Part part) {
        int volume = 0;
        if (part instanceof Cube) {
            int side = ((Cube) part).getSide();
            volume = side * side * side;
        } else if (part instanceof Sphere) {
            int radius = ((Sphere) part).getRadius();
            double sphereVolume = 4d / 3 * Math.PI * radius * radius * radius;
            volume = (int) Math.ceil(sphereVolume);
        } else if (part instanceof Tetrahedron) {
            int side = ((Tetrahedron) part).getSide();
            double tetrahedronVolume = Math.sqrt(2) / 12 * side * side * side;
            volume = (int) Math.ceil(tetrahedronVolume);
        }
        return volume;
    }


    private void reportRecommendedPackaging(Part part, Box box, int price) {
        String message = String.format(
                "Деталь %s варто покласти у ящик %s. Вартість пакування: %.2f₴",
                part, box, price / 100d);
        System.out.println(message);
    }

    private void reportUnableToPackage(Part part) {
        String message = String.format(
                "Деталь %s не вдалося розмістити у наявні ящики",
                part);
        System.out.println(message);
    }
}
