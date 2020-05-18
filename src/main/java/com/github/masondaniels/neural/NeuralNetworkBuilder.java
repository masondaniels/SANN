package com.github.masondaniels.neural;

import java.util.ArrayList;

import com.github.masondaniels.neural.exception.NeuralNetworkException;
import com.github.masondaniels.neural.specific.ActivationType;
import com.github.masondaniels.neural.specific.CostType;

public class NeuralNetworkBuilder {

	private ArrayList<NeuralLayer> layers = new ArrayList<NeuralLayer>();
	private ActivationType activationType;
	private CostType cost;

	public NeuralNetworkBuilder addLayer(int size) {
		layers.add(new NeuralLayer(size));
		return this;
	}

	public NeuralNetworkBuilder addLayers(int... sizes) {
		for (int i = 0; i < sizes.length; i++) {
			addLayer(sizes[i]);
		}
		return this;
	}

	public NeuralNetworkBuilder setCostFunction(CostType cost) {
		this.cost = cost;
		return this;
	}

	public NeuralNetworkBuilder setActivation(ActivationType activationType) {
		this.activationType = activationType;
		return this;
	}

	public NeuralNetwork build() throws NeuralNetworkException {
		readyNetwork();
		if (layers.isEmpty() || layers.size() <= 1) {
			throw new NeuralNetworkException(
					"Couldn't create neural network. Size: " + layers.size() + " | Empty: " + layers.isEmpty());
		}
		NeuralNetwork network = new NeuralNetwork(layers.toArray(new NeuralLayer[layers.size()]));
		if (cost != null) {
			network.setCostFunction(cost);
		}
		if (activationType != null) {
			network.setActivationType(activationType);
		}
		return network;
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