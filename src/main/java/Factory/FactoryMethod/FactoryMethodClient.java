package Factory.FactoryMethod;

import Factory.ReportGenerator;

/**
 * Created by oahnus on 2019/3/30
 * 19:30.
 */
public class FactoryMethodClient {
    public static void main(String... args) {
        ReportGeneratorFactory factory = new FinanceReportFactory();
        ReportGenerator reportGenerator = factory.buildGenerator();
        reportGenerator.doReport();
    }
}
