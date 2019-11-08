package newtest;

import java.util.Arrays;


public class NeuralNetwork {
	
	static enum LayerType {I, H, O}
	static final double LEARNING_RATE=0.014;
	final static int INPUT_NEURONS = 12;
	final static int HIDDEN_NEURONS = 18;
	final static int OUTPUT_NEURONS = 6;
	private Neuron[] neurons = new Neuron[INPUT_NEURONS + HIDDEN_NEURONS +OUTPUT_NEURONS];
	public NeuralNetwork(){	//뉴런생성
		for(int i=0;i<INPUT_NEURONS;i++) neurons[i] = new Neuron(LayerType.I);
		for(int i=INPUT_NEURONS;i<INPUT_NEURONS + HIDDEN_NEURONS;i++) neurons[i] = new Neuron(LayerType.H);
		for(int i=INPUT_NEURONS + HIDDEN_NEURONS;i<INPUT_NEURONS + HIDDEN_NEURONS + OUTPUT_NEURONS ;i++) neurons[i] = new Neuron(LayerType.O);
	}
	
	public NeuralNetwork forwardprop(double input[]){
		double weightedSum=0;
		for (int i = 0; i < neurons.length; i++) {
			switch (neurons[i].getLayerType()) {
			case I:
				neurons[i].setOutput(input[i]);
				break;
			case H:
				weightedSum = neurons[i].getThreshold();
				for(int InputNo=0;InputNo<INPUT_NEURONS; InputNo++){
					weightedSum += neurons[i].getWeights()[InputNo] * neurons[InputNo].getOutput();
				}
				neurons[i].applyActivationFunction(weightedSum);
				break;
			case O:
				weightedSum = neurons[i].getThreshold();
				for(int HiddenNo= INPUT_NEURONS; HiddenNo<INPUT_NEURONS + HIDDEN_NEURONS;HiddenNo++){
					weightedSum += neurons[i].getWeights()[HiddenNo - INPUT_NEURONS] * neurons[HiddenNo].getOutput();
				}
				neurons[i].applyActivationFunction(weightedSum);
				break;
			}
		}
		return this;
	}
	
	public NeuralNetwork backpropError(double targetResult, int outputNo){
		
		//OUTPUT
		for(int i=INPUT_NEURONS + HIDDEN_NEURONS;i<INPUT_NEURONS + HIDDEN_NEURONS + OUTPUT_NEURONS;i++){
			//OUTPUT SET
			if(i == (outputNo+ INPUT_NEURONS + HIDDEN_NEURONS)){
				neurons[i].setError((targetResult - neurons[i].getOutput()) * neurons[i].derivative());
				neurons[i].setThreshold(neurons[i].getThreshold() + LEARNING_RATE * neurons[i].getError());
				
				for(int j=INPUT_NEURONS;j<INPUT_NEURONS + HIDDEN_NEURONS;j++){
						neurons[i].getWeights()[INPUT_NEURONS + HIDDEN_NEURONS - j-1] = neurons[i].getWeights()[INPUT_NEURONS + HIDDEN_NEURONS - j - 1] + 
								LEARNING_RATE * neurons[i].getError() * neurons[(HIDDEN_NEURONS + INPUT_NEURONS -1) - j+INPUT_NEURONS ].getOutput();
				}
			}
		}
		
		//HIDDEN
		for(int i=INPUT_NEURONS;i<INPUT_NEURONS + HIDDEN_NEURONS;i++){

			//HIDDEN ERROR SUM
			double ErrorSum = 0; 
			for(int j=INPUT_NEURONS + HIDDEN_NEURONS;j<INPUT_NEURONS + HIDDEN_NEURONS + OUTPUT_NEURONS;j++){
				ErrorSum += (neurons[j].getWeights()[i-INPUT_NEURONS] * neurons[j].getError());
			}
			
			//HIDDEN SET
			neurons[i].setError(ErrorSum * neurons[i].derivative());
			neurons[i].setThreshold(neurons[i].getThreshold() + LEARNING_RATE * neurons[i].getError());
			for(int k=0;k<INPUT_NEURONS;k++){
				neurons[i].getWeights()[k] = neurons[i].getWeights()[k] + LEARNING_RATE * neurons[i].getError() * neurons[k].getOutput();
			}
		}
		
		return this;
	}
	
	public Neuron[] getNeurons() {return neurons;}	
	public String toString() {return Arrays.toString(neurons);}
	
}
