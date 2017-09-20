import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class Main {

    public static void main(String[] args) {
	// write your coList<String> list = new ArrayList<String>();
        try {
            Files.walk(Paths.get("C:\\Users\\gcan\\Desktop\\aaaa\\"), FileVisitOption.FOLLOW_LINKS).forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {
                    try {

                        final String belgeContent = Tesseract.withTesseract(a -> a.operate(filePath.toFile()));
                        System.out.println(belgeContent);
                    } catch (IOException e) {
                        System.out.print(e.getCause());
                    }
                }
            });
        } catch (IOException e) {
            System.out.print(e.getCause());
        }
    }
}
