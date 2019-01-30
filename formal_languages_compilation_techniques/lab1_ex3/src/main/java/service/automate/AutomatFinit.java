package service.automate;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class AutomatFinit {
    private List<State> states;
    private List<Transition> transitions;

    public AutomatFinit(List<State> states, List<Transition> transitions) {
        this.states = states;
        this.transitions = transitions;
    }

    public AutomatFinit() {
        this.states = new ArrayList<>();
        this.transitions = new ArrayList<>();
    }

    /**
     * Returns a list of all the characters in the alphabet.
     *
     * @return
     */
    public List<String> getAlphabet() {
        List<String> alphabet = new LinkedList<>();
        for (Transition transition : transitions) {
            alphabet.addAll(transition.getValues());
        }
        return alphabet.stream()
                .distinct()
                .collect(Collectors.toList());
    }


    /**
     * Returns a list of all the final states.
     *
     * @return
     */
    public List<State> getFinalStates() {
        return this.states.stream()
                .filter(State::getFinal)
                .collect(Collectors.toList());
    }

    private State getInitial() {
        for (State state : this.states) {
            if (state.getInitial()) {
                return state;
            }
        }
        return null;
    }

    private List<Transition> getTransitionsFromState(State s) {
        return this.transitions.stream()
                .filter(transition -> transition.getFrom().equals(s.getName()))
                .collect(Collectors.toList());
    }

    private State getStateByName(String name) {
        for (State state : this.states) {
            if (state.getName().equals(name)) {
                return state;
            }
        }
        return null;
    }

    /**
     * Tests if a sequence is accepted by the automate and logs the steps as well.
     *
     * @param sequence
     * @return
     * @throws Exception
     */
    public Boolean accepts(String sequence) throws Exception {
//        List<String> values = Arrays.asList(sequence.split(""));
//        State currentState = getInitial();
//        if (currentState == null) {
//            throw new Exception("invalid automat");
//        }
//
//        if(currentState.getFinal()&&sequence.equals("")){
//            return true;
//        }
//
//        for (String value : values) {
//            List<Transition> transitions = getTransitionsFromState(currentState);
//            boolean foundSomething = false;
//            for (Transition transition : transitions) {
//
//                if (value.equals(transition.getValue())) {
//                    System.out.println("From: " + currentState.getName() + " to " + transition.getTo() + " with value: " + transition.getValue());
//                    currentState = getStateByName(transition.getTo());
//                    transitions = getTransitionsFromState(currentState);
//                    foundSomething = true;
//                    break;
//                }
//            }
//            if (!foundSomething) {
//                System.out.println("Stopped at " + currentState.getName());
//                return false;
//            }
//        }
//        if (!currentState.getFinal()) {
//            return false;
//        }
        return true;
    }


    public String getLongestAcceptedPrefix(String sequence) throws Exception {
        // Pregatesc valorile initiale
        String prefix = "";
        String longestPrefix = "";
        StringBuilder sb = new StringBuilder(prefix);
        List<String> sequenceValues = Arrays.asList(sequence.split(""));

        List<Transition> lastVisit = new ArrayList<>();
        State currentState = getInitial();
        if (currentState == null) {
            throw new Exception("invalid automat");
        }


        Stack<Transition> drum = new Stack<>();
        Stack<Pair<State, List<Transition>>> visited = new Stack<>();
        Integer drumLength = 0;

        //Early exit possibilities
        if (sequence.equals("") && currentState.getFinal()) {
            return "";
        } else if (sequence.equals("") && !currentState.getFinal()) {
            return null;
        }

        // Incep de la primul state si vad daca se potriveste primul caracter.
        // Tin in memorie drumul (tranzitii parcurse) intr-o stiva
        // Tin si ceva in mem pt ce am vizitat deja
        List<Transition> transitionsFromState = getTransitionsFromState(currentState);
        Boolean foudSomething;
        List<String> alphabet = getAlphabet();
        while (true) {
            if (!alphabet.contains(sequenceValues.get(drumLength))) {
                break;
            }
            //alfabetul posibil
            List<String> possibleNextAlphabet = new ArrayList<>();
            List<Transition> possibleTrans = getTransitionsFromState(currentState);
            //System.out.println("Possible Transistions: ");
            //System.out.println(possibleTrans);
            for (Transition transition : possibleTrans) {
                possibleNextAlphabet.addAll(transition.getValues());
            }
            //System.out.println(possibleNextAlphabet);
            possibleNextAlphabet = possibleNextAlphabet.stream()
                    .distinct()
                    .collect(Collectors.toList());
            //System.out.println(possibleNextAlphabet);


            if (transitionsFromState.isEmpty()) {
                break;
            }
            //System.out.println("New Step: \n=================");
            //System.out.println("Current State: ");
            //System.out.println(currentState.toString());
            //System.out.println(getTransitionsFromState(currentState));
            foudSomething = false;

            if(possibleNextAlphabet.contains(sequenceValues.get(drumLength))) {
                // Parcurg tranzitiile
                for (Transition transition : transitionsFromState) {
                    //System.out.println("Testing: " + transition.getValues() + " " + sequenceValues.get(drumLength));
                    if (transition.getValues().contains(sequenceValues.get(drumLength))) {

                        drum.push(transition);
                        List<Transition> transList = new ArrayList<>();
                        transList.add(transition);

                        visited.push(new Pair<>(currentState, transList));

                        sb.append(sequenceValues.get(drumLength));
                        drumLength++;
                        currentState = getStateByName(transition.getTo());
                        if (currentState.getFinal()) {
                            longestPrefix = sb.toString();
                        }
                        foudSomething = true;
                        break;


                    }

                }
            }
            //handle iesiri
            if (!visited.empty()) {
                if (drumLength == 0
                        && visited.peek().getValue().size() == getTransitionsFromState(visited.peek().getKey()).size()) {
                    break;
                }
            }
            if (drum.empty() || drumLength == sequence.length()) {
                break;
            }

            //System.out.println(drum.toString());
            //System.out.println(visited.toString());
            //System.out.println(drumLength);
            //handle inapoi
            if (!foudSomething && !visited.empty()) {
                //System.out.println("hello returned at state");
                //System.out.println(currentState.toString());
                if (visited.peek().getValue().size() < transitionsFromState.size()) {
                    lastVisit = visited.pop().getValue();
                    //System.out.println("Last visit is now: ");
                    //System.out.println(lastVisit);
                    currentState = getStateByName(drum.pop().getFrom());
                    drumLength--;
                    sb.deleteCharAt(drumLength);
                }
            }
            transitionsFromState = getTransitionsFromState(currentState);
            if(foudSomething){
                //recompute possible alphabet
                possibleNextAlphabet = new ArrayList<>();
                possibleTrans = getTransitionsFromState(currentState);
                //System.out.println("Possible Transistions 2: ");
                //System.out.println(possibleTrans);
                for (Transition transition : possibleTrans) {
                    possibleNextAlphabet.addAll(transition.getValues());
                }
                //System.out.println(possibleNextAlphabet);
                possibleNextAlphabet = possibleNextAlphabet.stream()
                        .distinct()
                        .collect(Collectors.toList());
                //System.out.println(possibleNextAlphabet);
            }

            if (!visited.empty()) {
                //System.out.println("Loopsis: ");
                List<Transition> loopTransitions = transitionsFromState.stream()
                        .filter(transition -> transition.getFrom().equals(transition.getTo()))
                        .collect(Collectors.toList());

                //System.out.println(loopTransitions.toString());


                if(!lastVisit.isEmpty()) {
                    //System.out.println("dpecial");
                    List<Transition> temp = new ArrayList<>();
                    for (Transition transition : transitionsFromState) {
                        if (lastVisit.contains(transition)) {
                            temp.add(transition);
                        }
                    }
                    transitionsFromState = temp.stream().distinct().collect(Collectors.toList());
                } else {
                    transitionsFromState = transitionsFromState.stream()
                            .filter(transition -> !visited.peek().getValue().contains(transition))
                            .distinct()
                            .collect(Collectors.toList());
                }

                //System.out.println("first filter: ");
                //System.out.println(transitionsFromState.toString());
                if (foudSomething) {
                    loopTransitions.addAll(transitionsFromState);
                    transitionsFromState = loopTransitions;
                }
                transitionsFromState = transitionsFromState.stream().distinct().collect(Collectors.toList());
                //System.out.println("Current character: "+ sequenceValues.get(drumLength));
                //System.out.println("Possible next alphabet: ");
                //System.out.println(possibleNextAlphabet);
                if(!possibleNextAlphabet.contains(sequenceValues.get(drumLength))){
                    transitionsFromState = new ArrayList<>();
                }

                //System.out.println("final filter: ");
                //System.out.println(transitionsFromState.toString());
            }

        }


        return longestPrefix;
    }


    /**
     * Returns the state of the param.
     *
     * @return
     */
    private List<State> getStateParents(State state) {
        return transitions.stream()
                .filter(transition -> transition.getTo().equals(state.getName()))
                .map(transition -> {
                    return states.stream()
                            .filter(parentState -> parentState.getName().equals(transition.getFrom()))
                            .findFirst().get();
                })
                .collect(Collectors.toList());
    }

    public List<State> getStates() {
        return states;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }

    public List<Transition> getTransitions() {
        return transitions;
    }

    public void setTransitions(List<Transition> transitions) {
        this.transitions = transitions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutomatFinit that = (AutomatFinit) o;
        return Objects.equals(states, that.states) &&
                Objects.equals(transitions, that.transitions);
    }

    @Override
    public int hashCode() {

        return Objects.hash(states, transitions);
    }

    @Override
    public String toString() {
        return "AutomatFinit{" +
                "states=" + states +
                ", transitions=" + transitions +
                '}';
    }
}
