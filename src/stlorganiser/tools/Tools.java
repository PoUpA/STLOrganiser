/*
 * Tools 
 * 
 */
package stlorganiser.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;

/**
 * Mainly checksum calculator
 * 
 * @author Jean-Christophe Chatelain
 */
public class Tools {
    public static long getChecksum(String filename){
        try {
            CheckedInputStream cis = null;
            long fileSize = 0;
            try {
                // Computer CRC32 checksum
                cis = new CheckedInputStream(
                        new FileInputStream(filename), new CRC32());

                fileSize = new File(filename).length();

            } catch (FileNotFoundException e) {
                System.err.println("File not found.");
                System.exit(1);
            }

            byte[] buf = new byte[128];
            while(cis.read(buf) >= 0) {
            }

            long checksum = cis.getChecksum().getValue();
            System.out.println(checksum + " " + fileSize + " " + filename);
            return checksum;
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return (long)0x0;
    }
}
