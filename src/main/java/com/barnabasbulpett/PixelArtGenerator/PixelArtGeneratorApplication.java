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
public class PixelArtGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PixelArtGeneratorApplication.class, args);

		try {
			// Load the image
			File inputFile = new File("input.jpg"); // TODO: change this
			BufferedImage originalImage =
					Thumbnails.of(inputFile)
							.scale(1)
							.asBufferedImage();

			// Process the image
			BufferedImage pixelArtImage = processImage(originalImage);

			// Save the processed image
			File outputFile = new File("output.jpg"); // TODO: change this
			Thumbnails.of(pixelArtImage)
					.scale(1)
					.toFile(outputFile);

			System.out.println("Finished generating pixel art image.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static BufferedImage processImage(BufferedImage originalImage) {
		int targetWidth = 128; // TODO: change this to the necessary width
		int targetHeight = 128; // TODO: change this to the necessary height

		// Resize the image
		BufferedImage resizedImage =
				Thumbnails.of(originalImage)
						.size(targetWidth, targetHeight)
						.resizer(Resizers.BICUBIC)
						.asBufferedImage();

		// Reduce color pallette to 256 colors
		return quantize(resizedImage, 256);
	}

	private static BuferedImage quantize(BufferedImage image, int numColors) {
		Quantize quantize =
		  new Quantize(image, numColors, ColorizeAlgorithm.FLOYD_STEINBERG);

			return quantize.quantize();
	}
}
