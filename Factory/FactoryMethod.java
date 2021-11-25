package Factory;

public class FactoryMethod {
    public TShirts getType(String type) {
        if ("BlackM".equals(type)) {
            return new BlackM();
        } else if ("BlackS".equals(type)) {
            return new BlackS();
        } else if ("BlackL".equals(type)) {
            return new BlackL();
        } else if ("WhiteL".equals(type)) {
            return new WhiteL();
        } else if ("WhiteS".equals(type)) {
            return new WhiteS();
        } else {
            return new WhiteM();
        }
    }
}
