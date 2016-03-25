package findMe.validate;

public class test {
	public static void main(String[] args) throws CustomException{
		if(CpfValidate.validate("08373879322"))
			System.out.println("Acertou mizeravi");
		else
			System.out.println("eh cilada bino");
	}
}
