package com.github.masondaniels.neural.specific;

import java.util.Arrays;

public enum ActivationType {

	SIGMOID {
		@Override
		public double[] activate(double[] value) {
			double[] returnable = value;
			for (int i = 0; i < returnable.length; i++) {
				returnable[i] = 1d / (1 + Math.exp(returnable[i] * -1));
			}
			System.out.println("\t-> " + Arrays.toString(returnable));
			return returnable;
		}

		@Override
		public double[] derive(double[] value) {
			double[] returnable = value;
			for (int i = 0; i < returnable.length; i++) {
				returnable[i] = Math.exp(returnable[i] * -1) / Math.pow((1 + Math.exp(returnable[i] * -1)), 2);
			}
			return returnable;
		}
	},
	IDENTITY {
		@Override
		public double[] activate(double[] value) {
			System.out.println("\t-> " + Arrays.toString(value));
			return value;
		}

		@Override
		public double[] derive(double[] value) {
			double[] returnable = value;
			for (int i = 0; i < returnable.length; i++) {
				returnable[i] = 1;
			}
			return returnable;
		}
	};

	public abstract double[] activate(double[] value);

	public abstract double[] derive(double[] value);

}