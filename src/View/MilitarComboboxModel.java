package View;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import Model.Militar;

public class MilitarComboboxModel extends AbstractListModel implements ComboBoxModel{

	private List<Militar> listaMilitares;
	private Militar militarselecionado;
	
	public MilitarComboboxModel() {
		//método construtor criando uma lista de militares
		this.listaMilitares = new ArrayList<Militar>();
	}

	@Override
	public Object getElementAt(int index) {
		//retorna o militar selecionado por parâmetro
		return this.listaMilitares.get(index);
	}

	@Override
	public int getSize() {
		//retorna o tamanho da lista
		return listaMilitares.size();	
	}

	@Override
	public Object getSelectedItem() {
		return this.militarselecionado;
	}

	@Override
	public void setSelectedItem(Object item) {
		//verifica se o item selecionado é um militar
		//recebe o militar selecionado e atualiza o combobox
		if (item  instanceof Militar) {
			this.militarselecionado = (Militar) item;
			fireContentsChanged(this.listaMilitares, 0, this.listaMilitares.size());
		}
	}
	
	public void addMilitares(Militar mil) {
		this.listaMilitares.add(mil);
	}
	
	public void reset() {
		
	}

}
