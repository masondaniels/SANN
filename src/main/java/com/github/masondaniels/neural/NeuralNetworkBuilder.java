package com.github.masondaniels.neural;

import java.util.ArrayList;

public class NeuralNetworkBuilder {

	private ArrayList<NeuralLayer> layers = new ArrayList<NeuralLayer>();
	private ActivationType activationType;

	public NeuralNetworkBuilder addLayer(int size) {
		layers.add(new NeuralLayer(size));
		return this;
	}

	public NeuralNetworkBuilder setActivation(ActivationType activationType) {
		this.activationType = activationType;
		return this;
	}

	public NeuralNetwork build() {
		readyNetwork();
		return new NeuralNetwork(layers.toArray(new NeuralLayer[layers.size()]), activationType);
	}

	/*
	 * Adds biases to hidden layers & randomizes neurons
	 */
	private void readyNetwork() {
		for (int i = 1; i < layers.size(); i++) {
			NeuralLayer layer = layers.get(i);
			layer.initializeNeurons();
		}
	}

}