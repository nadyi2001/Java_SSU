package task5;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;
import java.util.zip.*;

public class t2 {

    private void addToZip(Path file, Path rootDir, ZipOutputStream zos) throws IOException {
        byte[] buffer = new byte[1024];
        String relativePath = rootDir.relativize(file).toString();
        if (Files.isDirectory(file)) {
            for (File subFile : file.toFile().listFiles()) {
                addToZip(subFile.toPath(), rootDir, zos);
            }
        } else {
            try (FileInputStream fis = new FileInputStream(file.toFile())) {
                zos.putNextEntry(new ZipEntry(relativePath));
                int length;
                while ((length = fis.read(buffer)) > 0) {
                    zos.write(buffer, 0, length);
                }
                zos.closeEntry();
            }
        }
    }

    public static void main(String[] args) {
        
        in_out2 dc = new in_out2();
        String path = dc.choser();
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a target string: ");
        final String targetString = scanner.nextLine();
        scanner.close();

        try (FileOutputStream fos = new FileOutputStream(path + ".zip");
             ZipOutputStream zos = new ZipOutputStream(fos)) {

            Files.walkFileTree(Paths.get(path), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    if (file.toFile().getName().contains(targetString)) {
                        try {
                            t2 ar = new t2();
                            ar.addToZip(file, Paths.get(path), zos);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    return FileVisitResult.CONTINUE;
                }
            });

            System.out.println("Archiving is completed. Archive path: " + path + ".zip");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




