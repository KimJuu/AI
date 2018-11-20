package backup;


public class Neuron_bak {
	
	private NeuralNetwork_bak.LayerType layerType;
	private double threshold = 0.5 - Math.random();
	private double[] weights = {0.5 - Math.random(), 0.5 - Math.random()};
	private double output = 0;
	private double error = 0;
	public Neuron_bak(NeuralNetwork_bak.LayerType layerType){
		this.layerType = layerType;
	}
	public void applyActivationFunction(double weightedSum){
		output = 1.0 / (1 + Math.exp(-1.0 * weightedSum));
	}
	public double derivative(){
		return output * (1.0 - output);
	}
	
	
	public NeuralNetwork_bak.LayerType getLayerType() {
		return layerType;
	}
	public void setLayerType(NeuralNetwork_bak.LayerType layerType) {
		this.layerType = layerType;
	}
	public double getThreshold() {
		return threshold;
	}
	public void setThreshold(double threshold) {
		this.threshold = threshold;
	}
	public double[] getWeights() {
		return weights;
	}
	public void setWeights(double[] weights) {
		this.weights = weights;
	}
	public double getOutput() {
		return output;
	}
	public void setOutput(double output) {
		this.output = output;
	}
	public double getError() {
		return error;
	}
	public void setError(double error) {
		this.error = error;
	}
	@Override
	public String toString() {
		String returnValue ="";
		if(layerType == NeuralNetwork_bak.LayerType.I){
			returnValue ="(" + layerType +": " + String.format("%.2f",output) + ")";
		}else{
			returnValue ="(" + layerType +", " + 
					String.format("%.2f", weights[0]) + ", "+ 
					String.format("%.2f", weights[1]) + ", "+
					String.format("%.2f", threshold)+", "+ 
					String.format("%.5f", output)+")";
		}
		return returnValue;
	}
}
