package com.company;

public class Main {

    public static void main(String[] args) {
        Factory factory = new Factory();

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
    }
}
