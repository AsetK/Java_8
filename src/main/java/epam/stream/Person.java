package epam.stream;

import java.util.LinkedList;
import java.util.List;

class Person {
    private java.lang.String name;
    private List<String> petList = new LinkedList<>();

    Person(java.lang.String name, List<String> petList){
        this.name = name;
        this.petList = petList;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public List<String> getPetList() {
        return petList;
    }

    public void setPetList(List<String> petList) {
        this.petList = petList;
    }
}
