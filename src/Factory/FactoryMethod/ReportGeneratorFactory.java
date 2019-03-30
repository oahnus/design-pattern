package Factory.FactoryMethod;

import Factory.ReportGenerator;

/**
 * Created by oahnus on 2019/3/30
 * 19:27.
 */
public interface ReportGeneratorFactory {
    ReportGenerator buildGenerator();
}
