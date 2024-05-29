package gerenciadores;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import classes.Oferta;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GerenciadorOfertas {

	private List<Oferta> ofertas;

	public GerenciadorOfertas() {
		this.ofertas = new ArrayList<>();

	}

	public void adicionarOferta(Oferta oferta) {

		ofertas.add(oferta);
		System.out.println("Oferta adicionada: " + oferta);

	}

	public void removerOferta(int idOferta) {

		Iterator<Oferta> iterator = ofertas.iterator();
		
		while (iterator.hasNext()) {
			
			Oferta oferta = iterator.next();
			if (oferta.getId() == idOferta) {

				iterator.remove();
				System.out.println("Oferta removida: " + oferta);
				return;

			}

			else {
				System.out.println("Oferta com ID" + idOferta + "não encontrada.");

			}

		}

	}

	public void listarOfertas() {
		System.out.println("Lista de Ofertas: ");
		for (Oferta oferta : ofertas) {
			System.out.println(oferta);
		}
	}

}
