package data;

import java.io.IOException;


public class totaldata {
	
	//연월일, 회차, 번호
	static int[][] firstData = {{2,0,1,8,1,1,1,0, 0,8,3,2, 13,14,19,26,40,43}, {2,0,1,8,1,1,0,3,0,8,3,1,3,10,16,19,31,39}};

	public static void main(String[] args) throws IOException {

		System.out.println(firstData.length);
		
		for(int i=0;i<firstData.length;i++){
			System.out.println("firstData["+i+"]");
			for(int j=0;j<firstData[0].length;j++){
				System.out.print(firstData[i][j]);
			}
			System.out.println();
			System.out.println("-------------------------------------------");
		}

	}
}
