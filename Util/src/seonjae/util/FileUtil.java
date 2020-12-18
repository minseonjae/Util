package seonjae.util;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

@UtilityClass
public class FileUtil {

    public static void copy(File file, File target) {
        copy(file, target.getPath());
    }

    @SneakyThrows(IOException.class)
    public void copy(File file, String path) {
        String newPath = path + "\\" + file.getName();

        File folder = new File(path);

        folder.mkdirs();

        if(file.isDirectory()) {
            for(File f : file.listFiles()) {
                copy(f, newPath);
            }
            return;
        }

        @Cleanup FileInputStream fis = new FileInputStream(file);
        @Cleanup FileOutputStream fos = new FileOutputStream(newPath);

        @Cleanup FileChannel fci = fis.getChannel();
        @Cleanup FileChannel fco = fos.getChannel();

        fci.transferTo(0, fci.size(), fco);
    }
    public static void delete(File file) {
        if (file.isDirectory()) for (File f : file.listFiles()) delete(f);

        file.delete();
    }
}
