package aula3;

public class Aula3 {


    public static void main(String[] args) {
        TipoVersao i = TipoVersao.TRES;

		switch (i) {
			case UM:
				System.out.println(TipoVersao.UM.descricao);
				break;
			case DOIS:
				System.out.println(TipoVersao.DOIS.descricao);
				break;
			default:
				System.out.println(TipoVersao.TRES.descricao);
		}
    }
//	public static void main(String[] args) {
//
//		TipoVersao i = TipoVersao.TRES;
//
//		switch (i) {
//			case UM:
//				System.out.println(TipoVersao.UM);
//				break;
//			case DOIS:
//				System.out.println(TipoVersao.DOIS);
//				break;
//			default:
//				System.out.println(TipoVersao.TRES);
//		}
//
//	}
	
//	static final int UM = 1;
//	static final int DOIS = 2;
//	static final int TRES = 3;
//	
//	public static void main(String[] args) {
//
//		int i = 0;
//
//		switch (i) {
//			case UM:
//				System.out.println(UM);
//				break;
//			case DOIS:
//				System.out.println(DOIS);
//				break;
//			default:
//				System.out.println(TRES);
//		}
//
//	}
}
