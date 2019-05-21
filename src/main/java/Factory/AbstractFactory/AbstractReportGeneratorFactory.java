package Factory.AbstractFactory;

/**
 * Created by oahnus on 2019/3/30
 * 19:35.
 */
public abstract class AbstractReportGeneratorFactory {
    abstract FinanceReportGenerator buildFinanceGenrator();
    abstract AbstractHRReportGenerator buildHRGenerator();
}
