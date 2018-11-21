package newtest;

import java.util.Arrays;
import java.util.stream.IntStream;

public class NeuralNetwork {
	
	static enum LayerType {I, H, O}
	static final double LEARNING_RATE=0.8;
	final static int INPUT_NEURONS = 12;
	//HIDDEN을 늘릴때는 weight도 신경써야함. (Neuron.weights, forwardprop.weightedSum, backpropError)
	final static int HIDDEN_NEURONS = 13;
	final static int OUTPUT_NEURONS = 7;
	private Neuron[] neurons = new Neuron[INPUT_NEURONS + HIDDEN_NEURONS +OUTPUT_NEURONS];
	public NeuralNetwork(){
		IntStream.range(0, INPUT_NEURONS).forEach(i -> neurons[i] = new Neuron(LayerType.I));
		IntStream.range(INPUT_NEURONS, INPUT_NEURONS + HIDDEN_NEURONS).forEach(i -> neurons[i] = new Neuron(LayerType.H));
		IntStream.range(INPUT_NEURONS + HIDDEN_NEURONS, INPUT_NEURONS + HIDDEN_NEURONS+OUTPUT_NEURONS).forEach(i -> neurons[i] = new Neuron(LayerType.O));
	}
	
	public NeuralNetwork forwardprop(double input[]){
		
		double weightedSum=0;
		for (int i = 0; i < neurons.length; i++) {
			switch (neurons[i].getLayerType()) {
			case I:
				neurons[i].setOutput(input[i]);
				break;
			case H:
				weightedSum = neurons[i].getThreshold() + 
										neurons[i].getWeights()[0] * neurons[0].getOutput() +
										neurons[i].getWeights()[1] * neurons[1].getOutput() +
										neurons[i].getWeights()[2] * neurons[2].getOutput() +
										neurons[i].getWeights()[3] * neurons[3].getOutput() +
										neurons[i].getWeights()[4] * neurons[4].getOutput() +
										neurons[i].getWeights()[5] * neurons[5].getOutput() +
										neurons[i].getWeights()[6] * neurons[6].getOutput() +
										neurons[i].getWeights()[7] * neurons[7].getOutput() +
										neurons[i].getWeights()[8] * neurons[8].getOutput() +
										neurons[i].getWeights()[9] * neurons[9].getOutput() +
										neurons[i].getWeights()[10] * neurons[10].getOutput() +
										neurons[i].getWeights()[11] * neurons[11].getOutput();
				neurons[i].applyActivationFunction(weightedSum);
				break;
			case O:
				weightedSum = neurons[i].getThreshold() + 
										neurons[i].getWeights()[0] * neurons[12].getOutput() +
										neurons[i].getWeights()[1] * neurons[13].getOutput() + 
										neurons[i].getWeights()[2] * neurons[14].getOutput() +
										neurons[i].getWeights()[3] * neurons[15].getOutput() +
										neurons[i].getWeights()[4] * neurons[16].getOutput() +
										neurons[i].getWeights()[5] * neurons[17].getOutput() +
										neurons[i].getWeights()[6] * neurons[18].getOutput() +
										neurons[i].getWeights()[7] * neurons[19].getOutput() +
										neurons[i].getWeights()[8] * neurons[20].getOutput() +
										neurons[i].getWeights()[9] * neurons[21].getOutput() +
										neurons[i].getWeights()[10] * neurons[22].getOutput() +
										neurons[i].getWeights()[11] * neurons[23].getOutput() +
										neurons[i].getWeights()[12] * neurons[24].getOutput();
				neurons[i].applyActivationFunction(weightedSum);
				break;
			}
		}
		return this;
	}
	
