package association.composition;

import java.util.ArrayList;
import java.util.List;

class Mobile {
    private String name;
    private String ram;
    private String rom;

    Mobile(String name, String ram, String rom) {
        this.name = name;
        this.ram = ram;
        this.rom = rom;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getRam() {
        return ram;
    }

    void setRam(String ram) {
        this.ram = ram;
    }

    String getRom() {
        return rom;
    }

    void setRom(String rom) {
        this.rom = rom;
    }
}

class MobileStore {
    private final List<Mobile> mobileList;

    MobileStore(List<Mobile> mobileList) {
        this.mobileList = mobileList;
    }

    List<Mobile> getMobileList() {
        return mobileList;
    }
}

class CompositionExample {
    public static void main(String[] args) {
        Mobile mob1 = new Mobile("Realme6", "8GB", "128GB");
        Mobile mob2 = new Mobile("SAMSUNG A21S", "4GB", "128");
        Mobile mob3 = new Mobile("SAMSUNG M10", "4GB", "64GB");

        List<Mobile> mobiles = new ArrayList<>();
        mobiles.add(mob1);
        mobiles.add(mob2);
        mobiles.add(mob3);

        MobileStore store = new MobileStore(mobiles);
        for (Mobile mobile : store.getMobileList()) {
            System.out.println("Name: " + mobile.getName() + " RAM: " + mobile.getRam() + " and ROM: " + mobile.getRom());
        }
    }
}