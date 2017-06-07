package exe02;

public class Exemplo {

	public static void main(String[] args) {
		
		int[] origem = {1,2,3,4,5};
		int[] dest = new int[origem.length];
		
		print(origem);
		print(dest);
		System.arraycopy(origem, 0, dest, 0, origem.length);
		print(dest);
		
		int[] v = origem.clone();
		System.out.println(origem);
		System.out.println(v);
		print(v);
	}

	public static void print(int[] vet) {
		for (int i : vet) {
			System.out.print(i + ",");
		}
		System.out.println();
	}
	
	
}
