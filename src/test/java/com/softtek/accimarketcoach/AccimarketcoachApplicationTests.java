package com.softtek.accimarketcoach;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * Diferencia entre Pruebas unitarias vs. Pruebas de integración
 * 
 * Pruebas unitarias: 
 * Verificar que el código que estamos desarrollando funcione de acuerdo a lo planeado. 
 * Las pruebas unitarias se realizan a nivel funciones/métodos --> assert
 * 
 * Pruebas funcionales:
 * Verifica que los componentes de nuestras distintas capas se comuniquen correctamente relizen exitosamente una tarea.
 * Las prubas funcionales se realizan a nivel clases/capas de arquitectura --> mocks
 * 
 * 
 * Referencias bibliograficas: 
 * 	https://www.youtube.com/watch?v=UwoCR0eJNgo
 * 
 * @author javier.perezb
 *
 */
@SpringBootTest
class AccimarketcoachApplicationTests {

	@Test
	void contextLoads() {
	}

}
