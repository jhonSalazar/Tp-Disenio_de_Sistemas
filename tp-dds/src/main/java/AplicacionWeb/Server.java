package AplicacionWeb;
import Repositorios.InstanciadorModeloCompleto;
import spark.Spark;
import spark.debug.DebugScreen;



public class Server {

	public static void main(String[] args) {
		InstanciadorModeloCompleto.init();
		Spark.port(9000);
		DebugScreen.enableDebugScreen();	
		Router.configure();
	}
}
