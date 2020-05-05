package com.github.masondaniels.neural;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		NeuralNetwork network = new NeuralNetworkBuilder().addLayers(4, 3, 2, 3, 4)
				.setActivation(ActivationType.IDENTITY).build();
		System.out.println("\nFINAL: " + Arrays.toString(network.calculate(1, 3, 3, 7)));
	}
}