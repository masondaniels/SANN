package com.github.masondaniels.neural;

import java.util.Arrays;

public class NeuralNetwork {

	private NeuralLayer[] layers;
	private ActivationType activationType;

	public NeuralNetwork(NeuralLayer[] layers, ActivationType activation) {
		setLayers(layers);
		setActivationType(activation);
	}

	public void setLayers(NeuralLayer[] layers) {
		this.layers = layers;
	}

	public ActivationType getActivationType() {
		return activationType;
	}

	public void setActivationType(ActivationType activationType) {
		this.activationType = activationType;
	}

	public double[] calculate(double... input) {
		System.out.println("INPUTS: " + Arrays.toString(input) + "\n");

		setInput(input);
		for (int i = 1; i < layers.length - 1; i++) {
			NeuralLayer layer = layers[i];
			layer.setStoredCalculation(activation(mult(layers[i - 1].getStoredCalculation(), layer)));
		}
		return activation(mult(layers[layers.length - 2].getStoredCalculation(), layers[layers.length - 1]));

	}

	private double[] mult(double[] storedCalculation, NeuralLayer layer) {
		double[] returnable = new double[layer.getSize()];
		for (int i = 0; i < returnable.length; i++) {
			for (int j = 0; j < storedCalculation.length; j++) {
				returnable[i] += storedCalculation[j] * layer.getNeuron(i).getWeight() + layer.getBias();
			}
		}
		System.out.println(Arrays.toString(returnable));
		return returnable;
	}

	private double[] activation(double[] storedCalculation) {
		double[] returnable = storedCalculation;

		if (activationType == ActivationType.SIGMOID) {
			for (int i = 0; i < returnable.length; i++) {
				returnable[i] = 1d / (1 + Math.pow(Math.E, returnable[i] * -1)); // What works better? Math.exp or pow? Does it matter? I dunno.
			}
			System.out.println("\t-> " + Arrays.toString(returnable));
			return returnable;
		}
		return null;
	}

	private void setInput(double[] input) {
		if (input.length != layers[0].getSize())
			throw new RuntimeException("Could not calculate due to " + input.length + " != " + layers[0].getSize());

		layers[0].setStoredCalculation(input);
	}

}