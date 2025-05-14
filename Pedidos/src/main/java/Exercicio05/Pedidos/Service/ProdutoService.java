package Exercicio05.Pedidos.Service;

import Exercicio05.Pedidos.Entity.Dto.ProdutoDTO;
import Exercicio05.Pedidos.Entity.Produto;
import Exercicio05.Pedidos.Repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public ProdutoDTO cadastrarProduto(ProdutoDTO produtoDTO){
        Produto produto = ProdutoDTO.toEntity(produtoDTO, modelMapper);
        Produto produtoSalvo = produtoRepository.save(produto);
        return ProdutoDTO.fromEntity(produtoSalvo, modelMapper);
    }

    public List<ProdutoDTO> listarProdutos() {
        List<Produto> produtos = produtoRepository.findAll();
        return produtos.stream().map(ProdutoDTO::new).toList();
    }
}
