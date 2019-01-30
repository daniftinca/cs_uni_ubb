package service.automate;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Objects;

public class State {
    private Boolean isFinal;
    private Boolean isInitial;
    private String name;

//    public State(Boolean isFinal, Boolean isInitial, String name) {
//        this.isFinal = isFinal;
//        this.isInitial = isInitial;
//        this.name = name;
//    }

//    public State(){}

    public Boolean getFinal() {
        return isFinal;
    }

    public void setFinal(Boolean aFinal) {
        isFinal = aFinal;
    }

    public Boolean getInitial() {
        return isInitial;
    }

    public void setInitial(Boolean initial) {
        isInitial = initial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "State{" +
                "isFinal=" + isFinal +
                ", isInitial=" + isInitial +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return Objects.equals(isFinal, state.isFinal) &&
                Objects.equals(isInitial, state.isInitial) &&
                Objects.equals(name, state.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(isFinal, isInitial, name);
    }
}
