import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import estruturadedados.Queue.Queue;
import estruturadedados.Stack.Stack;

public class Image {
    BufferedImage img;
    String fileName = "pixelImage";
    private final int width;
    private final int height;

    public Image(int width, int height) {
        this.width = width;
        this.height = height;

        this.createRandomImage(width, height);
    }

    private void createRandomImage(int width, int height) {

        this.img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int randomValue = (int) (Math.random() * 2);
                int p = (randomValue == 0) ? 0xFFFFFFFF : 0xFF000000;

                img.setRGB(x, y, p);
            }
        }

        this.saveImage();
    }


    public void saveImage() {
        try {
            File f = new File(" C:/Users/eduar/OneDrive/Desktop/Flood_Fill/src/" + this.fileName + ".png");

            ImageIO.write(img, "png", f);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    public int getPixelValue(int x, int y) {
        return img.getRGB(x, y);
    }

    public boolean isValidAndWhite(int x, int y) {
        return (x >= 0 && x < this.width && y >= 0 && y < this.height && getPixelValue(x, y) == 0xFFFFFFFF);
    }

    public void updatePixel(int x, int y, int color) {
        img.setRGB(x, y, color);
    }

    public void StackFloodFill(Coordinates coordinates) {

        Stack<Coordinates> stack = new Stack<>();

        stack.add(coordinates);

        while (!stack.isEmpty()) {
            Coordinates coord = stack.pop();

            int currentX = coord.getX();
            int currentY = coord.getY();

            if (this.isValidAndWhite(currentX, currentY)) {

                this.updatePixel(currentX, currentY, 0xFF000000);
                this.saveImage();

                stack.add(new Coordinates(currentX + 1, currentY));
                stack.add(new Coordinates(currentX - 1, currentY));
                stack.add(new Coordinates(currentX, currentY + 1));
                stack.add(new Coordinates(currentX, currentY - 1));
            }

        }
    }

    public void QueueFloodFill(Coordinates coordinates) {
        Queue<Coordinates> queue = new Queue<>();

        queue.add(coordinates);

        while (!queue.isEmpty()) {
            Coordinates coord = queue.dequeue();

            int currentX = coord.getX();
            int currentY = coord.getY();

            if (this.isValidAndWhite(currentX, currentY)) {

                this.updatePixel(currentX, currentY, 0xFF000000);
                this.saveImage();

                queue.add(new Coordinates(currentX + 1, currentY));
                queue.add(new Coordinates(currentX - 1, currentY));
                queue.add(new Coordinates(currentX, currentY + 1));
                queue.add(new Coordinates(currentX, currentY - 1));
            }
        }
    }

}



