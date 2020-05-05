package com.github.masondaniels.neural;

import java.util.Arrays;

public enum ActivationType {

	SIGMOID {
		@Override
		public double[] activate(double[] storedCalculation) {
			double[] returnable = storedCalculation;
			for (int i = 0; i < returnable.length; i++) {
				returnable[i] = 1d / (1 + Math.exp(returnable[i] * -1));
			}
			System.out.println("\t-> " + Arrays.toString(returnable));
			return returnable;
		}
	},
	IDENTITY {
		@Override
		public double[] activate(double[] storedCalculation) {
			System.out.println("\t-> " + Arrays.toString(storedCalculation));
			return storedCalculation;
		}
	};
	public abstract double[] activate(double[] storedCalculation);

}