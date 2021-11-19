package Factory;

public class Factory {
    public TShirts getType(String type) {
        if ("WhiteL".equals(type)) {
            return new WhiteL();
        } else if ("WhiteM".equals(type)) {
            return new WhiteM();
        } else if ("WhiteS".equals(type)) {
            return new WhiteS();
        } else if ("BlackL".equals(type)) {
            return new BlackL();
        } else if ("BlackM".equals(type)) {
            return new BlackM();
        } else {
            return new BlackS();
        }
    }
}
