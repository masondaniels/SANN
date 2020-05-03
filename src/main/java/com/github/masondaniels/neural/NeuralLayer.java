package com.github.masondaniels.neural;

import java.util.Random;

public class NeuralLayer {

	private static Random random = new Random();

	private double bias = 1;
	private Neuron[] neurons;

	private double[] storedCalculation;

	public NeuralLayer(int size) {
		setSize(size);
	}

	public int getSize() {
		return neurons.length;
	}

	public void setSize(int size) {
		this.neurons = new Neuron[size];
	}

	public void initializeNeurons() {
		for (int i = 0; i < neurons.length; i++) {
			neurons[i] = new Neuron(random.nextDouble());
		}
	}

	public void setNeuron(int index, Neuron neuron) {
		neurons[index] = neuron;
	}

	public Neuron getNeuron(int index) {
		return neurons[index];
	}
	
	public double[] getStoredCalculation() {
		return storedCalculation;
	}

	public void setStoredCalculation(double[] storedCalculation) {
		this.storedCalculation = storedCalculation;
	}

	public double getBias() {
		return bias;
	}
	
	public void setBias(double bias) {
		this.bias = bias;
	}

}