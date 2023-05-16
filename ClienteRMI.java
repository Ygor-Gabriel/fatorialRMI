import java.util.Scanner;
import java.rmi.Naming;

public class ClienteRMI
{

	public static void menu(){
		System.out.println("Escolha uma opção");
		System.out.println("1 - Se deseja fazer uma conta fatorial.");
		System.out.println("7 - Se deseja sair.");
	}
	static public void main (String rmi[])
	{
		try 
		{
			InterfaceRMI objeto = (InterfaceRMI) Naming.lookup ("rmi://localhost:1099/data");
			
			int opcao;
			try (Scanner entrada = new Scanner(System.in)) {
				do{
					menu();
					opcao = entrada.nextInt();

					switch(opcao){
						case 1:
							Scanner scan = new Scanner(System.in);
							System.out.println("\nDigite um número:");
							int num;
							num = scan.nextInt();
							int res = objeto.fatorial(num);
							System.out.println("Resultado do fatorial: " + res + "\n");
							break;
						case 7:
							break;
						default:
							System.out.println("Opção inválida");
					}
				}while(opcao != 7);
			}
		} 
		catch (Exception exc) 
		{
			System.err.println (exc.toString());
		}
	}	
}
