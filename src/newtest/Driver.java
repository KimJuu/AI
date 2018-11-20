package newtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

import data.TotalData;

public class Driver {
	static int NUMB_OF_EPOCHS = 10000;
	
	public static void main(String[] args) throws IOException {
		NeuralNetwork neuralNetwork = new NeuralNetwork();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		boolean flag = true;
		
		while(flag){
			System.out.println(">What do you want to do (run, train, exit)  ?");
			String command = bufferedReader.readLine();
			
			switch (command) {
			case "run":
				System.out.println("totaldata.Data[0][0][0] " +TotalData.Data[0][0][0]);
				System.out.println("totaldata.Data[0][0][1] " +TotalData.Data[0][0][1]);
				System.out.println("totaldata.Data[0][1][0] " +TotalData.Data[0][1][0]);
				System.out.println("totaldata.Data[0][1][1] " +TotalData.Data[0][1][1]);
				System.out.println("totaldata.Data[1][0][0] " +TotalData.Data[1][0][0]);
				System.out.println("totaldata.Data[1][0][1] " +TotalData.Data[1][0][1]);
				System.out.println("totaldata.Data[1][1][0] " +TotalData.Data[1][1][0]);
				System.out.println("totaldata.Data[1][1][1] " +TotalData.Data[1][1][1]);
				//String InputData = bufferedReader.readLine();
				//System.out.println(InputData.length());
				//InputData.substring(0, 2);
				//181006 827 - 5 11 12 29 33 44
				//double[] result = new double[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0				,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0				,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0				,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0				,0,0,0,0,0,0,0,0,0,0};
//				double[] result = new double[]{0,0,0,0};
//				IntStream.range(0, Driver.TRAINING_DATA.length).forEach(i ->{
//					result[i] = neuralNetwork.forwardprop(Driver.TRAINING_DATA[i][0])
//														.getNeurons()[NeuralNetwork.INPUT_NEURONS + NeuralNetwork.HIDDEN_NEURONS]
//														.getOutput();
//				});
//				printResult(result);
				break;
			case "train":
				IntStream.range(0, NUMB_OF_EPOCHS).forEach(i ->{
					System.out.println("[epoch "+i+"]");
					IntStream.range(0, TotalData.Data.length).forEach(j ->{
						System.out.println(neuralNetwork.forwardprop(TotalData.Data[j][0])
																			.backpropError(TotalData.Data[j][1][0]));
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
		IntStream.range(0, TotalData.Data.length).forEach(i->{
			IntStream.range(0,  TotalData.Data[0][0].length).forEach(j-> {
			System.out.print("     "+TotalData.Data[i][0][j]+"     |     ");
			});
			System.out.print("     " + TotalData.Data[i][1][0] + "     |     " + String.format("%.5f", result[i])+"     \n");
		});
	}
	
}
