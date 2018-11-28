package Dispositivos;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "LG")
public class FabricanteLG extends Fabricante {

		public FabricanteLG(String nombre) {
			super(nombre);
		}

		public void encender(String idDispositivo, FabricanteLG fabricante) {
			
		}
		
		public void apagar(String idDispositivo, FabricanteLG fabricante) {
			
		}
		
		public void ahorroEnergia(String idDispositivo, FabricanteLG fabricante) {
			
		}

}
