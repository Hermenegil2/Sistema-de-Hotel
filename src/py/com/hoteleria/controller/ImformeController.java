package py.com.hoteleria.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/********************************************************************

*	La siguiente clase llamada "Impresora", es la encargada de  	*

*	establecer la fuente con que se va a imprimir, de obtener el	*

*	trabajo de impresion, la p�gina. En esta clase hay un m�todo	*

*	llamado imprimir, el cual recibe una cadena y la imprime.		*

********************************************************************/

class Impresora {

    Font fuente = new Font("Dialog", Font.PLAIN, 10);

	PrintJob pj;

	java.awt.Graphics pagina;

 

 

	/********************************************************************

	*	A continuaci�n el constructor de la clase. Aqu� lo �nico que	*

	*	hago es tomar un objeto de impresion.							*

	********************************************************************/

	Impresora()

	{

		pj = Toolkit.getDefaultToolkit().getPrintJob(new Frame(), "SCAT", null);

	}

 

	/********************************************************************

	*	A continuaci�n el m�todo "imprimir(String)", el encargado de 	*

	*	colocar en el objeto gr�fico la cadena que se le pasa como 		*

	*	par�metro y se imprime.											*

	********************************************************************/

    public void imprimir(String Cadena)

	{

		//LO COLOCO EN UN try/catch PORQUE PUEDEN CANCELAR LA IMPRESION

		try

		{

			pagina = pj.getGraphics();

			pagina.setFont(fuente);

			pagina.setColor(Color.black);

 

			pagina.drawString(Cadena, 60, 60);

 
            pagina.dispose();

			pj.end();

		}catch(Exception e)

		{

			System.out.println("LA IMPRESION HA SIDO CANCELADA...");

		}

	}//FIN DEL PROCEDIMIENTO imprimir(String...)

 

 

}//FIN DE LA CLASE Impresora

 

public class ImformeController implements ActionListener{

	
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
