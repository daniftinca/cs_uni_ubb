package service.automate;

import java.util.List;
import java.util.Objects;

public class Transition {
    private String from;
    private String to;
    private List<String> values;

//    public Transition(State from, State to, String value) {
//        this.from = from;
//        this.to = to;
//        this.value = value;
//    }
//
//    public Transition(){}


    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }


    @Override
    public String toString() {
        return "Transition{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", values=" + values +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transition that = (Transition) o;
        return Objects.equals(from, that.from) &&
                Objects.equals(to, that.to) &&
                Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {

        return Objects.hash(from, to, values);
    }
}
