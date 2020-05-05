package com.github.masondaniels.neural;

public class Neuron {

	private double weight;

	public Neuron(double weight) {
		setWeight(weight);
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

}