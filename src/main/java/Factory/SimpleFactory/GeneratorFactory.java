package Factory.SimpleFactory;

import Factory.ReportGenerator;

/**
 * Created by oahnus on 2019/3/30
 * 19:21.
 */
public class GeneratorFactory {
    public ReportGenerator build(String name) {
        switch (name) {
            case "HR":
                return new HRReportGenerator();
            case "FINANCE":
                return new FinanceReportGenerator();
            default:
                throw new RuntimeException();
        }
    }
}
