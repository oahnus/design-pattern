package Factory.AbstractFactory;


/**
 * Created by oahnus on 2019/3/30
 * 19:39.
 */
public class EmployeeReportGeneratorFactory extends AbstractReportGeneratorFactory {

    @Override
    FinanceReportGenerator buildFinanceGenrator() {
        return new EmployeeFinanceReportGenerator();
    }

    @Override
    AbstractHRReportGenerator buildHRGenerator() {
        return null;
    }
}
