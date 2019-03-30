package Factory.SimpleFactory;

import Factory.ReportGenerator;

/**
 * Created by oahnus on 2019/3/30
 * 19:23.
 */
public class SimpleFactoryClient {
    public static void main(String... args) {
        GeneratorFactory factory = new GeneratorFactory();
        ReportGenerator reportGenerator = factory.build("HR");
        reportGenerator.doReport();
    }
}
