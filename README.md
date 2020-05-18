# SANN
Simple Artificial Neural Network

## Status
As of now, SANN can not train since it has no backpropagation/training algorithm implemented yet. Though, this is in development. Some activation functions (ActivationType) are supported currently. Networks support a layer size of 2 to infinite. Each layer can have a size of 1 to infinite.

There are a few system prints for debugging. They will be removed at a later time. This project is in its early-development.

## Usage
While you can create a NeuralNetwork with an array of NeuralLayers and an ActivationType, this isn't recommended. Use the NeuralNetworkBuilder. Examples below. Layer sizes are the only required thing before building the network. You can't have an empty/null layers array. 

###### Example 1

```java
NeuralNetwork network = new NeuralNetworkBuilder().addLayers(3, 4, 5, 4, 3, 2)
	.setActivation(ActivationType.SIGMOID).build();
System.out.println(Arrays.toString(network.calculate(10, -3, 0)));
```

###### Example 2

```java
NeuralNetwork network = new NeuralNetworkBuilder().addLayers(1, 2, 3, 2)
	.setActivation(ActivationType.IDENTITY).setCostFunction(CostType.SQAURE)
	.build();
System.out.println(Arrays.toString(network.calculate(1)));
```

###### Example 3

```java
NeuralNetwork network = new NeuralNetworkBuilder().addLayers(2, 3).build();
System.out.println(Arrays.toString(network.calculate(10, 93)));
```

###### Visual Example

![Visual](https://i.imgur.com/D2dlkfp.png)