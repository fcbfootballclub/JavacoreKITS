/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections.hashSet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

/**
 *
 * @author Hung
 */
public class HashSetWithHashCode { 
    static class Human { 
        private Integer age;
        private String name; 
        Human(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return getName() + getAge().toString();
        } 
        /**
         * @return the age
         */
        public Integer getAge() {
            return age;
        } 
        /**
         * @param age the age to set
         */
        public void setAge(Integer age) {
            this.age = age;
        }
        @Override
        public int hashCode(){
            return age.hashCode();
        }
        public String getName() {
            return name;
        }

        /**
         * @param name the name to set
         */
        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) { 
        Human human1 = new Human(21, "Sham");
        Human human2 = new Human(42, "Paul");
        Human human3 = new Human(18, "John");
        Set<Human> hashSet = new HashSet<Human>();
        hashSet.add(human1);
        hashSet.add(human2);
        hashSet.add(human3); 
        Human human4 = new Human(42, "Paul");
        hashSet.add(human4);
        for (Human h : hashSet) {
            System.out.println(h.toString());
        }
    }
}
