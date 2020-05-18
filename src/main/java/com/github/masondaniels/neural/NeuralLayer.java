package com.github.masondaniels.neural;

import java.util.Random;

public class NeuralLayer {

	private static Random random = new Random();
	private double bias = random.nextBoolean() ? random.nextDouble() : -(random.nextDouble());
	private double[] neuronWeights;
	private double[] neuronErrorSig;

	private double[] storedCalculation;

	public NeuralLayer(int size) {
		setSize(size);
	}

	public int getSize() {
		return neuronWeights.length;
	}

	public void setSize(int size) {
		this.neuronWeights = new double[size];
		this.neuronErrorSig = new double[size];
	}

	public void initializeNeurons() {
		for (int i = 0; i < neuronWeights.length; i++) {
			neuronWeights[i] = random.nextDouble();
		}
	}

	public void setNeuron(int index, double weight) {
		neuronWeights[index] = weight;
	}

	public double getNeuronWeight(int index) {
		return neuronWeights[index];
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

	public double getNeuronErrorSig(int index) {
		return neuronErrorSig[index];
	}

	public void setNeuronErrorSig(int index, double neuronErrorSig) {
		this.neuronErrorSig[index] = neuronErrorSig;
	}

}