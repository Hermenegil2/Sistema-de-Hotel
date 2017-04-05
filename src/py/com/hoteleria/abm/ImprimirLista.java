package py.com.hoteleria.abm;

import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import py.com.hoteleria.dao.ClienteDAO;
import py.com.hoteleria.model.Cliente;

public class ImprimirLista {

	
	
	
	
	
	
	public static void main(String[] args) {
		ClienteDAO dao=new ClienteDAO();
		
		ArrayList<Cliente> lista=new ArrayList<>();
		lista=dao.listarCliente();
		Cliente cli=null;
        for (int i = 0; i < lista.size(); i++) {
			cli=new Cliente();
			cli=lista.get(i);
			System.out.println(cli.getCodigo()+cli.getNombre());
		}
	}

}