	public NeuralNetwork backpropError(double targetResult){
		
		//OUTPUT 파트
		for(int i=25; i<32; i++){
			neurons[i].setError((targetResult - neurons[i].getOutput()) * neurons[i].derivative());
			neurons[i].setThreshold(neurons[i].getThreshold() + LEARNING_RATE * neurons[i].getError());
			neurons[i].getWeights()[0] = neurons[i].getWeights()[0] + LEARNING_RATE * neurons[i].getError() * neurons[12].getOutput();
			neurons[i].getWeights()[1] = neurons[i].getWeights()[1] + LEARNING_RATE * neurons[i].getError() * neurons[13].getOutput();
			neurons[i].getWeights()[2] = neurons[i].getWeights()[2] + LEARNING_RATE * neurons[i].getError() * neurons[14].getOutput();
			neurons[i].getWeights()[3] = neurons[i].getWeights()[3] + LEARNING_RATE * neurons[i].getError() * neurons[15].getOutput();
			neurons[i].getWeights()[4] = neurons[i].getWeights()[4] + LEARNING_RATE * neurons[i].getError() * neurons[16].getOutput();
			neurons[i].getWeights()[5] = neurons[i].getWeights()[5] + LEARNING_RATE * neurons[i].getError() * neurons[17].getOutput();
			neurons[i].getWeights()[6] = neurons[i].getWeights()[6] + LEARNING_RATE * neurons[i].getError() * neurons[18].getOutput();
			neurons[i].getWeights()[7] = neurons[i].getWeights()[7] + LEARNING_RATE * neurons[i].getError() * neurons[19].getOutput();
			neurons[i].getWeights()[8] = neurons[i].getWeights()[8] + LEARNING_RATE * neurons[i].getError() * neurons[20].getOutput();
			neurons[i].getWeights()[9] = neurons[i].getWeights()[9] + LEARNING_RATE * neurons[i].getError() * neurons[21].getOutput();
			neurons[i].getWeights()[10] = neurons[i].getWeights()[10] + LEARNING_RATE * neurons[i].getError() * neurons[22].getOutput();
			neurons[i].getWeights()[11] = neurons[i].getWeights()[11] + LEARNING_RATE * neurons[i].getError() * neurons[23].getOutput();
			neurons[i].getWeights()[12] = neurons[i].getWeights()[12] + LEARNING_RATE * neurons[i].getError() * neurons[24].getOutput();
		}

		//HIDDEN 파트
		for(int i=12; i<25; i++){
			double HiddenErrorSum = 0.0;
			
			for(int j=25; j<32;j++){
				HiddenErrorSum += neurons[j].getWeights()[i-12] * neurons[j].getError() * neurons[i].derivative();
			}
			
			neurons[i].setError(HiddenErrorSum);
			neurons[i].setThreshold(neurons[i].getThreshold() + LEARNING_RATE * neurons[i].getError());
			neurons[i].getWeights()[0] = neurons[i].getWeights()[0] + LEARNING_RATE * neurons[i].getError() * neurons[0].getOutput();
			neurons[i].getWeights()[1] = neurons[i].getWeights()[1] + LEARNING_RATE * neurons[i].getError() * neurons[1].getOutput();
			neurons[i].getWeights()[2] = neurons[i].getWeights()[2] + LEARNING_RATE * neurons[i].getError() * neurons[2].getOutput();
			neurons[i].getWeights()[3] = neurons[i].getWeights()[3] + LEARNING_RATE * neurons[i].getError() * neurons[3].getOutput();
			neurons[i].getWeights()[4] = neurons[i].getWeights()[4] + LEARNING_RATE * neurons[i].getError() * neurons[4].getOutput();
			neurons[i].getWeights()[5] = neurons[i].getWeights()[5] + LEARNING_RATE * neurons[i].getError() * neurons[5].getOutput();
			neurons[i].getWeights()[6] = neurons[i].getWeights()[6] + LEARNING_RATE * neurons[i].getError() * neurons[6].getOutput();
			neurons[i].getWeights()[7] = neurons[i].getWeights()[7] + LEARNING_RATE * neurons[i].getError() * neurons[7].getOutput();
			neurons[i].getWeights()[8] = neurons[i].getWeights()[8] + LEARNING_RATE * neurons[i].getError() * neurons[8].getOutput();
			neurons[i].getWeights()[9] = neurons[i].getWeights()[9] + LEARNING_RATE * neurons[i].getError() * neurons[9].getOutput();
			neurons[i].getWeights()[1] = neurons[i].getWeights()[10] + LEARNING_RATE * neurons[i].getError() * neurons[10].getOutput();
			neurons[i].getWeights()[11] = neurons[i].getWeights()[11] + LEARNING_RATE * neurons[i].getError() * neurons[11].getOutput();
		}
		
		return this;
	}
	
	public Neuron[] getNeurons() {return neurons;}
	public String toString() {return Arrays.toString(neurons);}
	
}
