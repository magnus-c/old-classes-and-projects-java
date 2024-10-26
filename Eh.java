
public class Eh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] myList = {1, 2, 3, 4, 5, 6};

		for (int i = myList.length - 2; i >= 0; i--) {
		myList[i + 1] = myList[i];
		}

		for (int e: myList)
		System.out.print(e + " ");
			}

}
