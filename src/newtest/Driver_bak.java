package newtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

import data.TotalData;

public class Driver_bak {
	static int NUMB_OF_EPOCHS = 10000;
	
	public static void main(String[] args) throws IOException {
		NeuralNetwork_bak neuralNetwork_bak = new NeuralNetwork_bak();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		boolean flag = true;
		
		while(flag){
			System.out.println(">What do you want to do (run, train, exit)  ?");
			String command = bufferedReader.readLine();
			
			switch (command) {
			case "run":
				double[] result = new double[]{0,0,0,0};
				IntStream.range(0, TotalData.TRAINING_DATA.length).forEach(i ->{
					result[i] = neuralNetwork_bak.forwardprop(TotalData.TRAINING_DATA[i][0])
														.getNeurons()[NeuralNetwork_bak.INPUT_NEURONS + NeuralNetwork_bak.HIDDEN_NEURONS]
														.getOutput();
				});
				printResult(result);
				break;
			case "train":
				IntStream.range(0, NUMB_OF_EPOCHS).forEach(i ->{
					System.out.println("[epoch "+i+"]");
					IntStream.range(0, TotalData.TRAINING_DATA.length).forEach(j ->{
						System.out.println(neuralNetwork_bak.forwardprop(TotalData.TRAINING_DATA[j][0])
																			.backpropError(TotalData.TRAINING_DATA[j][1][0]));
					});
				});
				System.out.println("[done training]");
				break;
			case "exit":
				flag=false;
				break;
			}
		}
		System.exit(0);
	}

	static void printResult(double[] result){
		System.out.println("     Input 1     |     Input 2     |     Target Result     |     Result     ");
		System.out.println("-----------------------------------------------------------------");
		IntStream.range(0, TotalData.TRAINING_DATA.length).forEach(i->{
			IntStream.range(0,  TotalData.TRAINING_DATA[0][0].length).forEach(j-> {
			System.out.print("     "+TotalData.TRAINING_DATA[i][0][j]+"     |     ");
			});
			System.out.print("     " + TotalData.TRAINING_DATA[i][1][0] + "     |     " + String.format("%.5f", result[i])+"     \n");
		});
	}
	
}
