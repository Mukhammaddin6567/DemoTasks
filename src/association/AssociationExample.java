package association;

import java.util.ArrayList;
import java.util.List;

class Mobile {
    private String mobileNumber;

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}

class Person {
    private String name;
    private List<Mobile> numbers;

    public void getNumbers() {
        this.numbers.forEach(number -> System.out.println("Number: " + number.getMobileNumber()));
    }

    public void setNumbers(List<Mobile> numbers) {
        this.numbers = numbers;
    }

    public String getName() {
        return "Name: " + this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class AssociationExample {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Mukhammaddin Bakhridinov");

        Mobile number1 = new Mobile();
        number1.setMobileNumber("+998904476567");
        Mobile number2 = new Mobile();
        number2.setMobileNumber("+998936576567");

        List<Mobile> numbersList = new ArrayList<>();
        numbersList.add(number1);
        numbersList.add(number2);

        person.setNumbers(numbersList);


        System.out.println(person.getName());
        person.getNumbers();
    }
}
