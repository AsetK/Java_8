package epam.optional;

import java.util.LinkedList;
import java.util.List;

class Person {
    private String name;
    private List<String> petList = new LinkedList<>();

    Person(String name, List<String> petList){
        this.name = name;
        this.petList = petList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPetList() {
        return petList;
    }

    public void setPetList(List<String> petList) {
        this.petList = petList;
    }
}
