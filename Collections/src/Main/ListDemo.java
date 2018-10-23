package Main;

import java.util.*;

public class ListDemo {
    public static int amountStartsWith(List<String> stringList, char character) {
        int count = 0;
        for (String string: stringList) {
            if (string.startsWith(Character.toString(character))) {
                count++;
            }
        }
        return count;
    }

    public static List<Human> amoutLastNameHumans(List<Human> humanList, Human human) {
        List<Human> result = new ArrayList<>();
        for (Human humanFromList: humanList) {
            if (humanFromList.getLastName().equals(human.getLastName())) {
                result.add(humanFromList);
            }
        }
        return result;
    }

    public static List<Human> listWithoutHuman(List<Human> humanList, Human human) {
        List<Human> result = new ArrayList<>(humanList);
        result.remove(human);
        return result;
    }

    public static List<Set<Integer>> listOfNotIntersectingSets(List<Set<Integer>> listOfSetOfInteger,
                                                               Set<Integer> setOfInteger) {
        List<Set<Integer>> result = new ArrayList<>();
        boolean flag;

        for (Set<Integer> integerSet: listOfSetOfInteger) {
            flag = false;
            for (Integer integer: setOfInteger) {
                if (integerSet.contains(integer)) {
                    flag = true;
                }
            }
            if (!flag) {
                result.add(integerSet);
            }
        }
        return result;
    }

    public static Set<Human> setOfHumansWithMaxAge(List<Human> humanList) {
        Set<Human> result = new HashSet<>();
        int maxAge = Integer.MIN_VALUE;
        for (Human human: humanList) {
            if (maxAge < human.getAge()) {
                result.clear();
                maxAge = human.getAge();
            }
            if (maxAge == human.getAge()) {
                result.add(human);
            }
        }
        return result;
    }

    public static List<Human> sortedHumanListByLastName(Set<? extends Human> humanSet) {
        Set<Human> sortedHumanSet = new TreeSet<>((h1, h2) -> h1.getLastName().compareTo(h2.getLastName()));
        sortedHumanSet.addAll(humanSet);
        return new ArrayList<>(sortedHumanSet);
    }

    public static Set<Human> setOfHumansContainsInAnotherSet(Map<Human, Integer> humanIntegerMap, Set<Integer> integerSet) {
        Set<Human> result = new HashSet<>();
        for (Human human: humanIntegerMap.keySet()) {
            if (integerSet.contains(humanIntegerMap.get(human))) {
                result.add(human);
            }
        }
        return result;
    }

    public static List<Integer> getAdultHumans(Map<Human, Integer> humanIntegerMap) {
        List<Integer> result = new ArrayList<>();
        for (Human human: humanIntegerMap.keySet()) {
            if (human.getAge() >= 18) {
                result.add(humanIntegerMap.get(human));
            }
        }
        return result;
    }
}
