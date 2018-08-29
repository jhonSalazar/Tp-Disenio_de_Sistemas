package Automatizaciones;

public enum Operacion  {
	
	
	Mayorque(">") {
        @Override
        public boolean  comparar(int operand1, int operand2) {
            return operand1 > operand2;
        }


    },
	
	Menorque("<") {
        @Override
        public boolean  comparar(int operand1, int operand2) {
            return operand1 < operand2;
        }
    },
	
	igual("==") {
        @Override
        public boolean  comparar(int operand1, int operand2) {
            return operand1 == operand2;
        }
    },
	
	MayorIgualque(">="){
		 public boolean  comparar(int operand1, int operand2) {
	            return operand1 >= operand2;
	        }
		
	},
	MenorIgualque("<="){
		 public boolean  comparar(int operand1, int operand2) {
	            return operand1 <= operand2;
	        }
		
	};

    private final String operador ;

    Operacion(String operador) {
        this.operador = operador;
    }

    public String getOperator() {
        return operador;
    }
    
  
    public abstract boolean comparar(int operand1, int operand2);
  
	
}
