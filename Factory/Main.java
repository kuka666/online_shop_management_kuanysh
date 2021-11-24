package Factory;

public class Main {

    public static void main(String[] args) {
        Factory factory = new Factory();
        FactoryMethodJeans factoryjeans = new FactoryMethodJeans();

        TShirts whiteLshirt = factory.getType("WhiteL");
        System.out.println(whiteLshirt.ChooseTShirt());

        TShirts blackMshirt = factory.getType("BlackM");
        System.out.println(blackMshirt.ChooseTShirt());

        TShirts blackSshirt = factory.getType("BlackS");
        System.out.println(blackSshirt.ChooseTShirt());

        TShirts whiteSshirt = factory.getType("WhiteS");
        System.out.println(whiteSshirt.ChooseTShirt());

        TShirts whiteMshirt = factory.getType("WhiteM");
        System.out.println(whiteMshirt.ChooseTShirt());

        TShirts blackLshirt = factory.getType("BlackL");
        System.out.println(blackLshirt.ChooseTShirt());

        Jeans blueSjeans = factoryjeans.getType("BlueSJeans");
        System.out.println(blueSjeans.ChooseJeans());

        Jeans blueLjeans = factoryjeans.getType("BlueLJeans");
        System.out.println(blueLjeans.ChooseJeans());

        Jeans blueMjeans = factoryjeans.getType("BlueMJeans");
        System.out.println(blueMjeans.ChooseJeans());

        Jeans blackSjeans = factoryjeans.getType("BlackSJeans");
        System.out.println(blackSjeans.ChooseJeans());

        Jeans blackMjeans = factoryjeans.getType("BlackMJeans");
        System.out.println(blackMjeans.ChooseJeans());

        Jeans blackLjeans = factoryjeans.getType("BlackLJeans");
        System.out.println(blackLjeans.ChooseJeans());
    }
}
