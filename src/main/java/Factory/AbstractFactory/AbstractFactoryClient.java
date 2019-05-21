package Factory.AbstractFactory;

/**
 * Created by oahnus on 2019/3/30
 * 19:49.
 */
public class AbstractFactoryClient {
    public static void main(String... args) {
        AbstractReportGeneratorFactory factory = new EmployeeReportGeneratorFactory();
        FinanceReportGenerator generator = factory.buildFinanceGenrator();
        generator.doFinanceReport();
    }
}
