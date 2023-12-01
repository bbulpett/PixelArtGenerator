package com.barnabasbulpett.PixelArtGenerator;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.resizers.Resizers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

@SpringBootApplication
public class PixelArtGenerator {

    public static void main(String[] args) {
        SpringApplication.run(PixelArtGenerator.class, args);

        try {
            // Read input image
            File inputFile = new File("input.jpg"); // Replace with input image path
            BufferedImage originalImage =
						    Thumbnails.of(inputFile).scale(1).asBufferedImage();

            // Process image
            BufferedImage pixelArtImage = processImage(originalImage);

            // Save pixel art image
            File outputFile = new File("output.png"); // Replace with desired output path
            Thumbnails.of(pixelArtImage).scale(1).toFile(outputFile);

            System.out.println("Pixel art generation complete.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BufferedImage processImage(BufferedImage originalImage) {
        int targetWidth = 128; // Set width for the pixel art image
        int targetHeight = 128; // Set height for the pixel art image

        // Resize image using Thumbnails library
        return Thumbnails.of(originalImage)
                .size(targetWidth, targetHeight)
                .resizer(Resizers.BICUBIC)
                .asBufferedImage();
    }
}
