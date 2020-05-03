package com.github.masondaniels.neural;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		NeuralNetwork network = new NeuralNetworkBuilder().addLayer(4).addLayer(2).addLayer(1)
				.setActivation(ActivationType.SIGMOID).build();
		System.out.println("\nFINAL: " + Arrays.toString(network.calculate(1, 3, 3, 7)));
	}
}