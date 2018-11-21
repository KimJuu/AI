package newtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

import data.TotalData;

public class Driver {
	static int NUMB_OF_EPOCHS = 10;
	
	public static void main(String[] args) throws IOException {
		NeuralNetwork neuralNetwork = new NeuralNetwork();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		boolean flag = true;
		
		while(flag){
			System.out.println(">What do you want to do (run, train, exit)  ?");
			String command = bufferedReader.readLine();
			
			switch (command) {
			case "run":
				double[][] result = new double[TotalData.Data.length][TotalData.Data[0][1].length];
				IntStream.range(0, TotalData.Data.length).forEach(i ->{
					IntStream.range(0, TotalData.Data[0][1].length).forEach(j ->{
						result[i][j] = neuralNetwork.forwardprop(TotalData.Data[i][0]).getNeurons()[j+25].getOutput();
					});
				});
				printResult(result);
				break;
			case "train":
				IntStream.range(0, NUMB_OF_EPOCHS).forEach(i ->{
					System.out.println("[epoch "+i+"]");
					IntStream.range(0, TotalData.Data.length).forEach(j ->{
						IntStream.range(0, TotalData.Data[0][1].length).forEach(k ->{
							//System.out.println(" TotalData.Data[j][1][0] : "+TotalData.Data[j][1][k]);
							System.out.println(neuralNetwork.forwardprop(TotalData.Data[j][0]).backpropError(TotalData.Data[j][1][k]));
						});
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

	static void printResult(double[][] result){
		System.out.println("           year            |   month   |     day     |            회차            |                       Target Result                       |                           Result                           |");
		System.out.println("-----------------------------------------------------------------");

		IntStream.range(0, TotalData.Data.length).forEach(i->{
			IntStream.range(0, TotalData.Data[0][0].length).forEach(j-> {
				System.out.print(TotalData.Data[i][0][j]+"  ");	//입력
				if(j == 3 || j == 5 || j == 7 || j == 11){
					System.out.print(" | ");	
				}
			});
			IntStream.range(0,  TotalData.Data[0][1].length).forEach(k-> {
				System.out.print(TotalData.Data[i][1][k] + "  ");		//타겟
				if(k == 6){
					System.out.print(" | ");
				}
			});
			IntStream.range(0,  TotalData.Data[0][1].length).forEach(p-> {
				System.out.print(String.format("%.2f", result[i][p])+ "  ");		//결과
				if(p == 6){
					System.out.print(" | ");
				}
			});
			System.out.println("");
		});
	}
	
}
