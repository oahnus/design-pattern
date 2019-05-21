package Factory.FactoryMethod;

import Factory.ReportGenerator;
import Factory.SimpleFactory.FinanceReportGenerator;

/**
 * Created by oahnus on 2019/3/30
 * 19:28.
 */
public class FinanceReportFactory implements ReportGeneratorFactory {
    @Override
    public ReportGenerator buildGenerator() {
        return new FinanceReportGenerator();
    }
}
