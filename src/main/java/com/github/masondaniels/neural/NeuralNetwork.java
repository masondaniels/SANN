package com.github.masondaniels.neural;

import java.util.Arrays;

import com.github.masondaniels.neural.exception.NeuralNetworkException;
import com.github.masondaniels.neural.specific.ActivationType;
import com.github.masondaniels.neural.specific.CostType;

public class NeuralNetwork {

	private NeuralLayer[] layers;
	private ActivationType activationType = ActivationType.SIGMOID;
	private CostType cost = CostType.SQAURE;

	public NeuralNetwork(NeuralLayer[] layers) {
		setLayers(layers);
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

	public double[] calculate(double... input) throws NeuralNetworkException {
		System.out.println("INPUTS: " + Arrays.toString(input) + "\n");
		setInput(input);
		for (int i = 1; i < layers.length; i++) {
			layers[i].setStoredCalculation(
					activationType.activate(preActivate(layers[i - 1].getStoredCalculation(), layers[i])));
		}
		return layers[layers.length - 1].getStoredCalculation();
	}

	private double[] preActivate(double[] storedCalculation, NeuralLayer layer) {
		double[] returnable = new double[layer.getSize()];
		for (int i = 0; i < returnable.length; i++) {
			for (int j = 0; j < storedCalculation.length; j++) {
				returnable[i] += storedCalculation[j] * layer.getNeuronWeight(i) + layer.getBias();
			}
		}
		System.out.println(Arrays.toString(returnable));
		return returnable;
	}

	private void train(double[] input, double[] target, double rate) throws NeuralNetworkException {
		if (input.length != layers[0].getSize() || target.length != layers[layers.length - 1].getSize())
			throw new NeuralNetworkException("Could not calculate due to " + input.length + " != " + layers[0].getSize()
					+ " OR " + target.length + " != " + layers[layers.length - 1].getSize());
		calculate(input);
		// TODO: add more
	}

	private void setInput(double[] input) throws NeuralNetworkException {
		if (input.length != layers[0].getSize())
			throw new NeuralNetworkException(
					"Could not calculate due to " + input.length + " != " + layers[0].getSize());
		layers[0].setStoredCalculation(input);
	}

	public CostType getCostFunction() {
		return cost;
	}

	public void setCostFunction(CostType cost) {
		this.cost = cost;
	}

}