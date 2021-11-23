package Factory;

public class FactoryMethodJeans {
    public Jeans getType(String type) {
        if ("BlackMJeans".equals(type)) {
            return new BlackMJeans();
        } else if ("BlackSJeans".equals(type)) {
            return new BlackSJeans();
        } else if ("BlackLJeans".equals(type)) {
            return new BlackLJeans();
        } else if ("BlueLJeans".equals(type)) {
            return new BlueLJeans();
        } else if ("BlueSJeans".equals(type)) {
            return new BlueSJeans();
        } else {
            return new BlueMJeans();
        }
    }
}
