package Exercicio05.Pedidos.Controller;

import Exercicio05.Pedidos.Entity.Dto.ClienteDTO;
import Exercicio05.Pedidos.Entity.Dto.ProdutoDTO;
import Exercicio05.Pedidos.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<ProdutoDTO> cadastrarProduto(@RequestBody ProdutoDTO produtoDTO){
        ProdutoDTO novoProduto = produtoService.cadastrarProduto(produtoDTO);
        return ResponseEntity.ok(novoProduto);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listarProdutos(){
        return ResponseEntity.ok(produtoService.listarProdutos());
    }

}
