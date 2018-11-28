package Dispositivos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_fabricante")
public class Fabricante {
		@Id
		@GeneratedValue
		private Integer id;
		private String nombre;
		
		@OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
		@JoinColumn(name="fabricante_id")
		private List<DispositivoInteligente> dispositivosInteligente = new ArrayList<DispositivoInteligente>();
		
		public Fabricante(String nombre) {
			this.nombre = nombre;
		}
		
		public Integer getId() {
			return id;
		}
			
		public void setId(Integer id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void encender(Integer idDispositivo, Fabricante fabricante) {
			
		}
		
		public void apagar(Integer idDispositivo, Fabricante fabricante) {
			
		}
		
		public void ahorroEnergia(Integer idDispositivo, Fabricante fabricante) {
			
		}

}
