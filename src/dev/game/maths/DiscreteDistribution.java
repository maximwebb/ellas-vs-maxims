package dev.game.maths;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class DiscreteDistribution<T> {
	
	private LinkedHashMap<Double, T> cumulativeProbabilities = new LinkedHashMap<Double, T>();
	
	public DiscreteDistribution(HashMap<T, Double> ratioTable) {
		
		double ratioTotal = 0;
		
		for (Double value : ratioTable.values()) {
			ratioTotal += value;
		}
		
		double totalProbability = 0;
		
		for (Entry<T, Double> entry : ratioTable.entrySet()) {
			double newProbability = entry.getValue()/ratioTotal;
			totalProbability += newProbability;
			cumulativeProbabilities.put(totalProbability, entry.getKey());
		}
	}
	
	public T getRandom() {
		
		double random = Math.random();
		
		for (Double probability : cumulativeProbabilities.keySet()) {
			if (random <= probability) {
				return cumulativeProbabilities.get(probability);
			}
		}
		
		return null;
	}
}
