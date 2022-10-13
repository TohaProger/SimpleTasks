package com.example.program.Model;

import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequirementsCollection implements Aggregate {
    public Map<Integer, Requirements> requirementsCollection = new HashMap<Integer, Requirements>();
    public static int key = 0;

    public void AddRequariments(Requirements requirements) {
        requirementsCollection.put(key, requirements);
        key++;
    }

    public RequirementsCollection(List<Requirements> newRequirements) {
        for (int i = 1; i <= newRequirements.size(); i++) {
            this.requirementsCollection.put(i, newRequirements.get(i));
        }

    }

    private class RequirementsIterator implements Iterator {

        @Override
        public boolean hasNext() {
            return requirementsCollection.containsKey(key += 1);
        }

        @Override
        public Requirements next() {
            if (this.hasNext()) {
                return requirementsCollection.get(key);
            } else {
                key = 0;
                return requirementsCollection.get(0);
            }
        }

        @Override
        public Object preview() {
            if (this.hasNext()) {
                return requirementsCollection.get(key);
            }
            return null;
        }
    }

    @Override
    public Iterator getIterator() {
        return new RequirementsIterator();
    }
}