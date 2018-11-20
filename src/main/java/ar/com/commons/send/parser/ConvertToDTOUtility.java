package ar.com.commons.send.parser;


import ar.com.commons.send.domain.Snipplet;
import ar.com.commons.send.dto.SnippletDTO;
import ar.com.commons.send.domain.Category;
import ar.com.commons.send.dto.CategoriaDTO;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertToDTOUtility {



	public static Category convertTOCategory(CategoriaDTO categoriaDTO ){

		Category category = new Category();

		category.setNombreCategoria(categoriaDTO.getNombre());
		List<Snipplet> snipplets = new LinkedList<>();
		for (SnippletDTO snippletDTO : categoriaDTO.getSnipplets()){

			snipplets.add(new Snipplet(snippletDTO,category));
		}

		category.setSnipplets(snipplets);

		return category;
	}

	public static CategoriaDTO fromCategoryToCategoryDTO(Category category){
		CategoriaDTO categoriaDTO = new CategoriaDTO();
		categoriaDTO.setNombre(category.getNombreCategoria());
		category.getSnipplets().stream().forEach(x -> new SnippletDTO(x));
		List<SnippletDTO> collect = category.getSnipplets().stream().map(x -> new SnippletDTO(x)).collect(Collectors.toList());
		categoriaDTO.setSnipplets(collect);
		return categoriaDTO;
	}


}
