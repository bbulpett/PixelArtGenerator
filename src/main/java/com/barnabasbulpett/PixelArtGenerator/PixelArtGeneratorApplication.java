package com.barnabasbulpett.PixelArtGenerator;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.resizers.Resizers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class PixelArtGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PixelArtGeneratorApplication.class, args);
	}

}
