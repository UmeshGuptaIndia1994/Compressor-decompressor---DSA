package Compressor_Decompressor;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/**
 *
 * @author Umesh Gupta
 */

public class Decompressor {
    // Method to decompress a GZIP file
    public static void method(File file) throws IOException {
        // Get the parent directory of the input file
        String fileDirectory = file.getParent();

        // Initialize FileInputStream to read the input GZIP file
        FileInputStream fis = new FileInputStream(file);

        // Initialize GZIPInputStream to decompress the input stream
        GZIPInputStream gzip = new GZIPInputStream(fis);

        // Initialize FileOutputStream to write the decompressed output to a new file
        FileOutputStream fos = new FileOutputStream(fileDirectory + "/decompressedFile");

        // Initialize a buffer for reading/writing data
        byte[] buffer = new byte[1024];

        int len;

        // Read from the GZIPInputStream and write to the FileOutputStream
        while ((len = gzip.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }

        // Close the streams in the reverse order: first GZIPInputStream, then FileOutputStream, and finally FileInputStream
        gzip.close();
        fos.close();
        fis.close();
    }
}
