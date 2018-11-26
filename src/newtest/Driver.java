package newtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import data.TotalData;

public class Driver {
	static int NUMB_OF_EPOCHS = 15000;
	
	public static void main(String[] args) throws IOException {
		NeuralNetwork neuralNetwork = new NeuralNetwork();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		boolean flag = true;
		
		while(flag){
			System.out.println(">What do you want to do (run, train, exit)  ?");
			String command = bufferedReader.readLine();	
			
			switch (command) {
			case "run":
				System.out.println(">>>>>>Driver run");
				double[][] result = new double[TotalData.TRAINING_DATA.length][TotalData.TRAINING_DATA[0][1].length];
				for(int i=0;i<TotalData.TRAINING_DATA.length;i++){
					for(int j=0;j<TotalData.TRAINING_DATA[0][1].length;j++){
						result[i][j] = neuralNetwork.forwardprop(TotalData.TRAINING_DATA[i][0]).getNeurons()[j+NeuralNetwork.INPUT_NEURONS+NeuralNetwork.HIDDEN_NEURONS].getOutput();
						}
				}
				printResult(result);
				break;
			case "train":
				for(int i=0;i<NUMB_OF_EPOCHS;i++){
					System.out.println("[epoch "+i+"]");
					for(int j=0;j<TotalData.TRAINING_DATA.length;j++){
						for(int k=0;k<TotalData.TRAINING_DATA[0][1].length;k++){
							System.out.println(neuralNetwork.forwardprop(TotalData.TRAINING_DATA[j][0]).backpropError(TotalData.TRAINING_DATA[j][1][k],k));
						}
					}
				}
				System.out.println("[done training]");
				break;
			case "exit":
				flag=false;
				break;
			}
		}
		System.exit(0);
	}

	static void printResult(double[][] result){
		System.out.println("                                     INPUT                                       |                          TARGET                          |                         RESULT                          |");
		System.out.println("-----------------------------------------------------------------");

		for(int i=0;i<TotalData.TRAINING_DATA.length;i++){
			for(int j=0;j<TotalData.TRAINING_DATA[0][0].length;j++){
				System.out.print(TotalData.TRAINING_DATA[i][0][j]+"  ");	//입력
				if(j == 2){
					System.out.print(" | ");	
				}
			}
			for(int k=0;k<TotalData.TRAINING_DATA[0][1].length;k++){
				System.out.print(TotalData.TRAINING_DATA[i][1][k] + "  ");		//타겟
				if(k == 1){
					System.out.print(" | ");
				}
			}
			for(int p=0;p<TotalData.TRAINING_DATA[0][1].length;p++){
				System.out.print(String.format("%.4f", result[i][p])+ "  ");		//결과
			}
			System.out.println("");
		}
	}
	
}
