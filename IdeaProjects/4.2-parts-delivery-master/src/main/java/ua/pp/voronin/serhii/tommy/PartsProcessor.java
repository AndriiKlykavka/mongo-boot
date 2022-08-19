package ua.pp.voronin.serhii.tommy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import ua.pp.voronin.serhii.tommy.exception.PackagingException;
import ua.pp.voronin.serhii.tommy.model.packaging.Box;
import ua.pp.voronin.serhii.tommy.model.part.Cube;
import ua.pp.voronin.serhii.tommy.model.part.Part;
import ua.pp.voronin.serhii.tommy.model.part.Sphere;
import ua.pp.voronin.serhii.tommy.model.part.Tetrahedron;

public class PartsProcessor {
    public PartsProcessor() {
    }

    public void packageParts(Collection<Part> parts, Collection<Box> boxes, int boxPackagingPricePerMillimeter) {
        List<Box> availableBoxes = new ArrayList(boxes);
        availableBoxes.sort(Comparator.comparing(Box::getSide));
        Iterator var5 = parts.iterator();

        while(var5.hasNext()) {
            Part part = (Part)var5.next();

            try {
                Box box = this.selectSmallestBox(part, availableBoxes);
                int boxSize = box.getSide();
                int boxArea = 6 * boxSize * boxSize;
                int boxPrice = (int)Math.ceil((double)(boxArea * boxPackagingPricePerMillimeter));
                this.reportRecommendedPackaging(part, box, boxPrice);
                availableBoxes.remove(box);
            } catch (PackagingException var11) {
                this.reportUnableToPackage(part);
            }
        }

    }

    private Box selectSmallestBox(Part part, List<Box> boxesSorted) {
        int boxSizeRequired = this.calculateRequiredBoxSize(part);
        int volume = this.calculatePartVolume(part);
        int weight = (int)Math.ceil((double)volume * part.getDensity());
        double protectiveLayerThickness = part.getProtectiveLayerThickness((double)weight);
        double finalSizeOfBox = (double)boxSizeRequired + protectiveLayerThickness * 2.0D;
        Iterator var10 = boxesSorted.iterator();

        Box box;
        do {
            if (!var10.hasNext()) {
                throw new PackagingException();
            }

            box = (Box)var10.next();
        } while(!((double)box.getSide() >= finalSizeOfBox));

        return box;
    }

    private int calculateRequiredBoxSize(Part part) {
        int boxSizeRequired = 0;
        if (part instanceof Cube) {
            boxSizeRequired = ((Cube)part).getSide();
        } else if (part instanceof Sphere) {
            boxSizeRequired = ((Sphere)part).getRadius() * 2;
        } else if (part instanceof Tetrahedron) {
            double cubeSide = (double)((Tetrahedron)part).getSide() / Math.sqrt(2.0D);
            boxSizeRequired = (int)Math.ceil(cubeSide);
        }

        return boxSizeRequired;
    }

    private int calculatePartVolume(Part part) {
        int volume = 0;
        int side;
        if (part instanceof Cube) {
            side = ((Cube)part).getSide();
            volume = side * side * side;
        } else {
            double tetrahedronVolume;
            if (part instanceof Sphere) {
                side = ((Sphere)part).getRadius();
                tetrahedronVolume = 4.1887902047863905D * (double)side * (double)side * (double)side;
                volume = (int)Math.ceil(tetrahedronVolume);
            } else if (part instanceof Tetrahedron) {
                side = ((Tetrahedron)part).getSide();
                tetrahedronVolume = Math.sqrt(2.0D) / 12.0D * (double)side * (double)side * (double)side;
                volume = (int)Math.ceil(tetrahedronVolume);
            }
        }

        return volume;
    }

    private void reportRecommendedPackaging(Part part, Box box, int price) {
        String message = String.format("Деталь %s варто покласти у ящик %s. Вартість пакування: %.2f₴", part, box, (double)price / 100.0D);
        System.out.println(message);
    }

    private void reportUnableToPackage(Part part) {
        String message = String.format("Деталь %s не вдалося розмістити у наявні ящики", part);
        System.out.println(message);
    }
}
