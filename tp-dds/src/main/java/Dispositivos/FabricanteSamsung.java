package Dispositivos;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "Samsung")
public class FabricanteSamsung extends Fabricante {

		public FabricanteSamsung(String nombre) {
			super(nombre);
		}

		public void encender(String idDispositivo, FabricanteSamsung fabricante) {
			
		}
		
		public void apagar(String idDispositivo, FabricanteSamsung fabricante) {
			
		}
		
		public void ahorroEnergia(String idDispositivo, FabricanteSamsung fabricante) {
			
		}

}
